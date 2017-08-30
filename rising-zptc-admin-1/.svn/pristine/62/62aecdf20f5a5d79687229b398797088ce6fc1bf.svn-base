package com.bhyf.service.impl.recharge;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bhyf.dao.recharge.RechargeOneCardRecordDao;
import com.bhyf.model.recharge.RechargeOneCardRecord;
import com.bhyf.pojo.dto.recharge.RechargeChartDto;
import com.bhyf.pojo.dto.recharge.RechargeOneCardRecordDto;
import com.bhyf.pojo.qo.recharge.RechargeOneCardRecordQo;
import com.bhyf.pojo.qo.recharge.RechargeStatisticsQo;
import com.bhyf.service.interf.recharge.RechargeOneCardRecordService;
import com.bhyf.service.interf.recharge.RechargeStatisticsService;
import com.google.common.collect.Lists;
import com.rising.common.util.DateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by admin on 2016/4/14.
 */
@Service
public class RechargeStatisticsServiceImpl implements RechargeStatisticsService{


    @Resource
    private RechargeOneCardRecordDao rechargeOneCardRecordDao;



    @Override
    public String statisticsRechargeChartData(RechargeStatisticsQo qo) {
        RechargeOneCardRecordQo recordQo = new RechargeOneCardRecordQo();
        recordQo.setBeginTime(qo.getBeginTime());
        recordQo.setEndTime(qo.getEndTime());
        List<RechargeOneCardRecord> rechargeOneCardRecordList  = rechargeOneCardRecordDao.findRechargeOneCardRecordByQo(recordQo);
        Map<String,Double> recordMap = analyRecord(rechargeOneCardRecordList,qo.getBeginTime());
        List<String> xAxis = Lists.newArrayList();
        List<Double> yAxis = Lists.newArrayList();
        for (Map.Entry<String, Double> stringDoubleEntry : recordMap.entrySet()) {
            xAxis.add(stringDoubleEntry.getKey());
            yAxis.add(stringDoubleEntry.getValue());
        }
        JSONObject object = new JSONObject();
        object.put("xAxis",xAxis);
        object.put("yAxis",yAxis);
        return object.toJSONString();
    }

    private Map<String,Double> analyRecord(List<RechargeOneCardRecord> list,Date date){
        Map<String,Double> recordMap = new LinkedHashMap<>();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int max = calendar.getActualMaximum(Calendar.DATE);
        for (int i = 1; i <= max; i++) {
            String d = DateUtil.formatDateTime(calendar.getTime(),"yyyy-MM-dd");
            recordMap.put(d,0.0);
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
        for (RechargeOneCardRecord rechargeOneCardRecord : list) {
            String d =DateUtil.formatDateTime(rechargeOneCardRecord.getRechTime(),"yyyy-MM-dd");
            Double money = recordMap.get(d);
            money += rechargeOneCardRecord.getRechMoney();
            recordMap.put(d,money);
        }
        return recordMap;
    }
}
