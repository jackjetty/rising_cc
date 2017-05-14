package com.rising.cc.pojo.command.api;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UpdateApiAccountInfoCommand implements Serializable{

	private Integer id;
	
	private Integer unitTime;
	
	private Integer callNumber;

	private Integer timeOut;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Integer timeOut) {
		this.timeOut = timeOut;
	}
	
	
}
