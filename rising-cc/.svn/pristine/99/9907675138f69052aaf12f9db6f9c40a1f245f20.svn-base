package com.rising.cc.pojo.command.task;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

/**
 * 
 * @description 修改Api信息 Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月3日 下午2:48:36
 *
 */
@SuppressWarnings("serial")
public class UpdateTimerTaskCommand implements Serializable{
	
	private Integer timerTaskId;
	
	private String serviceId;
	
	private String taskDesc;
	
	private String cronExpression;
	
	private String uniqueKey;
	
	private String controlLink;
	
	private String isStart;
	
	private Date createTime;
	
	private String createUser;

	
	public Integer getTimerTaskId() {
		return timerTaskId;
	}

	public void setTimerTaskId(Integer timerTaskId) {
		this.timerTaskId = timerTaskId;
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

	public void createCommand(EditTimerTaskCommand command){
		BeanUtils.copyProperties(command, this);
		this.timerTaskId = Integer.valueOf(command.getId());
	}
	
}
