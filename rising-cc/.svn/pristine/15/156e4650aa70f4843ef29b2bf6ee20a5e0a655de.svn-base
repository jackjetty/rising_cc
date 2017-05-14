package com.rising.cc.model.log;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.log.CreateLogDBCommand;
import com.rising.cc.pojo.command.log.RemoveLogDBCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/10/22 14:22
 * 修改人：caizh
 * 修改时间：2015/10/22 14:22
 * 修改备注：
 */
public class LogDB extends BaseModel{
    private String dbName;
    private String name;
    private Integer envirId;
    private Boolean isEnable;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Boolean saveLogDB(CreateLogDBCommand command) {
        boolean flag = true;
        setName(command.getName());
        if(command.getEnvirId() == null){
            flag = false;
        }else{
            setEnvirId(command.getEnvirId());
        }
        setDbName(command.getDbName());
        setIsEnable(true);
        return flag;
    }

    public Boolean removeLogDB(RemoveLogDBCommand command) {
        boolean flag = true;
        if(command.getId() == null){
            flag = false;
        }else {
            setId(command.getId());
        }
        setIsEnable(false);
        return flag;
    }
}
