package com.rising.cc.service.impl.project;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.project.EnginConfigInfoDao;
import com.rising.cc.dao.project.EnginConfigTypeDao;
import com.rising.cc.model.project.EnginConfigType;
import com.rising.cc.pojo.command.project.CreateEnginConfigTypeCommand;
import com.rising.cc.pojo.command.project.DeleteEnginConfigTypeCommand;
import com.rising.cc.pojo.command.project.UpdateEnginConfigTypeCommand;
import com.rising.cc.pojo.dto.project.EnginConfigTypeDto;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.qo.project.EnginConfigTypeQo;
import com.rising.cc.service.interf.project.EnginConfigTypeService;


/**
 * 
 * @description 工程配置类型
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:26:58
 *
 */
@Service
public class EnginConfigTypeServiceImpl implements EnginConfigTypeService{
	
	@Resource
	private EnginConfigTypeDao enginConfigTypeDao;
	
	@Resource
	private EnginConfigInfoDao enginConfigInfoDao;

	public Pagination findEnginConfigTypeListByPagination(Pagination pagination) {
		
		List<EnginConfigType> enginConfigTypeList = enginConfigTypeDao.findEnginConfigTypeListByPagination(pagination);
		
		List<EnginConfigTypeDto> dtoList = new ArrayList<EnginConfigTypeDto>(); 
		
		for (EnginConfigType enginConfigType : enginConfigTypeList) {
			EnginConfigTypeDto dto = new EnginConfigTypeDto();
			BeanUtils.copyProperties(enginConfigType, dto);
			
			EngineeringDto enginDto = new EngineeringDto();
			if(enginConfigType.getEngin() == null){
				enginDto.setId(0);
			}else{
				BeanUtils.copyProperties(enginConfigType.getEngin(), enginDto);
				
			}
			dto.setEnginDto(enginDto);
			dto.setEnginId(enginDto.getId());
			dtoList.add(dto);
		}
		
		pagination.setList(dtoList);
		pagination.setTotalCount(enginConfigTypeDao.countEnginConfigTypeListByPagination(pagination));
		
		return pagination;
	}

	@Transactional
	public boolean saveEnginConfigType(CreateEnginConfigTypeCommand command) {

		EnginConfigType enginConfigType = new EnginConfigType();
		enginConfigType.createEnginConfigType(command);
		
		enginConfigTypeDao.insertEnginConfigType(enginConfigType);
		
		return true;
	}

	@Transactional
	public boolean updateEnginConfigType(
			UpdateEnginConfigTypeCommand command) {

		EnginConfigType enginConfigType = new EnginConfigType();
		enginConfigType.updateEnginConfigType(command);
		
		enginConfigTypeDao.updateEnginConfigType(enginConfigType);
		return true;
	}

	@Transactional
	public boolean deleteEnginConfigType(
			DeleteEnginConfigTypeCommand command) {
		
		if(enginConfigInfoDao.countEnginConfigTypeByEnginConfigTypeId(command.getIds()) > 0){
			return false;
		}
		
		enginConfigTypeDao.deleteBatchEnginConfigType(command.getIds());

		return true;
	}

	public List<EnginConfigTypeDto> findEnginConfigTypeListByQo(
			EnginConfigTypeQo qo) {
		
		
		List<EnginConfigType> enginConfigTypeList = enginConfigTypeDao.findEnginConfigTypeListByQo(qo);
		List<EnginConfigTypeDto> dtoList = new ArrayList<EnginConfigTypeDto>();
		
		for (EnginConfigType configType : enginConfigTypeList) {
			EnginConfigTypeDto dto = new EnginConfigTypeDto();
			BeanUtils.copyProperties(configType, dto);
			dtoList.add(dto);
			
		}
		
		
		return dtoList;
	}

}
