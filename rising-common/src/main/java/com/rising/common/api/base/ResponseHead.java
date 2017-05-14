package com.rising.common.api.base;

import java.util.Date;

/**
 * 响应头
 * 
 */
public class ResponseHead {

	/**
	 * 响应时间
	 */
	private Date responseDate;

	/**
	 * 服务端处理时间，毫秒
	 */
	private Integer handleTimes;

	/**
	 * 会话id
	 */
	private String sessionId;
	
	public ResponseHead() {
		// TODO Auto-generated constructor stub
	}
	
	

	public ResponseHead(Date responseDate, Integer handleTimes, String sessionId) {
		super();
		this.responseDate = responseDate;
		this.handleTimes = handleTimes;
		this.sessionId = sessionId;
	}



	public Date getResponseDate() { 
		return responseDate;
	}

	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	public Integer getHandleTimes() {
		return handleTimes;
	}

	public void setHandleTimes(Integer handleTimes) {
		this.handleTimes = handleTimes;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

}
