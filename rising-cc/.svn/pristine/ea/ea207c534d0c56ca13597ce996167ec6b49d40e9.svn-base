package com.rising.cc.pojo.command.api;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

/**
 * 
 * @description 修改Api信息 Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class UpdateApiInfoCommand implements Serializable{
	
	private Integer envirId;
	
	private Integer apiInfoId;

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

	public Integer getApiInfoId() {
		return apiInfoId;
	}

	public void setApiInfoId(Integer apiInfoId) {
		this.apiInfoId = apiInfoId;
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

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void createCommand(EditApiInfoCommand command){
		BeanUtils.copyProperties(command, this);
		this.apiInfoId = Integer.valueOf(command.getId());
	}
	
}
