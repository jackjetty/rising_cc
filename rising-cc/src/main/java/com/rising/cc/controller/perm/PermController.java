package com.rising.cc.controller.perm;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rising.cc.common.component.BaseController;
import com.rising.cc.model.perm.SysPermission;
import com.rising.cc.pojo.command.perm.CreatePermCommand;
import com.rising.cc.pojo.command.perm.DeletePermCommand;
import com.rising.cc.pojo.command.perm.UpdatePermCommand;
import com.rising.cc.pojo.dto.perm.PermDto;
import com.rising.cc.service.interf.perm.PermService;
import com.rising.cc.util.JsonUtils;

/**
 * 
 * @description 权限控制器
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月20日 下午3:22:09
 *
 */
@Controller
@RequestMapping("/perm")
public class PermController extends BaseController{
	
	
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
	@RequestMapping("to_perm_list")
	public String toUserList(HttpServletRequest request,
			Model model){
		
		return "/perm/perm_list.html";
	}
	
	
	/**
	 * 
	 * @description 加载权限树
	 * @author caoy
	 * @date 2015年8月25日 上午8:39:52
	 * @param request
	 * @param parentId
	 * @param model
	 * @return
	 */
	@RequestMapping("perm_nestable_list")
	@ResponseBody
	public String findPermNestableList(HttpServletRequest request){
		
		return permService.createAceNestableListHtml();
	}
	
	/**
	 * 
	 * @description 加载子节点列表
	 * @author caoy
	 * @date 2015年8月11日 上午10:41:08
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("find_perm")
	@ResponseBody
	public PermDto findPermByPermQo(HttpServletRequest request,
			@RequestParam("id") Integer id,
			Model model){
		
		PermDto dto = null;
		
		if(id != null){
			dto = permService.findPermById(id);
			
		}
		
		return dto;
	}
	
	
	/**
	 * 
	 * @description 保存节点改变的位置信息（改变排序，以及改变父节点）
	 * [{"id":7,"children":[{"id":8},{"id":9},{"id":12},{"id":11},{"id":10}]},{"id":5},{"id":1,"children":[{"id":4},{"id":3,"children":[{"id":2}]}]}]
	 * @author caoy
	 * @date 2015年8月24日 下午3:46:00
	 * @param request
	 * @param changeJsonStr
	 * @param model
	 */
	@RequestMapping("update_perm_position")
	@ResponseBody
	public void updatePermPosition(HttpServletRequest request,
			@RequestParam("jsonStr") String jsonStr,
			Model model){
		
		List<SysPermission> permList = JsonUtils.JsonStringToSysPermissionList(jsonStr);
		
		permService.updateBatchPermPosition(permList);
		
	}
	
	/**
	 * 
	 * @description 更新权限信息
	 * @author caoy
	 * @date 2015年8月25日 上午10:49:46
	 * @param request
	 * @param command
	 * @param mode
	 */
	@RequestMapping("update_perm")
	@ResponseBody
	public void updatePerm(HttpServletRequest request,
			@ModelAttribute UpdatePermCommand command,
			Model mode){
		permService.updatePerm(command);
	}
	
	/**
	 * 
	 * @description 新增权限信息
	 * @author caoy
	 * @date 2015年8月25日 上午10:49:46
	 * @param request
	 * @param command
	 * @param mode
	 */
	@RequestMapping("add_perm")
	@ResponseBody
	public void addPerm(HttpServletRequest request,
			@ModelAttribute CreatePermCommand command,
			Model mode){
		
		permService.insertPerm(command);
	}
	
	/**
	 * 
	 * @description 删除权限
	 * @author caoy
	 * @date 2015年8月25日 上午10:49:59
	 * @param request
	 * @param command
	 * @param mode
	 */
	@RequestMapping("delete_perm")
	@ResponseBody
	public String deletePerm(HttpServletRequest request,
			@ModelAttribute DeletePermCommand command,
			Model mode){
		try {
			if(!permService.deletePerm(command)){
				return "exist_child";
			}
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	
}
