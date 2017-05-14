package com.rising.cc.dao.project;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.model.project.EnginConfigType;
import com.rising.cc.pojo.qo.project.EnginConfigTypeQo;

/**
 * 
 * @description 工程配置类型Dao
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午11:24:02
 *
 */
public interface EnginConfigTypeDao {
	
	public List<EnginConfigType> findEnginConfigTypeListByPagination(Pagination pagination);
	
	public Integer countEnginConfigTypeListByPagination(Pagination pagination);
	
	public Integer updateEnginConfigType(EnginConfigType enginConfigType);
	
	public Integer deleteBatchEnginConfigType(List<Integer> list);
	
	public Integer insertEnginConfigType(EnginConfigType enginConfigType);
	
	public List<EnginConfigType> findEnginConfigTypeListByQo(EnginConfigTypeQo qo);

	public Integer deleteBatchEnginConfigTypeByEnginIds(List<Integer> list);
	
	public Integer deleteEnginConfigTypeByProjectIds(List<Integer> list);
	
}
