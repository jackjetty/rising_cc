package com.bhyf.pojo.dto.enter;

import com.bhyf.model.enter.EnterRecord;

/**
 * Created by admin on 2016/4/12.
 */
public class EnterRecordDetailDto {

    private String enterExamName;
    /*
    '报名人'
     */
    private String userName;
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

    private String mobile;

    private String other1;

    private String other2;

    private String remark;

    private String sex;

    public String getEnterExamName() {
        return enterExamName;
    }

    public void setEnterExamName(String enterExamName) {
        this.enterExamName = enterExamName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void create(EnterRecord enterRecord) {
        setIdNum(enterRecord.getIdNum());
        setStuNo(enterRecord.getStudNo());
        setUserName(enterRecord.getUserName());
        setEnterExamName(enterRecord.getEnterExamName());
        setOther1(enterRecord.getOther1());
        setOther2(enterRecord.getOther2());
        setRemark(enterRecord.getRemark());
        setMobile(enterRecord.getMobile());
        if(enterRecord.getSex() !=null){
            switch (enterRecord.getSex()){
                case 0:
                    setSex("未知");
                case 1:
                    setSex("男");
                case 2:
                    setSex("女");
            }
        }
    }
}
