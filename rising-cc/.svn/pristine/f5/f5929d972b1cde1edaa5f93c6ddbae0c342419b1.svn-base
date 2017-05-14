package com.rising.cc.pojo.command.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @description 删除api信息Command
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月28日 下午3:01:18
 *
 */
public class DeleteTimerTaskCommand {
	
	
	private List<Integer> ids;
	

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public void createCommand(EditTimerTaskCommand command){
		String idStrs = command.getId();
		if(StringUtils.isNotBlank(idStrs)){
			List<Integer> ids = new ArrayList<Integer>();
			for (String id : idStrs.split(",")) {
				ids.add(Integer.valueOf(id));
			}
			this.ids = ids;
		}
	}
	
}
