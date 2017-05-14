package com.rising.cc.model.service;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.service.CreateServerCommand;
import com.rising.cc.pojo.command.service.UpdateServerCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 11:14
 * 修改人：caizh
 * 修改时间：2015/9/11 11:14
 * 修改备注：
 */
public class Server extends BaseModel{
    private String serverName;
    private String ip;
    private Integer type;
    private Integer status;
    private String address;
    private Boolean isEnable;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public void create(CreateServerCommand command) {
        setType(command.getType());
        setAddress(command.getAddress());
        setIp(command.getIp());
        setIsEnable(true);
        setServerName(command.getServerName());
        setStatus(command.getStatus());
    }

    public void update(UpdateServerCommand command) {
        setId(command.getId());
        setType(command.getType());
        setAddress(command.getAddress());
        setIp(command.getIp());
        setIsEnable(true);
        setServerName(command.getServerName());
        setStatus(command.getStatus());
    }
}
