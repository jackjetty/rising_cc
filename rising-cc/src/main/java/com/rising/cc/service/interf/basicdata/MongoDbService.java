package com.rising.cc.service.interf.basicdata;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.basicdata.mongodb.CreateMongoDbCommand;
import com.rising.cc.pojo.command.basicdata.mongodb.DeleteMongoDbCommand;
import com.rising.cc.pojo.command.basicdata.mongodb.UpdateMongoDbCommand;

public interface MongoDbService {

	public Pagination findMongoDbInfoListByPagination(Pagination pagination);

	public boolean saveMongoDb(CreateMongoDbCommand addCommand);

	public boolean updateMongoDb(UpdateMongoDbCommand updateCommand);

	public boolean deleteMongoDb(DeleteMongoDbCommand deleteCommand);

}
