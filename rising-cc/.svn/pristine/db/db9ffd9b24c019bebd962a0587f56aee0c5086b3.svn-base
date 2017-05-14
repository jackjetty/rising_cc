package com.rising.cc.controller.log;

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.pojo.command.log.*;
import com.rising.cc.pojo.qo.log.LogDBQo;
import com.rising.cc.service.interf.log.LogDBService;

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
 * 创建时间：2015/10/22 14:25
 * 修改人：caizh
 * 修改时间：2015/10/22 14:25
 * 修改备注：
 */
@Controller
@RequestMapping("/log_db")
public class LogDBController extends BaseController{
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
    @RequestMapping("/edit_log_db")
    @ResponseBody
    public String editLogDB(HttpServletRequest request,
                               @ModelAttribute EditLogDBCommand command,Model model,
                               @RequestParam String oper){
        String result = "";
        if(oper.equals("add")){
            CreateLogDBCommand createLogDBCommand = new CreateLogDBCommand();
            createLogDBCommand.createCommand(command);
            result = logDBService.saveLogDB(createLogDBCommand);
        }else if(oper.equals("del")){
            RemoveLogDBCommand removeLogDBCommand = new RemoveLogDBCommand();
            removeLogDBCommand.createCommand(command);
            result = logDBService.removeLogDB(removeLogDBCommand);
        }
        return result;
    }

    /**
     *
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/to_log_db_list")
    public String toLogDBList(HttpServletRequest request,
                                 Model model){
        return "/log/log_db_list.html";
    }

    /**
     *
     * @description 查找日志库列表
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/log_db_list")
    @ResponseBody
    public Pagination findLogDBList(HttpServletRequest request,
                                       @ModelAttribute LogDBQo qo,
                                       @RequestParam("page") Integer pageNo,
                                       @RequestParam("rows") Integer pageSize,
                                       Model model){

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = logDBService.findLogDBByPagination(pagination);
        return pagination;
    }

    /**
     *
     * @description 查找日志库
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/log_envir_db_list")
    @ResponseBody
    public String findLogDBList(HttpServletRequest request,
                                    @ModelAttribute LogDBQo qo,
                                    Model model){
        String logDBs =logDBService.findLogDBsByEnvirId(qo.getEnvirId());
        return logDBs;
    }
}
