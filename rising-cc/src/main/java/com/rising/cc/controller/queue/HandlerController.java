package com.rising.cc.controller.queue;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.pojo.command.queue.CreateHandlerCommand;
import com.rising.cc.pojo.command.queue.DeleteHandlerCommand;
import com.rising.cc.pojo.command.queue.EditHandlerCommand;
import com.rising.cc.pojo.command.queue.UpdateHandlerCommand;
import com.rising.cc.pojo.command.queue.UpdateQueueCommand;
import com.rising.cc.pojo.qo.queue.HandlerQo;
import com.rising.cc.service.interf.queue.HandlerService;

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
@RequestMapping("/handler")
public class HandlerController extends BaseController{

    @Resource
    private HandlerService handlerService;

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/to_handler_list")
    public String toHandlerList(HttpServletRequest request,
                                 Model model){
        return "/queue/handler_list.html";
    }



    @RequestMapping("/handler_list")
    @ResponseBody
    public Pagination findHandlerList(HttpServletRequest request,
                                       @ModelAttribute HandlerQo qo,
                                       @RequestParam("page") Integer pageNo,
                                       @RequestParam("rows") Integer pageSize,
                                       Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = handlerService.findHandlerByPagination(pagination);

        return pagination;
    }
    
    @RequestMapping("/edit_handler")
    @ResponseBody
    public String editHandler(HttpServletRequest request,
                               @ModelAttribute EditHandlerCommand command,Model model,
                               @RequestParam(required = true) String oper){
        if(oper.equals("add")){
            CreateHandlerCommand createHandlerCommand = new CreateHandlerCommand();
            createHandlerCommand.createCommand(command);
            return handlerService.saveHandler(createHandlerCommand);
        }else if(oper.equals("del")){
        	DeleteHandlerCommand deleteHandlerCommand = new DeleteHandlerCommand();
        	deleteHandlerCommand.createCommand(command);
        	return handlerService.deleteHandler(deleteHandlerCommand);
        }
//        else if(oper.equals("edit")){
//        	UpdateHandlerCommand updateHandlerCommand = new UpdateHandlerCommand();
//        	updateHandlerCommand.createCommand(command);
//            return handlerService.updateHandler(updateHandlerCommand);
//        }
        return "error";
    }
}
