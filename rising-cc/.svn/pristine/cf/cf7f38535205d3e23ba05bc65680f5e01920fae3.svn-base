package com.rising.cc.service.impl.envir;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.rising.cc.dao.envir.EnvirTypeDao;
import com.rising.cc.model.envir.EnvirType;
import com.rising.cc.pojo.dto.envir.EnvirTypeDto;
import com.rising.cc.service.interf.envir.EnvirTypeService;

@Service
public class EnvirTypeServiceImpl implements EnvirTypeService{

	@Resource
	private  EnvirTypeDao envirTypeDao; 
	
	public List<EnvirTypeDto> findEnvirTypeListAll() {
		
		List<EnvirType> envirTypeList = envirTypeDao.findEnvirTypeListAll();
		
		List<EnvirTypeDto> dtoList = new ArrayList<EnvirTypeDto>();
		
		for (EnvirType envirType : envirTypeList) {
			EnvirTypeDto dto = new EnvirTypeDto();
			
			BeanUtils.copyProperties(envirType, dto);
			
			dtoList.add(dto);
			
		}
		
		return dtoList;
	}

	@Override
	public List<EnvirTypeDto> findEnvirTypeListByUserId(Integer userId) {
		
		List<EnvirType> envirTypeList = envirTypeDao.findEnvirTypeListByUserId(userId);
		
		List<EnvirTypeDto> dtoList = new ArrayList<EnvirTypeDto>();
		
		for (EnvirType envirType : envirTypeList) {
			EnvirTypeDto dto = new EnvirTypeDto();
			
			BeanUtils.copyProperties(envirType, dto);
			
			dtoList.add(dto);
			
		}
		
		return dtoList;
	}

}
