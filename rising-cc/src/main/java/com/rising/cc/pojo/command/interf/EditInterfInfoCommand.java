package com.rising.cc.pojo.command.interf;

import com.rising.cc.common.component.BaseModel;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:01
 * 修改人：caizh
 * 修改时间：2015/11/17 10:01
 * 修改备注：
 */
public class EditInterfInfoCommand{
    private String id;
    private Integer methodId;
    private Integer parentId;
    private String node;
    private String nodeName;
    private Integer nodeType;
    private Integer nodeLength;
    private String defaultValue;
    private Boolean isEmpty;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMethodId() {
        return methodId;
    }

    public void setMethodId(Integer methodId) {
        this.methodId = methodId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Integer getNodeLength() {
        return nodeLength;
    }

    public void setNodeLength(Integer nodeLength) {
        this.nodeLength = nodeLength;
    }

    public Boolean getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(Boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
