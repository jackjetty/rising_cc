package com.bhyf.pojo.dto.enter;

import com.bhyf.model.enter.EnterStatistics;
import com.rising.common.component.BaseDto;

/**
 * Created by admin on 2016/4/12.
 */
public class EnterStatisticsDto extends BaseDto{

    private String enterExamName;
    /*
       考试分类：1：报名缴费；2：报名；3：缴费；
        */
    private Integer enterCategory;
    /*
        可报名人数
         */
    private Integer enterNum;
    /*
    已报名人数
     */
    private Integer enterSumNum;
    /*
    考试费用
     */
    private Double enterMoney;

    private Double enterSumMoney;

    private Double enterBestPaySumMoney;

    private String reconciliation;

    public String getEnterExamName() {
        return enterExamName;
    }

    public void setEnterExamName(String enterExamName) {
        this.enterExamName = enterExamName;
    }

    public Integer getEnterCategory() {
        return enterCategory;
    }

    public void setEnterCategory(Integer enterCategory) {
        this.enterCategory = enterCategory;
    }

    public Integer getEnterNum() {
        return enterNum;
    }

    public void setEnterNum(Integer enterNum) {
        this.enterNum = enterNum;
    }

    public Integer getEnterSumNum() {
        return enterSumNum;
    }

    public void setEnterSumNum(Integer enterSumNum) {
        this.enterSumNum = enterSumNum;
    }

    public Double getEnterMoney() {
        return enterMoney;
    }

    public void setEnterMoney(Double enterMoney) {
        this.enterMoney = enterMoney;
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

    public void create(EnterStatistics enterStatistics) {
        setId(enterStatistics.getId());
        setEnterExamName(enterStatistics.getEnter().getEnterExamName());
        setEnterCategory(enterStatistics.getEnter().getEnterCategory());
        setEnterNum(enterStatistics.getEnter().getEnterNum());
        setEnterSumNum(enterStatistics.getEnter().getEnterSumNum());
        setEnterMoney(enterStatistics.getEnter().getEnterMoney());
        setEnterSumMoney(enterStatistics.getEnterSumMoney());
        setEnterBestPaySumMoney(enterStatistics.getEnterBestPaySumMoney());
        setReconciliation(enterStatistics.getReconciliation());
    }
}
