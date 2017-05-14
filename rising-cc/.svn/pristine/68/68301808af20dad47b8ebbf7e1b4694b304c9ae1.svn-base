package com.rising.cc.model.task;

import com.rising.common.util.UUIDGenerator;
import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.task.CreateTimerTaskCommand;
import com.rising.cc.pojo.command.task.StartOverTimerTaskCommand;
import com.rising.cc.pojo.command.task.UpdateTimerTaskCommand;

@SuppressWarnings("serial")
public class TimerTask extends BaseModel{
	
	private String serviceId;
	
	private String taskDesc;
	
	private String cronExpression;
	
	private String uniqueKey;
	
	private String controlLink;
	
	private String isStart;

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
 
	public void createTimerTask(CreateTimerTaskCommand command){
		if(command != null){
			super.setCreateTime(command.getCreateTime());
			super.setCreateUser(command.getCreateUser());
			this.taskDesc = command.getTaskDesc();
			this.controlLink = command.getControlLink();
			this.cronExpression = command.getCronExpression();
			this.isStart = command.getIsStart();
			this.serviceId = command.getServiceId();
			this.uniqueKey = UUIDGenerator.getUUID();
		}
	}
	
	public void updateTimerTask(UpdateTimerTaskCommand command){
		if(command != null){
			super.setId(command.getTimerTaskId());
			this.taskDesc = command.getTaskDesc();
			this.controlLink = command.getControlLink();
			this.cronExpression = command.getCronExpression();
			this.isStart = command.getIsStart();
			this.serviceId = command.getServiceId();
			this.uniqueKey = command.getUniqueKey();
		}
	}
	
	public void startOverTimerTask(StartOverTimerTaskCommand command){
		if(command != null){
			super.setId(command.getId());
			this.isStart = command.getIsStart();
		}
	}
	
}
