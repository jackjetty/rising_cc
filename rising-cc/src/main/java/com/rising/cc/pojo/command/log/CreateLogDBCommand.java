package com.rising.cc.pojo.command.log;

import com.rising.cc.common.component.BaseCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/10/22 14:29
 * 修改人：caizh
 * 修改时间：2015/10/22 14:29
 * 修改备注：
 */
public class CreateLogDBCommand extends BaseCommand {
    private String dbName;
    private String name;
    private Integer envirId;

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

    public void createCommand(EditLogDBCommand command) {
        setDbName(command.getDbName());
        setEnvirId(command.getEnvirId());
        setName(command.getName());
    }
}