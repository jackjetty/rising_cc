package com.rising.cc.task;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.rising.common.task.TimerTaskContainer;
import com.rising.common.util.DateUtil;
import com.rising.common.util.UUIDGenerator;

@Component
public class SmsSendErrorMonitorTask {
	
	@PostConstruct
	public void execute(){
		
		TimerTaskContainer.setTimerTask("72def3b6564c4163abc865e95440ebb4", new Runnable() {
			@Override
			public void run() {
				try {
					
					System.out.println("短信接口发送异常监控定时任务........................................................................."+DateUtil.formatDateTime(new Date()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		 TimerTaskContainer.setTimerTask("82def3b6564c4163abc865e95440ebb4", new Runnable(){
			@Override
			public void run() {
				Date date = new Date();
				System.out.println(date+"测试定时任务。。。。。。。。。。。。。"+date.getTime());
				
			}
		});
		
	}
	
	public static void main(String[] args) {
			System.out.println(UUIDGenerator.getUUID());
	}
	
}
