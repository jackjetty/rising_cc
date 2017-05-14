package com.rising.cc.dao.project;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.model.project.Engineering;
import com.rising.cc.pojo.qo.project.EngineeringQo;

public interface EngineeringDao {
	
	public List<Engineering> findEngineeringListByPagination(Pagination pagination);
	
	public Integer countEngineeringListByPagination(Pagination pagination);
	
	public Integer updateEngineering(Engineering engin);
	
	public Integer deleteBatchEngineering(List<Integer> list);
	
	public Integer deleteEngineeringByProjectIds(List<Integer> list);
	
	public Integer insertEngineering(Engineering engin);
	
	public List<Engineering> findEngineeringListByQo(EngineeringQo qo);
	
}
