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

import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.pojo.command.project.CreateEngineeringCommand;
import com.rising.cc.pojo.command.project.DeleteEngineeringCommand;
import com.rising.cc.pojo.command.project.EditEngineeringCommand;
import com.rising.cc.pojo.command.project.UpdateEnginConfigInfoCommand;
import com.rising.cc.pojo.command.project.UpdateEngineeringCommand;
import com.rising.cc.pojo.constants.project.EnginConfigTypeConstants;
import com.rising.cc.pojo.constants.project.ProjectConstants;
import com.rising.cc.pojo.dto.envir.EnvirTypeDto;
import com.rising.cc.pojo.dto.project.EnginConfigInfoDto;
import com.rising.cc.pojo.dto.project.EnginConfigTypeDto;
import com.rising.cc.pojo.dto.project.ProjectDto;
import com.rising.cc.pojo.qo.project.EnginConfigInfoQo;
import com.rising.cc.pojo.qo.project.EnginConfigTypeQo;
import com.rising.cc.pojo.qo.project.EngineeringQo;
import com.rising.cc.pojo.qo.project.ProjectQo;
import com.rising.cc.service.interf.envir.EnvirTypeService;
import com.rising.cc.service.interf.perm.PermService;
import com.rising.cc.service.interf.project.EnginConfigInfoService;
import com.rising.cc.service.interf.project.EnginConfigTypeService;
import com.rising.cc.service.interf.project.EngineeringService;
import com.rising.cc.service.interf.project.ProjectService;

@Controller
@RequestMapping("engin")
public class EngineeringController extends BaseController{
	
	@Resource
	private EngineeringService engineeringService;
	
	@Resource
	private EnginConfigInfoService enginConfigInfoService;
	
	@Resource
	private EnginConfigTypeService enginConfigTypeService;
	
	@Resource
	private PermService permService;
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private EnvirTypeService envirTypeService;
	
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
	@RequestMapping("to_engin_list")
	public String toProjectList(HttpServletRequest request,
			Model model){
		
		ProjectQo qo = new ProjectQo();
		qo.setStatus(ProjectConstants.PROJECT_ENABLE);
		
		List<ProjectDto> dtoList = projectService.findProjectListByQo(qo);

		String str = "";
		for(ProjectDto dto : dtoList){
			str +=dto.getId()+":"+dto.getProjectName()+";";
		}
		if(str.length() > 0){
			str = str.substring(0, str.length()-1);
		}
		
		model.addAttribute("projects", str);

		return "/project/engin/engin_list.html";
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
	@RequestMapping("engin_list")
	@ResponseBody
	public Pagination findEnginConfigTypeList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute EngineeringQo qo,
			Model model){
	
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = engineeringService.findEnginListByPagination(pagination);
		
		return pagination;
	}
	
	/**
	 * 
	 * @description 保存工程
	 * @author caoy
	 * @date 2015年8月29日 下午1:35:03
	 * @param request
	 * @param command
	 * @param model
	 * @param oper
	 * @return
	 */
	@RequestMapping("save_engin")
	@ResponseBody
	public String saveEngin(HttpServletRequest request,
			@ModelAttribute EditEngineeringCommand command,Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateEngineeringCommand addCommand = new CreateEngineeringCommand();
			addCommand.createCommand(command);
			if(!engineeringService.saveEngineering(addCommand)){
				return "code_existing";
			}

		}else if(oper.equals("edit")){
			UpdateEngineeringCommand updateCommand = new UpdateEngineeringCommand();
			updateCommand.createCommand(command);
			if(!engineeringService.updateEngineering(updateCommand)){
				return "code_existing";
			}
		}else if(oper.equals("del")){
			DeleteEngineeringCommand deleteCommand = new DeleteEngineeringCommand();
			deleteCommand.createCommand(command);
			engineeringService.deleteEngineering(deleteCommand);

		}
		
		return "true";
	}
	
	@RequestMapping("to_update_config")
	public String toUpdateConfig(@ModelAttribute EnginConfigInfoQo qo, Model model){
		
		EnginConfigTypeQo typeQo = new EnginConfigTypeQo();
		typeQo.setStatus(EnginConfigTypeConstants.ENGIN_CONFIG_TYPE_ENABLE);
		typeQo.setEnginId(qo.getEnginId());
		typeQo.setArePublic(true);
		
		List<EnginConfigTypeDto> configTypeDtoList = enginConfigTypeService.findEnginConfigTypeListByQo(typeQo);
		List<EnginConfigInfoDto> configInfoDtoList = enginConfigInfoService.findEnginConfigInfoListByQo(qo);
		
		List<EnvirTypeDto> envirTypeList = envirTypeService.findEnvirTypeListByUserId(this.getCurrentUser().getId());
		
		model.addAttribute("enginId", qo.getEnginId());
		model.addAttribute("configInfoDtoList", configInfoDtoList);
		model.addAttribute("configTypeDtoList", configTypeDtoList);
		
		model.addAttribute("envirTypeList", envirTypeList);
		
		return "/project/engin/update_config_info.html";
	}
	
	@RequestMapping("update_config")
	@ResponseBody
	public String updateConfig(@ModelAttribute UpdateEnginConfigInfoCommand command){

		if(enginConfigInfoService.updateEnginConfigInfo(command)){
			return "success";
		}
		
		return "error";
		
	}
	
}
