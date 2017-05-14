package com.rising.cc.model.api;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.api.SetAccountApiInfoCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountInfoCommand;

/**
 * 
 * @description 角色权限关系Model
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:13:05
 *
 */
@SuppressWarnings("serial")
public class ApiAccountInfo extends BaseModel{

	private Integer accountId;
	
	private ApiAccount account;
	
	private Integer apiId;
	
	private ApiInfo apiInfo;

	private Integer unitTime;
	
	private Integer callNumber;
	
	private Integer timeOut;
	
	public Integer getUnitTime() {
		return unitTime;
	}

	public void setUnitTime(Integer unitTime) {
		this.unitTime = unitTime;
	}

	public Integer getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(Integer callNumber) {
		this.callNumber = callNumber;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getApiId() {
		return apiId;
	}

	public void setApiId(Integer apiId) {
		this.apiId = apiId;
	}

	public ApiAccount getAccount() {
		return account;
	}

	public void setAccount(ApiAccount account) {
		this.account = account;
	}

	public ApiInfo getApiInfo() {
		return apiInfo;
	}

	public void setApiInfo(ApiInfo apiInfo) {
		this.apiInfo = apiInfo;
	}

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}

	public void createAccountApiInfo(SetAccountApiInfoCommand command, Integer apiId){
		super.setCreateTime(command.getCreateTime());
		super.setCreateUser(command.getCreateUser());
		this.accountId = command.getAccountId();
		this.apiId = apiId;
	}
	
	public void updateUnitTimeCallNumber(UpdateApiAccountInfoCommand command){
		super.setId(command.getId());
		this.unitTime = command.getUnitTime();
		this.callNumber = command.getCallNumber();
		this.timeOut = command.getTimeOut();
	}
	
}
