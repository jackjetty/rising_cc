package com.rising.cc.model.project;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.project.CreateEnginConfigTypeCommand;
import com.rising.cc.pojo.command.project.UpdateEnginConfigTypeCommand;

/**
 * 
 * @description 工程配置类型
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 上午10:13:10
 *
 */
@SuppressWarnings("serial")
public class EnginConfigType extends BaseModel{

	private Engineering engin;
	
	private Integer enginId;
	
	private String configName;
	
	private String fileName;
	
	private Integer status;

	
	public Integer getEnginId() {
		return enginId;
	}

	public void setEnginId(Integer enginId) {
		this.enginId = enginId;
	}

	public Engineering getEngin() {
		return engin;
	}

	public void setEngin(Engineering engin) {
		this.engin = engin;
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

	public void createEnginConfigType(CreateEnginConfigTypeCommand command){
		if(command != null){
			super.setCreateTime(command.getCreateTime());
			super.setCreateUser(command.getCreateUser());
			this.configName = command.getConfigName();
			this.status = command.getStatus();
			this.fileName = command.getFileName();
			this.enginId = command.getEnginId();
		}
	}
	
	public void updateEnginConfigType(UpdateEnginConfigTypeCommand command){
		if(command != null){
			super.setId(command.getConfigTypeId());
			this.configName = command.getConfigName();
			this.status = command.getStatus();
			this.fileName = command.getFileName();
			this.enginId = command.getEnginId();
		}
	}
	
}
