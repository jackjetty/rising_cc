package com.rising.cc.pojo.command.user;

import java.io.Serializable;
import java.util.List;

import com.rising.cc.pojo.constants.user.LoginConstants;

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
	
	private List<Integer> idList;
	
	private String initialPwd;

	public ResetUserPwdCommand() {
		this.initialPwd = LoginConstants.INITIAL_PASSWORD_MD5;
	}
	
	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}

	public String getInitialPwd() {
		return initialPwd;
	}

	public void setInitialPwd(String initialPwd) {
		this.initialPwd = initialPwd;
	}


	
}
