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
import com.rising.cc.pojo.command.basicdata.redis.CreateRedisCommand;
import com.rising.cc.pojo.command.basicdata.redis.DeleteRedisCommand;
import com.rising.cc.pojo.command.basicdata.redis.EditRedisCommand;
import com.rising.cc.pojo.command.basicdata.redis.UpdateRedisCommand;
import com.rising.cc.pojo.qo.basicdata.RedisQo;
import com.rising.cc.service.interf.basicdata.RedisService;
import com.rising.cc.util.WebUtil;

@Controller
@RequestMapping("/redis")
public class RedisController extends BaseController{
	
	@Resource
	private RedisService redisService;
	/**
	 * @Description 跳转到redis列表页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:31:35
	 * @modifyTime 2015年8月7日 下午5:31:35
	 */
	@RequestMapping("/to_list")
	public String toList(HttpServletRequest request, Model model){

		return "/basicdata/redis/list.html";
	}
	
	
	/**
	 * @Description 跳转到新增或修改页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:31:56
	 * @modifyTime 2015年8月7日 下午5:31:56
	 */
	@RequestMapping("/to_add_or_update")
	public String toAddOrUpdate(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "/redis/push";
	}
	
	
	/**
	 * @Description 获取redis分页数据
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:32:32
	 * @modifyTime 2015年8月7日 下午5:32:32
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Pagination list(HttpServletRequest request, 
			@RequestParam(value = "page",required=true) Integer pageNo,
			@RequestParam(value = "rows",required=true) Integer pageSize,
			@ModelAttribute RedisQo qo,
			Model model){

		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = redisService.findRedisInfoListByPagination(pagination);
		
		return pagination;
	}
	
	
	/**
	 * @Description 新增、修改或者删除redis信息
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:33:16
	 * @modifyTime 2015年8月7日 下午5:33:16
	 */
	@RequestMapping("/edit_redis")
	@ResponseBody
	public String editRedis(HttpServletRequest request,
			@ModelAttribute EditRedisCommand command, Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateRedisCommand addCommand = new CreateRedisCommand();
			addCommand.createCommand(command);
			redisService.saveRedis(addCommand);
		} else if(oper.equals("edit")){
			UpdateRedisCommand updateCommand = new UpdateRedisCommand();
			updateCommand.createCommand(command);
			redisService.editRedis(updateCommand);
		} else if(oper.equals("del")){
			DeleteRedisCommand deleteCommand = new DeleteRedisCommand();
			deleteCommand.createCommand(command);
			redisService.deleteRedis(deleteCommand);
		}
		return "true";
	}
	
	
	/**
	 * @Description 删除redis信息
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月7日 下午5:33:26
	 * @modifyTime 2015年8月7日 下午5:33:26
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "list";
	}
}
