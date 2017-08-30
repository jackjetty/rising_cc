package com.bhyf.pojo.command.recharge;

import com.rising.common.component.BaseCommand;

/**
 * Created by admin on 2016/4/13.
 */
public class UpdateRechargeMoneyStatusCommand extends BaseCommand{

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
