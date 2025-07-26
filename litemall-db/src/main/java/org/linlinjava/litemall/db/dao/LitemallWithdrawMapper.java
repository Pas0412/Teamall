package org.linlinjava.litemall.db.dao;

import org.apache.ibatis.annotations.Mapper;
import org.linlinjava.litemall.db.domain.LitemallWithdraw;

import java.util.List;
import java.util.Map;

public interface LitemallWithdrawMapper {

    /**
     * 插入提现记录
     */
    int insert(LitemallWithdraw withdraw);

    /**
     * 根据ID查询提现记录
     */
    LitemallWithdraw selectById(Integer id);

    /**
     * 根据商户订单号查询提现记录
     */
    LitemallWithdraw selectByOutTradeNo(String outTradeNo);

    /**
     * 更新提现记录（带乐观锁）
     */
    int updateWithVersion(LitemallWithdraw withdraw);

    /**
     * 更新提现记录（不带乐观锁）
     */
    int update(LitemallWithdraw withdraw);
}