package com.rising.cc.service.interf.queue;

import com.rising.common.page.Pagination;
import com.rising.cc.model.queue.Handler;
import com.rising.cc.pojo.command.queue.CreateHandlerCommand;
import com.rising.cc.pojo.command.queue.DeleteHandlerCommand;
import com.rising.cc.pojo.command.queue.UpdateHandlerCommand;
import com.rising.cc.pojo.dto.queue.HandlerDto;
import com.rising.cc.pojo.qo.queue.HandlerQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/1 10:54
 * 修改人：caizh
 * 修改时间：2015/9/1 10:54
 * 修改备注：
 */
public interface HandlerService {
    public Pagination findHandlerByPagination(Pagination pagination);

    public List<HandlerDto> findHandlerByQo(HandlerQo qo);

//    public String updateHandler(UpdateHandlerCommand command);

    public String saveHandler(CreateHandlerCommand command);

    public String deleteHandler(DeleteHandlerCommand command);
}
