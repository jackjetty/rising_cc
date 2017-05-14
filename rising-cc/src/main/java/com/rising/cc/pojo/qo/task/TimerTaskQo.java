package com.rising.cc.pojo.qo.task;

import com.rising.cc.common.component.BaseQo;

/**
 * 
 * @description 
 * @company 碧海银帆
 * @author caoy
 * @date 2015年12月10日 下午1:33:45
 *
 */
@SuppressWarnings("serial")
public class TimerTaskQo extends BaseQo{
	
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
