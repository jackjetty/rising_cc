package com.bhyf.model.recharge;

import com.bhyf.pojo.command.recharge.UpdateOneCardBestPayStatisticsCommand;
import com.rising.common.component.BaseModel;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 2016/4/15.
 */
public class OneCardBestPayStatistics extends BaseModel{
    /*
    一卡通充值总计
     */
    private Double sumOneCardMoney;
    /*
    翼支付充值总计
     */
    private Double sumBestPayMoney;
    /*
    本系统充值总计
     */
    private Double sumOurMoney;
    /*
    平账信息
     */
    private String reconciliation;


    public OneCardBestPayStatistics() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        this.sumBestPayMoney = 0.0;
        this.sumOneCardMoney = 0.0;
        this.sumOurMoney = 0.0;
        setCreateTime(calendar.getTime());
    }

    public Double getSumOneCardMoney() {
        return sumOneCardMoney;
    }

    public void setSumOneCardMoney(Double sumOneCardMoney) {
        this.sumOneCardMoney = sumOneCardMoney;
    }

    public Double getSumBestPayMoney() {
        return sumBestPayMoney;
    }

    public void setSumBestPayMoney(Double sumBestPayMoney) {
        this.sumBestPayMoney = sumBestPayMoney;
    }

    public Double getSumOurMoney() {
        return sumOurMoney;
    }

    public void setSumOurMoney(Double sumOurMoney) {
        this.sumOurMoney = sumOurMoney;
    }

    public String getReconciliation() {
        return reconciliation;
    }

    public void setReconciliation(String reconciliation) {
        this.reconciliation = reconciliation;
    }

    public void update(UpdateOneCardBestPayStatisticsCommand command) {
        setId(command.getId());
        setReconciliation(command.getReconciliation());
    }
}
