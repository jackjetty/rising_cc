package com.bhyf.pojo.command.role;

import java.io.Serializable;
import java.util.Date;

import com.rising.common.util.SysDateUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;

import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.constants.user.LoginConstants;

/**
 * 
 * @description 创建角色Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class CreateRoleCommand implements Serializable{
	
	private String roleName;
	
	private Integer status;
	
	private Date createTime;
	
	private String createUser;

	public CreateRoleCommand() {
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		this.status = 1;
		this.createUser = sysUser.getUserName();
		this.createTime = SysDateUtils.getCurrentDate();
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



	public void createCommand(EditRoleCommand command){
		BeanUtils.copyProperties(command, this);
	}
	
}
