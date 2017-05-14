package com.rising.common.task;

import java.util.Date;

public class TestTask {
	
	public static void test(){
		
		TaskTarget taskTarget = new TaskTarget(new Runnable() {
			
			@Override
			public void run() {
				Date date = new Date();
				System.out.println(date+"==========1111111==================="+date.getTime());
				
			}
		},"*/1 * * * * ?");
		
		
		taskTarget.startupTimerTask();
		
	}
	
	
	
	public static void test1(){
		
		 TimerTaskContainer.setTimerTask("11111", new Runnable() {
			
			@Override
			public void run() {
				Date date = new Date();
				System.out.println(date+"==========1111111==================="+date.getTime());
				
			}
		});
		 
		 TimerTaskContainer.setTimerTask("2222", new Runnable() {
			 
			 @Override
			 public void run() {
				 Date date = new Date();
				 System.out.println(date+"==========2222222==================="+date.getTime());
				 
			 }
		 });
		
		 TimerTaskContainer.startupTimerTask("11111", "*/1 * * * * ?");
		 TimerTaskContainer.startupTimerTask("2222", "*/3 * * * * ?");
		
		 
		 
		 try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 TimerTaskContainer.shutdownTimerTask("11111");
	}
	
	
	public static void main(String[] args) {
		
//		TestTask.test();
		TestTask.test1();
		
	}
	
	
}
