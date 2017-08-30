package com.bhyf.pojo.qo.recharge;

import com.rising.common.component.BaseQo;
import com.rising.common.util.DateUtil;

import java.util.Date;

/**
 * Created by admin on 2016/4/14.
 */
public class RechargeStatisticsQo extends BaseQo{


    private Date beginTime;

    private Date endTime;

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {

        this.beginTime = DateUtil.parseDateTime(DateUtil.formatDateTime(beginTime,"yyyy-MM-dd HH:mm:ss")+"00:00:00","yyyy-MM-dd HH:mm:ss");
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = DateUtil.parseDateTime(DateUtil.formatDateTime(endTime,"yyyy-MM-dd HH:mm:ss")+"23:59:59","yyyy-MM-dd HH:mm:ss");
    }
}
