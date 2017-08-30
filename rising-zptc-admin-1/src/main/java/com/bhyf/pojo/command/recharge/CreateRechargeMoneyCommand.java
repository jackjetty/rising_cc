package com.bhyf.pojo.command.recharge;

import com.rising.common.component.BaseCommand;

/**
 * Created by admin on 2016/4/13.
 */
public class CreateRechargeMoneyCommand extends BaseCommand {
    private Double money;

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
