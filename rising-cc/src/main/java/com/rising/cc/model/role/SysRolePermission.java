package com.rising.cc.model.role;

import com.rising.common.component.BaseModel;
import com.rising.common.util.SysDateUtils;
import com.rising.cc.model.user.SysUser;

/**
 * 
 * @description 角色权限关系Model
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:13:05
 *
 */
@SuppressWarnings("serial")
public class SysRolePermission extends BaseModel{

	private Integer roleId;
	
	private Integer permId;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getPermId() {
		return permId;
	}

	public void setPermId(Integer permId) {
		this.permId = permId;
	}
	
	public void createSysRolePermission(Integer roleId, Integer permId, SysUser sysUser){
		super.setCreateTime(SysDateUtils.getCurrentDate());
		super.setCreateUser(sysUser.getUserName());
		this.roleId = roleId;
		this.permId = permId;
	}
	
}
