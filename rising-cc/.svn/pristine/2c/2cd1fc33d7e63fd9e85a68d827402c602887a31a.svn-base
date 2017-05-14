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
import com.rising.cc.pojo.command.project.CreateEnginConfigTypeCommand;
import com.rising.cc.pojo.command.project.DeleteEnginConfigTypeCommand;
import com.rising.cc.pojo.command.project.EditEnginConfigTypeCommand;
import com.rising.cc.pojo.command.project.UpdateEnginConfigTypeCommand;
import com.rising.cc.pojo.dto.project.EngineeringDto;
import com.rising.cc.pojo.qo.project.EnginConfigTypeQo;
import com.rising.cc.pojo.qo.project.EngineeringQo;
import com.rising.cc.service.interf.project.EnginConfigTypeService;
import com.rising.cc.service.interf.project.EngineeringService;

@Controller
@RequestMapping("engin_config_type")
public class EnginConfigTypeController extends BaseController{
	
	@Resource
	private EnginConfigTypeService enginConfigTypeService;
	
	@Resource
	private EngineeringService engineeringService;
	
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
	@RequestMapping("to_engin_config_type_list")
	public String toUserList(HttpServletRequest request,
			Model model){
		EngineeringQo qo = new EngineeringQo();
		
		List<EngineeringDto>  dtoList = engineeringService.findEngineeringListByQo(qo);
		
		String str = "0:所有工程;";
		for(EngineeringDto dto : dtoList){
			str +=dto.getId()+":"+dto.getEngineeringName()+";";
		}
		if(str.length() > 0){
			str = str.substring(0, str.length()-1);
		}
		
		model.addAttribute("engineerings", str);
		
		return "/project/engin_config_type/engin_config_type_list.html";
	}
	
	/**
	 * 
	 * @description 加载工程配置类别列表
	 * @author caoy
	 * @date 2015年8月28日 上午11:18:22
	 * @param request
	 * @param pageNo
	 * @param pageSize
	 * @param filters
	 * @param model
	 * @return
	 */
	@RequestMapping("engin_config_type_list")
	@ResponseBody
	public Pagination findEnginConfigTypeList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute EnginConfigTypeQo qo,
			Model model){
	
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = enginConfigTypeService.findEnginConfigTypeListByPagination(pagination);
		
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
	@RequestMapping("save_engin_config_type")
	@ResponseBody
	public String saveEnginConfigType(HttpServletRequest request,
			@ModelAttribute EditEnginConfigTypeCommand command,Model model,
			@RequestParam String oper){
		
		try {
			if(oper.equals("add")){
				CreateEnginConfigTypeCommand addCommand = new CreateEnginConfigTypeCommand();
				addCommand.createCommand(command);
				enginConfigTypeService.saveEnginConfigType(addCommand);
			}else if(oper.equals("edit")){
				UpdateEnginConfigTypeCommand updateCommand = new UpdateEnginConfigTypeCommand();
				updateCommand.createCommand(command);
				enginConfigTypeService.updateEnginConfigType(updateCommand);
			}else if(oper.equals("del")){
				DeleteEnginConfigTypeCommand deleteCommand = new DeleteEnginConfigTypeCommand();
				deleteCommand.createCommand(command);
				if(!enginConfigTypeService.deleteEnginConfigType(deleteCommand)){
					return "be_used";
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "false";
		}
		
		return "true";
	}
	
	
}
