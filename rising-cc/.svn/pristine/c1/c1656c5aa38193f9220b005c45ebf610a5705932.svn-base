package com.rising.cc.controller.project;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.BaseQo;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.pojo.command.project.CreateProjectCommand;
import com.rising.cc.pojo.command.project.DeleteProjectCommand;
import com.rising.cc.pojo.command.project.EditProjectCommand;
import com.rising.cc.pojo.command.project.UpdateProjectCommand;
import com.rising.cc.pojo.dto.project.ProjectDto;
import com.rising.cc.pojo.qo.project.ProjectQo;
import com.rising.cc.service.interf.perm.PermService;
import com.rising.cc.service.interf.project.ProjectService;

@Controller
@RequestMapping("project")
public class ProjectController extends BaseController{
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private PermService permService;
	
	/**
	 * 
	 * @description 跳转用户列表
	 * @author caoy
	 * @date 2015年8月11日 上午10:41:08
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("to_project_list")
	public String toProjectList(HttpServletRequest request,
			Model model){
		
		return "/project/project/project_list.html";
	}
	
	/**
	 * 
	 * @description 加载项目列表
	 * @author caoy
	 * @date 2015年8月28日 下午3:37:24
	 * @param request
	 * @param pageNo
	 * @param pageSize
	 * @param filters
	 * @param model
	 * @return
	 */
	@RequestMapping("project_list")
	@ResponseBody
	public Pagination findEnginConfigTypeList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute ProjectQo qo,
			Model model){
	
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = projectService.findProjectListByPagination(pagination);
		
		return pagination;
	}
	
	/**
	 * 
	 * @description 保存工程配置类型
	 * @author caoy
	 * @date 2015年8月28日 下午2:53:44
	 * @param request
	 * @param command
	 * @param model
	 * @param oper
	 * @return
	 */
	@RequestMapping("save_project")
	@ResponseBody
	public String saveProject(HttpServletRequest request,
			@ModelAttribute EditProjectCommand command,Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateProjectCommand addCommand = new CreateProjectCommand();
			addCommand.createCommand(command);
			if(!projectService.saveProject(addCommand)){
				return "code_existing";
			}
		}else if(oper.equals("edit")){
			UpdateProjectCommand updateCommand = new UpdateProjectCommand();
			updateCommand.createCommand(command);
			if(!projectService.updateProject(updateCommand)){
				return "code_existing";
			}
		}else if(oper.equals("del")){
			DeleteProjectCommand deleteCommand = new DeleteProjectCommand();
			deleteCommand.createCommand(command);
			projectService.deleteProject(deleteCommand);
		}
		
		return "true";
	}
	
	@RequestMapping("find_project_list_by_qo")
	@ResponseBody
	public List<ProjectDto> findProjectList(@ModelAttribute ProjectQo qo ){
		
		List<ProjectDto> dtoList = projectService.findProjectListByQo(qo);
		
		return dtoList;
	}
	
}
