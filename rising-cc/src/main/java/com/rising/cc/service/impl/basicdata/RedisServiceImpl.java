package com.rising.cc.service.impl.basicdata;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.basicdata.RedisDao;
import com.rising.cc.model.basicdata.SysRedisInfo;
import com.rising.cc.pojo.command.basicdata.redis.CreateRedisCommand;
import com.rising.cc.pojo.command.basicdata.redis.DeleteRedisCommand;
import com.rising.cc.pojo.command.basicdata.redis.UpdateRedisCommand;
import com.rising.cc.service.interf.basicdata.RedisService;

@Service
public class RedisServiceImpl implements RedisService {

	@Resource
	private RedisDao redisDao;
	
	public Pagination findRedisInfoListByPagination(Pagination pagination) {
		pagination.setList(this.redisDao.queryPagination(pagination));
		pagination.setTotalCount(this.redisDao.countPagination(pagination));
		pagination.adjustPageNo();
		return pagination;
	}

	@Transactional
	public boolean saveRedis(CreateRedisCommand command) {
		SysRedisInfo redis = new SysRedisInfo();
		redis.createRedis(command);
		redisDao.insetRedis(redis);
		return true;
	}

	@Transactional
	public boolean editRedis(UpdateRedisCommand command) {
		SysRedisInfo redis = new SysRedisInfo();
		redis.updateRedis(command);
		redisDao.updateRedisById(redis);
		return true;
	}

	@Transactional
	public boolean deleteRedis(DeleteRedisCommand command) {
		redisDao.updateRedisStatusByIds(command.getStatus(), command.getIds());
		
		return true;
	}

}
