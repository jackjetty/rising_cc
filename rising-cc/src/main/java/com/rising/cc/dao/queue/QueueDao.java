package com.rising.cc.dao.queue;

import com.rising.common.page.Pagination;
import com.rising.cc.model.queue.Queue;
import com.rising.cc.pojo.qo.queue.QueueQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/1 9:58
 * 修改人：caizh
 * 修改时间：2015/9/1 9:58
 * 修改备注：
 */
public interface QueueDao {
    public List<Queue> findQueueByPagination(Pagination pagination);
    public Integer countQueueByPagination(Pagination pagination);
    public List<Queue> findQueueByQo(QueueQo qo);
    public Integer saveQueue(Queue queue);
    public Integer updateQueue(Queue queue);
    public Integer deleteQueue(Integer id);

}
