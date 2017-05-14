package com.rising.cc.pojo.command.project;

import java.io.Serializable;

/**
 * 
 * @description 编辑工程Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class EditEngineeringCommand implements Serializable{
	
	private String id;

	private Integer projectId;
	
	private String engineeringName;
	
	private String engineeringCode;
	
	private String personLiable;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPersonLiable() {
		return personLiable;
	}

	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
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

}
