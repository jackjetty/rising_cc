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
import com.rising.cc.pojo.command.basicdata.rabbitmq.CreateRabbitMqCommand;
import com.rising.cc.pojo.command.basicdata.rabbitmq.DeleteRabbitMqCommand;
import com.rising.cc.pojo.command.basicdata.rabbitmq.EditRabbitMqCommand;
import com.rising.cc.pojo.command.basicdata.rabbitmq.UpdateRabbitMqCommand;
import com.rising.cc.pojo.qo.basicdata.RabbitMqQo;
import com.rising.cc.service.interf.basicdata.RabbitMqService;
import com.rising.cc.util.WebUtil;

@Controller
@RequestMapping("/rabbitmq")
public class RabbitMqController extends BaseController{
	
	@Resource
	private RabbitMqService rabbitMqService;
	
	/**
	 * @Description 跳转到rabbitmq列表页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:29:28
	 * @modifyTime 2015年8月7日 下午5:29:28
	 */
	@RequestMapping("/to_list")
	public String toList(HttpServletRequest request, Model model){

		return "/basicdata/rabbitmq/list.html";
	}
	
	
	/**
	 * @Description 跳转到新增或修改页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:29:57
	 * @modifyTime 2015年8月7日 下午5:29:57
	 */
	@RequestMapping("/to_add_or_update")
	public String toAddOrUpdate(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "/rabbitmq/push";
	}
	
	
	/**
	 * @Description 获取rabbitmq分页数据
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:30:28
	 * @modifyTime 2015年8月7日 下午5:30:28
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Pagination list(HttpServletRequest request, 
			@RequestParam(value = "page",required=true) Integer pageNo,
			@RequestParam(value = "rows",required=true) Integer pageSize,
			@ModelAttribute RabbitMqQo qo,
			Model model){
		
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = rabbitMqService.findRabbitMqInfoListByPagination(pagination);
		
		return pagination;
	}
	
	
	/**
	 * @Description 新增、修改或者删除rabbitmq信息
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:30:57
	 * @modifyTime 2015年8月7日 下午5:30:57
	 */
	@RequestMapping("/edit_rabbitmq")
	public String editRabbitMq(HttpServletRequest request,
			@ModelAttribute EditRabbitMqCommand command, Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateRabbitMqCommand addCommand = new CreateRabbitMqCommand();
			addCommand.createCommand(command);
			rabbitMqService.saveRabbitMq(addCommand);
		} else if(oper.equals("edit")){
			UpdateRabbitMqCommand updateCommand = new UpdateRabbitMqCommand();
			updateCommand.createCommand(command);
			rabbitMqService.editRabbitMq(updateCommand);
		} else if(oper.equals("del")){
			DeleteRabbitMqCommand deleteCommand = new DeleteRabbitMqCommand();
			deleteCommand.createCommand(command);
			rabbitMqService.deleteRabbitMq(deleteCommand);
		}
		return "true";
	}
	
	
	/**
	 * @Description 删除rabbitmq信息
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:31:19
	 * @modifyTime 2015年8月7日 下午5:31:19
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "list";
	}
	
}
