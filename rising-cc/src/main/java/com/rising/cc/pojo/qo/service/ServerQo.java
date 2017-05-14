package com.rising.cc.pojo.qo.service;

import com.rising.cc.common.component.BaseQo;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 13:20
 * 修改人：caizh
 * 修改时间：2015/9/11 13:20
 * 修改备注：
 */
public class ServerQo extends BaseQo {
    private String serverName;
    private String ip;
    private Integer type;
    private Integer status;

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
}
