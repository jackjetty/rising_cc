package com.rising.cc.pojo.dto.project;

import com.rising.cc.common.component.BaseDto;

/**
 * 
 * @description 工程配置类型
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:13:10
 *
 */
@SuppressWarnings("serial")
public class EnginConfigTypeDto extends BaseDto{
	
	private EngineeringDto enginDto;
	
	private Integer enginId;

	private String configName;
	
	private String fileName;
	
	private Integer status;
	

	public EngineeringDto getEnginDto() {
		return enginDto;
	}

	public void setEnginDto(EngineeringDto enginDto) {
		this.enginDto = enginDto;
	}

	public Integer getEnginId() {
		return enginId;
	}

	public void setEnginId(Integer enginId) {
		this.enginId = enginId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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


	
}
