package com.rising.cc.pojo.command.service;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.model.service.Server;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 14:30
 * 修改人：caizh
 * 修改时间：2015/9/11 14:30
 * 修改备注：
 */
public class EditServicesCommand{
    private String id;
    private Integer serverId;
    private Integer envirId;
    private Integer enginId;
    private String serviceName;
    private String address;
    private Integer port;
    private String remark;
    private Boolean isEnable;
    private Integer status;

    public Integer getEnginId() {
        return enginId;
    }

    public void setEnginId(Integer enginId) {
        this.enginId = enginId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getServerId() {
        return serverId;
    }

    public void setServerId(Integer serverId) {
        this.serverId = serverId;
    }

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
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

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
