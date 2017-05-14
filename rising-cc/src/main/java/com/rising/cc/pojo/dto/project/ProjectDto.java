package com.rising.cc.pojo.dto.project;

import com.rising.cc.common.component.BaseDto;

/**
 * 
 * @description 项目Dto
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:09:48
 *
 */
@SuppressWarnings("serial")
public class ProjectDto extends BaseDto{
	
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
	
	
}
