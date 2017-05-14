package com.rising.cc.pojo.command.task;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.rising.common.task.TimerTaskConstants;

/**
 * 
 * @description 启动停止任务 Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年12月11日 下午2:41:06
 *
 */
@SuppressWarnings("serial")
public class StartOverTimerTaskCommand implements Serializable{
	
	private Integer id;
	
	private String isStart;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsStart() {
		return isStart;
	}

	public void setIsStart(String isStart) {
		
		if(StringUtils.isNotBlank(isStart)){
			if(isStart.equals("Y")){
				this.isStart = TimerTaskConstants.IS_START;
			}else if(isStart.equals("N")){
				this.isStart = TimerTaskConstants.IS_STOP;
			}
		}
	}


	
}
