package com.rising.cc.controller.task;

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
import com.rising.cc.pojo.command.task.CreateTimerTaskCommand;
import com.rising.cc.pojo.command.task.DeleteTimerTaskCommand;
import com.rising.cc.pojo.command.task.EditTimerTaskCommand;
import com.rising.cc.pojo.command.task.StartOverTimerTaskCommand;
import com.rising.cc.pojo.command.task.UpdateTimerTaskCommand;
import com.rising.cc.pojo.qo.task.TimerTaskQo;
import com.rising.cc.service.interf.task.TimerTaskService;

/**
 * 
 * @description 
 * @company 碧海银帆
 * @author caoy
 * @date 2015年12月10日 下午1:30:34
 *
 */
@Controller("ccTimerTaskController")
@RequestMapping("task")
public class TimerTaskController extends BaseController{
	
	@Resource
	private TimerTaskService timerTaskService;
	
	/**
	 * 
	 * @description 
	 * @author caoy
	 * @date 2015年12月10日 下午1:30:27
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("to_timertask_list")
	public String toTimerTaskList(HttpServletRequest request,
			Model model){
		
		return "/task/timertask_list.html";
	}
	
	/**
	 * 
	 * @description 
	 * @author caoy
	 * @date 2015年12月10日 下午1:30:59
	 * @param request
	 * @param pageNo
	 * @param pageSize
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("timertask_list")
	@ResponseBody
	public Pagination findTimerTaskList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute TimerTaskQo qo,
			Model model){
	
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = timerTaskService.findTimerTaskListByPagination(pagination);
		
		return pagination;
	}
	
	/**
	 * 
	 * @description 保存Api信息
	 * @author caoy
	 * @date 2015年9月7日 下午3:18:29
	 * @param request
	 * @param command
	 * @param model
	 * @param oper
	 * @return
	 */
	@RequestMapping("save_timertask")
	@ResponseBody
	public String saveTimerTask(HttpServletRequest request,
			@ModelAttribute EditTimerTaskCommand command,Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateTimerTaskCommand addCommand = new CreateTimerTaskCommand();
			addCommand.createCommand(command);
			if(!timerTaskService.saveTimerTask(addCommand)){
				return "cronexp_error";
			}
		}else if(oper.equals("edit")){
			UpdateTimerTaskCommand updateCommand = new UpdateTimerTaskCommand();
			updateCommand.createCommand(command);
			if(!timerTaskService.updateTimerTask(updateCommand)){
				return "cronexp_error";
			}
		}else if(oper.equals("del")){
			DeleteTimerTaskCommand deleteCommand = new DeleteTimerTaskCommand();
			deleteCommand.createCommand(command);
			if(!timerTaskService.deleteTimerTask(deleteCommand)){
				return "true";
			}
		}
		
		return "true";
	}
	
	/**
	 * 
	 * @description 启动停止定时任务
	 * @author caoy
	 * @date 2015年12月11日 下午2:41:48
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("startover")
	@ResponseBody
	public boolean startOver(HttpServletRequest request,
			@ModelAttribute StartOverTimerTaskCommand command,Model model){
		
		return timerTaskService.startOverTimerTask(command);
	}
	
}
