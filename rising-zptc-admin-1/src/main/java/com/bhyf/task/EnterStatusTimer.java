package com.bhyf.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bhyf.common.wsclient.onecard.client.ClientWebService;
import com.bhyf.dao.enter.EnterDao;
import com.bhyf.model.enter.Enter;
import com.bhyf.model.recharge.OneCardBestPayStatistics;
import com.bhyf.model.recharge.OneCardRecord;
import com.bhyf.pojo.dto.recharge.RechargeOneCardRecordDto;
import com.bhyf.pojo.qo.recharge.RechargeOneCardRecordQo;
import com.bhyf.service.interf.enter.EnterService;
import com.bhyf.service.interf.recharge.OneCardBestPayStatisticsService;
import com.bhyf.service.interf.recharge.OneCardRecordService;
import com.bhyf.service.interf.recharge.RechargeOneCardRecordService;
import com.rising.common.util.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * 
 * 项目名称：monitoring-app  
 * 类名称：NewUserOnlineTimer  
 * 类描述： 每天新用户入库 
 * 创建人：dingzl  
 * 创建时间：2015年11月12日 下午4:44:44  
 * 修改人：dingzl 
 * 修改时间：2015年11月12日 下午4:44:44  
 * 修改备注：  
 * @version：v1.0.0
 */
@Component
public class EnterStatusTimer {
	
	@Resource
    private EnterDao enterDao;

	@Scheduled(cron = "0 50 23 * * ?")
	protected void execute() throws ParseException{


		Date begin =DateUtil.parseDateTime(DateUtil.formatDateTime(new Date(),"yyyy-MM-dd")+" 00:00:00","yyyy-MM-dd");
		Date end =DateUtil.parseDateTime(DateUtil.formatDateTime(new Date(),"yyyy-MM-dd")+" 00:00:00","yyyy-MM-dd");

		List<Enter> enterList = enterDao.findEnterByLoseTime(begin,end);
		for (Enter enter : enterList) {
			enter.setStatus(0);
			enterDao.updateEnter(enter);
		}
	}


}
