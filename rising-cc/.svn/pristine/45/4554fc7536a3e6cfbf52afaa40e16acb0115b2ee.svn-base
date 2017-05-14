package com.rising.cc.pojo.command.project;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;

import com.rising.common.util.SysDateUtils;
import com.rising.cc.model.project.Project;
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.constants.user.LoginConstants;

/**
 * 
 * @description 创建项目Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class CreateEngineeringCommand implements Serializable{
	
	private Integer projectId;
	
	private String engineeringName;
	
	private String engineeringCode;
	
	private String personLiable;
	
	private Date createTime;
	
	private String createUser;


	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getEngineeringName() {
		return engineeringName;
	}

	public void setEngineeringName(String engineeringName) {
		this.engineeringName = engineeringName;
	}

	public String getEngineeringCode() {
		return engineeringCode;
	}

	public void setEngineeringCode(String engineeringCode) {
		this.engineeringCode = engineeringCode;
	}
	
	public CreateEngineeringCommand() {
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		
		this.createUser = sysUser.getUserName();
		this.createTime = SysDateUtils.getCurrentDate();
	}
	
	public String getPersonLiable() {
		return personLiable;
	}

	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
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

	public void createCommand(EditEngineeringCommand command){
		BeanUtils.copyProperties(command, this);
	}
	
}
