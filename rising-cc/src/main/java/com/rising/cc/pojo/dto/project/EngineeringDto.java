package com.rising.cc.pojo.dto.project;

import com.rising.cc.common.component.BaseDto;

/**
 * 
 * @description 工程Model
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:09:39
 *
 */
@SuppressWarnings("serial")
public class EngineeringDto extends BaseDto{
	
	private ProjectDto projectDto;

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

	public ProjectDto getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectDto projectDto) {
		this.projectDto = projectDto;
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

	
}
