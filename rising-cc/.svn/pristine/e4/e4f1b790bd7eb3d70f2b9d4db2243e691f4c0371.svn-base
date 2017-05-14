package com.rising.cc.model.user;

import com.rising.common.component.BaseModel;
import com.rising.cc.pojo.command.user.SetUserEnvirCommand;

@SuppressWarnings("serial")
public class SysUserEnvir extends BaseModel {
	
	private Integer userId;
	
	private Integer envirId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getEnvirId() {
		return envirId;
	}

	public void setEnvirId(Integer envirId) {
		this.envirId = envirId;
	}
	
	public void createSysUserEnvir(SetUserEnvirCommand command, Integer envirId){
		super.setCreateTime(command.getCreateTime());
		super.setCreateUser(command.getCreateUser());
		this.userId = command.getUserId();
		this.envirId = envirId;
	}
	
	
}
