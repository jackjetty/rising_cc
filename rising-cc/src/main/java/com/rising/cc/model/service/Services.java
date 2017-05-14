package com.rising.cc.model.service;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.service.CreateServicesCommand;
import com.rising.cc.pojo.command.service.UpdateServicesCommand;

import java.awt.color.CMMException;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 14:30
 * 修改人：caizh
 * 修改时间：2015/9/11 14:30
 * 修改备注：
 */
public class Services extends BaseModel{
    private Integer serverId;
    private Integer envirId;
    private Integer enginId;
    private String serviceName;
    private String address;
    private Integer port;
    private String remark;
    private Integer status;
    private Boolean isEnable;

    public Integer getEnginId() {
        return enginId;
    }
    public void setEnginId(Integer enginId) {
        this.enginId = enginId;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public void update(UpdateServicesCommand command) {
        setId(command.getId());
        setAddress(command.getAddress());
        setEnvirId(command.getEnvirId());
        setPort(command.getPort());
        setRemark(command.getRemark());
        setServerId(command.getServerId());
        setServiceName(command.getServiceName());

    }

    public void create(CreateServicesCommand command) {
        setAddress(command.getAddress());
        setEnginId(command.getEnginId());
        setEnvirId(command.getEnvirId());
        setPort(command.getPort());
        setRemark(command.getRemark());
        setServerId(command.getServerId());
        setServiceName(command.getServiceName());
    }
}
