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
import com.rising.cc.pojo.command.basicdata.mongodb.CreateMongoDbCommand;
import com.rising.cc.pojo.command.basicdata.mongodb.DeleteMongoDbCommand;
import com.rising.cc.pojo.command.basicdata.mongodb.EditMongoDbCommand;
import com.rising.cc.pojo.command.basicdata.mongodb.UpdateMongoDbCommand;
import com.rising.cc.pojo.qo.basicdata.MongoDbQo;
import com.rising.cc.service.interf.basicdata.MongoDbService;
import com.rising.cc.util.WebUtil;

@Controller
@RequestMapping("/mongodb")
public class MongoDbController extends BaseController{
	
	@Resource 
	private MongoDbService mongoDbService;
	
	
	/**
	 * @Description 转向到mongodb列表页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:26:23
	 * @modifyTime 2015年8月7日 下午5:26:23
	 */
	@RequestMapping("/to_list")
	public String toList(HttpServletRequest request, Model model){

		return "/basicdata/mongodb/list.html";
	}
	
	
	/**
	 * @Description 转向到新增或修改页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:26:48
	 * @modifyTime 2015年8月7日 下午5:26:48
	 */
	@RequestMapping("/to_add_or_update")
	public String toAddOrUpdate(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "/mongodb/push";
	}
	
	
	/**
	 * @Description 获取mongodb列表数据
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:27:05
	 * @modifyTime 2015年8月7日 下午5:27:05
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Pagination list(HttpServletRequest request,
			@RequestParam(value = "page",required=true) Integer pageNo,
			@RequestParam(value = "rows",required=true) Integer pageSize,
			@ModelAttribute MongoDbQo qo,
			Model model){

		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = mongoDbService.findMongoDbInfoListByPagination(pagination);
		
		return pagination;
	}
	
	
	/**
	 * @Description 新增、修改或者删除mongodb信息
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:27:26
	 * @modifyTime 2015年8月7日 下午5:27:26
	 */
	@RequestMapping("/edit_mongodb")
	@ResponseBody
	public String editMongoDb(HttpServletRequest request, 
			@ModelAttribute EditMongoDbCommand command, Model model,
			@RequestParam String oper){

		if(oper.equals("add")){
			CreateMongoDbCommand addCommand = new CreateMongoDbCommand();
			addCommand.createCommand(command);
			mongoDbService.saveMongoDb(addCommand);
		} else if(oper.equals("edit")){
			UpdateMongoDbCommand updateCommand = new UpdateMongoDbCommand();
			updateCommand.createCommand(command);
			mongoDbService.updateMongoDb(updateCommand);
		} else if(oper.equals("del")){
			DeleteMongoDbCommand deleteCommand = new DeleteMongoDbCommand();
			deleteCommand.createCommand(command);
			mongoDbService.deleteMongoDb(deleteCommand);
		}
		return "true";
	}
	
	
	/**
	 * @Description 删除mongodb信息
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:27:48
	 * @modifyTime 2015年8月7日 下午5:27:48
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "list";
	}
}
