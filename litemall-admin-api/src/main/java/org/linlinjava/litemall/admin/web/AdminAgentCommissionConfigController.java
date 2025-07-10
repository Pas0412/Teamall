package org.linlinjava.litemall.admin.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.linlinjava.litemall.admin.annotation.RequiresPermissionsDesc;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallAgentCommissionConfig;
import org.linlinjava.litemall.db.service.LitemallAgentCommissionConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/agent/commission/config")
public class AdminAgentCommissionConfigController {
    @Autowired
    private LitemallAgentCommissionConfigService agentCommissionConfigService;

    /**
     * 根据配置键获取配置信息
     * @param configKey 配置键
     * @return 配置信息
     */
    @GetMapping("/query")
    public Object queryByKey(@RequestParam String configKey) {
        LitemallAgentCommissionConfig config = agentCommissionConfigService.queryByKey(configKey);
        Map<String, Object> data = new HashMap<>();
        data.put("config", config);
        return data;
    }

    /**
     * 查询所有未删除的配置信息
     * @return 配置信息列表
     */
    @RequiresPermissions("admin:agent_commission:list")
    @RequiresPermissionsDesc(menu = {"商城管理", "佣金管理"}, button = "查询")
    @GetMapping("/list")
    public Object list() {
        List<LitemallAgentCommissionConfig> configList = agentCommissionConfigService.queryAll();
//        Map<String, Object> data = new HashMap<>();
//        data.put("configList", configList);
        return ResponseUtil.okList(configList);
    }

    /**
     * 更新配置信息
     * @param config 配置信息
     * @return 更新结果
     */
    @RequiresPermissions("admin:agent_commission:update")
    @RequiresPermissionsDesc(menu = {"商城管理", "佣金管理"}, button = "更新")
    @PostMapping("/update")
    public Object update(@RequestBody LitemallAgentCommissionConfig config) {
        if (agentCommissionConfigService.updateById(config) == 0) {
            return ResponseUtil.updatedDataFailed();
        }
        return ResponseUtil.ok(config);
    }

    /**
     * 添加配置信息
     * @param config 配置信息
     * @return 添加结果
     */
    @PostMapping("/add")
    public Object add(@RequestBody LitemallAgentCommissionConfig config) {
        int result = agentCommissionConfigService.add(config);
        Map<String, Object> data = new HashMap<>();
        if (result > 0) {
            data.put("success", true);
            data.put("message", "添加成功");
        } else {
            data.put("success", false);
            data.put("message", "添加失败");
        }
        return data;
    }

    /**
     * 删除配置信息
     * @param id 配置 ID
     * @return 删除结果
     */
    @PostMapping("/delete")
    public Object delete(@RequestParam Integer id) {
        agentCommissionConfigService.deleteById(id);
        Map<String, Object> data = new HashMap<>();
        data.put("success", true);
        data.put("message", "删除成功");
        return data;
    }
}