package com.bhyf.pojo.command.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bhyf.pojo.constants.user.UserConstants;

/**
 * 
 * @description 删除用户Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月13日 上午10:30:43
 *
 */
public class RemoveUserCommand {
	
	
	private List<Integer> ids;
	
	private Integer status;

	public RemoveUserCommand() {
		this.status = UserConstants.USER_REMOVE;
	}
	
	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void createCommand(EditUserCommand command){
		String idStrs = command.getId();
		if(StringUtils.isNotBlank(idStrs)){
			List<Integer> ids = new ArrayList<Integer>();
			for (String id : idStrs.split(",")) {
				ids.add(Integer.valueOf(id));
			}
			this.ids = ids;
		}
		this.status = UserConstants.USER_REMOVE;
	}
	
}
