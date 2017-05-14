package com.rising.cc.pojo.command.project;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;

import com.rising.common.util.SysDateUtils;
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.constants.user.LoginConstants;

/**
 * 
 * @description 创建用户Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class CreateEnginConfigTypeCommand implements Serializable{
	
	private String configName;
	
	private String fileName;
	
	private Integer status;
	
	private Date createTime;
	
	private String createUser;
	
	private Integer enginId;
	
	
	public String getFileName() {
		return fileName;
	}


	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CreateEnginConfigTypeCommand() {
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		
		this.createUser = sysUser.getUserName();
		this.createTime = SysDateUtils.getCurrentDate();
	}
	
	
	public String getConfigName() {
		return configName;
	}


	public void setConfigName(String configName) {
		this.configName = configName;
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
	
	public Integer getEnginId() {
		return enginId;
	}

	public void setEnginId(Integer enginId) {
		this.enginId = enginId;
	}

	public void createCommand(EditEnginConfigTypeCommand command){
		BeanUtils.copyProperties(command, this);
	}
	
}
