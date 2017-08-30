package com.bhyf.service.impl.recharge;

import com.bhyf.dao.recharge.OneCardRecordDao;
import com.bhyf.model.enter.BestPayRecord;
import com.bhyf.model.recharge.OneCardRecord;
import com.bhyf.pojo.dto.enter.BestPayRecordDto;
import com.bhyf.pojo.dto.recharge.OneCardRecordDto;
import com.bhyf.pojo.qo.recharge.OneCardRecordQo;
import com.bhyf.service.interf.recharge.OneCardRecordService;
import com.bhyf.util.EntityConvertUtils;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2016/4/15.
 */
@Service
public class OneCardRecordServiceImpl implements OneCardRecordService{
    @Resource
    private OneCardRecordDao oneCardRecordDao;

    @Override
    public Pagination findOneCardRecordPagination(Pagination pagination) {
        List<OneCardRecord> oneCardRecordList = oneCardRecordDao.findOneCardRecordByPagination(pagination);
        Integer total = oneCardRecordDao.countOneCardRecordByPagination(pagination);

        List<OneCardRecordDto> oneCardRecordDtoList= EntityConvertUtils.convertEntityToDtoList(oneCardRecordList,OneCardRecordDto.class);
        pagination.setList(oneCardRecordDtoList);
        pagination.setTotalCount(total);
        return pagination;
    }

    @Override
    public List<OneCardRecordDto> findOneCardRecordByQo(OneCardRecordQo qo) {
        List<OneCardRecord> oneCardRecordList = oneCardRecordDao.findOneCardRecordByQo(qo);
        List<OneCardRecordDto> oneCardRecordDtoList= EntityConvertUtils.convertEntityToDtoList(oneCardRecordList,OneCardRecordDto.class);
        return oneCardRecordDtoList;
    }


    public String importData(Date beginTime,Date endTime){





        return "";
    }



    @Override
    public void saveOneCardRecordBatch(List<OneCardRecord> list) {
        if(list != null && list.size() >0){
            if(list.size() > 50){
                for(int i=1;i<=list.size();i=i+50){
                    if((i+49) > list.size()){
                        oneCardRecordDao.saveOneCardRecordBatch(list.subList(i-1, list.size()));
                    } else {
                        oneCardRecordDao.saveOneCardRecordBatch(list.subList(i-1, i+49));
                    }
                }
            } else {
                oneCardRecordDao.saveOneCardRecordBatch(list);
            }
        }
    }

    @Override
    public void saveOneCardRecord(OneCardRecord oneCardRecord) {
        OneCardRecord oneCardRecord1 = oneCardRecordDao.findOneCardRecordBystaSID(oneCardRecord.getStaSID());
        if(oneCardRecord1 == null){
            oneCardRecordDao.saveOneCardRecord(oneCardRecord);
        }
    }
}
