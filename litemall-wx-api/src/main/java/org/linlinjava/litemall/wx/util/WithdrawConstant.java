package org.linlinjava.litemall.wx.util;

public class WithdrawConstant {
    // 提现状态
    public static final short STATUS_PENDING = 0; // 待审核
    public static final short STATUS_APPROVED = 1; // 审核通过（待打款）
    public static final short STATUS_SUCCESS = 2; // 打款成功
    public static final short STATUS_FAILED = 3; // 打款失败
    public static final short STATUS_REJECTED = 4; // 审核拒绝

    // 状态文本描述
    public static String statusText(Short status) {
        switch (status) {
            case STATUS_PENDING: return "待审核";
            case STATUS_APPROVED: return "待打款";
            case STATUS_SUCCESS: return "提现成功";
            case STATUS_FAILED: return "打款失败";
            case STATUS_REJECTED: return "审核拒绝";
            default: return "未知状态";
        }
    }
}
