package org.linlinjava.litemall.wx.web;

import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.wx.annotation.LoginUser;
import org.linlinjava.litemall.wx.service.WxWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 微信提现相关API
 */
@RestController
@RequestMapping("/wx/withdraw")
public class WxWithdrawController {

    @Autowired
    private WxWithdrawService withdrawService;

    /**
     * 发起提现申请
     *
     * @param userId 用户ID
     * @param body   请求体，包含提现金额和备注
     * @return 操作结果
     */
    @PostMapping("/initiate")
    public Object initiate(@LoginUser Integer userId, @RequestBody String body) {
        return withdrawService.initiate(userId, body);
    }


}    