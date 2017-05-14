package com.rising.cc.dao.api;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.model.api.ApiAccount;
import com.rising.cc.model.api.ApiAccountInfo;
import com.rising.cc.pojo.qo.api.ApiAccountInfoQo;
import com.rising.cc.pojo.qo.api.ApiAccountQo;

public interface ApiAccountDao {
	
	public List<ApiAccount> findApiAccountListByPagination(Pagination pagination);
	
	public Integer countApiAccountListByPagination(Pagination pagination);
	
	public Integer updateApiAccount(ApiAccount apiAccount);
	
	public Integer deleteBatchApiAccount(List<Integer> list);
	
	public Integer insertApiAccount(ApiAccount apiAccount);

	public List<ApiAccount> findApiAccountListByQo(ApiAccountQo qo);
	
}
