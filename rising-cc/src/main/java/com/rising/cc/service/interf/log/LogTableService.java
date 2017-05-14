package com.rising.cc.service.interf.log;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.log.*;
import com.rising.cc.pojo.dto.log.LogTableDto;
import com.rising.cc.pojo.qo.log.LogTableQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 14:24
 * 修改人：caizh
 * 修改时间：2015/8/3 14:24
 * 修改备注：
 */
public interface LogTableService {
    public String saveLogTable(CreateLogTableCommand command);
    public String removeLogTable(RemoveLogTableCommand command);
    public String saveLogField(CreateLogFieldCommand command);
    public String removeLogField(RemoveLogFieldCommand command);

    public Pagination findLogTableByPagination(Pagination pagination);
    public List<LogTableDto> findLogTableByQo(LogTableQo qo);
    public LogTableDto findLogTableAndFieldById(Integer id);
    public Pagination findLogTableFieldByPagination(Pagination pagination);

    public String createLogServiceTable(CreateLogServiceTableCommand command);
    public String copyLogTableToEnvir(CopyLogTableToEnvirCommand command);
}
