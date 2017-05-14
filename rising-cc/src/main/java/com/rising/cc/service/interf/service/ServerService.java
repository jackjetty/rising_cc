package com.rising.cc.service.interf.service;

import com.rising.common.page.Pagination;
import com.rising.cc.model.service.Server;
import com.rising.cc.pojo.command.service.CreateServerCommand;
import com.rising.cc.pojo.command.service.RemoveServerCommand;
import com.rising.cc.pojo.command.service.UpdateServerCommand;
import com.rising.cc.pojo.dto.service.ServerDto;
import com.rising.cc.pojo.qo.service.ServerQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 11:24
 * 修改人：caizh
 * 修改时间：2015/9/11 11:24
 * 修改备注：
 */
public interface ServerService {
    public Pagination findServerByPagination(Pagination pagination);
    public List<ServerDto> findServerByQo(ServerQo qo);


    public String saveServer(CreateServerCommand command);
    public String updateServer(UpdateServerCommand command);
    public String removeServer(RemoveServerCommand command);
}
