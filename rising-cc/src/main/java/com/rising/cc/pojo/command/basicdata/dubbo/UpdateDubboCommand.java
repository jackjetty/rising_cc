package com.rising.cc.pojo.command.basicdata.dubbo;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

@SuppressWarnings("serial")
public class UpdateDubboCommand implements Serializable{

	private Integer dubboId;
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

	public Integer getDubboId() {
		return dubboId;
	}

	public void setDubboId(Integer dubboId) {
		this.dubboId = dubboId;
	}

	public void createCommand(EditDubboCommand command) {
		BeanUtils.copyProperties(command, this);
		this.dubboId = Integer.valueOf(command.getId());
	}

}
