package com.rising.cc.model.basicdata;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.basicdata.mongodb.CreateMongoDbCommand;
import com.rising.cc.pojo.command.basicdata.mongodb.UpdateMongoDbCommand;

@SuppressWarnings("serial")
public class SysMongoDbInfo extends BaseModel {
	/** mongoDb名称 */
	private String name;
	/** mongoDb地址 */
	private String url;
	/** mongoDb端口*/
	private String port;
	/** mongoDb用户名*/
	private String userName;
	/** mongoDb密码*/
	private String password;
	/** mongoDb说明*/
	private String description;
	/** mongoDb超时时间 */
	private Integer timeout;
	/** mongoDb类型 0:本地开发，1：本地测试，2：预发布，3：生产 */
	private Integer type;
	/** 状态 0:禁用;1:启用;80:删除 */
	private Integer status;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
	
	
	public void createSysMongoDbInfo(String name, String url, String port, String description, String userName,
			String password, Integer type){
		this.name = name;
		this.description = description;
		this.userName = userName;
		this.password = password;
		this.port = port;
		this.type = type;
		this.url = url;
	}
	
	public void createMongoDb(CreateMongoDbCommand command){
		if(command != null){
			this.name = command.getName();
			this.description = command.getDescription();
			this.userName = command.getUserName();
			this.password = command.getPassword();
			this.port = command.getPort();
			this.type = command.getType();
			this.url = command.getUrl();
			this.status = command.getStatus();
		}
	}
	
	public void updateMongoDb(UpdateMongoDbCommand command){
		if(command != null){
			super.setId(command.getMongoDbId());
			this.name = command.getName();
			this.description = command.getDescription();
			this.userName = command.getUserName();
			this.password = command.getPassword();
			this.port = command.getPort();
			this.type = command.getType();
			this.url = command.getUrl();
			this.status = command.getStatus();
		}
	}
}
