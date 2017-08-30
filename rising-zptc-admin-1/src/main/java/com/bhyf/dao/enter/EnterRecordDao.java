package com.bhyf.dao.enter;

import com.bhyf.model.enter.EnterRecord;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
public interface EnterRecordDao {

    List<EnterRecord> findEnterRecordByPagination(Pagination pagination);

    Integer countEnterRecordByPagination(Pagination pagination);

    List<EnterRecord> findEnterRecordByQo(EnterRecordQo qo);

    EnterRecord findEnterRecordById(Integer id);
}
