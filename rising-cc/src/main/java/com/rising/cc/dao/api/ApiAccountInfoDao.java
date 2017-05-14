package com.rising.cc.dao.api;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rising.common.page.Pagination;
import com.rising.cc.model.api.ApiAccountInfo;
import com.rising.cc.pojo.qo.api.ApiAccountInfoQo;

public interface ApiAccountInfoDao {
	
	public Integer deleteApiAccountInfoByAccountId(Integer accountId);
	
	public Integer deleteApiAccountInfoByAccountIdApiId(@Param("accountId")Integer accountId, @Param("apiIds")List<Integer> apiIds);
	
	public Integer insertBatchApiAccountInfo(List<ApiAccountInfo> list);
	
	public Integer updateApiAccountInfoById(ApiAccountInfo apiAccountInfo);
	
	public List<ApiAccountInfo> findApiAccountInfoListByQo(ApiAccountInfoQo qo);

	public List<ApiAccountInfo> findApiAccountInfoListByPagination(Pagination pagination);
	
	public Integer countApiAccountInfoListByPagination(Pagination pagination);
	
}
