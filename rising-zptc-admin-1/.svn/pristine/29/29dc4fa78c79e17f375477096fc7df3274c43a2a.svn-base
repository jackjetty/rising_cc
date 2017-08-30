package com.bhyf.pojo.dto.enter;

import com.bhyf.model.enter.EnterRecord;
import com.rising.common.component.BaseDto;

/**
 * Created by admin on 2016/4/12.
 */
public class EnterRecordDto extends BaseDto{
    /*
    '翼支付交易单号'
     */
    private String tradeNo;
    /*
    '缴费单号'
     */
    private String payNo;
    /*
    '报名人'
     */
    private String userName;
    /*
    '考试类别'
     */
    private Integer enterCategory;
    /*
    '报名人身份证号'
     */
    private String idNum;
    /*
    '学号'
     */
    private String stuNo;
    /*
    '缴费金额'
     */
    private Double payMoney;

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getEnterCategory() {
        return enterCategory;
    }

    public void setEnterCategory(Integer enterCategory) {
        this.enterCategory = enterCategory;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public Double getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    public void create(EnterRecord enterRecord) {
        setId(enterRecord.getId());
        setEnterCategory(enterRecord.getEnter().getEnterCategory());
        setIdNum(enterRecord.getIdNum());
        setTradeNo(enterRecord.getTradeNo());
        setStuNo(enterRecord.getStudNo());
        setUserName(enterRecord.getUserName());
    }
}
