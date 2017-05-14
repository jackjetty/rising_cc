package com.rising.cc.service.impl.queue;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.rising.cc.dao.queue.HandlerDao;
import com.rising.cc.model.queue.Handler;
import com.rising.cc.model.queue.Queue;
import com.rising.cc.pojo.command.queue.CreateHandlerCommand;
import com.rising.cc.pojo.command.queue.DeleteHandlerCommand;
import com.rising.cc.pojo.dto.queue.HandlerDto;
import com.rising.cc.pojo.qo.queue.HandlerQo;
import com.rising.cc.pojo.qo.queue.QueueQo;
import com.rising.cc.service.interf.queue.HandlerService;
import com.rising.cc.service.interf.queue.QueueService;
import com.rising.cc.util.EntityConvertUtils;
import com.rising.common.model.HttpResponse;
import com.rising.common.page.Pagination;
import com.rising.common.util.HttpUtil;
/**
 * 
 * 项目名称：bhyf-cc  
 * 类名称：HandlerServiceimpl  
 * 类描述：  
 * 创建人：caizh 
 * 创建时间：2015年9月9日 下午4:36:45  
 * 修改人：caizh 
 * 修改时间：2015年9月9日 下午4:36:45  
 * 修改备注：  
 * @version：v1.0.0
 */
@Service
public class HandlerServiceimpl implements HandlerService {

    @Resource
    private HandlerDao handlerDao;

    @Resource
    private QueueService queueService;

    @Override
    public Pagination findHandlerByPagination(Pagination pagination) {
        List<Handler> handlerList = handlerDao.findHandlerByPagination(pagination);
        List<HandlerDto> handlerDtoList = Lists.newArrayList();
        Integer totalCount = handlerDao.countHandlerByPagination(pagination);
        try{
            handlerDtoList = EntityConvertUtils.convertEntityToDtoList(handlerList, HandlerDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pagination.setList(handlerDtoList);
        pagination.setTotalCount(totalCount);
        return pagination;
    }

    @Override
    public List<HandlerDto> findHandlerByQo(HandlerQo qo) {
        List<Handler> handlerList  =handlerDao.findHandlerByQo(qo);
        List<HandlerDto> handlerDtoList = Lists.newArrayList();
        try{
            handlerDtoList = EntityConvertUtils.convertEntityToDtoList(handlerList, HandlerDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return handlerDtoList;
    }


    //    @Override
//    public String updateHandler(UpdateHandlerCommand command) {
//    	Handler handler = new Handler();
//        handler.updateHandler(command);
//        handlerDao.updateHandler(handler);
//        return null;
//    }
    @Override
    public String saveHandler(CreateHandlerCommand command){
        Handler handler = new Handler();
        handler.createHandler(command);
        handlerDao.saveHandler(handler);
        return "";
    }

    @Override
    public String deleteHandler(DeleteHandlerCommand command){
        List<Handler> handlerList = handlerDao.findHandlerByQo(new HandlerQo(command.getId()));
        if(handlerList != null && handlerList.size() >0){
            Handler handler = handlerList.get(0);
            if(isUsed(handler.getId())){
                return "handler is used";
            }
            //TODO removeHandler
        }else {
            return "object is null";
        }
        handlerDao.deleteHandler(command.getId());
        return "";
    }


    private Boolean isUsed(Integer id){
        Boolean flag = false;
        List<Queue> queueList = queueService.findQueueByQo(new QueueQo(id));
        if(queueList != null && queueList.size() > 0){
            flag = true;
        }
        return flag;
    }

    private String  removeSMSHandler(String name){
        String url = "http://localhost:8082/handler/removeSMSHandler";
        Map<String,String> params = Maps.newHashMap();
//        params.put("queue",queue.getListener());
//        params.put("listener",queue.getListener());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return "";
    }
    private String  addSMSHandler(Handler handler){
        String url = "http://localhost:8082/handler/removeSMSHandler";
        Map<String,String> params = Maps.newHashMap();
//        params.put("queue",queue.getListener());
//        params.put("listener",queue.getListener());
        HttpResponse httpResponse = HttpUtil.executePostMethod(url, params, 60000);
        return "";
    }
}
