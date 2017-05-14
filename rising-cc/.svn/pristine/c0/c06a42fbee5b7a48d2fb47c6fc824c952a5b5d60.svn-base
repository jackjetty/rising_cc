package com.rising.cc.dao.queue;

import com.rising.common.page.Pagination;
import com.rising.cc.model.queue.Handler;
import com.rising.cc.model.queue.Queue;
import com.rising.cc.pojo.qo.queue.HandlerQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/1 9:58
 * 修改人：caizh
 * 修改时间：2015/9/1 9:58
 * 修改备注：
 */
public interface HandlerDao {
    public List<Handler> findHandlerByPagination(Pagination pagination);
    public List<Handler> findHandlerByQo(HandlerQo qo);
    public Integer countHandlerByPagination(Pagination pagination);

    public Integer saveHandler(Handler handler);
    public void updateHandler(Handler handler);
    public void deleteHandler(Integer id);
}
