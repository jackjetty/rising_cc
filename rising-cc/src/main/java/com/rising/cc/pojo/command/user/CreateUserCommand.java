package com.rising.cc.pojo.command.user;

import java.io.Serializable;
import java.util.Date;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;

import com.rising.common.util.SysDateUtils;
import com.rising.cc.model.user.SysUser;
import com.rising.cc.pojo.constants.user.LoginConstants;

/**
 * 
 * @description 创建用户Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class CreateUserCommand implements Serializable{
	
	/***
	 * 账号信息
	 * */
	private String userName;
	
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
	
	/***
	 * 备注
	 * */
	private String note;
	
	/**
	 * 状态
	 */
	private Integer status;
	
	private Date createTime;
	
	private String createUser;
	
	public CreateUserCommand() {
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		
		this.createUser = sysUser.getUserName();
		this.createTime = SysDateUtils.getCurrentDate();
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public void createCommand(EditUserCommand command){
		BeanUtils.copyProperties(command, this);
	}
	
}
