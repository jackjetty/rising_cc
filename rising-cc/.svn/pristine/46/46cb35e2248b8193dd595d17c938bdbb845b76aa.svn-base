package com.rising.cc.service.interf.project;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.project.CreateEngineeringCommand;
import com.rising.cc.pojo.command.project.DeleteEngineeringCommand;
import com.rising.cc.pojo.command.project.UpdateEngineeringCommand;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.qo.project.EngineeringQo;


/**
 * 
 * @description 工程配置信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:26:58
 *
 */
public interface EngineeringService {

	public Pagination findEnginListByPagination(Pagination pagination);

	public boolean saveEngineering(CreateEngineeringCommand addCommand);
	
	public boolean updateEngineering(UpdateEngineeringCommand updateCommand);
	
	public boolean deleteEngineering(DeleteEngineeringCommand deleteCommand);
	
	public List<EngineeringDto> findEngineeringListByQo(EngineeringQo qo);

}
