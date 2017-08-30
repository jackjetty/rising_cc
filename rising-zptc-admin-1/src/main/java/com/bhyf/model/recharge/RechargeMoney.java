package com.bhyf.model.recharge;

import com.bhyf.pojo.command.recharge.CreateRechargeMoneyCommand;
import com.bhyf.pojo.command.recharge.UpdateRechargeMoneyStatusCommand;
import com.rising.common.component.BaseModel;

/**
 * Created by admin on 2016/4/13.
 */
public class RechargeMoney extends BaseModel{
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

    public boolean create(CreateRechargeMoneyCommand command) {
        setMoney(command.getMoney());
        setStatus(0);
        return true;
    }

    public boolean updateStatus(UpdateRechargeMoneyStatusCommand command) {
        setId(command.getId());
        setStatus(command.getStatus());
        return true;
    }
}
