package com.bhyf.service.interf.recharge;

import com.bhyf.model.enter.BestPayRecord;
import com.bhyf.model.recharge.OneCardRecord;
import com.bhyf.pojo.dto.enter.BestPayRecordDto;
import com.bhyf.pojo.dto.recharge.OneCardRecordDto;
import com.bhyf.pojo.qo.enter.BestPayRecordQo;
import com.bhyf.pojo.qo.recharge.OneCardRecordQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/15.
 */
public interface OneCardRecordService {
    Pagination findOneCardRecordPagination(Pagination pagination);

    List<OneCardRecordDto> findOneCardRecordByQo(OneCardRecordQo qo);

    void saveOneCardRecordBatch(List<OneCardRecord> list);

    void saveOneCardRecord(OneCardRecord oneCardRecord);
}
