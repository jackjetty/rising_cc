package com.rising.cc.controller.log;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rising.common.component.PaginQo;
import com.rising.common.page.Pagination;
import com.rising.cc.pojo.dto.log.LogFieldDto;
import com.rising.cc.pojo.dto.log.LogTableDto;
import com.rising.cc.pojo.qo.log.LogQo;
import com.rising.cc.pojo.qo.log.LogTableQo;
import com.rising.cc.service.interf.log.LogService;
import com.rising.cc.service.interf.log.LogTableService;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/4 9:05
 * 修改人：caizh
 * 修改时间：2015/8/4 9:05
 * 修改备注：
 */
@Controller
@RequestMapping("/log")
public class LogContrller {
    @Resource
    private LogTableService logTableService;
    @Resource
    private LogService logService;

    @RequestMapping(value="/to_log")
    public String toLog(HttpSession session, HttpServletRequest request, Model model) {
        LogTableQo logTableQo = new LogTableQo();
        logTableQo.setEnvirId(1);
        List<LogTableDto> logTableDtoList = logTableService.findLogTableByQo(logTableQo);
        model.addAttribute("logTableList", logTableDtoList);
        return "log/log.html";
    }
    @RequestMapping(value="/find_table_list")
    @ResponseBody
    public String findTableList(HttpSession session, HttpServletRequest request, Model model,
                                @RequestParam(required = true, value = "envirId") Integer envirId) {
        LogTableQo logTableQo = new LogTableQo();
        logTableQo.setEnvirId(envirId);
        List<LogTableDto> logTableDtoList = logTableService.findLogTableByQo(logTableQo);
        for (LogTableDto logTableDto : logTableDtoList) {
            if(!logTableDto.getIsSync()){
                logTableDtoList.remove(logTableDto);
                if(logTableDtoList.size() == 0){
                    break;
                }
            }
        }
        return JSON.toJSONString(logTableDtoList);
    }

    @RequestMapping(value="/find_table_by_id")
    @ResponseBody
    public String findTableById(HttpSession session, HttpServletRequest request, ModelMap map,
                                @RequestParam(required = true, value = "id") Integer id) {
        LogTableDto logTableDto = logTableService.findLogTableAndFieldById(id);
        session.setAttribute("logTableDto", logTableDto);
        return JSON.toJSONString(logTableDto.getFieldList());
    }

    @RequestMapping(value="/find_log")
    @ResponseBody
    public Pagination findLog(HttpSession session, HttpServletRequest request, ModelMap map,@ModelAttribute LogQo qo,@RequestParam("page") Integer pageNo,
                              @RequestParam("rows") Integer pageSize) {
        PaginQo paginQo = new PaginQo();
        paginQo.setPageSize(pageSize);
        paginQo.setPageNo(pageNo);
        LogTableDto logTableDto = (LogTableDto) session.getAttribute("logTableDto");
        List<LogFieldDto> logFieldDtoList = logTableDto.getFieldList();
        JSONObject object = logService.analyseLogQo(qo,logFieldDtoList);
        return logService.findLog(object,paginQo,logTableDto.getId());
    }

}
