package com.rising.cc.pojo.command.queue;

import com.rising.cc.common.component.BaseCommand;
import com.rising.cc.model.service.ServicesAndServer;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/7 9:54
 * 修改人：caizh
 * 修改时间：2015/9/7 9:54
 * 修改备注：
 */
public class CreateQueueCommand extends BaseCommand{
    private String name;
    private String exchange;
    private String queue;
    private Integer customer;
    private Integer handlerId;
    private Integer envirId;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public Integer getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }


    public Integer getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Integer handlerId) {
        this.handlerId = handlerId;
    }

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public void createCommand(EditQueueCommand command) {
        setHandlerId(command.getHandlerId());
        setExchange(command.getExchange());
        setName(command.getName());
        setQueue(command.getQueue());
        setCustomer(command.getCustomer());
        setEnvirId(command.getEnvirId());
    }


}
