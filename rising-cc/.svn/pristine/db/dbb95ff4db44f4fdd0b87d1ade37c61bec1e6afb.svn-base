package com.rising.cc.model.user;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.user.CreateUserCommand;
import com.rising.cc.pojo.command.user.ResetUserPwdCommand;
import com.rising.cc.pojo.command.user.UpdateUserCommand;
import com.rising.cc.pojo.command.user.UpdateUserPwdCommand;
import com.rising.cc.pojo.constants.user.LoginConstants;

/**
 * 
 * @description 用户账号信息
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午1:43:19
 *
 */
@SuppressWarnings("serial")
public class SysUser extends BaseModel {
	
	private String userName; // 登陆名
	
	private String userPwd; // 密码
	
	private Integer status; // 状态：0：禁用；1：启用；80：删除；
	
	private Integer isBuilt; // 是否内置：0：外置；1：内置；
	
	private String note; //备注
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPwd() {
		return userPwd;
	}
	
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getIsBuilt() {
		return isBuilt;
	}
	
	public void setIsBuilt(Integer isBuilt) {
		this.isBuilt = isBuilt;
		
	}
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	public void createUser(CreateUserCommand command){
		if(command != null){
			this.userName = command.getUserName();
			this.userPwd = LoginConstants.INITIAL_PASSWORD_MD5;
			this.status = command.getStatus();
			this.note = command.getNote();
			this.isBuilt = 1;
		}
		
	}
	
	public void updateUser(UpdateUserCommand command){
		if(command != null){
			super.setId(command.getUserId());
			this.userName = command.getUserName();
			//this.userPwd = Md5Util.MD5("123456");
			this.status = command.getStatus();
			this.note = command.getNote();
			//this.isBuilt = 1;
		}
		
	}
	
	public void updateUserPwd(UpdateUserPwdCommand command){
		if(command != null){
			super.setId(command.getUserId());
			this.userPwd = command.getNewPwd();
		}
		
	}
	

	public void resetUserPwd(ResetUserPwdCommand command, Integer userId){
		if(command != null){
			super.setId(userId);
			this.userPwd = command.getInitialPwd();
		}
		
	}
	
}
