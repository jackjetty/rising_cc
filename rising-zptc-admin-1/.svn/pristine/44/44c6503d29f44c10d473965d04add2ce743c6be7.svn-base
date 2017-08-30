package com.bhyf.dao.recharge;

import com.bhyf.model.enter.BestPayRecord;
import com.bhyf.model.recharge.OneCardRecord;
import com.bhyf.pojo.qo.recharge.OneCardRecordQo;
import com.rising.common.page.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by admin on 2016/4/15.
 */
public interface OneCardRecordDao {
    List<OneCardRecord> findOneCardRecordByQo(OneCardRecordQo qo);
    List<OneCardRecord> findOneCardRecordByPagination(Pagination pagination);
    Integer countOneCardRecordByPagination(Pagination pagination);

    OneCardRecord findOneCardRecordBystaSID(@Param("staSID")String staSID);

    void saveOneCardRecordBatch(List<OneCardRecord> list);

    void saveOneCardRecord(OneCardRecord oneCardRecord);
}
