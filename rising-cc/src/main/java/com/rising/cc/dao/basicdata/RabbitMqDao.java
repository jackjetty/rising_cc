package com.rising.cc.dao.basicdata;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rising.common.page.Pagination;
import com.rising.cc.model.basicdata.SysRabbitMqInfo;

public interface RabbitMqDao {

	public List<Pagination> queryPagination(Pagination pagination);

	public Integer countPagination(Pagination pagination);

	public Integer insertRabbitMq(SysRabbitMqInfo rabbitMq);

	public Integer updateRabbitMqById(SysRabbitMqInfo rabbitMq);

	public Integer updateRabbitMqStatusByIds(@Param("status") Integer status, @Param("ids")List<Integer> ids);

}
