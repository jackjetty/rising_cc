package com.bhyf.model.enter;

import com.bhyf.pojo.command.enter.UpdateEnterStatisticsCommand;
import com.rising.common.component.BaseModel;

/**
 * Created by admin on 2016/4/12.
 */
public class EnterStatistics extends BaseModel {

    private Enter enter;

    private Double enterSumMoney;

    private Double enterBestPaySumMoney;

    private String reconciliation;

    public Enter getEnter() {
        return enter;
    }

    public void setEnter(Enter enter) {
        this.enter = enter;
    }

    public Double getEnterSumMoney() {
        return enterSumMoney;
    }

    public void setEnterSumMoney(Double enterSumMoney) {
        this.enterSumMoney = enterSumMoney;
    }

    public Double getEnterBestPaySumMoney() {
        return enterBestPaySumMoney;
    }

    public void setEnterBestPaySumMoney(Double enterBestPaySumMoney) {
        this.enterBestPaySumMoney = enterBestPaySumMoney;
    }

    public String getReconciliation() {
        return reconciliation;
    }

    public void setReconciliation(String reconciliation) {
        this.reconciliation = reconciliation;
    }

    public boolean update(UpdateEnterStatisticsCommand command) {
        setId(command.getId());
        setReconciliation(command.getReconciliation());
        return true;
    }
}
