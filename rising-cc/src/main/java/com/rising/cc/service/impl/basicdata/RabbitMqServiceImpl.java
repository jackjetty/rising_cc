package com.rising.cc.service.impl.basicdata;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.common.page.Pagination;
import com.rising.cc.dao.basicdata.RabbitMqDao;
import com.rising.cc.model.basicdata.SysRabbitMqInfo;
import com.rising.cc.pojo.command.basicdata.rabbitmq.CreateRabbitMqCommand;
import com.rising.cc.pojo.command.basicdata.rabbitmq.DeleteRabbitMqCommand;
import com.rising.cc.pojo.command.basicdata.rabbitmq.UpdateRabbitMqCommand;
import com.rising.cc.service.interf.basicdata.RabbitMqService;

@Service
public class RabbitMqServiceImpl implements RabbitMqService {

	@Resource
	private RabbitMqDao rabbitMqDao;
	
	public Pagination findRabbitMqInfoListByPagination(Pagination pagination) {
		pagination.setList(this.rabbitMqDao.queryPagination(pagination));
		pagination.setTotalCount(this.rabbitMqDao.countPagination(pagination));
		pagination.adjustPageNo();
		return pagination;
	}

	@Transactional
	public boolean saveRabbitMq(CreateRabbitMqCommand command) {
		SysRabbitMqInfo rabbitMq = new SysRabbitMqInfo();
		rabbitMq.createRabbitMq(command);
		rabbitMqDao.insertRabbitMq(rabbitMq);
		return true;
	}

	@Transactional
	public boolean editRabbitMq(UpdateRabbitMqCommand command) {
		SysRabbitMqInfo rabbitMq = new SysRabbitMqInfo();
		rabbitMq.updateRabbitMq(command);
		rabbitMqDao.updateRabbitMqById(rabbitMq);
		return true;
	}

	@Transactional
	public boolean deleteRabbitMq(DeleteRabbitMqCommand command) {
		rabbitMqDao.updateRabbitMqStatusByIds(command.getStatus(), command.getIds());
		
		return true;
	}

}
