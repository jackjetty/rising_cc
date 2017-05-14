package com.rising.cc.controller.role;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.rising.common.page.Pagination;
import com.rising.cc.common.component.BaseController;
import com.rising.cc.common.component.PaginQo;
import com.rising.cc.pojo.command.role.CreateRoleCommand;
import com.rising.cc.pojo.command.role.EditRoleCommand;
import com.rising.cc.pojo.command.role.RemoveRoleCommand;
import com.rising.cc.pojo.command.role.UpdateRoleCommand;
import com.rising.cc.pojo.constants.role.RoleConstants;
import com.rising.cc.pojo.dto.perm.tree.AceTreeNode;
import com.rising.cc.pojo.qo.role.RoleQo;
import com.rising.cc.service.interf.perm.PermService;
import com.rising.cc.service.interf.role.RoleService;

/**
 * 
 * @description 角色相关控制器
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月20日 下午3:22:09
 *
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController{
	
	
	@Resource
	private PermService permService;
	
	@Resource
	private RoleService roleService;
	
	
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
	@RequestMapping("to_role_list")
	public String toUserList(HttpServletRequest request,
			Model model){
		
		return "/role/role_list.html";
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
	@RequestMapping("role_list")
	@ResponseBody
	public Pagination findUserList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@RequestParam(value="filters",required=false) String filters,
			Model model){
	
		RoleQo qo =JSONObject.toJavaObject(JSONObject.parseObject(filters), RoleQo.class);
		qo = qo == null ? new RoleQo() : qo;
		qo.setNoStatus(RoleConstants.ROLE_REMOVE);
		
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		pagination = roleService.findRoleListByPagination(pagination);
		
		return pagination;
	}
	
	
	@RequestMapping("save_role")
	@ResponseBody
	public boolean saveRole(HttpServletRequest request,
			@ModelAttribute EditRoleCommand command,Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateRoleCommand addCommand = new CreateRoleCommand();
			addCommand.createCommand(command);
			roleService.saveRole(addCommand);
		}else if(oper.equals("edit")){
			UpdateRoleCommand updateCommand = new UpdateRoleCommand();
			updateCommand.createCommand(command);
			roleService.updateRole(updateCommand);
		}else if(oper.equals("del")){
			RemoveRoleCommand removeCommand = new RemoveRoleCommand();
			removeCommand.createCommand(command);
			roleService.removeRole(removeCommand);
		}
		
		return true;
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
	@RequestMapping("perm_node_child_list")
	@ResponseBody
	public Map<String,AceTreeNode> findChildNodeList(HttpServletRequest request,
			@RequestParam("parentId") Integer parentId,
			@RequestParam("roleId") Integer roleId,
			Model model){
	
		Map<String,AceTreeNode> treeMap = permService.findPermChildNodeListByParentId(parentId, roleId);

		return treeMap;
	}
	
	@RequestMapping("set_perm")
	@ResponseBody
	public String updateRolePerm(HttpServletRequest request,
			@RequestParam("roleId") Integer roleId,
			@RequestParam("permIds") List<Integer> permIdList){
		
		if(roleService.updateRolePerm(roleId, permIdList)){
			return "success";
		}
		
		return "error";
	}
	
}
