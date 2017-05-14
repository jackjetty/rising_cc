package com.rising.cc.model.api;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.api.CreateApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiInfoCommand;

@SuppressWarnings("serial")
public class ApiInfo extends BaseModel{
	
	private Integer envirId;

	private String apiCode;
	
	private String apiName;
	
	private Integer timeOut;
	
	private String apiDesc;
	
	private Integer status;

	public Integer getEnvirId() {
		return envirId;
	}

	public void setEnvirId(Integer envirId) {
		this.envirId = envirId;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public String getApiCode() {
		return apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}

	public String getApiDesc() {
		return apiDesc;
	}

	public void setApiDesc(String apiDesc) {
		this.apiDesc = apiDesc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void createApiInfo(CreateApiInfoCommand command){
		if(command != null){
			super.setCreateTime(command.getCreateTime());
			super.setCreateUser(command.getCreateUser());
			this.envirId = command.getEnvirId();
			this.apiCode = command.getApiCode();
			this.apiName = command.getApiName();
			this.timeOut = command.getTimeOut();
			this.apiDesc = command.getApiDesc();
			this.status = command.getStatus();
		}
	}
	
	public void updateApiInfo(UpdateApiInfoCommand command){
		if(command != null){
			super.setId(command.getApiInfoId());
			this.envirId = command.getEnvirId();
			this.apiCode = command.getApiCode();
			this.apiName = command.getApiName();
			this.timeOut = command.getTimeOut();
			this.apiDesc = command.getApiDesc();
			this.status = command.getStatus();
		}
	}
}
