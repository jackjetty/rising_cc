package com.rising.common.api.base;

import java.io.Serializable;

/**
 * 对外api请求基础业务参数，所有封装对外api业务参数类必须继承此类
 * @author caoy
 *
 */
@SuppressWarnings("serial")
public class ApiBusinessParam implements Serializable {

	/**
	 * 客户端唯一标识
	 */
	private String seqNo;

	/**
	 * 来源标识：0 mobile , 1  pc
	 */
	private Integer sendLogo;
	
	/***
	 * 短信发送失败次数；；短信业务使用
	 **/
	private Integer failCount;

	
	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public Integer getSendLogo() {
		return sendLogo;
	}

	public void setSendLogo(Integer sendLogo) {
		this.sendLogo = sendLogo;
	}

	public Integer getFailCount() {
		return failCount;
	}

	public void setFailCount(Integer failCount) {
		this.failCount = failCount;
	}

}
