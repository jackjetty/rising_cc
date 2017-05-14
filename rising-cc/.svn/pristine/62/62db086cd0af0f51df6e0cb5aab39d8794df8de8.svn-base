package com.rising.cc.service.impl.service;

import com.rising.common.page.Pagination;
import com.google.common.collect.Lists;
import com.rising.cc.dao.service.ServerDao;
import com.rising.cc.model.service.Server;
import com.rising.cc.pojo.command.service.CreateServerCommand;
import com.rising.cc.pojo.command.service.RemoveServerCommand;
import com.rising.cc.pojo.command.service.UpdateServerCommand;
import com.rising.cc.pojo.dto.service.ServerDto;
import com.rising.cc.pojo.qo.service.ServerQo;
import com.rising.cc.service.interf.service.ServerService;
import com.rising.cc.util.EntityConvertUtils;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 11:25
 * 修改人：caizh
 * 修改时间：2015/9/11 11:25
 * 修改备注：
 */
@Service
public class ServerServiceimpl implements ServerService {

    @Resource
    private ServerDao serverDao;

    @Override
    public Pagination findServerByPagination(Pagination pagination) {
        List<Server> serverList = serverDao.findServerByPagination(pagination);
        List<ServerDto> serverDtoList = Lists.newArrayList();
        Integer totalCount = serverDao.countServerByPagination(pagination);
        try{
            serverDtoList = EntityConvertUtils.convertEntityToDtoList(serverList, ServerDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        pagination.setList(serverDtoList);
        pagination.setTotalCount(totalCount);
        return pagination;
    }

    @Override
    public List<ServerDto> findServerByQo(ServerQo qo) {
        List<Server> serverList = serverDao.findServerByQo(qo);
        List<ServerDto> serverDtoList = Lists.newArrayList();
        try{
            serverDtoList = EntityConvertUtils.convertEntityToDtoList(serverList, ServerDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverDtoList;
    }

    @Override
    public String saveServer(CreateServerCommand command) {
        Server server = new Server();
        server.create(command);
        serverDao.saveServer(server);
        return "";
    }

    @Override
    public String updateServer(UpdateServerCommand command) {
        Server server = new Server();
        server.update(command);
        serverDao.updateServer(server);
        return "";
    }

    @Override
    public String removeServer(RemoveServerCommand command) {
        serverDao.removeServer(command.getId());
        return "";
    }
}
