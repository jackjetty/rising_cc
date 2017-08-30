package com.bhyf.dao.recharge;

import com.bhyf.model.recharge.OneCardBestPayStatistics;
import com.bhyf.model.recharge.OneCardRecord;
import com.bhyf.pojo.qo.recharge.OneCardRecordQo;
import com.bhyf.pojo.qo.recharge.RechargeStatisticsQo;
import com.rising.common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2016/4/15.
 */
public interface OneCardBestPayStatisticsDao {
    List<OneCardBestPayStatistics> findOneCardBestPayStatisticsByPagination(Pagination pagination);
    Double findSumOneCardMoney(RechargeStatisticsQo qo);
    Double findSumBestPayMoney(RechargeStatisticsQo qo);
    Double findSumOurMoney(RechargeStatisticsQo qo);
    Integer countOneCardBestPayStatisticsByPagination(Pagination pagination);

    void saveOneCardBestPayStatistics(OneCardBestPayStatistics oneCardBestPayStatistics);
    void updateOneCardBestPayStatistics(OneCardBestPayStatistics oneCardBestPayStatistics);

    OneCardBestPayStatistics findOneCardBestPayStatisticsById(@Param("id") Integer id);
}
