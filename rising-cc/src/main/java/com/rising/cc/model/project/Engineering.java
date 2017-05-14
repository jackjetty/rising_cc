package com.rising.cc.model.project;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.project.CreateEngineeringCommand;
import com.rising.cc.pojo.command.project.UpdateEngineeringCommand;

/**
 * 
 * @description 工程Model
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:09:39
 *
 */
@SuppressWarnings("serial")
public class Engineering extends BaseModel{
	
	private Project project;
	
	private Integer projectId;
	
	private String engineeringName;
	
	private String engineeringCode;
	
	private String personLiable;

	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public String getPersonLiable() {
		return personLiable;
	}

	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}
	
	public void createEngineering(CreateEngineeringCommand command){
		if(command != null){
			super.setCreateTime(command.getCreateTime());
			super.setCreateUser(command.getCreateUser());
			this.engineeringName = command.getEngineeringName();
			this.engineeringCode = command.getEngineeringCode();
			this.personLiable = command.getPersonLiable();
			this.projectId = command.getProjectId();
		}
	}
	
	public void updateEngineering(UpdateEngineeringCommand command){
		if(command != null){
			super.setId(command.getEnginId());
			this.engineeringName = command.getEngineeringName();
			this.engineeringCode = command.getEngineeringCode();
			this.personLiable = command.getPersonLiable();
			this.projectId = command.getProjectId();
		}
	}
}
