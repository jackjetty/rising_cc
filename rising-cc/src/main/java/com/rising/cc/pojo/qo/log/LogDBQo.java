package com.rising.cc.pojo.qo.log;

import com.rising.cc.common.component.BaseQo;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/10/22 15:39
 * 修改人：caizh
 * 修改时间：2015/10/22 15:39
 * 修改备注：
 */
public class LogDBQo extends BaseQo {
    private String dbName;
    private Integer envirId;

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }
}
