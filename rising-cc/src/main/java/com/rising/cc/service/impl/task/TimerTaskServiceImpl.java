package com.rising.cc.service.impl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.quartz.CronExpression;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rising.cc.dao.task.TimerTaskDao;
import com.rising.cc.model.task.TimerTask;
import com.rising.cc.pojo.command.task.CreateTimerTaskCommand;
import com.rising.cc.pojo.command.task.DeleteTimerTaskCommand;
import com.rising.cc.pojo.command.task.StartOverTimerTaskCommand;
import com.rising.cc.pojo.command.task.UpdateTimerTaskCommand;
import com.rising.cc.pojo.dto.task.TimerTaskDto;
import com.rising.cc.pojo.qo.task.TimerTaskQo;
import com.rising.cc.service.interf.task.TimerTaskService;
import com.rising.common.model.HttpResponse;
import com.rising.common.page.Pagination;
import com.rising.common.task.TimerTaskConstants;
import com.rising.common.util.HttpUtil;

/**
 * 
 * @description 
 * @company 碧海银帆
 * @author caoy
 * @date 2015年12月10日 下午1:42:36
 *
 */
@Service
public class TimerTaskServiceImpl implements TimerTaskService{

	@Resource
	private TimerTaskDao timerTaskDao;
	
	@Override
	public Pagination findTimerTaskListByPagination(Pagination pagination) {
		List<TimerTask> modelList = timerTaskDao.findTimerTaskListByPagination(pagination);
		List<TimerTaskDto> dtoList = new ArrayList<TimerTaskDto>();
		
		for (TimerTask timerTask : modelList) {
			TimerTaskDto dto = new TimerTaskDto();
			BeanUtils.copyProperties(timerTask, dto);
			dtoList.add(dto);
		}
		
		pagination.setList(dtoList);
		pagination.setTotalCount(timerTaskDao.countTimerTaskListByPagination(pagination));
		
		return pagination;
	}

	@Transactional
	@Override
	public boolean saveTimerTask(CreateTimerTaskCommand addCommand) {
		if(!CronExpression.isValidExpression(addCommand.getCronExpression())){
			return false;
		}
		
		TimerTask timerTask = new TimerTask();
		timerTask.createTimerTask(addCommand);
		timerTaskDao.insertTimerTask(timerTask);
		return true;
	}

	@Transactional
	@Override
	public boolean updateTimerTask(UpdateTimerTaskCommand updateCommand) {
		if(!CronExpression.isValidExpression(updateCommand.getCronExpression())){
			return false;
		}
		
		TimerTask timerTask = new TimerTask();
		timerTask.updateTimerTask(updateCommand);
		
		timerTaskDao.updateTimerTask(timerTask);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteTimerTask(DeleteTimerTaskCommand deleteCommand) {
		timerTaskDao.deleteBatchTimerTask(deleteCommand.getIds());
		return true;
	}

	@Override
	public List<TimerTaskDto> findTimerTaskListByQo(TimerTaskQo qo) {

		List<TimerTask> modelList = timerTaskDao.findTimerTaskListByQo(qo);
		List<TimerTaskDto> dtoList = new ArrayList<TimerTaskDto>();
		
		for (TimerTask timerTask : modelList) {
			TimerTaskDto dto = new TimerTaskDto();
			BeanUtils.copyProperties(timerTask, dto);
			dtoList.add(dto);
		}
		
		return dtoList;
	}

	@Transactional
	@Override
	public boolean startOverTimerTask(StartOverTimerTaskCommand command) {
		try {
			
			TimerTaskQo qo = new TimerTaskQo();
			qo.setId(command.getId());
			
			TimerTask timerTask = timerTaskDao.findTimerTaskByQo(qo);
			
			if(timerTask != null){
				StringBuffer sb = new StringBuffer();
				sb.append(timerTask.getControlLink());
				sb.append(TimerTaskConstants.CONTROL_URL);
				
				Map<String,String> paramMap = new HashMap<String,String>();
				paramMap.put("uniqueKey", timerTask.getUniqueKey());
				paramMap.put("isStart", command.getIsStart());
				paramMap.put("cronExpression", timerTask.getCronExpression());
				
				HttpResponse response = HttpUtil.executePostMethod(sb.toString(), paramMap, 10000);
				
				if("true".equals(response.getResult())){
					timerTask.startOverTimerTask(command);
					timerTaskDao.updateTimerTask(timerTask);
					
				}else{
					return false;
				}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		}
		return true;
	}

	
}
