package com.bhyf.service.interf.enter;

import com.bhyf.pojo.dto.enter.EnterBestPayRecordDto;
import com.bhyf.pojo.qo.enter.EnterBestPayRecordQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
public interface EnterBestPayRecordService {


    Pagination findEnterBestPayRecordByPagination(Pagination pagination);

    List<EnterBestPayRecordDto> findEnterBestPayRecordByQo(EnterBestPayRecordQo qo);
}
