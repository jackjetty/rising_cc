package com.rising.cc.model.basicdata;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.basicdata.rabbitmq.CreateRabbitMqCommand;
import com.rising.cc.pojo.command.basicdata.rabbitmq.UpdateRabbitMqCommand;

@SuppressWarnings("serial")
public class SysRabbitMqInfo extends BaseModel{
	/** rabbitMq地址 */
	private String url;
	/** rabbitMq端口*/
	private String port;
	/** rabbitMq用户名*/
	private String userName;
	/** rabbitMq密码*/
	private String password;
	/** rabbitMq说明*/
	private String description;
	/** rabbitMq超时时间 */
	private Integer timeout;
	/** rabbitMq类型 0:本地开发，1：本地测试，2：预发布，3：生产 */
	private Integer type;
	/** 状态 0:禁用;1:启用;80:删除 */
	private Integer status;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	
	public void createSysRabbitMqInfo(String url, String port, String userName, String password,
			String description, Integer type, Integer timeout){
		this.url =url;
		this.port = port;
		this.userName = userName;
		this.password = password;
		this.description = description;
		this.type = type;
		this.timeout = timeout;
	}
	
	public void createRabbitMq(CreateRabbitMqCommand command){
		if(command != null){
			this.url = command.getUrl();
			this.port = command.getPort();
			this.userName = command.getUserName();
			this.password = command.getPassword();
			this.description = command.getDescription();
			this.type = command.getType();
			this.timeout = command.getTimeout();
			this.status = command.getStatus();
		}
	}
	
	public void updateRabbitMq(UpdateRabbitMqCommand command){
		if(command != null){
			this.url = command.getUrl();
			this.port = command.getPort();
			this.userName = command.getUserName();
			this.password = command.getPassword();
			this.description = command.getDescription();
			this.type = command.getType();
			this.timeout = command.getTimeout();
			this.status = command.getStatus();
		}
	}
}
