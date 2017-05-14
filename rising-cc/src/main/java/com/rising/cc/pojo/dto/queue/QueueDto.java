package com.rising.cc.pojo.dto.queue;


import com.rising.cc.common.component.BaseDto;
import com.rising.cc.common.component.BaseModel;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/31 17:29
 * 修改人：caizh
 * 修改时间：2015/8/31 17:29
 * 修改备注：
 */
public class QueueDto extends BaseDto {

    private String name;
    private String exchange;
    private String queue;
    private Integer customer;
    private Integer handlerId;

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
}
