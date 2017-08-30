package com.bhyf.service.impl.recharge;

import com.bhyf.dao.recharge.OneCardBestPayStatisticsDao;
import com.bhyf.model.recharge.OneCardBestPayStatistics;
import com.bhyf.pojo.command.recharge.UpdateOneCardBestPayStatisticsCommand;
import com.bhyf.pojo.dto.recharge.OneCardBestPayStatisticsDto;
import com.bhyf.pojo.qo.recharge.OneCardBestPayStatisticsQo;
import com.bhyf.pojo.qo.recharge.RechargeStatisticsQo;
import com.bhyf.service.interf.recharge.OneCardBestPayStatisticsService;
import com.bhyf.util.EntityConvertUtils;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/4/15.
 */

@Service
public class OneCardBestPayStatisticsServiceImpl implements OneCardBestPayStatisticsService {

    @Resource
    private OneCardBestPayStatisticsDao oneCardBestPayStatisticsDao;

    @Override
    public Pagination findOneCardBestPayStatisticsPagination(Pagination pagination) {
        List<OneCardBestPayStatistics> oneCardBestPayStatisticsList = oneCardBestPayStatisticsDao.findOneCardBestPayStatisticsByPagination(pagination);
        Integer total = oneCardBestPayStatisticsDao.countOneCardBestPayStatisticsByPagination(pagination);

        List<OneCardBestPayStatisticsDto> oneCardBestPayStatisticsDtoList = EntityConvertUtils.convertEntityToDtoList(oneCardBestPayStatisticsList,OneCardBestPayStatisticsDto.class);
        pagination.setList(oneCardBestPayStatisticsDtoList);
        pagination.setTotalCount(total);
        return pagination;
    }

    @Override
    @Transactional
    public String saveOneCardBestPaySatistics(OneCardBestPayStatistics oneCardBestPayStatistics) {
        oneCardBestPayStatisticsDao.saveOneCardBestPayStatistics(oneCardBestPayStatistics);
        return "success";
    }

    @Override
    public String statisticsData(Integer  id) {
        OneCardBestPayStatistics oneCardBestPayStatistics = oneCardBestPayStatisticsDao.findOneCardBestPayStatisticsById(id);
        RechargeStatisticsQo qo = new RechargeStatisticsQo();
        qo.setBeginTime(oneCardBestPayStatistics.getCreateTime());
        qo.setEndTime(oneCardBestPayStatistics.getCreateTime());
        oneCardBestPayStatistics.setSumBestPayMoney(oneCardBestPayStatisticsDao.findSumBestPayMoney(qo));
        oneCardBestPayStatistics.setSumOneCardMoney(oneCardBestPayStatisticsDao.findSumOneCardMoney(qo));
        oneCardBestPayStatistics.setSumOurMoney(oneCardBestPayStatisticsDao.findSumOurMoney(qo));
        oneCardBestPayStatisticsDao.updateOneCardBestPayStatistics(oneCardBestPayStatistics);
        return "success";
    }

    @Override
    public String updateOneCardBestPayStatistics(UpdateOneCardBestPayStatisticsCommand command) {
        OneCardBestPayStatistics oneCardBestPayStatistics = new OneCardBestPayStatistics();
        oneCardBestPayStatistics.update(command);
        oneCardBestPayStatisticsDao.updateOneCardBestPayStatistics(oneCardBestPayStatistics);
        return "success";
    }
}
