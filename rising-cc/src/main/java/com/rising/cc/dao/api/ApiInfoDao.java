package com.rising.cc.dao.api;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.model.api.ApiInfo;
import com.rising.cc.pojo.qo.api.ApiInfoQo;

public interface ApiInfoDao {
	
	public List<ApiInfo> findApiInfoListByPagination(Pagination pagination);
	
	public Integer countApiInfoListByPagination(Pagination pagination);
	
	public Integer updateApiInfo(ApiInfo apiInfo);
	
	public Integer deleteBatchApiInfo(List<Integer> list);
	
	public Integer insertApiInfo(ApiInfo apiInfo);

	public List<ApiInfo> findApiInfoListByQo(ApiInfoQo qo);
	
	public Integer countApiInfoAccountListByApiIds(List<Integer> list);
	
}
