package com.rising.cc.pojo.qo.log;

import com.rising.common.component.BaseQo;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/4 9:03
 * 修改人：caizh
 * 修改时间：2015/8/4 9:03
 * 修改备注：
 */
public class LogQo extends BaseQo{
    private String qos;
    private Integer envirId;

    public String getQos() {
        return qos;
    }

    public void setQos(String qos) {
        this.qos = qos;
    }

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }
}
