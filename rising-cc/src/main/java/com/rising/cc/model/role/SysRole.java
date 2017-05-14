package com.rising.cc.model.role;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.role.CreateRoleCommand;
import com.rising.cc.pojo.command.role.UpdateRoleCommand;

/**
 * 
 * @description 系统角色
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午1:49:51
 *
 */
@SuppressWarnings("serial")
public class SysRole extends BaseModel{
	
	private String roleName;
	
	private Integer status;
	
	private Integer isBuilt;

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
	
	public void createRole(CreateRoleCommand command){
		if(command != null){
			super.setCreateTime(command.getCreateTime());
			super.setCreateUser(command.getCreateUser());
			this.roleName = command.getRoleName();
			this.status = command.getStatus();
			this.isBuilt = 1;
		}
	}
	
	public void updateRole(UpdateRoleCommand command){
		if(command != null){
			super.setId(command.getRoleId());
			this.roleName = command.getRoleName();
			this.status = command.getStatus();
			this.isBuilt = 1;
		}
	}
	
}
