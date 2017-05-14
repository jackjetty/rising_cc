package com.rising.cc.pojo.qo.role;

import com.rising.cc.common.component.BaseQo;

/**
 * 
 * @description 用户检索对象
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月11日 上午10:44:38
 *
 */
@SuppressWarnings("serial")
public class RoleQo extends BaseQo{
	
	private Integer status;
	
	private Integer noStatus;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getNoStatus() {
		return noStatus;
	}

	public void setNoStatus(Integer noStatus) {
		this.noStatus = noStatus;
	}
	
	
}
