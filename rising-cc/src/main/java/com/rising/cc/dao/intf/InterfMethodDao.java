package com.rising.cc.dao.intf;

import com.rising.common.page.Pagination;
import com.rising.cc.model.interf.InterfMethod;
import com.rising.cc.pojo.qo.interf.InterfMethodQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:37
 * 修改人：caizh
 * 修改时间：2015/11/17 10:37
 * 修改备注：
 */
public interface InterfMethodDao {
    public void insertInterfMethod(InterfMethod interfMethod);
    public void removeInterfMethod(InterfMethod interfMethod);
    public void updateInterfMethod(InterfMethod interfMethod);
    public List<InterfMethod> findInterfMethodByPagination(Pagination pagination);
    public Integer countInterfMethodByPagination(Pagination pagination);

    public List<InterfMethod> findInterfMethodByQo(InterfMethodQo interfMethodQo);
}
