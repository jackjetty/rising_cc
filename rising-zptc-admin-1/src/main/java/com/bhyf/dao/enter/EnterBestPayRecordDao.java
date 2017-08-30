package com.bhyf.dao.enter;

import com.bhyf.model.enter.EnterBestPayRecord;
import com.bhyf.pojo.qo.enter.EnterBestPayRecordQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
public interface EnterBestPayRecordDao {

    public List<EnterBestPayRecord> findEnterBestPayRecordByQo(EnterBestPayRecordQo qo);

    List<EnterBestPayRecord> findEnterBestPayRecordByPagination(Pagination pagination);

    Integer countEnterBestPayRecordByPagination(Pagination pagination);
}
