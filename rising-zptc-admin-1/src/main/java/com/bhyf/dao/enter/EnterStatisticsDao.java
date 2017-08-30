package com.bhyf.dao.enter;

import com.bhyf.model.enter.EnterStatistics;
import com.bhyf.pojo.qo.enter.EnterStatisticsQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
public interface EnterStatisticsDao {
    List<EnterStatistics> findEnterStatisticsByQo(EnterStatisticsQo qo);
    List<EnterStatistics> findEnterStatisticsByPagination(Pagination pagination);
    Integer countEnterStatisticsByPagination(Pagination pagination);

    void saveEnterStatistics(EnterStatistics enterStatistics);

    Double findTotalMoney(EnterStatisticsQo qo);

    void updateEnterStatistics(EnterStatistics enterStatistics);
}
