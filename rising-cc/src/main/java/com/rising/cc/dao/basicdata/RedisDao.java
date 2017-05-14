package com.rising.cc.dao.basicdata;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rising.common.page.Pagination;
import com.rising.cc.model.basicdata.SysRedisInfo;

public interface RedisDao {

	public List<Pagination> queryPagination(Pagination pagination);

	public Integer countPagination(Pagination pagination);

	public Integer insetRedis(SysRedisInfo redis);

	public Integer updateRedisById(SysRedisInfo redis);

	public Integer updateRedisStatusByIds(@Param("status") Integer status, @Param("ids")List<Integer> ids);

}
