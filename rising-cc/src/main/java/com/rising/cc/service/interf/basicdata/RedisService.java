package com.rising.cc.service.interf.basicdata;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.basicdata.redis.CreateRedisCommand;
import com.rising.cc.pojo.command.basicdata.redis.DeleteRedisCommand;
import com.rising.cc.pojo.command.basicdata.redis.UpdateRedisCommand;

public interface RedisService {

	public Pagination findRedisInfoListByPagination(Pagination pagination);

	public boolean saveRedis(CreateRedisCommand addCommand);

	public boolean editRedis(UpdateRedisCommand updateCommand);

	public boolean deleteRedis(DeleteRedisCommand deleteCommand);

}
