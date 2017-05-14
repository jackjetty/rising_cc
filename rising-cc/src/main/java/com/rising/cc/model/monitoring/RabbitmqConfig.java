package com.rising.cc.model.monitoring;

import com.rising.cc.common.component.BaseModel;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/12/15 9:31
 * 修改人：caizh
 * 修改时间：2015/12/15 9:31
 * 修改备注：
 */
public class RabbitmqConfig extends BaseModel{
    private String queue;
    private Integer alarm;
    private boolean isSendMsg;
    private boolean isSendMail;
    private Integer status;
    private String mobile;
    private String email;

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public Integer getAlarm() {
        return alarm;
    }

    public void setAlarm(Integer alarm) {
        this.alarm = alarm;
    }

    public boolean isSendMsg() {
        return isSendMsg;
    }

    public void setSendMsg(boolean isSendMsg) {
        this.isSendMsg = isSendMsg;
    }

    public boolean isSendMail() {
        return isSendMail;
    }

    public void setSendMail(boolean isSendMail) {
        this.isSendMail = isSendMail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
