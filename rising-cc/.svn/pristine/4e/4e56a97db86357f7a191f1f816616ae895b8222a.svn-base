package com.rising.cc.model.basicdata;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.basicdata.database.CreateDataBaseCommand;
import com.rising.cc.pojo.command.basicdata.database.UpdateDataBaseCommand;

/**
 * 项目名称：bhyf-cc  
 * 类名称：SysDataBaseInfo  
 * 类描述：  系统关系数据库类
 * 创建人：dingzl  
 * 创建时间：2015年9月10日 下午1:41:05  
 * 修改人：dingzl 
 * 修改时间：2015年9月10日 下午1:41:05  
 * 修改备注：  
 * @version：v1.0.0
 */
@SuppressWarnings("serial")
public class SysDataBaseInfo extends BaseModel{
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

	public void createSysDataBaseInfo(String name,String description, String userName,
			String password, String port, Integer type, String drive, String url){
		this.name = name;
		this.description = description;
		this.userName = userName;
		this.password = password;
		this.port = port;
		this.type = type;
		this.drive = drive;
		this.url = url;
	}
	
	public void createDataBase(CreateDataBaseCommand command){
		if(command != null){
			this.name = command.getName();
			this.description = command.getDescription();
			this.userName = command.getUserName();
			this.password = command.getPassword();
			this.port = command.getPort();
			this.type = command.getType();
			this.drive = command.getDrive();
			this.url = command.getUrl();
			this.status = command.getStatus();
		}
		
	}
	
	public void updateDataBase(UpdateDataBaseCommand command){
		if(command != null){
			super.setId(command.getDataBaseId());
			this.name = command.getName();
			this.description = command.getDescription();
			this.userName = command.getUserName();
			this.password = command.getPassword();
			this.port = command.getPort();
			this.type = command.getType();
			this.drive = command.getDrive();
			this.url = command.getUrl();
			this.status = command.getStatus();
		}
		
	}
	
}
