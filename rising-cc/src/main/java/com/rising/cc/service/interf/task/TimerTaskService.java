package com.rising.cc.service.interf.task;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.task.CreateTimerTaskCommand;
import com.rising.cc.pojo.command.task.DeleteTimerTaskCommand;
import com.rising.cc.pojo.command.task.StartOverTimerTaskCommand;
import com.rising.cc.pojo.command.task.UpdateTimerTaskCommand;
import com.rising.cc.pojo.dto.task.TimerTaskDto;
import com.rising.cc.pojo.qo.task.TimerTaskQo;

public interface TimerTaskService {

	/**
	 * 
	 * @description 分页查询
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:41
	 * @param pagination
	 * @return
	 */
	public Pagination findTimerTaskListByPagination(Pagination pagination);
	
	/**
	 * 
	 * @description 新增
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:55
	 * @param addCommand
	 * @return
	 */
	public boolean saveTimerTask(CreateTimerTaskCommand addCommand);
	
	/**
	 * 
	 * @description 修改
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:55
	 * @param updateCommand
	 * @return
	 */
	public boolean updateTimerTask(UpdateTimerTaskCommand updateCommand);
	
	/**
	 * 
	 * @description 删除
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:55
	 * @param deleteCommand
	 * @return
	 */
	public boolean deleteTimerTask(DeleteTimerTaskCommand deleteCommand);
	
	/**
	 * 
	 * @description 根据TimerTaskQo 查询Api信息列表
	 * @author caoy
	 * @date 2015年9月10日 上午9:43:55
	 * @param qo
	 * @return
	 */
	public List<TimerTaskDto> findTimerTaskListByQo(TimerTaskQo qo);
	
	/**
	 * 
	 * @description 启动停止定时任务
	 * @author caoy
	 * @date 2015年12月11日 下午2:43:48
	 * @param command
	 * @return
	 */
	public boolean startOverTimerTask(StartOverTimerTaskCommand command);
	
}
