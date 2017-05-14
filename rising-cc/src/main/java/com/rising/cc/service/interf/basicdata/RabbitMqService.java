package com.rising.cc.service.interf.basicdata;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.basicdata.rabbitmq.CreateRabbitMqCommand;
import com.rising.cc.pojo.command.basicdata.rabbitmq.DeleteRabbitMqCommand;
import com.rising.cc.pojo.command.basicdata.rabbitmq.UpdateRabbitMqCommand;

public interface RabbitMqService {

	public Pagination findRabbitMqInfoListByPagination(Pagination pagination);

	public boolean saveRabbitMq(CreateRabbitMqCommand addCommand);

	public boolean editRabbitMq(UpdateRabbitMqCommand updateCommand);

	public boolean deleteRabbitMq(DeleteRabbitMqCommand deleteCommand);

}
