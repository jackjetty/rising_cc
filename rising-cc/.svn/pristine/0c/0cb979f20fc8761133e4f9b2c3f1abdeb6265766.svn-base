package com.rising.cc.dao.project;

import java.util.List;

import com.rising.cc.model.project.EnginConfigInfo;
import com.rising.cc.pojo.qo.project.EnginConfigInfoQo;
import com.rising.cc.pojo.qo.project.ReadPropertiesInfoQo;

public interface EnginConfigInfoDao {
	
	public List<EnginConfigInfo> findEnginConfigInfoListByQo(EnginConfigInfoQo qo);
	
	public Integer deleteEnginConfigInfoByEnginId(Integer enginId);
	
	public Integer deleteEnginConfigInfoByProjectIds(List<Integer> list);
	
	public Integer deleteBatchEnginConfigInfoByEnginIds(List<Integer> list);

	public Integer insertBatchEnginConfigInfo(List<EnginConfigInfo> list);
	
	public Integer countEnginConfigTypeByEnginConfigTypeId(List<Integer> list);
	
	public List<EnginConfigInfo> findEnginConfigInfoListByPropQo(ReadPropertiesInfoQo qo);
	
}
