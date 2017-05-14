package com.rising.cc.service.interf.queue;

import com.rising.common.page.Pagination;
import com.rising.cc.model.queue.Queue;
import com.rising.cc.pojo.command.queue.CreateQueueCommand;
import com.rising.cc.pojo.command.queue.DeleteQueueCommand;
import com.rising.cc.pojo.command.queue.UpdateQueueCommand;
import com.rising.cc.pojo.dto.queue.QueueDto;
import com.rising.cc.pojo.qo.queue.QueueQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/1 10:54
 * 修改人：caizh
 * 修改时间：2015/9/1 10:54
 * 修改备注：
 */
public interface QueueService {
    public Pagination findQueueByPagination(Pagination pagination);

    public String updateQueue(UpdateQueueCommand command);


    public String saveQueue(CreateQueueCommand command);

    public String deleteQueue(DeleteQueueCommand command);

	public List<Queue> findQueueByQo(QueueQo qo);
}
