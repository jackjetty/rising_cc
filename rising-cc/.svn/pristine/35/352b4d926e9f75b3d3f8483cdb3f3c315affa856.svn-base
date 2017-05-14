package com.rising.cc.service.impl.interf;

import com.rising.common.page.Pagination;
import com.google.common.collect.Lists;
import com.rising.cc.dao.intf.InterfManagerDao;
import com.rising.cc.dao.service.ServicesDao;
import com.rising.cc.model.interf.InterfManager;
import com.rising.cc.model.interf.InterfMethod;
import com.rising.cc.model.project.Engineering;
import com.rising.cc.model.service.Services;
import com.rising.cc.model.service.ServicesAndServer;
import com.rising.cc.pojo.command.interf.CreateInterfManagerCommand;
import com.rising.cc.pojo.command.interf.DeleteInterfManagerCommand;
import com.rising.cc.pojo.dto.interf.InterfManagerDto;
import com.rising.cc.pojo.dto.interf.InterfMethodDto;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.qo.service.ServicesQo;
import com.rising.cc.service.interf.interf.InterfManagerService;
import com.rising.cc.service.interf.service.ServicesService;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 11:05
 * 修改人：caizh
 * 修改时间：2015/11/17 11:05
 * 修改备注：
 */
@Service
public class InterfManagerServiceImpl implements InterfManagerService {

    @Resource
    private InterfManagerDao interfManagerDao;
    @Resource
    private ServicesDao servicesDao;

    @Override
    public Pagination findInterfManangerByPagination(Pagination pagination) {
        ServicesQo qo = new ServicesQo();
        Engineering engineering;
        InterfMethod interfMethod;
        InterfManagerDto interfManagerDto;
        List<InterfManager> interfManagerList = interfManagerDao.findInterfManagerByPagination(pagination);
        Integer total = interfManagerDao.countInterfManagerByPagination(pagination);
        List<InterfManagerDto> interfManagerDtoList = Lists.newArrayList();
        for (InterfManager interfManager : interfManagerList) {
            interfMethod = interfManager.getInterfMethod();
            engineering = interfManager.getEngineering();
            interfManagerDto = new InterfManagerDto(interfManager.getEnvirId(),engineering.getEngineeringName(),interfMethod.getMethod(),interfMethod.getSpecification());
//            qo.setEnvirId(interfManager.getEnvirId());
//            qo.setEnginId(interfManager.getEngineering().getId());
//            List<ServicesAndServer> servicesList = servicesDao.findServicesAndServerByQo(qo);
//            interfMethodDto = new InterfMethodDto();
//            BeanUtils.copyProperties(interfManager.getInterfMethod(),interfMethodDto);
//            engineeringDto = new EngineeringDto();
//            BeanUtils.copyProperties(interfManager.getEngineering(),engineeringDto);
//            interfManagerDto.setEngineering(engineeringDto);
//            interfManagerDto.setInterfMethod(interfMethodDto);
//            interfManagerDto.setEnvirId(interfManager.getEnvirId());
            interfManagerDtoList.add(interfManagerDto);
        }
        pagination.setTotalCount(total);
        pagination.setList(interfManagerDtoList);
        return pagination;
    }

    @Override
    public String saveInterfManager(CreateInterfManagerCommand command) {
        String result = "success";
        InterfManager interfManager = new InterfManager();
        if(!interfManager.createInterfManager(command)){
            result = "param is error";
        }else{
            interfManagerDao.insertInterfManager(interfManager);
        }


        return result;
    }

    @Override
    public String deleteInterfManager(DeleteInterfManagerCommand command) {
        String result = "success";
        InterfManager interfManager = new InterfManager();
        if(!interfManager.deleteInterfManager(command)){
            result = "param is error";
        }else{
            interfManagerDao.deleteInterfManager(interfManager);
        }
        return result;
    }
}
