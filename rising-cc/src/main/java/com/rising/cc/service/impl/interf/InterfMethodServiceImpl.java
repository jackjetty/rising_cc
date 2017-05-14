package com.rising.cc.service.impl.interf;

import com.rising.common.page.Pagination;
import com.google.common.collect.Lists;
import com.rising.cc.dao.intf.InterfMethodDao;
import com.rising.cc.model.interf.InterfInfo;
import com.rising.cc.model.interf.InterfMethod;
import com.rising.cc.pojo.command.interf.CreateInterfMethodCommand;
import com.rising.cc.pojo.command.interf.RemoveInterfMethodCommand;
import com.rising.cc.pojo.command.interf.UpdateInterfMethodCommand;
import com.rising.cc.pojo.dto.interf.InterfInfoDto;
import com.rising.cc.pojo.dto.interf.InterfManagerDto;
import com.rising.cc.pojo.dto.interf.InterfMethodDto;
import com.rising.cc.pojo.qo.interf.InterfMethodQo;
import com.rising.cc.service.interf.interf.InterfMethodService;
import com.rising.cc.util.EntityConvertUtils;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 11:04
 * 修改人：caizh
 * 修改时间：2015/11/17 11:04
 * 修改备注：
 */
@Service
public class InterfMethodServiceImpl implements InterfMethodService {
    @Resource
    private InterfMethodDao interfMethodDao;
    @Override
    public Pagination findInterfMethodByPagination(Pagination pagination) {
        List<InterfMethod> interfMethodList = interfMethodDao.findInterfMethodByPagination(pagination);
        Integer total = interfMethodDao.countInterfMethodByPagination(pagination);
        List<InterfMethodDto> interfMethodDtoList = Lists.newArrayList();
        try {
            interfMethodDtoList = EntityConvertUtils.convertEntityToDtoList(interfMethodList,InterfMethodDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pagination.setList(interfMethodDtoList);
        pagination.setTotalCount(total);
        return pagination;
    }

    @Override
    public String saveInterfMethod(CreateInterfMethodCommand createInterfMethodCommand) {
        String result = "success";
        InterfMethod interfMethod = new InterfMethod();
        if(!interfMethod.createInterfMethod(createInterfMethodCommand)){
            result = "param is error";
        }else{
            interfMethodDao.insertInterfMethod(interfMethod);
        }
        return result;
    }

    @Override
    public String updateInterfMethod(UpdateInterfMethodCommand updateInterfMethodCommand) {
        String result = "success";
        InterfMethod interfMethod = new InterfMethod();
        if(!interfMethod.updateInterfMethod(updateInterfMethodCommand)){
            result = "param is error";
        }else{
            interfMethodDao.updateInterfMethod(interfMethod);
        }
        return result;
    }

    @Override
    public String removeInterfMethod(RemoveInterfMethodCommand removeInterfMethodCommand) {
        String result = "success";
        InterfMethod interfMethod = new InterfMethod();
        if(!interfMethod.removeInterfMethod(removeInterfMethodCommand)){
            result = "param is error";
        }else{
            interfMethodDao.removeInterfMethod(interfMethod);
        }
        return result;
    }

    @Override
    public List<InterfMethodDto> findInterfMethodByQo(InterfMethodQo interfMethodQo) {
        List<InterfMethod> interfMethodList = interfMethodDao.findInterfMethodByQo(interfMethodQo);
        List<InterfMethodDto> interfMethodDtoList = Lists.newArrayList();
        try {
            interfMethodDtoList = EntityConvertUtils.convertEntityToDtoList(interfMethodList,InterfMethodDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return interfMethodDtoList;
    }
}
