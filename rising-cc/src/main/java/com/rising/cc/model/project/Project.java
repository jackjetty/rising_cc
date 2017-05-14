package com.rising.cc.model.project;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.project.CreateProjectCommand;
import com.rising.cc.pojo.command.project.UpdateProjectCommand;

/**
 * 
 * @description 项目Model
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:09:48
 *
 */
@SuppressWarnings("serial")
public class Project extends BaseModel{
	
	private String projectName;
	
	private String projectCode;
	
	private String personLiable;
	
	private Integer status;

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

	public void createProject(CreateProjectCommand command){
		if(command != null){
			super.setCreateTime(command.getCreateTime());
			super.setCreateUser(command.getCreateUser());
			this.projectName = command.getProjectName();
			this.projectCode = command.getProjectCode();
			this.personLiable = command.getPersonLiable();
			this.status = command.getStatus();
		}
	}
	
	public void updateProject(UpdateProjectCommand command){
		if(command != null){
			super.setId(command.getProjectId());
			this.projectName = command.getProjectName();
			this.projectCode = command.getProjectCode();
			this.personLiable = command.getPersonLiable();
			this.status = command.getStatus();
		}
	}
	
}
