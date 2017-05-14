package com.rising.common.api.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * api请求基类
 * 
 */
@SuppressWarnings("serial")
public class ApiRequest implements Serializable {

	/**
	 * 请求头信息
	 */
	private RequestHead head;

	/**
	 * 请求主体信息
	 */
	private RequestBody body;

	public ApiRequest() {
		super();
	}

	/**
	 * 
	 * @类名：ApiRequest.java
	 * @描述：TODO
	 * @param seqNo
	 * @param userName
	 * @param passWord
	 * @param apiName
	 * @param sendLogo
	 * @param sendIp
	 * @param receiveLogo
	 * @param sendTime
	 * @param businessParam
	 */
	public ApiRequest(String seqNo, String userName, String passWord, String apiName, 
			Integer sendLogo, String sendIp, String receiveLogo, String sendTime, ApiBusinessParam businessParam) {
		this.head = new RequestHead();
		this.body = new RequestBody();
		head.setSeqNo(seqNo);
		head.setUserName(userName);
		head.setPassWord(passWord);
		head.setApiName(apiName);
		head.setSendLogo(sendLogo);
		head.setSendIp(sendIp);
		head.setReceiveLogo(receiveLogo);
		head.setSendTime(sendTime);
		body.setBusinessParam(JSON.toJSONString(businessParam));
	}
	
	/**
	 * 需要重写
	 * @return
	 */
	public Class<?> getResponseClazz() {
		return null;
	}
	
	public RequestHead getHead() {
		return head;
	}

	public void setHead(RequestHead head) {
		this.head = head;
	}

	public RequestBody getBody() {
		return body;
	}

	public void setBody(RequestBody body) {
		this.body = body;
	}

}
