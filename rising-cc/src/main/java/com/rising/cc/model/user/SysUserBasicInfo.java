package com.rising.cc.model.user;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.user.CreateUserCommand;
import com.rising.cc.pojo.command.user.UpdateUserCommand;

/**
 * 
 * @description 用户基础信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午1:46:01
 *
 */
@SuppressWarnings("serial")
public class SysUserBasicInfo extends BaseModel{
	
	/***
	 * 账号信息
	 * */
	private SysUser sysUser;
	
	/***
	 * 真是姓名
	 * */
	private String realName;
	
	/***
	 * 邮箱
	 * */
	private String email;
	
	/***
	 * 手机号码
	 * */
	private String telphone;

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}
	
	public void createUserBasicInfo(CreateUserCommand command, SysUser user){
		if(command != null){
			this.realName = command.getRealName();
			this.email = command.getEmail();
			this.telphone = command.getTelphone();
			this.sysUser = user;
			super.setCreateTime(command.getCreateTime());
			super.setCreateUser(command.getCreateUser());
		}
	}
	
	public void updateUserBasicInfo(UpdateUserCommand command, SysUser user){
		if(command != null){
			this.sysUser = user;
			this.realName = command.getRealName();
			this.email = command.getEmail();
			this.telphone = command.getTelphone();
			//this.sysUser = user;
		}
	}
}
