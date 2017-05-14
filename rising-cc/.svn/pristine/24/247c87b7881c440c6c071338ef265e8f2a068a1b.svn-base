package com.rising.cc.model.queue;


import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.queue.CreateQueueCommand;
import com.rising.cc.pojo.command.queue.DeleteQueueCommand;
import com.rising.cc.pojo.command.queue.UpdateQueueCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/31 17:29
 * 修改人：caizh
 * 修改时间：2015/8/31 17:29
 * 修改备注：
 */
public class Queue extends BaseModel {

    private String name;
    private String exchange;
    private String queue;
    private Integer customer;
    private Handler handler;
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


    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public void updateCustomer(UpdateQueueCommand command) {
        setCustomer(command.getCustomer());
        setId(command.getId());
    }


    public void createQueue(CreateQueueCommand command) {
        handler = new Handler();
        handler.setId(command.getHandlerId());
        setId(command.getId());
        setCustomer(command.getCustomer());
        setName(command.getName());
        setExchange(command.getExchange());
        setHandler(handler);
        setQueue(command.getQueue());
        setEnvirId(command.getEnvirId());
    }

    public void deleteQueue(DeleteQueueCommand command) {
        setId(command.getId());
    }

    public void updateHandler(UpdateQueueCommand command) {
        handler = new Handler();
        handler.setId(command.getHandlerId());
        setId(command.getId());
        setHandler(handler);
    }
}
