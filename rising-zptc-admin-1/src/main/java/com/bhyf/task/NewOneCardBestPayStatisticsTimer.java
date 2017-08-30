package com.bhyf.task;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bhyf.common.wsclient.onecard.client.ClientWebService;
import com.bhyf.model.recharge.OneCardBestPayStatistics;
import com.bhyf.model.recharge.OneCardRecord;
import com.bhyf.pojo.dto.recharge.OneCardRecordDto;
import com.bhyf.pojo.dto.recharge.RechargeOneCardRecordDto;
import com.bhyf.pojo.qo.recharge.OneCardRecordQo;
import com.bhyf.pojo.qo.recharge.RechargeOneCardRecordQo;
import com.bhyf.service.interf.recharge.OneCardBestPayStatisticsService;
import com.bhyf.service.interf.recharge.OneCardRecordService;
import com.bhyf.service.interf.recharge.RechargeOneCardRecordService;
import com.rising.common.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class NewOneCardBestPayStatisticsTimer {

	Logger logger = Logger.getLogger(NewOneCardBestPayStatisticsTimer.class);
	
	@Resource
    private OneCardBestPayStatisticsService oneCardBestPayStatisticsService;
	@Resource
	private RechargeOneCardRecordService rechargeOneCardRecordService;
	@Resource
	private OneCardRecordService oneCardRecordService;

	@Scheduled(cron = "0 0 1 * * ?")
	protected void execute() throws ParseException{

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_MONTH,-1);

		OneCardBestPayStatistics oneCardBestPayStatistics = new OneCardBestPayStatistics();
		oneCardBestPayStatisticsService.saveOneCardBestPaySatistics(oneCardBestPayStatistics);
		RechargeOneCardRecordQo qo = new RechargeOneCardRecordQo();

		qo.setBeginTime(DateUtil.parseDateTime(DateUtil.formatDateTime(calendar.getTime(),"yyyy-MM-dd HH")+" 00:00:00","yyyy-MM-dd HH:mm:ss"));
		qo.setEndTime(DateUtil.parseDateTime(DateUtil.formatDateTime(calendar.getTime(),"yyyy-MM-dd HH")+" 23:59:59","yyyy-MM-dd HH:mm:ss"));
		List<RechargeOneCardRecordDto> oneCardRecordDtoList = rechargeOneCardRecordService.findRechargeOneCardRecordByQo(qo);
		for (RechargeOneCardRecordDto oneCardRecordDto : oneCardRecordDtoList) {
			String data = ClientWebService.getPaymentBooks(oneCardRecordDto.getCardNo(),DateUtil.formatDateTime(calendar.getTime(),"yyyyMMdd"),DateUtil.formatDateTime(calendar.getTime(),"yyyyMMdd"));
			data = data.replaceAll("\\\\","\\\\\\\\");
			logger.info(JSON.toJSONString(oneCardRecordDto)+"====================================="+data);
			JSONObject object = JSON.parseObject(data);
			JSONArray array = JSON.parseArray(object.get("Table1").toString());
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = array.getJSONObject(i);
				OneCardRecord oneCardRecord = new OneCardRecord(obj);
				oneCardRecordService.saveOneCardRecord(oneCardRecord);
			}
		}
	}
}

