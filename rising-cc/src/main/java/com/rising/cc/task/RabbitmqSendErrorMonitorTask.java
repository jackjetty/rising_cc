package com.rising.cc.task;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.rising.common.task.TimerTaskContainer;
import com.rising.common.util.DateUtil;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/12/15 15:58
 * 修改人：caizh
 * 修改时间：2015/12/15 15:58
 * 修改备注：
 */
@Component
public class RabbitmqSendErrorMonitorTask {


    @PostConstruct
    public void execute(){

        TimerTaskContainer.setTimerTask("6dc0cb3ff36d4a4c82ddd39864bc6325", new Runnable() {
            @Override
            public void run() {
				System.out.println("短信队列累计监控定时任务........................................................................."+DateUtil.formatDateTime(new Date()));

            }
        });

    }
}
