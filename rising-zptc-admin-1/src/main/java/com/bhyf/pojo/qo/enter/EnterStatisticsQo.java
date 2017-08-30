package com.bhyf.pojo.qo.enter;

import com.rising.common.component.BaseQo;

/**
 * Created by admin on 2016/4/12.
 */
public class EnterStatisticsQo extends BaseQo {

    private Integer enterId;

    private Integer status;

    private Integer enterCategory;

    private String enterExamName;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
    }

    public Integer getEnterCategory() {
        return enterCategory;
    }

    public void setEnterCategory(Integer enterCategory) {
        this.enterCategory = enterCategory;
    }

    public String getEnterExamName() {
        return enterExamName;
    }

    public void setEnterExamName(String enterExamName) {
        this.enterExamName = enterExamName;
    }
}
