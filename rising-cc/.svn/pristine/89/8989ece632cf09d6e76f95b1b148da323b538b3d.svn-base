package com.rising.cc.service.interf.log;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.log.CreateLogDBCommand;
import com.rising.cc.pojo.command.log.RemoveLogDBCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/10/22 14:26
 * 修改人：caizh
 * 修改时间：2015/10/22 14:26
 * 修改备注：
 */
public interface LogDBService {

    public String saveLogDB(CreateLogDBCommand command);
    public String removeLogDB(RemoveLogDBCommand command);
    public Pagination findLogDBByPagination(Pagination pagination);

    public String findLogDBsByEnvirId(Integer envirId);
}
