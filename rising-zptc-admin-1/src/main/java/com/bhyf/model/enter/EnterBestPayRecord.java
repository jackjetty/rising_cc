package com.bhyf.model.enter;

import com.rising.common.component.BaseModel;

import java.util.Date;

/**
 * Created by admin on 2016/4/12.
 */
public class EnterBestPayRecord extends BaseModel {
    /*
    报名编号
     */
    private Integer enterId;
    /*
    报名考试名称
     */
    private String enterExamName;
    /*
    缴费单号，由用户录入
     */
    private String payNo;
    /*
    报名交易编号，，由系统生成
     */
    private String tradeNo;
    /*
    缴费人手机
     */
    private String payMobile;
    /*
    缴费费用
     */
    private Double payMoney;
    /*
    缴费结果：0，失败；1，成功；
     */
    private Integer status;
    /*
    翼支付网关平台交易流水号（对账依据）
     */
    private String tranSeq;
    /*
    翼支付网关平台交易日期（对账专用）
     */
    private Date tranDate;
    /*
    缴费时间
     */
    private Date createTime;
    /*
    缴费人id
     */
    private Integer userId;

    private String remark;

    public Integer getEnterId() {
        return enterId;
    }

    public void setEnterId(Integer enterId) {
        this.enterId = enterId;
    }

    public String getEnterExamName() {
        return enterExamName;
    }

    public void setEnterExamName(String enterExamName) {
        this.enterExamName = enterExamName;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
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

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
