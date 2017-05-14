package com.rising.cc.pojo.command.basicdata.database;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EditDataBaseCommand implements Serializable{
	
	private String id;

	/** 数据库名称 */
	private String name;
	/** 数据库说明*/
	private String description;
	/** 数据库用户*/
	private String userName;
	/** 数据库密码*/
	private String password;
	/** 数据库端口*/
	private String port;
	/** 数据库类型 0:本地开发库，1：本地测试库，2：预发布库，3：生产库 */
	private Integer type;
	/** 数据库驱动 */
	private String drive;
	/** 数据库地址*/
	private String url;
	/** 状态 0:禁用;1:启用;80:删除 */
	private Integer status;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
	
	public String getPort() {
		return port;
	}
	
	public void setPort(String port) {
		this.port = port;
	}
	
	public Integer getType() {
		return type;
	}
	
	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getDrive() {
		return drive;
	}
	
	public void setDrive(String drive) {
		this.drive = drive;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
