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
import com.rising.cc.dao.project.EngineeringDao;
import com.rising.cc.model.project.Engineering;
import com.rising.cc.pojo.command.project.CreateEngineeringCommand;
import com.rising.cc.pojo.command.project.DeleteEngineeringCommand;
import com.rising.cc.pojo.command.project.UpdateEngineeringCommand;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.dto.project.ProjectDto;
import com.rising.cc.pojo.qo.project.EngineeringQo;
import com.rising.cc.service.interf.project.EngineeringService;


/**
 * 
 * @description 工程配置信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:26:58
 *
 */
@Service
public class EngineeringServiceImpl implements EngineeringService{

	@Resource
	private EngineeringDao engineeringDao;
	
	@Resource
	private EnginConfigInfoDao enginConfigInfoDao;
	
	@Resource
	private EnginConfigTypeDao enginConfigTypeDao;
	
	public Pagination findEnginListByPagination(Pagination pagination) {

		List<Engineering> enginList = engineeringDao.findEngineeringListByPagination(pagination);
		List<EngineeringDto> dtoList = new ArrayList<EngineeringDto>(); 
		
		for (Engineering engin : enginList) {
			EngineeringDto dto = new EngineeringDto();
			ProjectDto projectDto = new ProjectDto();
			
			BeanUtils.copyProperties(engin.getProject(), projectDto);
			BeanUtils.copyProperties(engin, dto);
			
			dto.setProjectDto(projectDto);
			dto.setProjectId(projectDto.getId());
			dtoList.add(dto);
			
		}
		pagination.setList(dtoList);
		pagination.setTotalCount(engineeringDao.countEngineeringListByPagination(pagination));
		
		return pagination;
	}

	@Transactional
	public boolean saveEngineering(CreateEngineeringCommand addCommand) {

		Engineering engin = new Engineering();
		engin.createEngineering(addCommand);
		
		EngineeringQo qo = new EngineeringQo();
		qo.setEngineeringCode(engin.getEngineeringCode());
		List<Engineering> list = engineeringDao.findEngineeringListByQo(qo);
		if(list != null && list.size() > 0){
			return false;
		}

		engineeringDao.insertEngineering(engin);
		
		return true;
	}

	@Transactional
	public boolean updateEngineering(UpdateEngineeringCommand updateCommand) {
		Engineering engin = new Engineering();
		engin.updateEngineering(updateCommand);
		
		EngineeringQo qo = new EngineeringQo();
		qo.setEngineeringCode(engin.getEngineeringCode());
		List<Engineering> list = engineeringDao.findEngineeringListByQo(qo);
		if(list != null){
			for(Engineering e : list){
				if(e.getEngineeringCode().equals(engin.getEngineeringCode()) 
						&& !e.getId().equals(engin.getId())){
					return false;
				}
			}
		}
		
		engineeringDao.updateEngineering(engin);
		
		return true;
	}

	@Transactional
	public boolean deleteEngineering(DeleteEngineeringCommand deleteCommand) {
		
		engineeringDao.deleteBatchEngineering(deleteCommand.getIds());
		enginConfigInfoDao.deleteBatchEnginConfigInfoByEnginIds(deleteCommand.getIds());
		enginConfigTypeDao.deleteBatchEnginConfigTypeByEnginIds(deleteCommand.getIds());
		
		return true;
	}

	public List<EngineeringDto> findEngineeringListByQo(EngineeringQo qo) {
		List<Engineering> enginList = engineeringDao.findEngineeringListByQo(qo);
		List<EngineeringDto> dtoList = new ArrayList<EngineeringDto>(); 
		
		for (Engineering engin : enginList) {
			EngineeringDto dto = new EngineeringDto();
			ProjectDto projectDto = new ProjectDto();
			
			BeanUtils.copyProperties(engin.getProject(), projectDto);
			BeanUtils.copyProperties(engin, dto);
			
			dto.setProjectDto(projectDto);
			dto.setProjectId(projectDto.getId());
			dtoList.add(dto);
			
		}
		
		return dtoList;
	}


}
