package com.bhyf.service.interf.enter;

import com.bhyf.pojo.command.enter.UpdateEnterStatisticsCommand;
import com.bhyf.pojo.dto.enter.EnterStatisticsDto;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.bhyf.pojo.qo.enter.EnterStatisticsQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
public interface EnterStatisticsService {

    Pagination findEnterStatisticsByPagination(Pagination pagination);

    List<EnterStatisticsDto> findEnterStatisticsByQo(EnterStatisticsQo qo);

    String statisticsData(Integer enterId);

    String updateEnterStatistics(UpdateEnterStatisticsCommand command);

}
