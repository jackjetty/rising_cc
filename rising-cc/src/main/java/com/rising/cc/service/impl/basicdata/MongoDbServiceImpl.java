package com.rising.cc.service.impl.basicdata;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.basicdata.MongoDbDao;
import com.rising.cc.model.basicdata.SysMongoDbInfo;
import com.rising.cc.pojo.command.basicdata.mongodb.CreateMongoDbCommand;
import com.rising.cc.pojo.command.basicdata.mongodb.DeleteMongoDbCommand;
import com.rising.cc.pojo.command.basicdata.mongodb.UpdateMongoDbCommand;
import com.rising.cc.service.interf.basicdata.MongoDbService;

@Service
public class MongoDbServiceImpl implements MongoDbService {

	@Resource
	private MongoDbDao mongoDbDao;
	
	public Pagination findMongoDbInfoListByPagination(Pagination pagination) {
		pagination.setList(this.mongoDbDao.queryPagination(pagination));
		pagination.setTotalCount(this.mongoDbDao.countPagination(pagination));
		pagination.adjustPageNo();
		return pagination;
	}

	@Transactional
	public boolean saveMongoDb(CreateMongoDbCommand command) {
		SysMongoDbInfo mongoDb = new SysMongoDbInfo();
		mongoDb.createMongoDb(command);
		mongoDbDao.insetMongoDb(mongoDb);
		return true;
	}

	@Transactional
	public boolean updateMongoDb(UpdateMongoDbCommand command) {
		SysMongoDbInfo mongoDb = new SysMongoDbInfo();
		mongoDb.updateMongoDb(command);
		mongoDbDao.updateMongoDbById(mongoDb);
		return true;
	}

	@Transactional
	public boolean deleteMongoDb(DeleteMongoDbCommand command) {
		mongoDbDao.updateMongoDbStatusByIds(command.getStatus(), command.getIds());
		
		return true;
	}

}
