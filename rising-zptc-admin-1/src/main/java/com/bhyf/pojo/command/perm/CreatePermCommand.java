package com.bhyf.pojo.command.perm;

import java.io.Serializable;
import java.util.Date;

import com.rising.common.util.SysDateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.constants.user.LoginConstants;

@SuppressWarnings("serial")
public class CreatePermCommand implements Serializable{
	
	private Integer parentId;
	
	private String permName;
	
	private String permUrl;
	
	private String permRel;
	
	private Integer permType;
	
	private Integer isEnable;

	private Date createTime;
	
	private String createUser;

	public CreatePermCommand() {
		
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getPermName() {
		return permName;
	}

	public void setPermName(String permName) {
		this.permName = permName;
	}

	public String getPermUrl() {
		return permUrl;
	}

	public void setPermUrl(String permUrl) {
		this.permUrl = permUrl;
	}

	public String getPermRel() {
		return permRel;
	}

	public void setPermRel(String permRel) {
		this.permRel = permRel;
	}

	public Integer getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}

	public Integer getPermType() {
		return permType;
	}

	public void setPermType(Integer permType) {
		this.permType = permType;
	}
	
	

}
