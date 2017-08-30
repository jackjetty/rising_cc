package com.bhyf.pojo.command.role;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

/**
 * 
 * @description 修改角色Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class UpdateRoleCommand implements Serializable{
	
	private Integer roleId;
	
	private String roleName;
	
	private Integer status;
	
	private Integer isBuilt;

	
	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsBuilt() {
		return isBuilt;
	}

	public void setIsBuilt(Integer isBuilt) {
		this.isBuilt = isBuilt;
	}


	public void createCommand(EditRoleCommand command){
		BeanUtils.copyProperties(command, this);
		this.roleId = Integer.valueOf(command.getId());
	}
	
}
