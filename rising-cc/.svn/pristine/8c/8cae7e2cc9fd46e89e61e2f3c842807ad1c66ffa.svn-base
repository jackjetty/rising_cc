package com.rising.cc.service.impl.service;

import com.rising.common.page.Pagination;
import com.google.common.collect.Lists;
import com.rising.cc.dao.service.ServerDao;
import com.rising.cc.dao.service.ServicesDao;
import com.rising.cc.model.service.Server;
import com.rising.cc.model.service.Services;
import com.rising.cc.model.service.ServicesAndServer;
import com.rising.cc.pojo.command.service.*;
import com.rising.cc.pojo.dto.service.ServerDto;
import com.rising.cc.pojo.dto.service.ServicesDto;
import com.rising.cc.service.interf.service.ServerService;
import com.rising.cc.service.interf.service.ServicesService;
import com.rising.cc.util.EntityConvertUtils;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 11:25
 * 修改人：caizh
 * 修改时间：2015/9/11 11:25
 * 修改备注：
 */
@Service
public class ServicesServiceimpl implements ServicesService {

    @Resource
    private ServerDao serverDao;
    @Resource
    private ServicesDao servicesDao;

    @Override
    public Pagination findServicesByPagination(Pagination pagination) {
        List<Services> servicesList = servicesDao.findServicesByPagination(pagination);
        List<ServicesDto> servicesDtoList = Lists.newArrayList();
        Integer totalCount = servicesDao.countServicesByPagination(pagination);
        try{
            servicesDtoList = EntityConvertUtils.convertEntityToDtoList(servicesList, ServicesDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pagination.setList(servicesDtoList);
        pagination.setTotalCount(totalCount);
        return pagination;
    }

    @Override
    public List<ServicesAndServer> findAllServicesAndServer() {
        return servicesDao.findAllServicesAndServer();
    }

    @Override
    public String saveServices(CreateServicesCommand command) {
        Services services = new Services();
        services.create(command);
        servicesDao.saveServices(services);
        return null;
    }

    @Override
    public String updateServices(UpdateServicesCommand command) {
        Services services = new Services();
        services.update(command);
        servicesDao.saveServices(services);
        return null;
    }

    @Override
    public String removeServices(RemoveServicesCommand command) {
        servicesDao.removeServices(command.getId());
        return null;
    }
}
