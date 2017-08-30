package com.bhyf.controller.app;

import com.bhyf.common.component.BaseController;
import com.bhyf.common.component.BaseQo;
import com.bhyf.common.component.PaginQo;
import com.bhyf.pojo.command.app.CreateHelpCommand;
import com.bhyf.pojo.command.app.UpdateHelpCommand;
import com.bhyf.pojo.command.enter.CreateEnterCommand;
import com.bhyf.pojo.command.enter.RemoveEnterCommand;
import com.bhyf.pojo.command.enter.UpdateEnterCommand;
import com.bhyf.pojo.command.enter.UpdateEnterStatusCommand;
import com.bhyf.pojo.qo.enter.EnterQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.app.HelpService;
import com.bhyf.service.interf.enter.EnterService;
import com.rising.common.page.Pagination;
import com.rising.common.util.FileUtils;
import com.rising.common.util.JsonUtil;
import com.rising.common.util.PathUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description 用户管理控制器
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:45:44
 *
 */
@Controller
@RequestMapping("/help")
public class HelpController extends BaseController{

	@Resource
	private HelpService helpService;
	




	
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
	@RequestMapping("to_help_list")
	public String toEnterList(HttpServletRequest request,
			Model model){

		return "/app/help.html";
	}

	/**
	 * 
	 * @description 加载用户列表
	 * @author caoy
	 * @date 2015年8月11日 上午10:41:08
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("help_list")
	@ResponseBody
	public DataGridResponse findEnterList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			Model model){
		
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, new BaseQo());


		pagination = helpService.findHelpByPagination(pagination);
		return new DataGridResponse(pagination);
	}

	/**
	 *
	 * @description 加载用户列表
	 * @author caoy
	 * @date 2015年8月11日 上午10:41:08
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("save_help")
	@ResponseBody
	public String saveHelp(HttpServletRequest request,
										 @ModelAttribute CreateHelpCommand command,
										 Model model){


		String str =  helpService.saveHelp(command);
		return str;
	}
	@RequestMapping("update_help")
	@ResponseBody
	public String updateHelp(HttpServletRequest request,
										 @ModelAttribute UpdateHelpCommand command,
										 Model model){


		String str =  helpService.updateHelp(command);
		return str;
	}
}
