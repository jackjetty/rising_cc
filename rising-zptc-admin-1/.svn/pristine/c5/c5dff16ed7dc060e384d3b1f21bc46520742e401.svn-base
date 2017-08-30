package com.bhyf.service.interf.enter;

import com.bhyf.model.enter.BestPayRecord;
import com.bhyf.pojo.dto.enter.BestPayRecordDto;
import com.bhyf.pojo.qo.enter.BestPayRecordQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/13.
 */
public interface BestPayRecordService {

    Pagination findBestPayRecordPagination(Pagination pagination);

    List<BestPayRecordDto> findBestPayRecordByQo(BestPayRecordQo qo);

    void saveBestPayRecordBatch(List<BestPayRecord> bestPayRecordList);
}
