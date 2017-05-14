package com.rising.cc.model.basicdata;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.basicdata.dubbo.CreateDubboCommand;
import com.rising.cc.pojo.command.basicdata.dubbo.UpdateDubboCommand;

@SuppressWarnings("serial")
public class SysDubboInfo extends BaseModel{
	/** dubbo地址 */
	private String address;
	/** dubbo说明*/
	private String description;
	/** dubbo超时时间 */
	private Integer timeout;
	/** dubbo类型 0:本地开发，1：本地测试，2：预发布，3：生产 */
	private Integer type;
	/** 状态 0:禁用;1:启用;80:删除 */
	private Integer status;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	public void createSysDubboInfo(String address, String description, 
			Integer timeout, Integer type){
		this.address = address;
		this.description = description;
		this.timeout = timeout;
		this.type = type;
	}
	
	public void createDubbo(CreateDubboCommand command){
		if(command != null){
			this.address = command.getAddress();
			this.description = command.getDescription();
			this.timeout = command.getTimeout();
			this.type = command.getType();
			this.status = command.getStatus();
		}
	}
	
	public void updateDubbo(UpdateDubboCommand command){
		if(command != null){
			super.setId(command.getDubboId());
			this.address = command.getAddress();
			this.description = command.getDescription();
			this.timeout = command.getTimeout();
			this.type = command.getType();
			this.status = command.getStatus();
		}
	}
			
}
