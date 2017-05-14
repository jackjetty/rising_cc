package com.rising.cc.pojo.dto.log;


import com.rising.common.component.BaseDto;
import com.google.common.collect.Lists;
import com.rising.cc.model.log.LogField;
import com.rising.cc.model.log.LogTable;
import com.rising.cc.util.EntityConvertUtils;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 13:22
 * 修改人：caizh
 * 修改时间：2015/8/3 13:22
 * 修改备注：
 */
public class LogTableDto extends BaseDto {
    private Integer logDBId;
    private String tableName;
    private String name;
    private Boolean isSync;
    private List<LogFieldDto> fieldList;

    public Integer getLogDBId() {
        return logDBId;
    }

    public void setLogDBId(Integer logDBId) {
        this.logDBId = logDBId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<LogFieldDto> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<LogFieldDto> fieldList) {
        this.fieldList = fieldList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsSync() {
        return isSync;
    }
    public void setIsSync(Boolean isSync) {
        this.isSync = isSync;
    }

    public LogTableDto(Integer logDBId, String tableName, String name, List<LogFieldDto> fieldList) {
        this.logDBId = logDBId;
        this.tableName = tableName;
        this.name = name;
        this.fieldList = fieldList;
    }

    public LogTableDto() {
    }

    public void createLogTableAndField(LogTable logTable) {
        setLogDBId(logTable.getLogDB().getId());
        setId(logTable.getId());
        setTableName(logTable.getTableName());
        setIsSync(logTable.getIsSync());
        List<LogFieldDto> logFieldListDto = Lists.newArrayList();
        try{
            logFieldListDto = EntityConvertUtils.convertEntityToDtoList(logTable.getFieldList(), LogFieldDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        setFieldList(logFieldListDto);
    }
}
