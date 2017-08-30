package com.bhyf.service.impl.enter;

import com.bhyf.dao.enter.BestPayRecordDao;
import com.bhyf.model.enter.BestPayRecord;
import com.bhyf.pojo.dto.enter.BestPayRecordDto;
import com.bhyf.pojo.qo.enter.BestPayRecordQo;
import com.bhyf.service.interf.enter.BestPayRecordService;
import com.bhyf.util.EntityConvertUtils;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by admin on 2016/4/13.
 */

@Service
public class BestPayRecordServiceImpl implements BestPayRecordService {

    @Resource
    private BestPayRecordDao bestPayRecordDao;

    @Override
    public Pagination findBestPayRecordPagination(Pagination pagination) {
        List<BestPayRecord> bestPayRecordList = bestPayRecordDao.findBestPayRecordByPagination(pagination);
        Integer total = bestPayRecordDao.countBestPayRecordByPagination(pagination);

        List<BestPayRecordDto> bestPayRecordDtoList = EntityConvertUtils.convertEntityToDtoList(bestPayRecordList,BestPayRecordDto.class);
        pagination.setList(bestPayRecordDtoList);
        pagination.setTotalCount(total);
        return pagination;
    }

    @Override
    public List<BestPayRecordDto> findBestPayRecordByQo(BestPayRecordQo qo) {
        List<BestPayRecord> bestPayRecordList = bestPayRecordDao.findBestPayRecordByQo(qo);

        List<BestPayRecordDto> bestPayRecordDtoList = EntityConvertUtils.convertEntityToDtoList(bestPayRecordList,BestPayRecordDto.class);
        return bestPayRecordDtoList;
    }

    @Override
    public void saveBestPayRecordBatch(List<BestPayRecord> list) {
        if(list != null && list.size() >0){
            if(list.size() > 50){
                for(int i=1;i<=list.size();i=i+50){
                    if((i+49) > list.size()){
                        bestPayRecordDao.saveBestPayRecordBatch(list.subList(i-1, list.size()));
                    } else {
                        bestPayRecordDao.saveBestPayRecordBatch(list.subList(i-1, i+49));
                    }
                }
            } else {
                bestPayRecordDao.saveBestPayRecordBatch(list);
            }
        }
    }
}
