package com.rising.cc.model.user;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.user.SetRoleUserCommand;

/**
 * 
 * @description 用户角色关系Model
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午1:43:19
 *
 */
@SuppressWarnings("serial")
public class SysUserRole extends BaseModel {
	private Integer userId;
	
	private Integer roleId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	public void createSysUserRole(SetRoleUserCommand command, Integer roleId){
		super.setCreateTime(command.getCreateTime());
		super.setCreateUser(command.getCreateUser());
		this.userId = command.getUserId();
		this.roleId = roleId;
	}
	
}
