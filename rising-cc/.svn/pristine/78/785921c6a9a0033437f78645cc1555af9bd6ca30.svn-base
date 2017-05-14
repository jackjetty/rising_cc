package com.rising.cc.dao.service;

import com.rising.common.page.Pagination;
import com.rising.cc.model.service.Server;
import com.rising.cc.model.service.Services;
import com.rising.cc.model.service.ServicesAndServer;
import com.rising.cc.pojo.qo.service.ServicesQo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 14:37
 * 修改人：caizh
 * 修改时间：2015/9/11 14:37
 * 修改备注：
 */
public interface ServicesDao {
    public List<ServicesAndServer> findServicesAndServerByQo(ServicesQo qo);
    public List<Services> findServicesByPagination(Pagination pagination);
    public Integer countServicesByPagination(Pagination pagination);
    public List<ServicesAndServer> findAllServicesAndServer();

    public Integer saveServices(Services services);
    public Integer updateServices(Services services);
    public Integer removeServices(Integer id);
}
