package com.bhyf.pojo.command.recharge;

import com.rising.common.component.BaseCommand;

/**
 * Created by admin on 2016/4/13.
 */
public class UpdateOneCardBestPayStatisticsCommand extends BaseCommand{

    private String reconciliation;

    public String getReconciliation() {
        return reconciliation;
    }

    public void setReconciliation(String reconciliation) {
        this.reconciliation = reconciliation;
    }
}
