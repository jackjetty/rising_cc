package com.rising.cc.pojo.command.queue;

import com.rising.cc.common.component.BaseCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/1 16:34
 * 修改人：caizh
 * 修改时间：2015/9/1 16:34
 * 修改备注：
 */
public class UpdateQueueCommand extends BaseCommand{
    private Integer customer;
    private Integer handlerId;

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

    public void createCommand(EditQueueCommand command) {
        setId(Integer.parseInt(command.getId()));
        setCustomer(command.getCustomer());
        setHandlerId(command.getHandlerId());
    }
}
