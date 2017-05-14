package com.rising.cc.controller.user;

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
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.command.user.CreateUserCommand;
import com.rising.cc.pojo.command.user.EditUserCommand;
import com.rising.cc.pojo.command.user.RemoveUserCommand;
import com.rising.cc.pojo.command.user.ResetUserPwdCommand;
import com.rising.cc.pojo.command.user.SetRoleUserCommand;
import com.rising.cc.pojo.command.user.SetUserEnvirCommand;
import com.rising.cc.pojo.command.user.UpdateUserCommand;
import com.rising.cc.pojo.command.user.UpdateUserPwdCommand;
import com.rising.cc.pojo.constants.role.RoleConstants;
import com.rising.cc.pojo.dto.envir.EnvirTypeDto;
import com.rising.cc.pojo.dto.role.SysRoleDto;
import com.rising.cc.pojo.dto.user.SysUserBasicInfoDto;
import com.rising.cc.pojo.qo.role.RoleQo;
import com.rising.cc.pojo.qo.user.UserQo;
import com.rising.cc.service.interf.envir.EnvirTypeService;
import com.rising.cc.service.interf.role.RoleService;
import com.rising.cc.service.interf.user.UserService;

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
	
	@Resource
	private EnvirTypeService envirTypeService;
	
	@RequestMapping("to_update")
	public String toUpdateSysUserBasicInfo(Model model){
		
		SysUser user = this.getCurrentUser();
		if(user != null){
			UserQo qo = new UserQo();
			qo.setId(user.getId());
			qo.setUserName(user.getUserName());
			
			SysUserBasicInfoDto dto = userService.findSysUserBasicInfoByUserQo(qo);
			
			model.addAttribute("dto", dto);
		}
		model.addAttribute("oper", "edit");
		
		return "user/update_user_basic_info.html";
	}
	
	@RequestMapping("to_update_pwd")
	public String toUpdatePwd(Model model){
		
		return "user/update_user_pwd.html";
	}
	
	@RequestMapping("update_user_basic_info")
	@ResponseBody
	public String updateSysUserBasicInfo(@ModelAttribute UpdateUserCommand command,Model model){
		
		SysUser user = this.getCurrentUser();
		boolean bool = false;
		if(user != null){
			command.setUserId(user.getId());
			bool = userService.updateUser(command);
		}
		
		if(bool){
			return "success";
		}
		
		return "error";
	}
	
	@RequestMapping("update_pwd")
	@ResponseBody
	public String updateUserPwd(@ModelAttribute UpdateUserPwdCommand command,Model model){
		
		try {
			SysUser user = this.getCurrentUser();
			if(user != null){
				command.setUserId(user.getId());
				if(!userService.updateUserPwd(command)){
					return "old_pwd_error";
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
	public String saveUserInfo(HttpServletRequest request,
			@ModelAttribute EditUserCommand command,Model model,
			@RequestParam String oper){
		
		if(oper.equals("add")){
			CreateUserCommand addCommand = new CreateUserCommand();
			addCommand.createCommand(command);
			if(!userService.saveUser(addCommand)){
				return "username_existing";
			}
		}else if(oper.equals("edit")){
			UpdateUserCommand updateCommand = new UpdateUserCommand();
			updateCommand.createCommand(command);
			if(!userService.updateUser(updateCommand)){
				return "username_existing";
			}
		}else if(oper.equals("del")){
			RemoveUserCommand removeCommand = new RemoveUserCommand();
			removeCommand.createCommand(command);
			userService.removeUser(removeCommand);
		}
		
		return "true";
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

		return "/user/user_list.html";
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
	public Pagination findUserList(HttpServletRequest request,
			@RequestParam(value="page",required=true) Integer pageNo,
			@RequestParam(value="rows",required=true) Integer pageSize,
			@ModelAttribute UserQo qo,
			Model model){
		
		PaginQo paginQo = new PaginQo();
		paginQo.setPageNo(pageNo);
		paginQo.setPageSize(pageSize);
		
		Pagination pagination = this.createPagination(paginQo, qo);
		
		
		pagination = userService.findUserInfoListByPagination(pagination);
		
		return pagination;
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
	
	@RequestMapping("to_set_user_envir")
	public String toSetUserEnvir(HttpServletRequest request,
			@RequestParam(value="userId",required=true) Integer userId,
			Model model){
		
		List<EnvirTypeDto> envirTypeList = envirTypeService.findEnvirTypeListAll();
		List<EnvirTypeDto> dtoList = envirTypeService.findEnvirTypeListByUserId(userId);
		
		
		model.addAttribute("dtoList", dtoList);
		model.addAttribute("envirTypeList", envirTypeList);
		model.addAttribute("userId", userId);
		return "user/update_user_envir.html";
	}
	
	@RequestMapping("set_user_envir")
	@ResponseBody
	public String updateAccountApiInfo(@ModelAttribute SetUserEnvirCommand command){
		
		try {
			userService.setUserEnvir(command);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
		
		return "success";
	}
	
}
