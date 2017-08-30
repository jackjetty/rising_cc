package com.bhyf.pojo.command.role;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.bhyf.pojo.constants.role.RoleConstants;

/**
 * 
 * @description 删除角色Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月13日 上午10:30:43
 *
 */
public class RemoveRoleCommand {
	
	
	private List<Integer> ids;

	private Integer status;
	
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

	public void createCommand(EditRoleCommand command){
		String idStrs = command.getId();
		if(StringUtils.isNotBlank(idStrs)){
			List<Integer> ids = new ArrayList<Integer>();
			for (String id : idStrs.split(",")) {
				ids.add(Integer.valueOf(id));
			}
			this.ids = ids;
		}
		
		this.status = RoleConstants.ROLE_REMOVE;
	}
	
}
