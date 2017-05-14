package com.rising.common.api.base;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RequestBody implements Serializable{

	/**
	 * 请求业务内容
	 */
	private String businessParam;
	
	public RequestBody() {
		// TODO Auto-generated constructor stub
	}

	public RequestBody(String businessParam) {
		super();
		this.businessParam = businessParam;
	}

	public String getBusinessParam() {
		return businessParam;
	}

	public void setBusinessParam(String businessParam) {
		this.businessParam = businessParam;
	}

}
