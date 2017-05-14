package com.rising.cc.pojo.command.log;

import com.rising.common.component.BaseCommand;
import com.rising.cc.pojo.dto.log.LogFieldDto;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 14:00
 * 修改人：caizh
 * 修改时间：2015/8/3 14:00
 * 修改备注：
 */
public class CreateLogTableCommand extends BaseCommand {
    private Integer logDBId;
    private String tableName;
    private String name;
    private Integer envirId;

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createCommand(EditLogTableCommand command) {
        setName(command.getName());
        setLogDBId(command.getLogDBId());
        setTableName(command.getTableName());
        setEnvirId(command.getEnvirId());
    }
}
