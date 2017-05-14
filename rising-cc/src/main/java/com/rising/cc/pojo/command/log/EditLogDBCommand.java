package com.rising.cc.pojo.command.log;

import com.rising.cc.common.component.BaseCommand;

import java.io.Serializable;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/10/22 14:33
 * 修改人：caizh
 * 修改时间：2015/10/22 14:33
 * 修改备注：
 */
public class EditLogDBCommand implements Serializable {
    private String id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
