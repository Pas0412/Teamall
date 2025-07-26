package org.linlinjava.litemall.wx.service;

import com.github.binarywang.wxpay.bean.entpay.EntPayRequest;
import com.github.binarywang.wxpay.bean.entpay.EntPayResult;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.github.binarywang.wxpay.service.WxPayService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.linlinjava.litemall.core.notify.NotifyService;
import org.linlinjava.litemall.core.util.JacksonUtil;
import org.linlinjava.litemall.core.util.ResponseUtil;
import org.linlinjava.litemall.db.domain.LitemallUser;
import org.linlinjava.litemall.db.domain.LitemallWithdraw;
import org.linlinjava.litemall.db.service.LitemallUserService;
import org.linlinjava.litemall.db.service.LitemallWithdrawService;
import org.linlinjava.litemall.wx.util.WithdrawConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.linlinjava.litemall.wx.util.WxResponseCode.*;

@Service
public class WxWithdrawService {
    private final Log logger = LogFactory.getLog(WxWithdrawService.class);

    @Autowired
    private LitemallUserService userService;
//    @Autowired
//    private LitemallWithdrawService withdrawService;
    @Autowired
    private WxPayService wxPayService;
    @Autowired
    private NotifyService notifyService;

    /**
     * 发起提现申请
     */
    @Transactional
    public Object initiate(Integer userId, String body) {
        if (userId == null) {
            return ResponseUtil.unlogin();
        }
        if (body == null) {
            return ResponseUtil.badArgument();
        }

        // 解析请求参数
        Integer amount = JacksonUtil.parseInteger(body, "amount");
        String remark = JacksonUtil.parseString(body, "remark");
        if (amount == null || amount <0) {
            return ResponseUtil.badArgumentValue();
        }

        // 校验用户信息
        LitemallUser user = userService.findById(userId);
        if (user == null) {
            return ResponseUtil.fail(1, "用户不存在");
        }
        if (user.getWeixinOpenid() == null || user.getWeixinOpenid().isEmpty()) {
            return ResponseUtil.fail(1, "请先绑定微信账号");
        }

        // 校验用户余额
        if (user.getBalance()==null||user.getBalance().compareTo(BigDecimal.valueOf(amount)) < 0) {
            return ResponseUtil.fail(1, "余额不足");
        }

        // 扣减用户余额
        user.setBalance(user.getBalance().subtract(BigDecimal.valueOf(amount)));
        userService.updateById(user);

        // 创建提现记录（状态：待打款）
        LitemallWithdraw withdraw = new LitemallWithdraw();
        withdraw.setUserId(userId);
        withdraw.setAmount(BigDecimal.valueOf(amount));
        withdraw.setStatus((int) WithdrawConstant.STATUS_APPROVED);
        withdraw.setOutTradeNo(generateOutTradeNo(userId));
        withdraw.setRemark(remark);
        withdraw.setCreateTime(LocalDateTime.now());
//        withdrawService.add(withdraw);

        try {
            // 调用微信企业付款接口
            EntPayRequest request = new EntPayRequest();
            request.setPartnerTradeNo(withdraw.getOutTradeNo());
            request.setOpenid(user.getWeixinOpenid());
            request.setCheckName("NO_CHECK"); // 不校验真实姓名
            request.setAmount(BigDecimal.valueOf(amount).multiply(new BigDecimal(100)).intValue()); // 单位：分
            request.setDescription(remark != null ? remark : "用户提现");
            request.setSpbillCreateIp("127.0.0.1");
            request.setMchAppid("123456789987654321abcdefgabcdefg");
            request.setAppid("wxbca8a0aa7fef00db");
            request.setMchId("1723089048");
            EntPayResult result = wxPayService.getEntPayService().entPay(request);

            if ("SUCCESS".equals(result.getReturnCode()) && "SUCCESS".equals(result.getResultCode())) {
                withdraw.setStatus((int) WithdrawConstant.STATUS_SUCCESS);
                withdraw.setWithdrawNo(result.getPaymentNo());
                withdraw.setUpdateTime(LocalDateTime.now());
//                withdrawService.update(withdraw);

                // 发送通知
//                notifyService.notifySmsTemplateSync(user.getMobile(), NotifyType.WITHDRAW_SUCCESS,
//                        new String[]{amount.toString(), withdraw.getOutTradeNo()});

                return ResponseUtil.ok();
            } else {
                // 提现失败，退回余额
                user.setBalance(user.getBalance().add(BigDecimal.valueOf(amount)));
                userService.updateById(user);

                withdraw.setStatus((int) WithdrawConstant.STATUS_FAILED);
                withdraw.setRemark(result.getReturnMsg() + "|" + result.getErrCodeDes());
                withdraw.setUpdateTime(LocalDateTime.now());
//                withdrawService.update(withdraw);

                return ResponseUtil.fail(1, "提现失败：" + result.getReturnMsg());
            }
        } catch (WxPayException e) {
            logger.error("微信提现失败", e);
            // 异常处理：回滚余额
            user.setBalance(user.getBalance().add(BigDecimal.valueOf(amount)));
            userService.updateById(user);

            // 更新提现记录为失败
            withdraw.setStatus((int) WithdrawConstant.STATUS_FAILED);
            withdraw.setRemark(e.getErrCodeDes());
            withdraw.setUpdateTime(LocalDateTime.now());
//            withdrawService.update(withdraw);

            return ResponseUtil.fail(1, "提现失败：" + e.getErrCodeDes());}
    }

    // 其他方法（list、detail等）保持不变...

    /**
     * 生成商户订单号
     */
    private String generateOutTradeNo(Integer userId) {
        return "W" + System.currentTimeMillis() + UUID.randomUUID().toString().substring(0, 8);
    }
}