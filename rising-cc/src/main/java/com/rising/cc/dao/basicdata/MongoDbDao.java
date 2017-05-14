package com.rising.cc.dao.basicdata;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rising.common.page.Pagination;
import com.rising.cc.model.basicdata.SysMongoDbInfo;

public interface MongoDbDao {

	public List<Pagination> queryPagination(Pagination pagination);
	
	public Integer countPagination(Pagination pagination);

	public Integer insetMongoDb(SysMongoDbInfo mongoDb);

	public Integer updateMongoDbById(SysMongoDbInfo mongoDb);

	public Integer updateMongoDbStatusByIds(@Param("status") Integer status, @Param("ids")List<Integer> ids);

}
