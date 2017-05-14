package com.rising.cc.pojo.command.task;

import java.io.Serializable;

/**
 * 
 * @description 编辑 Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class EditTimerTaskCommand implements Serializable{
	
	private String id;
	
	private String serviceId;

	private String taskDesc;
	
	private String cronExpression;
	
	private String uniqueKey;
	
	private String controlLink;
	
	private String isStart;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getUniqueKey() {
		return uniqueKey;
	}

	public void setUniqueKey(String uniqueKey) {
		this.uniqueKey = uniqueKey;
	}

	public String getControlLink() {
		return controlLink;
	}

	public void setControlLink(String controlLink) {
		this.controlLink = controlLink;
	}

	public String getIsStart() {
		return isStart;
	}

	public void setIsStart(String isStart) {
		this.isStart = isStart;
	}


	
}
