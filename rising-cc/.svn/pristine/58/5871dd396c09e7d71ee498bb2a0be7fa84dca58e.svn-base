package com.rising.cc.controller.service;

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.pojo.command.service.CreateServerCommand;
import com.rising.cc.pojo.command.service.EditServerCommand;
import com.rising.cc.pojo.command.service.RemoveServerCommand;
import com.rising.cc.pojo.command.service.UpdateServerCommand;
import com.rising.cc.pojo.qo.service.ServerQo;
import com.rising.cc.service.interf.service.ServerService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 13:19
 * 修改人：caizh
 * 修改时间：2015/9/11 13:19
 * 修改备注：
 */
@RequestMapping("/server")
@Controller
public class ServerController extends BaseController{
    @Resource
    private ServerService serverService;
    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/to_server_list")
    public String toLogTableList(HttpServletRequest request,
                                 Model model){
        return "/service/server_list.html";
    }



    @RequestMapping("/server_list")
    @ResponseBody
    public Pagination findServerList(HttpServletRequest request,
                                    @ModelAttribute ServerQo qo,
                                    @RequestParam("page") Integer pageNo,
                                    @RequestParam("rows") Integer pageSize,
                                    Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = serverService.findServerByPagination(pagination);
//        pagination = userService.findUserInfoListByPagination(pagination);

        return pagination;
    }

    @RequestMapping("/edit_server")
    @ResponseBody
    public String editServer(HttpServletRequest request,
                            @ModelAttribute EditServerCommand command,Model model,
                            @RequestParam(required = true) String oper){
        if(oper.equals("add")){
            CreateServerCommand createServerCommand = new CreateServerCommand();
            createServerCommand.create(command);
            return serverService.saveServer(createServerCommand);
        }else if(oper.equals("del")){
            RemoveServerCommand deleteServerCommand = new RemoveServerCommand();
            deleteServerCommand.create(command);
            return serverService.removeServer(deleteServerCommand);
        }else if(oper.equals("edit")){
            UpdateServerCommand updateServerCommand = new UpdateServerCommand();
            updateServerCommand.create(command);
            return serverService.updateServer(updateServerCommand);
        }
        return "error";
    }
}
