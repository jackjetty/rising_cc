package com.rising.cc.controller.queue;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.model.project.Engineering;
import com.rising.cc.model.queue.Handler;
import com.rising.cc.model.service.ServicesAndServer;
import com.rising.cc.pojo.command.queue.CreateQueueCommand;
import com.rising.cc.pojo.command.queue.DeleteQueueCommand;
import com.rising.cc.pojo.command.queue.EditQueueCommand;
import com.rising.cc.pojo.command.queue.UpdateQueueCommand;
import com.rising.cc.pojo.dto.envir.EnvirTypeDto;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.dto.queue.HandlerDto;
import com.rising.cc.pojo.qo.project.EngineeringQo;
import com.rising.cc.pojo.qo.queue.HandlerQo;
import com.rising.cc.pojo.qo.queue.QueueQo;
import com.rising.cc.pojo.qo.user.UserQo;
import com.rising.cc.service.interf.project.EngineeringService;
import com.rising.cc.service.interf.queue.HandlerService;
import com.rising.cc.service.interf.queue.QueueService;
import com.rising.cc.util.PropertiesUtil;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/1 10:51
 * 修改人：caizh
 * 修改时间：2015/9/1 10:51
 * 修改备注：
 */
@Controller
@RequestMapping("/queue")
public class QueueController extends BaseController{

    private Properties  spi=PropertiesUtil.getProp("/spi.properties");
    private String engineeringCode = spi.getProperty("queue");

    @Resource
    private QueueService queueService;

    @Resource
    private EngineeringService engineeringService;

    @Resource
    private HandlerService handlerService;

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/to_queue_list")
    public String toQueueList(HttpServletRequest request,
                                 Model model){
        HandlerQo handlerQo = new HandlerQo();
        List<HandlerDto> handlerDtoList = handlerService.findHandlerByQo(handlerQo);
        List<EnvirTypeDto> envirTypeDtoList = (List<EnvirTypeDto>) getSession().getAttribute("envirTypeDtoList");
        StringBuffer str;
        JSONObject object = new JSONObject();
        for (EnvirTypeDto envirTypeDto : envirTypeDtoList) {
            str = new StringBuffer();
            for (HandlerDto handlerDto : handlerDtoList) {
                if(handlerDto.getEnvirId().equals(envirTypeDto.getId())) {
                    str.append(handlerDto.getId()).append(":").append(handlerDto.getName()).append(";");
                }
            }
            if(StringUtils.isNotBlank(str.toString()) && str.length()>0) {
                object.put(envirTypeDto.getId() + "", str.substring(0, str.length() - 1));
            }
        }

        model.addAttribute("object",object.toJSONString());
        return "/queue/queue_list.html";
    }




    @RequestMapping("/queue_list")
    @ResponseBody
    public Pagination findQueueList(HttpServletRequest request,
                                       @ModelAttribute QueueQo qo,
                                       @RequestParam("page") Integer pageNo,
                                       @RequestParam("rows") Integer pageSize,
                                       Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = queueService.findQueueByPagination(pagination);
//        pagination = userService.findUserInfoListByPagination(pagination);

        return pagination;
    }

    @RequestMapping("/edit_queue")
    @ResponseBody
    public String editQueue(HttpServletRequest request,
                               @ModelAttribute EditQueueCommand command,Model model,
                               @RequestParam(required = true) String oper){
        Map<String,ServicesAndServer> servicesAndServerMap = (Map<String,ServicesAndServer>) getSession().getAttribute("servicesAndServerMap");
        EngineeringQo qo = new EngineeringQo();
        qo.setEngineeringCode(engineeringCode);
        List<EngineeringDto> engineeringList = engineeringService.findEngineeringListByQo(qo);
        String key = "";
        if(engineeringList.size() == 1){
            key = command.getEnvirId()+":"+engineeringList.get(0).getId();
        }
        if(oper.equals("add")){
            CreateQueueCommand createQueueCommand = new CreateQueueCommand();
            createQueueCommand.createCommand(command);
            createQueueCommand.createSpi(servicesAndServerMap.get(key));
            return queueService.saveQueue(createQueueCommand);
        }else if(oper.equals("del")){
            DeleteQueueCommand deleteQueueCommand = new DeleteQueueCommand();
            deleteQueueCommand.createCommand(command);
            deleteQueueCommand.createSpi(servicesAndServerMap.get(key));
            return queueService.deleteQueue(deleteQueueCommand);
        }else if(oper.equals("edit")){
            UpdateQueueCommand updateQueueCommand = new UpdateQueueCommand();
            updateQueueCommand.createCommand(command);
            updateQueueCommand.createSpi(servicesAndServerMap.get(key));
            return queueService.updateQueue(updateQueueCommand);
        }
        return "error";
    }
}
