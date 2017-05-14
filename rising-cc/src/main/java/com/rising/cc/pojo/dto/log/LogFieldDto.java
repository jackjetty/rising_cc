package com.rising.cc.pojo.dto.log;


import com.rising.common.component.BaseDto;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 13:26
 * 修改人：caizh
 * 修改时间：2015/8/3 13:26
 * 修改备注：
 */
public class LogFieldDto extends BaseDto {
    private String fieldName;
    private String name;
    private String type;
    private Integer tableId;

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

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public LogFieldDto() {
    }

}
