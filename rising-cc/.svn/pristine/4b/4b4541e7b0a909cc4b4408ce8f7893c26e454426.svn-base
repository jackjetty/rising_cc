package com.rising.cc.service.interf.project;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.project.CreateEnginConfigTypeCommand;
import com.rising.cc.pojo.command.project.DeleteEnginConfigTypeCommand;
import com.rising.cc.pojo.command.project.UpdateEnginConfigTypeCommand;
import com.rising.cc.pojo.dto.project.EnginConfigTypeDto;
import com.rising.cc.pojo.qo.project.EnginConfigTypeQo;


/**
 * 
 * @description 工程配置类型
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:26:58
 *
 */
public interface EnginConfigTypeService {

	public Pagination findEnginConfigTypeListByPagination(Pagination pagination);
	
	public boolean saveEnginConfigType(CreateEnginConfigTypeCommand addCommand);
	
	public boolean updateEnginConfigType(UpdateEnginConfigTypeCommand updateCommand);
	
	public boolean deleteEnginConfigType(DeleteEnginConfigTypeCommand removeCommand);
	
	public List<EnginConfigTypeDto> findEnginConfigTypeListByQo(EnginConfigTypeQo qo);
	
}
