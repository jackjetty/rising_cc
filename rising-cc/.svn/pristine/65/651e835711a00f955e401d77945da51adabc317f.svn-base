package com.rising.cc.pojo.dto.api;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.rising.cc.common.component.BaseDto;
import com.rising.cc.model.api.ApiAccount;
import com.rising.cc.model.api.ApiInfo;

@SuppressWarnings("serial")
public class ApiAccountDto extends BaseDto{
	
	private Integer envirId;
	
	private String account;
	
	private String company;
	
	private String description;
	
	private String sendIp;
	
	private String secretKey;
	
	private Integer status;
	
	private String apiInfos;

	
	public Integer getEnvirId() {
		return envirId;
	}

	public void setEnvirId(Integer envirId) {
		this.envirId = envirId;
	}

	public String getApiInfos() {
		return apiInfos;
	}

	public void setApiInfos(String apiInfos) {
		this.apiInfos = apiInfos;
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

	public void createDto(ApiAccount apiAccount, List<ApiInfo> apiInfoList){
		BeanUtils.copyProperties(apiAccount, this);
		
		if(apiInfoList != null){
			String apiInfos = "";
			
			for (int i = 0; i < apiInfoList.size(); i++) {
				ApiInfo apiInfo = apiInfoList.get(i);
				apiInfos = apiInfos + apiInfo.getApiCode();
				if(i + 1 != apiInfoList.size()){
					apiInfos+="、";
				}
			}
			
			this.apiInfos = apiInfos;
			
		}
		
	}
	
}
