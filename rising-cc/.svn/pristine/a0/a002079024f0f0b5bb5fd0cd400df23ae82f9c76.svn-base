package com.rising.cc.service.impl.queue;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rising.cc.dao.queue.QueueDao;
import com.rising.cc.model.queue.Queue;
import com.rising.cc.pojo.command.queue.CreateQueueCommand;
import com.rising.cc.pojo.command.queue.DeleteQueueCommand;
import com.rising.cc.pojo.command.queue.UpdateQueueCommand;
import com.rising.cc.pojo.dto.queue.QueueDto;
import com.rising.cc.pojo.qo.queue.QueueQo;
import com.rising.cc.service.interf.queue.QueueService;
import com.rising.cc.util.EntityConvertUtils;
import com.rising.common.model.HttpResponse;
import com.rising.common.page.Pagination;
import com.rising.common.util.HttpUtil;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/1 10:57
 * 修改人：caizh
 * 修改时间：2015/9/1 10:57
 * 修改备注：
 */
@Service
public class QueueServiceimpl implements QueueService {

    @Resource
    private QueueDao queueDao;


    @Override
    public Pagination findQueueByPagination(Pagination pagination) {
        List<Queue> queueList = queueDao.findQueueByPagination(pagination);
        List<QueueDto> queueDtoList = Lists.newArrayList();
        Integer totalCount = queueDao.countQueueByPagination(pagination);
        try{
            queueDtoList = EntityConvertUtils.convertEntityToDtoList(queueList, QueueDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        for (int i = 0; i < queueList.size(); i++) {
            queueDtoList.get(i).setHandlerId(queueList.get(i).getHandler().getId());
        }
        pagination.setList(queueDtoList);
        pagination.setTotalCount(totalCount);
        return pagination;
    }
    @Override
    public List<Queue> findQueueByQo(QueueQo qo) {
    	List<Queue> queueList = queueDao.findQueueByQo(qo);
    	return queueList;
    }

    @Override
    public String updateQueue(UpdateQueueCommand command) {
        Queue queue = new Queue();
        if(command.getCustomer() != null){
            queue.updateCustomer(command);
            updateCustomer(command);
        }
        if(command.getHandlerId() != null){
            queue.updateHandler(command);

        }
        queueDao.updateQueue(queue);
        return null;
    }

    @Override
    public String saveQueue(CreateQueueCommand command){
        Queue queue = new Queue();
        queue.createQueue(command);
        queueDao.saveQueue(queue);
        return "";
    }

    @Override
    public String deleteQueue(DeleteQueueCommand command){
        queueDao.deleteQueue(command.getId());
        return "";
    }

    private String updateCustomer(UpdateQueueCommand command){
        String url = command.getSpi()+"/rabbitmq/setCustomer";//?name=sms_gx_xxt&url=http://121.41.93.171:58083/component/api&failUrl=http://127.0.0.1:58081/bhyf-api/smsfail&rate=0";
        System.out.println(url);
        Map<String,String> params = Maps.newHashMap();
//        params.put("listener",queue.getListener());
//        params.put("num",queue.getCustomer().toString());
//        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return "";
    }


    public String updateListener(Queue queue){
        String url = "http://localhost:8082/rabbitmq/updateListener";
        Map<String,String> params = Maps.newHashMap();
//        params.put("queue",queue.getListener());
//        params.put("listener",queue.getListener());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return "";
    }

    public String addListener(Queue queue){
        String url = "http://localhost:8082/rabbitmq/addListener";
        Map<String,String> params = Maps.newHashMap();
//        params.put("queue",queue.getListener());
//        params.put("listener",queue.getListener());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return "";
    }

    public String startupListener(Queue queue){
        String url = "http://localhost:8082/rabbitmq/startupListener";
        Map<String,String> params = Maps.newHashMap();
//        params.put("queue",queue.getListener());
//        params.put("listener",queue.getListener());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return "";
    }
    public String shutdownListener(Queue queue){
        String url = "http://localhost:8082/rabbitmq/shutdownListener";
        Map<String,String> params = Maps.newHashMap();
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return "";
    }

    public String binding(Queue queue){
        String url = "http://localhost:8082/rabbitmq/binding";
        Map<String,String> params = Maps.newHashMap();
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return "";
    }

}
