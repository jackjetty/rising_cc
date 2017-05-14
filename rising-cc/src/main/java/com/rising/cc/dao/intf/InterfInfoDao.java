package com.rising.cc.dao.intf;

import com.rising.common.page.Pagination;
import com.rising.cc.model.interf.InterfInfo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:28
 * 修改人：caizh
 * 修改时间：2015/11/17 10:28
 * 修改备注：
 */
public interface InterfInfoDao {
    public Integer insertInterfInfo(InterfInfo interfInfo);
    public Integer updateInterfInfo(InterfInfo interfInfo);
    public Integer deleteInterfInfo(InterfInfo interfInfo);
    public List<InterfInfo> findInterfInfoByPagination(Pagination pagination);
    public Integer countInterfInfoByPagination(Pagination pagination);
    public List<InterfInfo> findChildInterfInfoByPagination(Pagination pagination);
}
