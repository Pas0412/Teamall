package org.linlinjava.litemall.wx.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.service.LitemallOrderService;
import org.linlinjava.litemall.db.service.LitemallUserService;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

        // 获取区域代理总金额
        int agent_role_id = user.getAgentRoleId();
        BigDecimal agent_amount = orderService.getAgentAmount(agent_role_id);
        data.put("agentAmount", agent_amount);

        return ResponseUtil.ok(data);
    }

}