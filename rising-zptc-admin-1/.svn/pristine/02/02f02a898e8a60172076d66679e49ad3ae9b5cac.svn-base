package com.bhyf.pojo.command.user;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

/**
 * 
 * @description 创建用户Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class UpdateUserCommand implements Serializable{
	
	/**
	 * UserID
	 */
	private Integer userId;
	
	
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
	private String telephone;
	

	/**
	 * 状态
	 */
	private Integer status;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public void createCommand(EditUserCommand command){
		BeanUtils.copyProperties(command, this);
		this.userId = Integer.valueOf(command.getId());
	}
	
}
