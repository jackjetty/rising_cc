package com.bhyf.model.enter;

import com.rising.common.component.BaseModel;

import java.util.Date;

/**
 * Created by admin on 2016/4/13.
 */
public class BestPayRecord extends BaseModel{

    private String tradeNo;

    private String tranSeq;

    private Integer status;

    private Double money;

    private Date tranDate;

    public BestPayRecord(String tempString,Date date) {
       String[] data =  tempString.split("\\|");
        this.tranSeq = data[1];
        this.tradeNo = data[2];
        this.status = tradeNo.contains("C")?1:0;
        this.money = Double.valueOf(data[4])/100;
        this.tranDate = date;
    }

    public BestPayRecord(){

    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
}
