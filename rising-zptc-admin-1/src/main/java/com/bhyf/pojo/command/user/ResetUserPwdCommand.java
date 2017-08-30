package com.bhyf.pojo.command.user;

import java.io.Serializable;
import java.util.List;

import com.bhyf.pojo.constants.user.LoginConstants;

/**
 * 
 * @description 重置用户密码Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class ResetUserPwdCommand implements Serializable{
	
	private Integer id;
	
	private String initialPwd;

	public ResetUserPwdCommand() {
		this.initialPwd = LoginConstants.INITIAL_PASSWORD_MD5;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInitialPwd() {
		return initialPwd;
	}

	public void setInitialPwd(String initialPwd) {
		this.initialPwd = initialPwd;
	}


	
}
