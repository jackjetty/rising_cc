package com.rising.cc.dao.monitoring;

import com.rising.cc.model.monitoring.RabbitmqConfig;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/12/15 9:34
 * 修改人：caizh
 * 修改时间：2015/12/15 9:34
 * 修改备注：
 */
public interface RabbitmqMonitoringDao {
    public List<RabbitmqConfig> findStartRabbitmqConfig();

}
