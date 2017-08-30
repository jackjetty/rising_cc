package com.bhyf.pojo.dto.recharge;

import com.bhyf.model.recharge.RechargeOneCardRecord;
import com.rising.common.component.BaseDto;
import com.rising.common.util.DateUtil;

import java.util.Date;

/**
 * Created by admin on 2016/4/13.
 */
public class RechargeOneCardRecordDetailDto extends BaseDto {
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
    充值结果：0，表示失败；1，表示成功
     */
    private String status;
    /*
    充值时间
     */
    private String rechTime;
    /*
    充值人
     */
    private String userName;
    /*
    持卡人
     */
    private String cardHolder;
    /*
    实际支付金额
     */
    private Double payMoney;
    /*
    翼支付网关平台交易流水号（对账依据）
     */
    private String tranSeq;
    /*
    翼支付网关平台交易日期（对账专用）
     */
    private String tranDate;


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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRechTime() {
        return rechTime;
    }

    public void setRechTime(String rechTime) {
        this.rechTime = rechTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public String getTranSeq() {
        return tranSeq;
    }

    public void setTranSeq(String tranSeq) {
        this.tranSeq = tranSeq;
    }


    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public void create(RechargeOneCardRecord rechargeOneCardRecord) {
        setTradeNo(rechargeOneCardRecord.getTradeNo());
        setCardNo(rechargeOneCardRecord.getCardNo());
        setPayMobile(rechargeOneCardRecord.getPayMobile());
        setPayMoney(rechargeOneCardRecord.getPayMoney());
        setRechMoney(rechargeOneCardRecord.getRechMoney());
        setRechTime(DateUtil.formatDateTime(rechargeOneCardRecord.getRechTime(),"yyyy-MM-dd HH:mm:ss"));
        if(rechargeOneCardRecord.getStatus() != null) {
            switch (rechargeOneCardRecord.getStatus()) {
                case 0:
                    setStatus("待支付");
                    break;
                case 1:
                    setStatus("成功");
                    break;
                case 2:
                    setStatus("失败");
                    break;
            }
        }
        setTranSeq(rechargeOneCardRecord.getTranSeq());
        setUserName(rechargeOneCardRecord.getCardHolder());
        setTranDate(DateUtil.formatDateTime(rechargeOneCardRecord.getRechTime(),"yyyy-MM-dd HH:mm:ss"));
    }
}
