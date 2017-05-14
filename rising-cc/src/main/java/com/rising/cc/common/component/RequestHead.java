package com.rising.cc.common.component;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RequestHead implements Serializable {

	/**
	 * 唯一序列uuid
	 */
	private String seqNo; 	 	//消息唯一序列uuid
	
	private String userName; 	//生产环境需分配--
	
	private String sign; 	//签名结果
	
	private String apiName;  	//请求的接口名称
	
	private Integer sendLogo; 	//用户来源标识 0：mobile，1：pc
	
	private String sendIp;   	//发起调用系统标识（ip）
	
	private String receiveLogo;	//接收方标识（待确认）
	
	private Long sendTime;	//发送时间格林威治毫秒数

	public RequestHead() {
		// TODO Auto-generated constructor stub
	}
	
	public RequestHead(String seqNo, String userName, String sign, String apiName, 
			Integer sendLogo, String sendIp, String receiveLogo, Long sendTime) {
		super();
		this.seqNo = seqNo;
		this.userName = userName;
		this.sign = sign;
		this.apiName = apiName;
		this.sendLogo = sendLogo;
		this.sendIp = sendIp;
		this.receiveLogo = receiveLogo;
		this.sendTime = sendTime;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getApiName() {
		return apiName;
	}

	public void setApiName(String apiName) {
		this.apiName = apiName;
	}

	public Integer getSendLogo() {
		return sendLogo;
	}

	public void setSendLogo(Integer sendLogo) {
		this.sendLogo = sendLogo;
	}

	public String getSendIp() {
		return sendIp;
	}

	public void setSendIp(String sendIp) {
		this.sendIp = sendIp;
	}

	public String getReceiveLogo() {
		return receiveLogo;
	}

	public void setReceiveLogo(String receiveLogo) {
		this.receiveLogo = receiveLogo;
	}

	public Long getSendTime() {
		return sendTime;
	}

	public void setSendTime(Long sendTime) {
		this.sendTime = sendTime;
	}
}
