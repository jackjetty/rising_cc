package com.bhyf.service.impl.enter;

import com.bhyf.dao.enter.EnterBestPayRecordDao;
import com.bhyf.dao.enter.EnterRecordDao;
import com.bhyf.model.enter.EnterBestPayRecord;
import com.bhyf.model.enter.EnterRecord;
import com.bhyf.pojo.dto.enter.EnterRecordDetailDto;
import com.bhyf.pojo.dto.enter.EnterRecordDto;
import com.bhyf.pojo.qo.enter.EnterBestPayRecordQo;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.bhyf.service.interf.enter.EnterRecordService;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
@Service
public class EnterRecordServiceImpl implements EnterRecordService{

    @Resource
    private EnterRecordDao enterRecordDao;
    @Resource
    private EnterBestPayRecordDao enterBestPayRecordDao;


    @Override
    public Pagination findEnterRecordByPagination(Pagination pagination) {
        List<EnterRecord> enterRecordList = enterRecordDao.findEnterRecordByPagination(pagination);
        Integer total = enterRecordDao.countEnterRecordByPagination(pagination);
        List<EnterRecordDto> enterRecordDtoList = new ArrayList<>();
        for (EnterRecord enterRecord : enterRecordList) {
            EnterRecordDto dto = new EnterRecordDto();
            dto.create(enterRecord);
            EnterBestPayRecordQo qo = new EnterBestPayRecordQo();
            qo.setTradeNo(enterRecord.getTradeNo());
            List<EnterBestPayRecord> enterBestPayRecordList =  enterBestPayRecordDao.findEnterBestPayRecordByQo(qo);
            if(enterBestPayRecordList != null && enterBestPayRecordList.size()>0){
                EnterBestPayRecord enterBestPayRecord = enterBestPayRecordList.get(0);
                dto.setPayNo(enterBestPayRecord.getPayNo());
                dto.setPayMoney(enterBestPayRecord.getPayMoney());
            }
            enterRecordDtoList.add(dto);
        }
        pagination.setList(enterRecordDtoList);
        pagination.setTotalCount(total);
        return pagination;
    }

    @Override
    public List<EnterRecordDto> findEnterRecordByQo(EnterRecordQo qo) {
        List<EnterRecord> enterRecordList = enterRecordDao.findEnterRecordByQo(qo);
        List<EnterRecordDto> enterRecordDtoList = new ArrayList<>();
        for (EnterRecord enterRecord : enterRecordList) {
            EnterRecordDto dto = new EnterRecordDto();
            dto.create(enterRecord);
            EnterBestPayRecordQo enterBestPayRecordQo = new EnterBestPayRecordQo();
            enterBestPayRecordQo.setTradeNo(enterRecord.getTradeNo());
            List<EnterBestPayRecord> enterBestPayRecordList =  enterBestPayRecordDao.findEnterBestPayRecordByQo(enterBestPayRecordQo);
            if(enterBestPayRecordList != null && enterBestPayRecordList.size()>0){
                EnterBestPayRecord enterBestPayRecord = enterBestPayRecordList.get(0);
                dto.setPayNo(enterBestPayRecord.getPayNo());
                dto.setPayMoney(enterBestPayRecord.getPayMoney());
            }
            enterRecordDtoList.add(dto);
        }
        return enterRecordDtoList;
    }

    @Override
    public EnterRecordDetailDto findEnterRecordById(Integer id) {
        EnterRecord enterRecord = enterRecordDao.findEnterRecordById(id);
        EnterRecordDetailDto dto = new EnterRecordDetailDto();
        dto.create(enterRecord);
        EnterBestPayRecordQo enterBestPayRecordQo = new EnterBestPayRecordQo();
        enterBestPayRecordQo.setTradeNo(enterRecord.getTradeNo());
        List<EnterBestPayRecord> enterBestPayRecordList =  enterBestPayRecordDao.findEnterBestPayRecordByQo(enterBestPayRecordQo);
        if(enterBestPayRecordList != null && enterBestPayRecordList.size()>0){
            EnterBestPayRecord enterBestPayRecord = enterBestPayRecordList.get(0);
            dto.setPayMoney(enterBestPayRecord.getPayMoney());
        }

        return dto;
    }
}
