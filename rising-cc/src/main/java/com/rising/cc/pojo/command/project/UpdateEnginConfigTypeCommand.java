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
public class UpdateEnginConfigTypeCommand implements Serializable{
	
	private Integer configTypeId;
	
	private String configName;
	
	private String fileName;
	
	private Integer status;
	
	private Integer enginId;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getConfigTypeId() {
		return configTypeId;
	}

	public void setConfigTypeId(Integer configTypeId) {
		this.configTypeId = configTypeId;
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

	public Integer getEnginId() {
		return enginId;
	}

	public void setEnginId(Integer enginId) {
		this.enginId = enginId;
	}

	public void createCommand(EditEnginConfigTypeCommand command){
		BeanUtils.copyProperties(command, this);
		this.configTypeId = Integer.valueOf(command.getId());
	}
	
}
