package com.rising.cc.controller.service;

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.model.service.Server;
import com.rising.cc.pojo.command.service.*;
import com.rising.cc.pojo.constants.project.ProjectConstants;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.dto.project.ProjectDto;
import com.rising.cc.pojo.dto.service.ServerDto;
import com.rising.cc.pojo.qo.project.EngineeringQo;
import com.rising.cc.pojo.qo.project.ProjectQo;
import com.rising.cc.pojo.qo.service.ServerQo;
import com.rising.cc.pojo.qo.service.ServicesQo;
import com.rising.cc.service.interf.project.EngineeringService;
import com.rising.cc.service.interf.service.ServerService;
import com.rising.cc.service.interf.service.ServicesService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 13:19
 * 修改人：caizh
 * 修改时间：2015/9/11 13:19
 * 修改备注：
 */
@RequestMapping("/services")
@Controller
public class ServicesController extends BaseController{
    @Resource
    private ServicesService servicesService;

    @Resource
    private EngineeringService engineeringService;

    @Resource
    private ServerService serverService;
    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/to_services_list")
    public String toLogTableList(HttpServletRequest request,
                                 Model model){
        ServerQo qo = new ServerQo();
        List<EngineeringDto> engineeringDtoList = engineeringService.findEngineeringListByQo(new EngineeringQo());
        List<ServerDto> serverDtoList = serverService.findServerByQo(qo);

        StringBuffer serverStr = new StringBuffer();
        StringBuffer engineeringStr = new StringBuffer();
        for (EngineeringDto engineeringDto : engineeringDtoList) {
            engineeringStr.append(engineeringDto.getId()).append(":").append(engineeringDto.getEngineeringName()).append(";");
        }
        for(ServerDto dto : serverDtoList){
            serverStr.append(dto.getId()).append(":").append(dto.getServerName()).append(";");
        }
        if(serverStr.length() > 0){
            model.addAttribute("serverList", serverStr.substring(0, serverStr.length()-1));
        }
        if(engineeringStr.length() > 0){
            model.addAttribute("enginneringList",engineeringStr.substring(0,engineeringStr.length()-1));
        }

        return "/service/services_list.html";
    }



    @RequestMapping("/services_list")
    @ResponseBody
    public Pagination findServerList(HttpServletRequest request,
                                    @ModelAttribute ServicesQo qo,
                                    @RequestParam("page") Integer pageNo,
                                    @RequestParam("rows") Integer pageSize,
                                    Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = servicesService.findServicesByPagination(pagination);


        return pagination;
    }

    @RequestMapping("/edit_services")
    @ResponseBody
    public String editServer(HttpServletRequest request,
                            @ModelAttribute EditServicesCommand command,Model model,
                            @RequestParam(required = true) String oper){
        if(oper.equals("add")){
            CreateServicesCommand createServicesCommand = new CreateServicesCommand();
            createServicesCommand.create(command);
            return servicesService.saveServices(createServicesCommand);
        }else if(oper.equals("del")){
            RemoveServicesCommand removeServicesCommand = new RemoveServicesCommand();
            removeServicesCommand.create(command);
            return servicesService.removeServices(removeServicesCommand);
        }else if(oper.equals("edit")){
            UpdateServicesCommand updateServicesCommand = new UpdateServicesCommand();
            updateServicesCommand.create(command);
            return servicesService.updateServices(updateServicesCommand);
        }
        return "error";
    }
}
