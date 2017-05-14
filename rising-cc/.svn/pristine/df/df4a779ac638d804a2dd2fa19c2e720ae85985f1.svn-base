package com.rising.cc.service.impl.interf;

import com.rising.common.page.Pagination;
import com.google.common.collect.Lists;
import com.rising.cc.dao.intf.InterfInfoDao;
import com.rising.cc.model.interf.InterfInfo;
import com.rising.cc.pojo.command.interf.CreateInterfInfoCommand;
import com.rising.cc.pojo.command.interf.DeleteInterfInfoCommand;
import com.rising.cc.pojo.command.interf.UpdateInterfInfoCommand;
import com.rising.cc.pojo.dto.interf.InterfInfoDto;
import com.rising.cc.service.interf.interf.InterfInfoService;
import com.rising.cc.util.EntityConvertUtils;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 11:01
 * 修改人：caizh
 * 修改时间：2015/11/17 11:01
 * 修改备注：
 */
@Service
public class InterfInfoServiceImpl implements InterfInfoService {
    @Resource
    private InterfInfoDao interfInfoDao;

    @Override
    public Pagination findInterfInfoByPagination(Pagination pagination) {
        List<InterfInfo> interfInfoList = interfInfoDao.findInterfInfoByPagination(pagination);
        List<InterfInfoDto> interfInfoDtoList = Lists.newArrayList();
        try{
            interfInfoDtoList = EntityConvertUtils.convertEntityToDtoList(interfInfoList,InterfInfoDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pagination.setList(interfInfoDtoList);
        return pagination;
    }
    @Override
    public Pagination findChildInterfInfoByPagination(Pagination pagination) {
        List<InterfInfo> interfInfoList = interfInfoDao.findChildInterfInfoByPagination(pagination);
        List<InterfInfoDto> interfInfoDtoList = Lists.newArrayList();
        try{
            interfInfoDtoList = EntityConvertUtils.convertEntityToDtoList(interfInfoList,InterfInfoDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pagination.setList(interfInfoDtoList);
        return pagination;
    }

    @Override
    public String saveInterfInfo(CreateInterfInfoCommand createInterfInfoCommand) {
        String result = "success";
        InterfInfo interfInfo = new InterfInfo();
        if(!interfInfo.createInterfInfo(createInterfInfoCommand)){
            result = "params is error";
        }else{
            interfInfoDao.insertInterfInfo(interfInfo);
        }
        return result;
    }

    @Override
    public String updateInterfInfo(UpdateInterfInfoCommand updateInterfInfoCommand) {
        String result = "success";
        InterfInfo interfInfo = new InterfInfo();
        if(!interfInfo.updateInterfInfo(updateInterfInfoCommand)){
            result = "params is error";
        }else{
            interfInfoDao.updateInterfInfo(interfInfo);
        }
        return result;
    }

    @Override
    public String deleteInterfInfo(DeleteInterfInfoCommand deleteInterfInfoCommand) {
        String result = "success";
        InterfInfo interfInfo = new InterfInfo();
        if(!interfInfo.deleteInterfInfo(deleteInterfInfoCommand)){
            result = "params is error";
        }else{
            interfInfoDao.deleteInterfInfo(interfInfo);
        }
        return result;
    }
}
