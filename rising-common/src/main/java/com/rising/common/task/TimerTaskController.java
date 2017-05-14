package com.rising.common.task;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimerTaskController {
	
	@RequestMapping("/task/exec")
	@ResponseBody
	public String execute(HttpServletRequest request,
			@RequestParam(required=true) String uniqueKey,
			@RequestParam(required=true) String isStart,
			@RequestParam(required=false) String cronExpression){
		
		if(StringUtils.isNotBlank(uniqueKey) 
				&& StringUtils.isNotBlank(isStart)){
			if(isStart.equals(TimerTaskConstants.IS_START) && StringUtils.isNotBlank(cronExpression)){
				return TimerTaskContainer.startupTimerTask(uniqueKey, cronExpression)+"";
			}else if(isStart.equals(TimerTaskConstants.IS_STOP)){
				return TimerTaskContainer.shutdownTimerTask(uniqueKey)+"";
			}
			
		}
		return "param error";
	}
	
}
