package com.rising.cc.pojo.qo.interf;


import com.rising.cc.common.component.BaseQo;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/31 17:29
 * 修改人：caizh
 * 修改时间：2015/8/31 17:29
 * 修改备注：
 */
public class InterfInfoQo extends BaseQo {

    private Integer parentId;
    private Integer methodId;

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getMethodId() {
        return methodId;
    }

    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }
}
