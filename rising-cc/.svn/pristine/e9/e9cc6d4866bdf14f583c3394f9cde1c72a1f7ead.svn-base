package com.rising.cc.controller.interf;

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.pojo.command.interf.*;
import com.rising.cc.pojo.command.log.CreateLogTableCommand;
import com.rising.cc.pojo.command.log.EditLogTableCommand;
import com.rising.cc.pojo.command.log.RemoveLogTableCommand;
import com.rising.cc.pojo.qo.interf.InterfInfoQo;
import com.rising.cc.pojo.qo.interf.InterfMethodQo;
import com.rising.cc.pojo.qo.log.LogTableQo;
import com.rising.cc.service.interf.interf.InterfInfoService;
import com.rising.cc.service.interf.interf.InterfMethodService;

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
 * 创建时间：2015/11/17 15:19
 * 修改人：caizh
 * 修改时间：2015/11/17 15:19
 * 修改备注：
 */
@Controller
@RequestMapping("/interf_method")//interf_method/interf_method_list
public class InterfMethodController extends BaseController {

    @Resource
    private InterfMethodService interfMethodService;
    @Resource
    private InterfInfoService interfInfoService;


    @RequestMapping("/to_interf_method_list")
    public String toInterfMethodList(HttpServletRequest request,
                                           Model model){
        return "/interf/interf_method_list.html";
    }

    /**
     *
     * @param request
     * @param command
     * @param model
     * @param oper
     * @return
     */
    @RequestMapping("/edit_interf_method")
    @ResponseBody
    public String editInterfMethod(HttpServletRequest request,
                               @ModelAttribute EditInterfMethodCommand command,Model model,
                               @RequestParam String oper){
        String result = "";
        if(oper.equals("add")){
            CreateInterfMethodCommand createInterfMethodCommand = new CreateInterfMethodCommand();
            createInterfMethodCommand.createCommand(command);
            result = interfMethodService.saveInterfMethod(createInterfMethodCommand);
        }else if(oper.equals("edit")){
            UpdateInterfMethodCommand updateInterfMethodCommand = new UpdateInterfMethodCommand();
            updateInterfMethodCommand.createCommand(command);
            result = interfMethodService.updateInterfMethod(updateInterfMethodCommand);
        }else if(oper.equals("del")){
            RemoveInterfMethodCommand removeInterfMethodCommand = new RemoveInterfMethodCommand();
            removeInterfMethodCommand.createCommand(command);
            result = interfMethodService.removeInterfMethod(removeInterfMethodCommand);
        }
        return result;
    }
    /**
     *
     * @param request
     * @param command
     * @param model
     * @param oper
     * @return
     */
    @RequestMapping("/edit_interf_info")
    @ResponseBody
    public String editInterfInfo(HttpServletRequest request,
                               @ModelAttribute EditInterfInfoCommand command,Model model,
                               @RequestParam String oper){
        String result = "";
        if(oper.equals("add")){
            CreateInterfInfoCommand createInterfInfoCommand = new CreateInterfInfoCommand();
            createInterfInfoCommand.createCommand(command);
            result = interfInfoService.saveInterfInfo(createInterfInfoCommand);
        }else if(oper.equals("edit")){
            UpdateInterfInfoCommand updateInterfInfoCommand = new UpdateInterfInfoCommand();
            updateInterfInfoCommand.createCommand(command);
            result = interfInfoService.updateInterfInfo(updateInterfInfoCommand);
        }else if(oper.equals("del")){
            DeleteInterfInfoCommand deleteInterfInfoCommand = new DeleteInterfInfoCommand();
            deleteInterfInfoCommand.createCommand(command);
            result = interfInfoService.deleteInterfInfo(deleteInterfInfoCommand);
        }
        return result;
    }

    @RequestMapping("/find_interf_method_list")
    @ResponseBody
    public Pagination findInterfMethodList(HttpServletRequest request,
                                       @ModelAttribute InterfMethodQo qo,
                                       @RequestParam("page") Integer pageNo,
                                       @RequestParam("rows") Integer pageSize,
                                       Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);
        pagination = interfMethodService.findInterfMethodByPagination(pagination);
        return pagination;
    }
    @RequestMapping("/find_interf_info_list")
    @ResponseBody
    public Pagination findInterfInfoList(HttpServletRequest request,
                                       @ModelAttribute InterfInfoQo qo,
                                       @RequestParam("page") Integer pageNo,
                                       @RequestParam("rows") Integer pageSize,
                                       Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);
        pagination = interfInfoService.findInterfInfoByPagination(pagination);
        return pagination;
    }
    @RequestMapping("/find_child_interf_info_list")
    @ResponseBody
    public Pagination findChildInterfInfoList(HttpServletRequest request,
                                       @ModelAttribute InterfInfoQo qo,
                                       @RequestParam("page") Integer pageNo,
                                       @RequestParam("rows") Integer pageSize,
                                       Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);
        pagination = interfInfoService.findChildInterfInfoByPagination(pagination);
        return pagination;
    }

}
