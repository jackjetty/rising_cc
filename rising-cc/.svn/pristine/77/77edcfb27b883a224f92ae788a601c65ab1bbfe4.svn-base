package com.rising.cc.pojo.command.project;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.rising.cc.model.project.Project;

/**
 * 
 * @description 修改工程配置类型Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class UpdateEngineeringCommand implements Serializable{
	
	private Integer enginId;

	private Integer projectId;
	
	private String engineeringName;
	
	private String engineeringCode;
	
	private String personLiable;
	

	public Integer getEnginId() {
		return enginId;
	}

	public void setEnginId(Integer enginId) {
		this.enginId = enginId;
	}

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

	public String getPersonLiable() {
		return personLiable;
	}

	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}


	public void createCommand(EditEngineeringCommand command){
		BeanUtils.copyProperties(command, this);
		this.enginId = Integer.valueOf(command.getId());
	}
	
}
