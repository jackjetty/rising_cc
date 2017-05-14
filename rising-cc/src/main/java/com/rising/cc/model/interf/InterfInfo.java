package com.rising.cc.model.interf;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.interf.CreateInterfInfoCommand;
import com.rising.cc.pojo.command.interf.DeleteInterfInfoCommand;
import com.rising.cc.pojo.command.interf.UpdateInterfInfoCommand;

import org.apache.commons.lang.StringUtils;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:01
 * 修改人：caizh
 * 修改时间：2015/11/17 10:01
 * 修改备注：
 */
public class InterfInfo extends BaseModel{
    private InterfMethod interfMethod;
    private InterfInfo parentInterfInfo;
    private String node;
    private String nodeName;
    private Integer nodeType;
    private Integer nodeLength;
    private String defaultValue;
    private Boolean isEmpty;
    private String remark;

    public InterfInfo getParentInterfInfo() {
        return parentInterfInfo;
    }

    public void setParentInterfInfo(InterfInfo parentInterfInfo) {
        this.parentInterfInfo = parentInterfInfo;
    }

    public InterfMethod getInterfMethod() {
        return interfMethod;
    }

    public void setInterfMethod(InterfMethod interfMethod) {
        this.interfMethod = interfMethod;
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

    public boolean createInterfInfo(CreateInterfInfoCommand createInterfInfoCommand) {
        if(createInterfInfoCommand.getMethodId()== null || createInterfInfoCommand.getMethodId() ==0){
            return  false;
        }
        if(createInterfInfoCommand.getParentId()== null){
            return  false;
        }
        if(StringUtils.isBlank(createInterfInfoCommand.getNode())){
            return false;
        }
        if(createInterfInfoCommand.getNodeType()== null){
            return  false;
        }
        if(createInterfInfoCommand.getIsEmpty()== null){
            return  false;
        }
        InterfMethod interfMethod = new InterfMethod();
        interfMethod.setId(createInterfInfoCommand.getMethodId());
        InterfInfo parentInterfInfo = new InterfInfo();
        parentInterfInfo.setId(createInterfInfoCommand.getParentId());
        setNode(createInterfInfoCommand.getNode());
        setNodeName(createInterfInfoCommand.getNodeName());
        setParentInterfInfo(parentInterfInfo);
        setInterfMethod(interfMethod);
        setNodeType(createInterfInfoCommand.getNodeType());
        setNodeLength(createInterfInfoCommand.getNodeLength());
        setRemark(createInterfInfoCommand.getRemark());
        setIsEmpty(createInterfInfoCommand.getIsEmpty());
        setDefaultValue(createInterfInfoCommand.getDefaultValue());
        return true;
    }

    public boolean updateInterfInfo(UpdateInterfInfoCommand updateInterfInfoCommand) {
        if(updateInterfInfoCommand.getId() == null || updateInterfInfoCommand.getId() ==0){
            return false;
        }
        setId(updateInterfInfoCommand.getId());
        setNode(updateInterfInfoCommand.getNode());
        setNodeName(updateInterfInfoCommand.getNodeName());
        setNodeType(updateInterfInfoCommand.getNodeType());
        setNodeLength(updateInterfInfoCommand.getNodeLength());
        setRemark(updateInterfInfoCommand.getRemark());
        setIsEmpty(updateInterfInfoCommand.getIsEmpty());
        setDefaultValue(updateInterfInfoCommand.getDefaultValue());
        return true;
    }

    public boolean deleteInterfInfo(DeleteInterfInfoCommand deleteInterfInfoCommand) {
        if(deleteInterfInfoCommand.getId() == null || deleteInterfInfoCommand.getId() ==0){
            return false;
        }
        setId(deleteInterfInfoCommand.getId());
        return true;
    }
}
