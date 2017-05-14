package com.rising.cc.dao.task;

import java.util.List;

import com.rising.common.page.Pagination;
import com.rising.cc.model.task.TimerTask;
import com.rising.cc.pojo.qo.task.TimerTaskQo;

/**
 * 
 * @description 
 * @company 碧海银帆
 * @author caoy
 * @date 2015年12月10日 上午9:51:37
 *
 */
public interface TimerTaskDao {
	
    public List<TimerTask> findTimerTaskListByPagination(Pagination pagination);
    
    public Integer countTimerTaskListByPagination(Pagination pagination);
    
	public Integer updateTimerTask(TimerTask timerTask);
	
	public Integer deleteBatchTimerTask(List<Integer> list);
	
	public Integer insertTimerTask(TimerTask timerTask);

	public List<TimerTask> findTimerTaskListByQo(TimerTaskQo qo);
	
	public TimerTask findTimerTaskByQo(TimerTaskQo qo);
	
}