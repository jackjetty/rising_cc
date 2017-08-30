package com.bhyf.service.impl.enter;

import com.bhyf.dao.enter.EnterBestPayRecordDao;
import com.bhyf.model.enter.EnterBestPayRecord;
import com.bhyf.pojo.dto.enter.EnterBestPayRecordDto;
import com.bhyf.pojo.qo.enter.EnterBestPayRecordQo;
import com.bhyf.service.interf.enter.EnterBestPayRecordService;
import com.bhyf.util.EntityConvertUtils;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
@Service
public class EnterBestPayRecordServiceImpl implements EnterBestPayRecordService{

    @Resource
    private EnterBestPayRecordDao enterBestPayRecordDao;

    @Override
    public Pagination findEnterBestPayRecordByPagination(Pagination pagination) {
        List<EnterBestPayRecord> enterBestPayRecordList = enterBestPayRecordDao.findEnterBestPayRecordByPagination(pagination);
        Integer total = enterBestPayRecordDao.countEnterBestPayRecordByPagination(pagination);
        List<EnterBestPayRecordDto> enterBestPayRecordDtoList = EntityConvertUtils.convertEntityToDtoList(enterBestPayRecordList,EnterBestPayRecordDto.class);
        pagination.setList(enterBestPayRecordDtoList);
        pagination.setTotalCount(total);
        return pagination;
    }
    @Override
    public List<EnterBestPayRecordDto> findEnterBestPayRecordByQo(EnterBestPayRecordQo qo) {
        List<EnterBestPayRecord> enterBestPayRecordList = enterBestPayRecordDao.findEnterBestPayRecordByQo(qo);
        List<EnterBestPayRecordDto> enterBestPayRecordDtoList = EntityConvertUtils.convertEntityToDtoList(enterBestPayRecordList,EnterBestPayRecordDto.class);
        return enterBestPayRecordDtoList;
    }
}
