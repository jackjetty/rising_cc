package com.bhyf.pojo.qo.enter;

import com.rising.common.component.BaseQo;

import java.util.Date;

/**
 * Created by admin on 2016/4/13.
 */
public class BestPayRecordQo extends BaseQo{

    private String tradeNo;

    private String tranSeq;

    private String cardNo;

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

    public String getTranSeq() {
        return tranSeq;
    }

    public void setTranSeq(String tranSeq) {
        this.tranSeq = tranSeq;
    }
}
