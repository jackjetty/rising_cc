package com.rising.cc.model.api;

import com.rising.common.util.UUIDGenerator;
import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.api.CreateApiAccountCommand;
import com.rising.cc.pojo.command.api.RefreshSecretKeyAccountCommand;
import com.rising.cc.pojo.command.api.UpdateApiAccountCommand;

@SuppressWarnings("serial")
public class ApiAccount extends BaseModel{
	
	private Integer envirId;
	
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

	public void createApiAccount(CreateApiAccountCommand command){
		if(command != null){
			super.setCreateTime(command.getCreateTime());
			super.setCreateUser(command.getCreateUser());
			this.envirId = command.getEnvirId();
			this.account = command.getAccount();
			this.company = command.getCompany();
			this.description = command.getDescription();
			this.secretKey = UUIDGenerator.getUUID();
			this.sendIp = command.getSendIp();
			this.status = command.getStatus();
		}
	}
	
	public void updateApiAccount(UpdateApiAccountCommand command){
		if(command != null){
			super.setId(command.getAccountId());
			this.envirId = command.getEnvirId();
			this.account = command.getAccount();
			this.company = command.getCompany();
			this.description = command.getDescription();
			this.sendIp = command.getSendIp();
			this.status = command.getStatus();
		}
	}
	
	public void refreshSecretKey(RefreshSecretKeyAccountCommand command){
		super.setId(command.getAccountId());
		this.secretKey = UUIDGenerator.getUUID();
	}
	
}
