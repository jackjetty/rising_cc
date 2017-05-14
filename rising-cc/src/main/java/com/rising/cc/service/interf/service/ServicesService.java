package com.rising.cc.service.interf.service;

import com.rising.common.page.Pagination;
import com.rising.cc.model.service.ServicesAndServer;
import com.rising.cc.pojo.command.service.*;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 11:24
 * 修改人：caizh
 * 修改时间：2015/9/11 11:24
 * 修改备注：
 */
public interface ServicesService {
    public Pagination findServicesByPagination(Pagination pagination);
    public List<ServicesAndServer> findAllServicesAndServer();

    public String saveServices(CreateServicesCommand command);
    public String updateServices(UpdateServicesCommand command);
    public String removeServices(RemoveServicesCommand command);
}
