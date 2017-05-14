package com.rising.cc.model.log;


import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.log.CreateLogFieldCommand;
import com.rising.cc.pojo.command.log.RemoveLogFieldCommand;

import org.apache.commons.lang.StringUtils;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 13:26
 * 修改人：caizh
 * 修改时间：2015/8/3 13:26
 * 修改备注：
 */
public class LogField extends BaseModel {
    private String fieldName;
    private String name;
    private String type;
    private Integer tableId;
    private Boolean isEnable;

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public boolean createLogField(CreateLogFieldCommand command) {
        if(StringUtils.isBlank(command.getName()))
            return false;
        if(StringUtils.isBlank(command.getType()))
            return false;
        if(StringUtils.isBlank(command.getFieldName()))
            return false;
        if(command.getTableId() == null || command.getTableId()==0)
            return false;
        setName(command.getName());
        setType(command.getType());
        setFieldName(command.getFieldName());
        setTableId(command.getTableId());
        setIsEnable(true);
        return true;
    }

    public boolean removeLogField(RemoveLogFieldCommand command) {
        if(command.getId() == null || command.getId() == 0)
            return false;
        setId(command.getId());
        setIsEnable(false);
        return true;
    }
}
