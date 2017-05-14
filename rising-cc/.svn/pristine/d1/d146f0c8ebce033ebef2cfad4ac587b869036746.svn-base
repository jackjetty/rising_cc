package com.rising.cc.dao.log;

import com.rising.common.page.Pagination;
import com.rising.cc.model.log.LogField;
import com.rising.cc.model.log.LogTable;
import com.rising.cc.pojo.qo.log.LogTableQo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 14:42
 * 修改人：caizh
 * 修改时间：2015/8/3 14:42
 * 修改备注：
 */
public interface LogTableDao {

    public List<LogTable> findLogTableByPagination(Pagination pagination);
    public List<LogField> findLogTableFieldByPagination(Pagination pagination);
    public Integer countLogTableByPagination(Pagination pagination);
    public Integer countLogTableFieldByPagination(Pagination pagination);


    public LogTable findLogTableAndFieldById(@Param("id")Integer id);

    public List<LogTable> findAllLogTable();

    public Integer saveLogTable(LogTable logTable);

    public void syncLogTable(LogTable logTable);

    public Integer removeLogTable(LogTable logTable);

    public Integer saveLogField(LogField logField);

    public Integer removeLogField(LogField logField);


    public List<LogTable> findlogTableByQo(LogTableQo qo);
}
