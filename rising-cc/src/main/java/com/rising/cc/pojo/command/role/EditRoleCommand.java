package com.rising.cc.pojo.command.role;

import java.io.Serializable;

/**
 * 
 * @description 创建用户Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class EditRoleCommand implements Serializable{
	
	private String id;
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
