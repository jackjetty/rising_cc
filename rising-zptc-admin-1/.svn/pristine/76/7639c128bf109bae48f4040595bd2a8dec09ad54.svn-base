package com.bhyf.pojo.command.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.rising.common.util.SysDateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.constants.user.LoginConstants;

@SuppressWarnings("serial")
public class SetUserEnvirCommand implements Serializable{
	
	private List<Integer> addIds;
	
	private List<Integer> delIds;
	
	private Integer userId;
	
	private Date createTime;
	
	private String createUser;

	public SetUserEnvirCommand() {
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

	public List<Integer> getAddIds() {
		return addIds;
	}

	public void setAddIds(List<Integer> addIds) {
		this.addIds = addIds;
	}

	public List<Integer> getDelIds() {
		return delIds;
	}

	public void setDelIds(List<Integer> delIds) {
		this.delIds = delIds;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
}
