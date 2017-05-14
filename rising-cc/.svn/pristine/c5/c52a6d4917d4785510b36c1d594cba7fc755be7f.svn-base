package com.rising.cc.service.impl.basicdata;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.basicdata.DataBaseDao;
import com.rising.cc.model.basicdata.SysDataBaseInfo;
import com.rising.cc.pojo.command.basicdata.database.CreateDataBaseCommand;
import com.rising.cc.pojo.command.basicdata.database.DeleteDataBaseCommand;
import com.rising.cc.pojo.command.basicdata.database.UpdateDataBaseCommand;
import com.rising.cc.service.interf.basicdata.DataBaseService;

@Service
public class DataBaseServiceImpl implements DataBaseService {

	@Resource
	private DataBaseDao dataBaseDao;
	
	public Pagination findDataBaseInfoListByPagination(Pagination pagination) {
		pagination.setList(this.dataBaseDao.queryPagination(pagination));
		pagination.setTotalCount(this.dataBaseDao.countPagination(pagination));
		pagination.adjustPageNo();
		return pagination;
	}

	@Transactional
	public boolean saveDataBase(CreateDataBaseCommand command) {
		SysDataBaseInfo dataBase = new SysDataBaseInfo();
		dataBase.createDataBase(command);
		dataBaseDao.saveDataBase(dataBase);
		return true;
	}

	@Transactional
	public boolean editDataBase(UpdateDataBaseCommand command) {
		SysDataBaseInfo dataBase = new SysDataBaseInfo();
		dataBase.updateDataBase(command);
		dataBaseDao.updateDataBase(dataBase);
		return true;
	}

	@Transactional
	public boolean deleteDataBase(DeleteDataBaseCommand command) {
		dataBaseDao.updateDataBaseStatusByIds(command.getStatus(), command.getIds());
		return true;
	}

}
