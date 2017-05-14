package com.rising.cc.dao.basicdata;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rising.common.page.Pagination;
import com.rising.cc.model.basicdata.SysDubboInfo;

public interface DubboDao {

	public List<Pagination> queryPagination(Pagination pagination);

	public Integer countPagination(Pagination pagination);

	public Integer insertDubbo(SysDubboInfo dubbo);

	public Integer updateDubbo(SysDubboInfo dubbo);

	public Integer updateDubboStatusByIds(@Param("status") Integer status, @Param("ids")List<Integer> ids);

}
