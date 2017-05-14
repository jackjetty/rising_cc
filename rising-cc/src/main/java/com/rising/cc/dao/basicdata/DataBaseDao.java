package com.rising.cc.dao.basicdata;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.rising.common.page.Pagination;
import com.rising.cc.model.basicdata.SysDataBaseInfo;

public interface DataBaseDao {

	public List<Pagination>  queryPagination(Pagination pagination);

	public Integer countPagination(Pagination pagination);

	public Integer saveDataBase(SysDataBaseInfo dataBase);

	public Integer updateDataBase(SysDataBaseInfo dataBase);

	public Integer updateDataBaseStatusByIds(@Param("status") Integer status, @Param("ids")List<Integer> ids);

}
