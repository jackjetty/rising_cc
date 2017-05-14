package com.rising.cc.pojo.qo.log;


import com.rising.cc.common.component.BaseQo;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 16:48
 * 修改人：caizh
 * 修改时间：2015/8/3 16:48
 * 修改备注：
 */
public class LogTableQo extends BaseQo {
    private String tableName;
    private String dbName;
    private Integer envirId;

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

}
