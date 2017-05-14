package com.rising.cc.model.queue;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.queue.CreateHandlerCommand;
import com.rising.cc.pojo.command.queue.UpdateHandlerCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/1 9:35
 * 修改人：caizh
 * 修改时间：2015/9/1 9:35
 * 修改备注：
 */
public class Handler extends BaseModel {
    private String name;
    private String url;
    private String failUrl;
    private Integer rate;
    private Integer type;
    private Integer envirId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFailUrl() {
        return failUrl;
    }

    public void setFailUrl(String failUrl) {
        this.failUrl = failUrl;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public void createHandler(CreateHandlerCommand command) {
        setName(command.getName());
        setFailUrl(command.getFailUrl());
        setRate(command.getRate());
        setType(command.getType());
        setUrl(command.getUrl());
        setEnvirId(command.getEnvirId());
    }

    public void updateHandler(UpdateHandlerCommand command){
        setId(command.getId());
        setUrl(command.getUrl());
        setType(command.getType());
        setRate(command.getRate());
        setFailUrl(command.getFailUrl());
        setName(command.getName());
        setEnvirId(command.getEnvirId());
    }

}
