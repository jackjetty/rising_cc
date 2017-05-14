package com.rising.cc.controller.basicdata;

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
import com.rising.cc.pojo.command.basicdata.dubbo.CreateDubboCommand;
import com.rising.cc.pojo.command.basicdata.dubbo.DeleteDubboCommand;
import com.rising.cc.pojo.command.basicdata.dubbo.EditDubboCommand;
import com.rising.cc.pojo.command.basicdata.dubbo.UpdateDubboCommand;
import com.rising.cc.pojo.qo.basicdata.DubboQo;
import com.rising.cc.service.interf.basicdata.DubboService;
import com.rising.cc.util.WebUtil;

@Controller
@RequestMapping("/dubbo")
public class DubboController extends BaseController{
	
	@Resource
	private DubboService dubboService;
	
	
	/**
	 * @Description 转向到dubbo列表页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:24:30
	 * @modifyTime 2015年8月7日 下午5:24:30
	 */
	@RequestMapping("/to_list")
	public String toList(HttpServletRequest request, Model model){
		
		return "/basicdata/dubbo/list.html";
	}
	
	/**
	 * @Description 转向到新增或修改页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:24:53
	 * @modifyTime 2015年8月7日 下午5:24:53
	 */
	@RequestMapping("/to_add_or_update")
	public String toAddOrUpdate(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "/dubbo/push";
	}
	
	/**
	 * @Description 获取dubbo列表数据
	 * @param request
	 * @param model
	 * @return 
	 * @throws
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:25:06
	 * @modifyTime 2015年8月7日 下午5:25:06
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Pagination list(HttpServletRequest request,
			@RequestParam(value = "page",required=true) Integer pageNo,
			@RequestParam(value = "rows",required=true) Integer pageSize,
			@ModelAttribute DubboQo qo,
			Model model){
		
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = dubboService.findDubboInfoListByPagination(pagination);
		
		return pagination;
	}
	
	
	/**
	 * @Description 新增、修改或者删除dubbo信息
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:25:31
	 * @modifyTime 2015年8月7日 下午5:25:31
	 */
	@RequestMapping("/edit_dubbo")
	@ResponseBody
	public String editDubbo(HttpServletRequest request,
			@ModelAttribute EditDubboCommand command, Model model,
			@RequestParam String oper){
		if(oper.equals("add")){
			CreateDubboCommand addCommand = new CreateDubboCommand();
			addCommand.createCommand(command);
			dubboService.saveDubbo(addCommand);
		} else if(oper.equals("edit")){
			UpdateDubboCommand updateCommand = new UpdateDubboCommand();
			updateCommand.createCommand(command);
			dubboService.updateDubbo(updateCommand);
		} else if(oper.equals("del")){
			DeleteDubboCommand deleteCommand = new DeleteDubboCommand();
			deleteCommand.createCommand(command);
			dubboService.deleteCommand(deleteCommand);
		}
		return "true";
	}
	
	/**
	 * @Description 删除dubbo信息
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:25:58
	 * @modifyTime 2015年8月7日 下午5:25:58
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "list";
	}
}
