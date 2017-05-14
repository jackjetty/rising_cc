package com.rising.common.task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.util.ErrorHandler;

/**
 * 
 * @description 定时任务容器
 * @company 碧海银帆
 * @author caoy
 * @date 2015年12月15日 上午11:00:22
 *
 */
public class TimerTaskContainer {
	
	/**
	 * 存放任务线程的map
	 */
	private static final Map<String, TaskTarget> taskMap = new HashMap<String, TaskTarget>();
	
	/**
	 * 外置任务调度器
	 */
	private static final TaskScheduler taskScheduler = new ConcurrentTaskScheduler(Executors.newScheduledThreadPool(5)); 
	
	public TimerTaskContainer() {
		
	}
	
	/**
	 * 
	 * @description 获取定时任务操作对象
	 * @author caoy
	 * @date 2015年12月9日 上午10:28:20
	 * @param uniqueKey
	 * @return
	 */
	public static TaskTarget getTaskTarget(String uniqueKey){
		return taskMap.get(uniqueKey);
	}
	
	/**
	 * 
	 * @description 启动指定定时任务
	 * @author caoy
	 * @date 2015年12月15日 上午9:26:30
	 * @param uniqueKey
	 * @param cronExp
	 * @return
	 */
	public static boolean startupTimerTask(String uniqueKey, String cronExp){
		TaskTarget taskTarget = taskMap.get(uniqueKey);
		if(taskTarget != null){
			
			return taskTarget.startupTimerTask(taskScheduler, cronExp);
		}
		return true;
	}
	
	
	/**
	 * 
	 * @description 停止指定定时任务
	 * @author caoy
	 * @date 2015年12月15日 上午9:29:47
	 * @param uniqueKey
	 * @return
	 */
	public static boolean shutdownTimerTask(String uniqueKey){
		TaskTarget taskTarget = taskMap.get(uniqueKey);
		if(taskTarget != null){
			return taskTarget.shutdownTimerTask();
		}
		return true;
	}
	
	/**
	 * 
	 * @description 设置定时任务的执行线程 
	 * @author caoy
	 * @date 2015年12月9日 上午10:22:34
	 * @param uniqueKey ： 唯一key，当前工程必须保持唯一
	 * @param task ： 任务线程
	 * @return
	 */
	public static boolean setTimerTask(String uniqueKey, Runnable task){
		return	 setTimerTask(uniqueKey, task, null);
	}

	/**
	 * 
	 * @description 设置定时任务的执行线程 
	 * @author caoy
	 * @date 2015年12月15日 上午9:21:45
	 * @param uniqueKey：唯一key，建议用UUID，当前工程必须保持唯一
	 * @param task ： 任务线程
	 * @param errorHandler：失败处理器
	 * @return
	 */
	public static boolean setTimerTask(String uniqueKey, Runnable task, ErrorHandler errorHandler){
		try {
			TaskTarget taskTarget = new TaskTarget(task, errorHandler);
			taskMap.put(uniqueKey, taskTarget);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	
}
