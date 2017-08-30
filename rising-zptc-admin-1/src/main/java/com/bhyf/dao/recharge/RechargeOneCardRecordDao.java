package com.bhyf.dao.recharge;

import com.bhyf.model.recharge.RechargeOneCardRecord;
import com.bhyf.pojo.qo.recharge.RechargeOneCardRecordQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/13.
 */
public interface RechargeOneCardRecordDao {

    List<RechargeOneCardRecord> findRechargeOneCardRecordByPagination(Pagination pagination);
    Integer countRechargeOneCardRecordByPagination(Pagination pagination);


    List<RechargeOneCardRecord> findRechargeOneCardRecordByQo(RechargeOneCardRecordQo qo);
}
