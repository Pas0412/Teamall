package org.linlinjava.litemall.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallAgentCommissionConfig;
import org.linlinjava.litemall.db.domain.LitemallRegion;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.service.LitemallAgentCommissionConfigService;
import org.linlinjava.litemall.db.service.LitemallOrderService;
import org.linlinjava.litemall.db.service.LitemallRegionService;
import org.linlinjava.litemall.db.service.LitemallUserService;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;

/**
 * 余额服务
 */
@RestController
@RequestMapping("/wx/balance")
@Validated
public class WxBalanceController {

    private final Log logger = LogFactory.getLog(WxUserController.class);

    @Autowired
    private LitemallOrderService orderService;

    @Autowired
    private LitemallUserService userService;

    @Autowired
    private LitemallAgentCommissionConfigService agentCommissionConfigService;

    @Autowired
    private LitemallRegionService regionService;


    /**
     * 余额流水
     * <p>
     * 目前是用户订单统计信息
     *
     * @param userId 用户ID
     * @return 余额页面数据
     */
    @GetMapping("index")
    public Object list(@LoginUser Integer userId) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }

        Map<Object, Object> data = new HashMap<Object, Object>();
        LitemallUser user = userService.findById(userId);
        data.put("balance", user.getBalance());

        // 根据父邀请人id获取团队所有的user id
        List<LitemallUser> users = userService.queryByPid(userId);

        // 获取订单总金额
        BigDecimal team_amount = orderService.getTeamAmount(userId);
        data.put("teamAmount", team_amount);
        // 获取团队抽成总额
        data.put("teamCommissionAmount", orderService.getTeamCommissionAmount(userId));

        // 获取区域代理总金额
        int agent_role_id = user.getAgentRoleId();
        BigDecimal agent_amount = orderService.getAgentAmount(agent_role_id);
        data.put("agentAmount", agent_amount);
        // 获取用户作为代理的抽成总额
        data.put("agentCommissionAmount", getTotalCommission(agent_role_id));

        return ResponseUtil.ok(data);
    }

    /**
     * 根据传入的 id，获取其下所有区（type=3）的佣金总和
     * 调用哪个 orderService 方法，取决于原始节点的 type
     */
    public BigDecimal getTotalCommission(Integer id) {
        LitemallRegion root = regionService.findById(id);
        if (root == null) {
            return BigDecimal.ZERO;
        }

        // 收集所有 type=3（区）的 id
        List<Integer> countyIds = new ArrayList<>();
        collectAllCountyIds(root, countyIds);

        // 根据原始节点的 type 选择 commission 方法
        Function<Integer, BigDecimal> commissionGetter = getCommissionFunction(root.getType());

        // 并行计算（可选），如果数据量大且方法耗时
        return countyIds.parallelStream()
                .map(commissionGetter)
                .filter(Objects::nonNull)  // 防止 null 值
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    /**
     * 递归收集所有 type=3 的区域 id
     */
    private void collectAllCountyIds(LitemallRegion region, List<Integer> result) {
        if (region.getType() == 3) {
            result.add(region.getId());
            return;
        }

        List<LitemallRegion> children = regionService.queryByPid(region.getId());
        if (children != null && !children.isEmpty()) {
            for (LitemallRegion child : children) {
                collectAllCountyIds(child, result);
            }
        }
    }

    /**
     * 根据原始节点的 type 返回对应的 commission 获取方法
     */
    private Function<Integer, BigDecimal> getCommissionFunction(int type) {
        switch (type) {
            case 1:
                return orderService::getProvinceCommissionAmount;
            case 2:
                return orderService::getCityCommissionAmount;
            case 3:
                return orderService::getCountyCommissionAmount;
            default:
                throw new IllegalArgumentException("无效的区域类型: " + type);
        }
    }
}