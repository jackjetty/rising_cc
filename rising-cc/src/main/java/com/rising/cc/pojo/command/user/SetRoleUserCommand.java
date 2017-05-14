package com.rising.cc.pojo.command.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.rising.common.util.SysDateUtils;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.constants.user.LoginConstants;

@SuppressWarnings("serial")
public class SetRoleUserCommand implements Serializable{
	
	private Integer userId;
	
	private List<Integer> roleIds;
	
	private Date createTime;
	
	private String createUser;
	
	public SetRoleUserCommand() {
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		
		this.createUser = sysUser.getUserName();
		this.createTime = SysDateUtils.getCurrentDate();
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Integer> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<Integer> roleIds) {
		this.roleIds = roleIds;
	}

}
