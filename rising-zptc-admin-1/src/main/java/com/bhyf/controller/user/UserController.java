package com.bhyf.controller.user;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bhyf.pojo.response.DataGridResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bhyf.common.component.BaseController;
import com.bhyf.common.component.PaginQo;
import com.rising.common.page.Pagination;
import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.command.user.CreateUserCommand;
import com.bhyf.pojo.command.user.EditUserCommand;
import com.bhyf.pojo.command.user.RemoveUserCommand;
import com.bhyf.pojo.command.user.ResetUserPwdCommand;
import com.bhyf.pojo.command.user.SetRoleUserCommand;
import com.bhyf.pojo.command.user.UpdateUserCommand;
import com.bhyf.pojo.command.user.UpdateUserPwdCommand;
import com.bhyf.pojo.constants.role.RoleConstants;
import com.bhyf.pojo.dto.role.SysRoleDto;
import com.bhyf.pojo.dto.user.SysUserBasicInfoDto;
import com.bhyf.pojo.qo.role.RoleQo;
import com.bhyf.pojo.qo.user.UserQo;
import com.bhyf.service.interf.role.RoleService;
import com.bhyf.service.interf.user.UserService;

/**
 * 
 * @description 用户管理控制器
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:45:44
 *
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Resource
	private UserService userService;
	
	@Resource
	private RoleService roleService;
	



	@RequestMapping("update_pwd")
	@ResponseBody
	public String updateUserPwd(@ModelAttribute UpdateUserPwdCommand command,Model model){
		
		try {
			SysUser user = this.getCurrentUser();
			if(user != null){
				command.setUserId(user.getId());
				if(!userService.updateUserPwd(command)){
					return "原密码错误";
				}
				return "success";
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";
	}
	
	@RequestMapping("reset_pwd")
	@ResponseBody
	public String resetUserPwd(@ModelAttribute ResetUserPwdCommand command,Model model){
		
		try {
			if(userService.resetUserPwd(command)){
				return "success";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "error";
	}
	
	
	/**
	 * 
	 * @description 保存用户相关信息
	 * @author caoy
	 * @date 2015年8月12日 上午9:55:51
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("save_userinfo")
	@ResponseBody
	public Integer saveUserInfo(HttpServletRequest request,
			@ModelAttribute CreateUserCommand command,Model model){
		
			return userService.saveUser(command);
//		}else if(oper.equals("edit")){
//			UpdateUserCommand updateCommand = new UpdateUserCommand();
//			updateCommand.createCommand(command);
//			if(!userService.updateUser(updateCommand)){
//				return "username_existing";
//			}
//		}else if(oper.equals("del")){
//			RemoveUserCommand removeCommand = new RemoveUserCommand();
//			removeCommand.createCommand(command);
//			userService.removeUser(removeCommand);
//		}
	}
	/**
	 *
	 * @description 修改用户相关信息
	 * @author caoy
	 * @date 2015年8月12日 上午9:55:51
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("update_userinfo")
	@ResponseBody
	public boolean updateUserInfo(HttpServletRequest request,
			@ModelAttribute UpdateUserCommand command,Model model){

			return userService.updateUser(command);
	}
	/**
	 *
	 * @description 修改用户相关信息
	 * @author caoy
	 * @date 2015年8月12日 上午9:55:51
	 * @param request
	 * @param command
	 * @param model
	 * @return
	 */
	@RequestMapping("remove_user")
	@ResponseBody
	public boolean removeUserInfo(HttpServletRequest request,
			@ModelAttribute RemoveUserCommand command,Model model){

			return userService.removeUser(command);
	}

	
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
	@RequestMapping("to_user_list")
	public String toUserList(HttpServletRequest request,
			Model model){
		RoleQo qo = new RoleQo();
		qo.setStatus(RoleConstants.ROLE_ENABLE);
		
		List<SysRoleDto> roleList = roleService.findRoleListByQo(qo);
		
		model.addAttribute("roleList", roleList);

		return "/user/user.html";
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
	@RequestMapping("user_list")
	@ResponseBody
	public DataGridResponse findUserList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute UserQo qo,
			Model model){
		
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);


		pagination = userService.findUserInfoListByPagination(pagination);
		return new DataGridResponse(pagination);
	}
	
	
	@RequestMapping("find_user_role")
	@ResponseBody
	public List<SysRoleDto> findUserRole(HttpServletRequest request,
			@RequestParam(value="userId",required=true) Integer userId,
			Model model){
		
		List<SysRoleDto> roleList = roleService.findUserRoleListByUserId(userId);
		 
		return roleList;
	}
	
	@RequestMapping("set_role")
	@ResponseBody
	public String updateRolePerm(HttpServletRequest request,
			@ModelAttribute SetRoleUserCommand command){
		
		if(userService.setRoleUser(command)){
			return "success";
		}
		
		return "error";
	}
	
}
