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
public class UpdateApiAccountCommand implements Serializable{
	
	private Integer envirId;
	
	private Integer accountId;

	private String account;
	
	private String company;
	
	private String description;
	
	private String sendIp;
	
	private String secretKey;
	
	private Integer status;
	

	public Integer getEnvirId() {
		return envirId;
	}

	public void setEnvirId(Integer envirId) {
		this.envirId = envirId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSendIp() {
		return sendIp;
	}

	public void setSendIp(String sendIp) {
		this.sendIp = sendIp;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void createCommand(EditApiAccountCommand command){
		BeanUtils.copyProperties(command, this);
		this.accountId = Integer.valueOf(command.getId());
	}
	
}
