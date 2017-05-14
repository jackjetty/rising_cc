package com.rising.common.model;

import java.util.Date;

/**
 * @类功能说明：封装HTTP响应对象 Response
 */
public class HttpResponse {
	/**
	 * 相应信息
	 */
	private String result;
	/**
	 * 发送时间
	 */
	private Date sendTime;
	/**
	 * 接收时间
	 */
	private Date handOverTime;
	/**
	 * 响应时间
	 */
	private Long responseTime;
	/**
	 * 相应状态 1 正常 2 警告 3 超时
	 */
	private int responseState;
	/**
	 *相应状态码 
	 */
	private int respoinsCode;

	@Override
	public String toString() {
		return "HttpResponse [result=" + result + ", sendTime=" + sendTime
				+ ", handOverTime=" + handOverTime + ", responseTime="
				+ responseTime + ", responseState=" + responseState
				+ ", respoinsCode=" + respoinsCode + "]";
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public Date getHandOverTime() {
		return handOverTime;
	}
	public void setHandOverTime(Date handOverTime) {
		this.handOverTime = handOverTime;
	}
	public Long getResponseTime() {
		return responseTime;
	}
	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}
	public int getResponseState() {
		return responseState;
	}
	public void setResponseState(int responseState) {
		this.responseState = responseState;
	}
	public int getRespoinsCode() {
		return respoinsCode;
	}
	public void setRespoinsCode(int respoinsCode) {
		this.respoinsCode = respoinsCode;
	}
}