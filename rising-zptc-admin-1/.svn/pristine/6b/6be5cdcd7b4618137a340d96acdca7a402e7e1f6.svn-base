package com.bhyf.service.impl.enter;

import com.bhyf.dao.enter.EnterStatisticsDao;
import com.bhyf.model.enter.EnterStatistics;
import com.bhyf.pojo.command.enter.UpdateEnterStatisticsCommand;
import com.bhyf.pojo.dto.enter.EnterStatisticsDto;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.bhyf.pojo.qo.enter.EnterStatisticsQo;
import com.bhyf.service.interf.enter.EnterStatisticsService;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
@Service
public class EnterStatisticsServiceImpl implements EnterStatisticsService {

    @Resource
    private EnterStatisticsDao enterStatisticsDao;


    @Override
    public Pagination findEnterStatisticsByPagination(Pagination pagination) {
        List<EnterStatistics> enterStatisticsList = enterStatisticsDao.findEnterStatisticsByPagination(pagination);
        Integer total = enterStatisticsDao.countEnterStatisticsByPagination(pagination);

        List<EnterStatisticsDto> enterStatisticsDtoList = new ArrayList<>();
        for (EnterStatistics enterStatistics : enterStatisticsList) {
            EnterStatisticsDto dto = new EnterStatisticsDto();
            dto.create(enterStatistics);
            enterStatisticsDtoList.add(dto);
        }
        pagination.setList(enterStatisticsDtoList);
        pagination.setTotalCount(total);
        return pagination;
    }

    @Override
    public List<EnterStatisticsDto> findEnterStatisticsByQo(EnterStatisticsQo qo) {
        List<EnterStatistics> enterStatisticsList = enterStatisticsDao.findEnterStatisticsByQo(qo);
        List<EnterStatisticsDto> enterStatisticsDtoList = new ArrayList<>();
        for (EnterStatistics enterStatistics : enterStatisticsList) {
            EnterStatisticsDto dto = new EnterStatisticsDto();
            dto.create(enterStatistics);
            enterStatisticsDtoList.add(dto);
        }
        return enterStatisticsDtoList;
    }

    @Override
    public String statisticsData(Integer enterId) {
        EnterStatisticsQo qo = new EnterStatisticsQo();
        qo.setEnterId(enterId);
        List<EnterStatistics> statisticseList = enterStatisticsDao.findEnterStatisticsByQo(qo);
        EnterStatistics enterStatistics ;
        if(statisticseList != null && statisticseList.size() >0){
            enterStatistics = statisticseList.get(0);
            Double enterSumMoney = enterStatisticsDao.findTotalMoney(qo);
            qo.setStatus(1);
            Double enterBestPaySumMoney = enterStatisticsDao.findTotalMoney(qo);
            enterStatistics.setEnterSumMoney(enterSumMoney);
            enterStatistics.setEnterBestPaySumMoney(enterBestPaySumMoney);
            if(enterBestPaySumMoney != null && enterSumMoney != null && enterBestPaySumMoney.doubleValue() == enterSumMoney.doubleValue()){
                enterStatistics.setReconciliation("对账成功");
            }
            enterStatisticsDao.updateEnterStatistics(enterStatistics);
        }else{
            return "data error";
        }

        return "success";
    }

    @Override
    public String updateEnterStatistics(UpdateEnterStatisticsCommand command) {
        EnterStatistics enterStatistics = new EnterStatistics();
        enterStatistics.update(command);
        enterStatisticsDao.updateEnterStatistics(enterStatistics);
        return "success";
    }
}
