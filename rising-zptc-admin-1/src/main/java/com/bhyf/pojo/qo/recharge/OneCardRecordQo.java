package com.bhyf.pojo.qo.recharge;

import com.rising.common.component.BaseQo;

import java.util.Date;

/**
 * Created by admin on 2016/4/13.
 */
public class OneCardRecordQo extends BaseQo{

    private String tradeNo;

    private String cardNo;

    private String staSID;

    private Date beginTime;

    private Date endTime;

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getStaSID() {
        return staSID;
    }

    public void setStaSID(String staSID) {
        this.staSID = staSID;
    }
}
