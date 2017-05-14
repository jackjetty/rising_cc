package com.rising.cc.model.service;

import com.rising.cc.common.component.BaseModel;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/14 11:12
 * 修改人：caizh
 * 修改时间：2015/9/14 11:12
 * 修改备注：
 */
public class ServicesAndServer extends BaseModel{
    private Server server;
    private Integer envirId;
    private Integer enginId;
    private String serviceName;
    private String address;
    private Integer port;
    private String remark;
    private Integer status;
    private Boolean isEnable;

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public Integer getEnginId() {
        return enginId;
    }

    public void setEnginId(Integer enginId) {
        this.enginId = enginId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }
}
