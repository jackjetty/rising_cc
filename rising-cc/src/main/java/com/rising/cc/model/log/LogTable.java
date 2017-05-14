package com.rising.cc.model.log;


import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.log.CopyLogTableToEnvirCommand;
import com.rising.cc.pojo.command.log.CreateLogTableCommand;
import com.rising.cc.pojo.command.log.RemoveLogTableCommand;
import com.rising.cc.pojo.dto.log.LogFieldDto;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
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
public class LogTable extends BaseModel {
    private LogDB logDB;
    private String tableName;
    private String name;
    private Date createDate;
    private Boolean isEnable;
    private Boolean isSync;
    private List<LogField> fieldList;
    private Integer envirId;


    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public LogDB getLogDB() {
        return logDB;
    }

    public void setLogDB(LogDB logDB) {
        this.logDB = logDB;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<LogField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<LogField> fieldList) {
        this.fieldList = fieldList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Boolean getIsEnable() {
        return isEnable;
    }
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Boolean getIsSync() {
        return isSync;
    }

    public void setIsSync(Boolean isSync) {
        this.isSync = isSync;
    }

    public boolean createLogTable(CreateLogTableCommand command){
        if(command.getLogDBId() == null || command.getLogDBId() ==0){
            return false;
        }
        if(command.getEnvirId() == null || command.getEnvirId() ==0){
            return false;
        }
        if(StringUtils.isBlank(command.getName())){
            return false;
        }
        if(StringUtils.isBlank(command.getTableName())){
            return false;
        }
        logDB = new LogDB();
        logDB.setId(command.getLogDBId());
        setLogDB(logDB);
        setTableName(command.getTableName());
        setName(command.getName());
        setCreateDate(new Date());
        setIsEnable(true);
        setIsSync(false);
        setEnvirId(command.getEnvirId());
        return true;
    }


    public void removeLogTable() {
        setIsEnable(false);
    }

    public boolean updateEnvir(CopyLogTableToEnvirCommand command) {
        if(command.getEnvirId() ==null || command.getEnvirId() == 0){
            return false;
        }
        setIsSync(false);
        setEnvirId(command.getEnvirId());
        return true;
    }
}
