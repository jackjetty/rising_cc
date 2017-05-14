package com.rising.cc.pojo.qo.api;

import com.rising.cc.common.component.BaseQo;

@SuppressWarnings("serial")
public class ApiAccountInfoQo extends BaseQo{
	
	private Integer accountId;

	private Integer accStatus;
	
	private Integer apiStatus;
	
	private String apiCode;
	
	private Integer envirId;
	
	
	public Integer getEnvirId() {
		return envirId;
	}

	public void setEnvirId(Integer envirId) {
		this.envirId = envirId;
	}

	public String getApiCode() {
		return apiCode;
	}

	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}

	public Integer getAccStatus() {
		return accStatus;
	}

	public void setAccStatus(Integer accStatus) {
		this.accStatus = accStatus;
	}

	public Integer getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(Integer apiStatus) {
		this.apiStatus = apiStatus;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	
	
	
}
