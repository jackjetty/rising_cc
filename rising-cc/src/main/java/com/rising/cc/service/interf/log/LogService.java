package com.rising.cc.service.interf.log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rising.common.component.PaginQo;
import com.rising.common.page.Pagination;
import com.rising.cc.pojo.dto.log.LogFieldDto;
import com.rising.cc.pojo.qo.log.LogQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/4 9:00
 * 修改人：caizh
 * 修改时间：2015/8/4 9:00
 * 修改备注：
 */
public interface LogService {
    public Pagination findLog(JSONObject qo,PaginQo paginQo,Integer tableId);

    public Integer countLog(JSONObject qo,Integer tableId);

    public JSONObject analyseLogQo(LogQo qo, List<LogFieldDto> logFieldDtoList);
}
