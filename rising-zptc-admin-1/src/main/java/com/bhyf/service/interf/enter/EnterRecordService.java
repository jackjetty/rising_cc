package com.bhyf.service.interf.enter;

import com.bhyf.pojo.dto.enter.EnterRecordDetailDto;
import com.bhyf.pojo.dto.enter.EnterRecordDto;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.rising.common.page.Pagination;

import java.util.List;

/**
 * Created by admin on 2016/4/12.
 */
public interface EnterRecordService {

    public Pagination findEnterRecordByPagination(Pagination pagination);

    List<EnterRecordDto> findEnterRecordByQo(EnterRecordQo qo);

    EnterRecordDetailDto findEnterRecordById(Integer id);
}
