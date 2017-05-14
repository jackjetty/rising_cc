package com.rising.cc.controller.interf;

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.model.interf.InterfManager;
import com.rising.cc.pojo.command.interf.*;
import com.rising.cc.pojo.dto.interf.InterfManagerDto;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.dto.service.ServerDto;
import com.rising.cc.pojo.qo.interf.InterfInfoQo;
import com.rising.cc.pojo.qo.interf.InterfManagerQo;
import com.rising.cc.pojo.qo.interf.InterfMethodQo;
import com.rising.cc.pojo.qo.log.LogTableQo;
import com.rising.cc.pojo.qo.project.EngineeringQo;
import com.rising.cc.pojo.qo.service.ServerQo;
import com.rising.cc.service.interf.interf.InterfInfoService;
import com.rising.cc.service.interf.interf.InterfManagerService;
import com.rising.cc.service.interf.interf.InterfMethodService;
import com.rising.cc.service.interf.project.EngineeringService;

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
 * 创建时间：2015/11/17 15:19
 * 修改人：caizh
 * 修改时间：2015/11/17 15:19
 * 修改备注：
 */
@Controller
@RequestMapping("/interf_manager")
public class InterfManagerController extends BaseController {

    @Resource
    private InterfMethodService interfMethodService;
    @Resource
    private InterfInfoService interfInfoService;
    @Resource
    private InterfManagerService interfManagerService;
    @Resource
    private EngineeringService engineeringService;


    @RequestMapping("/to_interf_manager_list")
    public String toInterfManagerList(HttpServletRequest request,
                                           Model model){
        List<EngineeringDto> engineeringDtoList = engineeringService.findEngineeringListByQo(new EngineeringQo());
//        List<InterfManagerDto> interfManagerDtoList = interfMethodService.findInterfMethodByQo(new InterfMethodQo());
        StringBuffer engineeringStr = new StringBuffer();
        for (EngineeringDto engineeringDto : engineeringDtoList) {
            engineeringStr.append(engineeringDto.getId()).append(":").append(engineeringDto.getEngineeringName()).append(";");
        }
        if(engineeringStr.length() > 0){
            model.addAttribute("enginneringList",engineeringStr.substring(0,engineeringStr.length()-1));
        }

        return "/interf/interf_manager_list.html";
    }

    /**
     *
     * @param request
     * @param command
     * @param model
     * @param oper
     * @return
     */
    @RequestMapping("/edit_interf_manager")
    @ResponseBody
    public String editInterfManager(HttpServletRequest request,
                               @ModelAttribute EditInterfManagerCommand command,Model model,
                               @RequestParam String oper){
        String result = "";
        if(oper.equals("add")){
            CreateInterfManagerCommand createInterfManagerCommand = new CreateInterfManagerCommand();
            createInterfManagerCommand.createCommand(command);
            result = interfManagerService.saveInterfManager(createInterfManagerCommand);
        }else if(oper.equals("del")){
            DeleteInterfManagerCommand deleteInterfManagerCommand = new DeleteInterfManagerCommand();
            deleteInterfManagerCommand.createCommand(command);
            result = interfManagerService.deleteInterfManager(deleteInterfManagerCommand);
        }
        return result;
    }

    @RequestMapping("/find_interf_manager_list")
    @ResponseBody
    public Pagination findInterfMethodList(HttpServletRequest request,
                                       @ModelAttribute InterfManagerQo qo,
                                       @RequestParam("page") Integer pageNo,
                                       @RequestParam("rows") Integer pageSize,
                                       Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);
        pagination = interfManagerService.findInterfManangerByPagination(pagination);
        return pagination;
    }

}
