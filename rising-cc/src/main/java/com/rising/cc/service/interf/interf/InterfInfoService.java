package com.rising.cc.service.interf.interf;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.interf.CreateInterfInfoCommand;
import com.rising.cc.pojo.command.interf.DeleteInterfInfoCommand;
import com.rising.cc.pojo.command.interf.UpdateInterfInfoCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:56
 * 修改人：caizh
 * 修改时间：2015/11/17 10:56
 * 修改备注：
 */
public interface InterfInfoService {
    public Pagination findInterfInfoByPagination(Pagination pagination);

    Pagination findChildInterfInfoByPagination(Pagination pagination);

    public String saveInterfInfo(CreateInterfInfoCommand createInterfInfoCommand);
    public String updateInterfInfo(UpdateInterfInfoCommand updateInterfInfoCommand);
    public String deleteInterfInfo(DeleteInterfInfoCommand deleteInterfInfoCommand);
}
