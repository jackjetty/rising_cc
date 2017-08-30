package com.bhyf.service.interf.recharge;

import com.alibaba.fastjson.JSON;
import com.bhyf.pojo.qo.recharge.RechargeStatisticsQo;

/**
 * Created by admin on 2016/4/14.
 */
public interface RechargeStatisticsService {


    public String statisticsRechargeChartData(RechargeStatisticsQo qo);
}
