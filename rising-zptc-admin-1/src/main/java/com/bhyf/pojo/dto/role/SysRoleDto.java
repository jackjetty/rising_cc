package com.bhyf.pojo.dto.role;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @description 系统角色
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午1:49:51
 *
 */
@SuppressWarnings("serial")
public class SysRoleDto implements Serializable{
	
	private Integer id;
	
	private String roleName;
	
	private Integer status;
	
	private Integer isBuilt;

	private Date createTime;
	
	private String createUser;
	
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	
}
