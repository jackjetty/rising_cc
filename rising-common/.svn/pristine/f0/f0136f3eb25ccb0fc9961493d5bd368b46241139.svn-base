package com.rising.common.task;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang.StringUtils;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.scheduling.support.TaskUtils;
import org.springframework.util.ErrorHandler;

/**
 * 
 * @description 定时任务调度对象
 * @company 碧海银帆
 * @author caoy
 * @date 2015年12月15日 上午11:03:05
 *
 */
public class TaskTarget {

	/**
	 * 任务线程
	 */
	private Runnable task;
	
	/**
	 * 任务future
	 */
	private Future future;
	
	/**
	 * 任务调度器
	 */
	private TaskScheduler taskScheduler = new ConcurrentTaskScheduler(Executors.newScheduledThreadPool(1)); 
	
	/**
	 * 定时器
	 */
	private CronTrigger cronTrigger;
	
	/**
	 * 错误处理对象
	 */
	private ErrorHandler errorHandler;

	public TaskTarget() {
		
	}
	
	public TaskTarget(Runnable task) {
		super();
		this.task = task;
	}
	
	public TaskTarget(Runnable task, ErrorHandler errorHandler) {
		super();
		this.task = task;
		this.errorHandler = errorHandler;
	}

	public TaskTarget(Runnable task, String cornExp) {
		super();
		this.task = task;
		this.cronTrigger = new CronTrigger(cornExp);
	}
	
	public TaskTarget(Runnable task, String cornExp,
			ErrorHandler errorHandler) {
		super();
		this.task = task;
		this.cronTrigger = new CronTrigger(cornExp);
		this.errorHandler = errorHandler;
	}

	public TaskTarget(Runnable task, TaskScheduler taskScheduler, CronTrigger cronTrigger,
			ErrorHandler errorHandler) {
		super();
		this.task = task;
		this.taskScheduler = taskScheduler;
		this.cronTrigger = cronTrigger;
		this.errorHandler = errorHandler;
	}

	
	public CronTrigger getCronTrigger() {
		return cronTrigger;
	}

	/**
	 * 
	 * @description 设置corn表达式触发器
	 * @author caoy
	 * @date 2015年12月9日 上午9:41:23
	 * @param cronExp corn表达式
	 */
	public void setCronTrigger(String cronExp) {
		this.cronTrigger = new CronTrigger(cronExp);
	}

	public void setTaskScheduler(TaskScheduler taskScheduler) {
		this.taskScheduler = taskScheduler;
	}

	public TaskScheduler getTaskScheduler() {
		return taskScheduler;
	}

	public ErrorHandler getErrorHandler() {
		return errorHandler;
	}

	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

	public Runnable getTask() {
		return task;
	}

	public void setTask(Runnable task) {
		this.task = task;
	}

	public Future getFuture() {
		return future;
	}

	public void setFuture(Future future) {
		this.future = future;
	}
	
	
	/**
	 * 
	 * @description 开启定时器，若已经存在定时器，则先关闭，后启动，，使用内置调度器
	 * @author caoy
	 * @date 2015年12月8日 下午4:53:10
	 * @param cronExp
	 */
	public boolean startupTimerTask(){
		try {
			if(this.task == null  || this.cronTrigger == null){
				return false;
			}
			if(this.getFuture() != null){
				this.getFuture().cancel(true);
			}
			Runnable handlingRunnable = TaskUtils.decorateTaskWithErrorHandler(this.task, this.errorHandler, false); 
			Future future = this.taskScheduler.schedule(handlingRunnable, this.cronTrigger);
			
			this.setFuture(future);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}

	
	/**
	 * 
	 * @description 开启定时器，若已经存在定时器，则先关闭，后启动，，使用内置调度器
	 * @author caoy
	 * @date 2015年12月8日 下午4:53:10
	 * @param cronExp
	 */
	public boolean startupTimerTask(String cronExp){
		try {
			if(StringUtils.isBlank(cronExp)){
				return false;
			}
			this.setCronTrigger(cronExp);  
			
			return this.startupTimerTask();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
	}
	
	
	
	
	/**
	 * 
	 * @description 开启定时器，若已经存在定时器，则先关闭，后启动，，使用外置调度器
	 * @author caoy
	 * @date 2015年12月8日 下午4:53:10
	 * @param taskScheduler
	 */
	public boolean startupTimerTask(TaskScheduler taskScheduler){
		try {
			if(this.task == null  || this.cronTrigger == null){
				return false;
			}
			if(this.getFuture() != null){
				this.getFuture().cancel(true);
			}
			Runnable handlingRunnable = TaskUtils.decorateTaskWithErrorHandler(this.task, errorHandler, false); 
			Future future = taskScheduler.schedule(handlingRunnable, this.cronTrigger);
			
			this.setFuture(future);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}

	
	
	/**
	 * 
	 * @description 开启定时器，若已经存在定时器，则先关闭，后启动，，使用外置调度器
	 * @author caoy
	 * @date 2015年12月8日 下午4:53:10
	 * @param taskScheduler
	 * @param cronExp
	 */
	public boolean startupTimerTask(TaskScheduler taskScheduler, String cronExp){
		try {
			if(StringUtils.isBlank(cronExp)){
				return false;
			}
			this.setCronTrigger(cronExp);  
			
			return this.startupTimerTask(taskScheduler);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		
	}
	
	/**
	 * 
	 * @description 关闭定时器
	 * @author caoy
	 * @date 2015年12月8日 下午4:53:10
	 * @param 
	 */
	public boolean shutdownTimerTask(){
		try {
			if(this.getFuture() != null){
				this.getFuture().cancel(true);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		return true;
	}
	
/*	*//**
	 * 
	 * @description 重启定时器
	 * @author caoy
	 * @date 2015年12月8日 下午4:53:10
	 * @param 
	 *//*
	private void restartTimerTask(String cronExp){
		if(this.getFuture() != null){
			this.getFuture().cancel(true);
		}
	}*/
		
		
}
