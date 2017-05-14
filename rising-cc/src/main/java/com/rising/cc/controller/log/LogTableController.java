package com.rising.cc.controller.log;

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
import com.rising.cc.pojo.command.log.*;
import com.rising.cc.pojo.qo.log.LogTableQo;
import com.rising.cc.service.interf.log.LogDBService;
import com.rising.cc.service.interf.log.LogTableService;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/3 14:15
 * 修改人：caizh
 * 修改时间：2015/8/3 14:15
 * 修改备注：
 */
@Controller
@RequestMapping("/log_table")
public class LogTableController extends BaseController {
    @Resource
    private LogTableService logTableService;

    @Resource
    private LogDBService logDBService;

    /**
     * 编辑日志表
     * @param request
     * @param command
     * @param model
     * @param oper
     * @return
     */
    @RequestMapping("/edit_log_table")
    @ResponseBody
    public String editLogTable(HttpServletRequest request,
                               @ModelAttribute EditLogTableCommand command,Model model,
                               @RequestParam String oper){

        if(oper.equals("add")){
            CreateLogTableCommand createLogTableCommand = new CreateLogTableCommand();
            createLogTableCommand.createCommand(command);
            logTableService.saveLogTable(createLogTableCommand);
        }else if(oper.equals("del")){
            RemoveLogTableCommand removeLogTableCommand = new RemoveLogTableCommand();
            removeLogTableCommand.createCommand(command);
            logTableService.removeLogTable(removeLogTableCommand);
        }
        return "success";
    }
    @RequestMapping("/edit_log_field")
    @ResponseBody
    public String editLogField(HttpServletRequest request,
                               @ModelAttribute EditLogFieldCommand command,Model model,
                               @RequestParam String oper){

        if(oper.equals("add")){
            CreateLogFieldCommand createLogFieldCommand = new CreateLogFieldCommand();
            createLogFieldCommand.createCommand(command);
            logTableService.saveLogField(createLogFieldCommand);
        }else if(oper.equals("del")){
            RemoveLogFieldCommand removeLogFieldCommand = new RemoveLogFieldCommand();
            removeLogFieldCommand.createCommand(command);
            logTableService.removeLogField(removeLogFieldCommand);
        }
        return "success";
    }


    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/to_log_table_list")
    public String toLogTableList(HttpServletRequest request,
                             Model model){

        return "/log/log_table_list.html";
    }

    /**
     *
     * @description 查找日志列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/log_table_list")
    @ResponseBody
    public Pagination findLogTableList(HttpServletRequest request,
                                   @ModelAttribute LogTableQo qo,
                                   @RequestParam("page") Integer pageNo,
                                   @RequestParam("rows") Integer pageSize,
                                   Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);
        pagination = logTableService.findLogTableByPagination(pagination);
        return pagination;
    }

    @RequestMapping("/log_table_field_list")
    @ResponseBody
    public Pagination findLogTableFieldList(HttpServletRequest request,
                                   @ModelAttribute LogTableQo qo,
                                   @RequestParam("page") Integer pageNo,
                                   @RequestParam("rows") Integer pageSize,
                                   Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = logTableService.findLogTableFieldByPagination(pagination);

        return pagination;
    }
    @RequestMapping("/create_log_table")
    @ResponseBody
    public String createLogTable(HttpServletRequest request,
                                 @ModelAttribute CreateLogServiceTableCommand command,
                                   Model model){


         String result = logTableService.createLogServiceTable(command);
        return result;
    }
    @RequestMapping("/copy_log_table_to_envir")
    @ResponseBody
    public String copyLogTableToEnvir(HttpServletRequest request,
                                 @ModelAttribute CopyLogTableToEnvirCommand command,
                                   Model model){
         String result = logTableService.copyLogTableToEnvir(command);
        return result;
    }

}
