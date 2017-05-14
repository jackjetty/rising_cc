package com.rising.cc.pojo.command.project;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

/**
 * 
 * @description 修改工程配置类型Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class UpdateProjectCommand implements Serializable{
	
	private Integer projectId;

	private String projectName;
	
	private String projectCode;
	
	private String personLiable;
	
	private Integer status;
	
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getPersonLiable() {
		return personLiable;
	}

	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void createCommand(EditProjectCommand command){
		BeanUtils.copyProperties(command, this);
		this.projectId = Integer.valueOf(command.getId());
	}
	
}
