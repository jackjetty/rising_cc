package com.bhyf.dao.enter;

import com.bhyf.model.enter.BestPayRecord;
import com.bhyf.model.enter.EnterBestPayRecord;
import com.bhyf.pojo.qo.enter.BestPayRecordQo;
import com.bhyf.pojo.qo.enter.EnterBestPayRecordQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
public interface BestPayRecordDao {

    List<BestPayRecord> findBestPayRecordByQo(BestPayRecordQo qo);
    List<BestPayRecord> findBestPayRecordByPagination(Pagination pagination);
    Integer countBestPayRecordByPagination(Pagination pagination);


    void saveBestPayRecordBatch(List<BestPayRecord> bestPayRecord);



}
