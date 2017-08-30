package com.bhyf.service.impl.recharge;

import com.bhyf.dao.recharge.RechargeOneCardRecordDao;
import com.bhyf.model.recharge.RechargeOneCardRecord;
import com.bhyf.pojo.dto.recharge.RechargeOneCardRecordDetailDto;
import com.bhyf.pojo.dto.recharge.RechargeOneCardRecordDto;
import com.bhyf.pojo.qo.recharge.RechargeOneCardRecordQo;
import com.bhyf.service.interf.recharge.RechargeOneCardRecordService;
import com.bhyf.util.EntityConvertUtils;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/4/13.
 */
@Service
public class RechargeOneCardRecordServiceImpl implements RechargeOneCardRecordService {

    @Resource
    private RechargeOneCardRecordDao rechargeOneCardRecordDao;


    @Override
    public Pagination findRechargeOneCardRecordByPagination(Pagination pagination) {

        List<RechargeOneCardRecord> rechargeOneCardRecordList =  rechargeOneCardRecordDao.findRechargeOneCardRecordByPagination(pagination);
        Integer total = rechargeOneCardRecordDao.countRechargeOneCardRecordByPagination(pagination);
        List<RechargeOneCardRecordDto> rechargeOneCardRecordDtoList = EntityConvertUtils.convertEntityToDtoList(rechargeOneCardRecordList,RechargeOneCardRecordDto.class);
        for (RechargeOneCardRecordDto rechargeOneCardRecordDto : rechargeOneCardRecordDtoList) {
            // TODO: 2016/4/13  查询用户信息 获得用户名
        }
        pagination.setList(rechargeOneCardRecordDtoList);
        pagination.setTotalCount(total);
        return pagination;
    }

    @Override
    public List<RechargeOneCardRecordDto> findRechargeOneCardRecordByQo(RechargeOneCardRecordQo qo) {
        List<RechargeOneCardRecord> rechargeOneCardRecordList = rechargeOneCardRecordDao.findRechargeOneCardRecordByQo(qo);
        List<RechargeOneCardRecordDto> rechargeOneCardRecordDtoList = EntityConvertUtils.convertEntityToDtoList(rechargeOneCardRecordList,RechargeOneCardRecordDto.class);
        for (RechargeOneCardRecordDto rechargeOneCardRecordDto : rechargeOneCardRecordDtoList) {
            // TODO: 2016/4/13  查询用户信息 获得用户名
        }
        return rechargeOneCardRecordDtoList;
    }

    @Override
    public RechargeOneCardRecordDetailDto findRechargeOneCardRecordDetailByQo(RechargeOneCardRecordQo qo) {
        List<RechargeOneCardRecord> rechargeOneCardRecordList = rechargeOneCardRecordDao.findRechargeOneCardRecordByQo(qo);
        RechargeOneCardRecordDetailDto dto = new RechargeOneCardRecordDetailDto();
        if(rechargeOneCardRecordList != null && rechargeOneCardRecordList.size()>0){
            dto.create(rechargeOneCardRecordList.get(0));

        }
        return dto;
    }
}
