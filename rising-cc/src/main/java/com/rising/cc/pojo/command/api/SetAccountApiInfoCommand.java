package com.rising.cc.pojo.command.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.rising.common.util.SysDateUtils;
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.constants.user.LoginConstants;

@SuppressWarnings("serial")
public class SetAccountApiInfoCommand implements Serializable{
	
	private List<Integer> addIds;
	
	private List<Integer> delIds;
	
	private Integer accountId;
	
	private Date createTime;
	
	private String createUser;

	public SetAccountApiInfoCommand() {
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

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	
}
