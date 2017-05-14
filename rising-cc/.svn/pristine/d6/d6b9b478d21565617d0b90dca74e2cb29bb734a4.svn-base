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
import com.rising.cc.pojo.command.basicdata.database.CreateDataBaseCommand;
import com.rising.cc.pojo.command.basicdata.database.DeleteDataBaseCommand;
import com.rising.cc.pojo.command.basicdata.database.EditDataBaseCommand;
import com.rising.cc.pojo.command.basicdata.database.UpdateDataBaseCommand;
import com.rising.cc.pojo.qo.basicdata.DataBaseQo;
import com.rising.cc.service.interf.basicdata.DataBaseService;
import com.rising.cc.util.WebUtil;



@Controller
@RequestMapping("/database")
public class DataBaseController extends BaseController {
	
	@Resource
	private DataBaseService dataBaseService;
	
	/**
	 * @Description 转向到数据库列表页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月5日 下午6:16:50
	 * @modifyTime 2015年8月5日 下午6:16:50
	 */
	@RequestMapping("/to_list")
	public String toList(HttpServletRequest request, Model model){
		
		return "/basicdata/database/list.html";
	}
	
	
	/**
	 * @Description 转向到新增或修改页面
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月5日 下午6:17:27
	 * @modifyTime 2015年8月5日 下午6:17:27
	 */
	@RequestMapping("/to_add_or_update")
	public String toAddOrUpdate(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "/database/push";
	}
	
	
	/**
	 * @Description 获取数据库列表数据
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月5日 下午6:24:02
	 * @modifyTime 2015年8月5日 下午6:24:02
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Pagination list(HttpServletRequest request,
			@RequestParam(value = "page",required=true) Integer pageNo,
			@RequestParam(value = "rows",required=true) Integer pageSize,
			@ModelAttribute DataBaseQo qo,
			Model model){
		
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = dataBaseService.findDataBaseInfoListByPagination(pagination);
		
		return pagination;
	}
	
	
	/**
	 * @Description 新增、修改或删除记录关系数据库
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月5日 下午6:25:00
	 * @modifyTime 2015年8月5日 下午6:25:00
	 */
	@RequestMapping("/edit_database")
	@ResponseBody
	public String editDatabase(HttpServletRequest request, 
			@ModelAttribute EditDataBaseCommand command, Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateDataBaseCommand addCommand = new CreateDataBaseCommand();
			addCommand.createCommand(command);
			dataBaseService.saveDataBase(addCommand);
		} else if(oper.equals("edit")){
			UpdateDataBaseCommand updateCommand = new UpdateDataBaseCommand();
			updateCommand.createCommand(command);
			dataBaseService.editDataBase(updateCommand);
		} else if(oper.equals("del")){
			DeleteDataBaseCommand deleteCommand = new DeleteDataBaseCommand();
			deleteCommand.createCommand(command);
			dataBaseService.deleteDataBase(deleteCommand);
		}
		return "true";
	}
	
	/**
	 * @Description 根据id删除数据
	 * @param request
	 * @param model
	 * @author dingzl
	 * @creatTime 2015年8月5日 下午6:25:25
	 * @modifyTime 2015年8月5日 下午6:25:25
	 */
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model){
		String basePath = WebUtil.getBasePath(request);
		model.addAttribute("basePath", basePath);
		return "list";
	}
}
