package com.bhyf.model.recharge;

import com.rising.common.component.BaseModel;

import java.util.Date;

/**
 * Created by admin on 2016/4/13.
 */
public class RechargeOneCardRecord extends BaseModel{
    /*
    订单号
     */
    private String tradeNo;
    /*
    付费手机号码
     */
    private String payMobile;
    /*
    充值卡号
     */
    private String cardNo;
    /*
    充值金额
     */
    private Double rechMoney;
    /*
    实际支付金额
     */
    private Double payMoney;
    /*
    充值结果：0，表示待支付；1，表示成功;2,表示失败
     */
    private Integer status;
    /*
    充值时间
     */
    private Date rechTime;
    /*
    充值人
     */
    private Integer rechUserId;
    /*
    持卡人
     */
    private String cardHolder;
    /*
    翼支付网关平台交易流水号（对账依据）
     */
    private String tranSeq;
    /*
    翼支付网关平台交易日期（对账专用）
     */
    private Date tranDate;

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getPayMobile() {
        return payMobile;
    }

    public void setPayMobile(String payMobile) {
        this.payMobile = payMobile;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public Double getRechMoney() {
        return rechMoney;
    }

    public void setRechMoney(Double rechMoney) {
        this.rechMoney = rechMoney;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getRechTime() {
        return rechTime;
    }

    public void setRechTime(Date rechTime) {
        this.rechTime = rechTime;
    }

    public Integer getRechUserId() {
        return rechUserId;
    }

    public void setRechUserId(Integer rechUserId) {
        this.rechUserId = rechUserId;
    }

    public String getTranSeq() {
        return tranSeq;
    }

    public void setTranSeq(String tranSeq) {
        this.tranSeq = tranSeq;
    }

    public Date getTranDate() {
        return tranDate;
    }

    public void setTranDate(Date tranDate) {
        this.tranDate = tranDate;
    }
}
