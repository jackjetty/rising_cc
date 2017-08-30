package com.bhyf.model.recharge;

import com.alibaba.fastjson.JSONObject;
import com.rising.common.component.BaseModel;
import com.rising.common.util.DateUtil;

import java.util.Date;

/**
 * Created by admin on 2016/4/15.
 */
public class OneCardRecord extends BaseModel{
    /*
    一卡通回传的标识与serialNo对应
     */
    private String staSID;
    /*
    卡户个人编号与cardNo对应
     */
    private String perCode;
    /*
    交易时间
     */
    private Date dealTime;
    /*
    充值金额
     */
    private Double monDeal;

    public OneCardRecord(JSONObject obj) {
        this.staSID = obj.getString("StaSID");
        this.perCode = obj.getString("PerCode");
        this.dealTime = DateUtil.parseDateTime(obj.getString("DealTime"),"yyyy/M/dd HH:mm:ss");
        this.monDeal = Double.valueOf(obj.getString("MonDeal"));
    }

    public OneCardRecord() {
    }

    public String getStaSID() {
        return staSID;
    }

    public void setStaSID(String staSID) {
        this.staSID = staSID;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    public Double getMonDeal() {
        return monDeal;
    }

    public void setMonDeal(Double monDeal) {
        this.monDeal = monDeal;
    }
}
