package com.rising.cc.controller.api;

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
import com.rising.cc.pojo.command.api.CreateApiInfoCommand;
import com.rising.cc.pojo.command.api.DeleteApiInfoCommand;
import com.rising.cc.pojo.command.api.EditApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiInfoCommand;
import com.rising.cc.pojo.dto.envir.EnvirTypeDto;
import com.rising.cc.pojo.qo.api.ApiInfoQo;
import com.rising.cc.service.interf.api.ApiInfoService;
import com.rising.cc.service.interf.envir.EnvirTypeService;

/**
 * 
 * @description Api管理控制器
 * @company 碧海银帆
 * @author caoy
 * @date 2015年9月7日 下午3:20:21
 *
 */
@Controller
@RequestMapping("api")
public class ApiInfoController extends BaseController{
	
	@Resource
	private ApiInfoService apiInfoService;
	
	@Resource
	private EnvirTypeService envirTypeService;
	
	/**
	 * 
	 * @description 跳转至api列表
	 * @author caoy
	 * @date 2015年9月7日 下午3:16:36
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("to_api_list")
	public String toApiInfoList(HttpServletRequest request,
			Model model){
		
		List<EnvirTypeDto> envirTypeList = envirTypeService.findEnvirTypeListByUserId(this.getCurrentUser().getId());
		
		model.addAttribute("envirTypeList", envirTypeList);
		return "/api/api/api_list.html";
	}
	
	/**
	 * 
	 * @description 加载Api列表
	 * @author caoy
	 * @date 2015年9月7日 下午3:16:59
	 * @param request
	 * @param pageNo
	 * @param pageSize
	 * @param qo
	 * @param model
	 * @return
	 */
	@RequestMapping("api_list")
	@ResponseBody
	public Pagination findApiInfoList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute ApiInfoQo qo,
			Model model){
	
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = apiInfoService.findApiInfoListByPagination(pagination);
		
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
	@RequestMapping("save_api")
	@ResponseBody
	public String saveApiInfo(HttpServletRequest request,
			@ModelAttribute EditApiInfoCommand command,Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateApiInfoCommand addCommand = new CreateApiInfoCommand();
			addCommand.createCommand(command);
			if(!apiInfoService.saveApiInfo(addCommand)){
				return "code_existing";
			}
		}else if(oper.equals("edit")){
			UpdateApiInfoCommand updateCommand = new UpdateApiInfoCommand();
			updateCommand.createCommand(command);
			if(!apiInfoService.updateApiInfo(updateCommand)){
				return "code_existing";
			}
		}else if(oper.equals("del")){
			DeleteApiInfoCommand deleteCommand = new DeleteApiInfoCommand();
			deleteCommand.createCommand(command);
			if(!apiInfoService.deleteApiInfo(deleteCommand)){
				return "be_used";
			}
		}
		
		return "true";
	}
	
}
