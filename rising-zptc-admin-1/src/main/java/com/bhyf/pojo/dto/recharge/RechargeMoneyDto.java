package com.bhyf.pojo.dto.recharge;

import com.rising.common.component.BaseDto;

/**
 * Created by admin on 2016/4/13.
 */
public class RechargeMoneyDto extends BaseDto{
    /*
   充值金额
    */
    private Double money;
    /*
     状态：0:失效；1:有效；80：删除；
     */
    private Integer status;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
