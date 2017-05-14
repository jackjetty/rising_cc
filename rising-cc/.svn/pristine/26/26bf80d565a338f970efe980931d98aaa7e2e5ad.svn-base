package com.rising.cc.dao.service;

import com.rising.common.page.Pagination;
import com.rising.cc.model.service.Server;
import com.rising.cc.pojo.qo.service.ServerQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 11:20
 * 修改人：caizh
 * 修改时间：2015/9/11 11:20
 * 修改备注：
 */
public interface ServerDao {
    public List<Server> findServerByPagination(Pagination pagination);
    public Integer countServerByPagination(Pagination pagination);
    public List<Server> findServerByQo(ServerQo qo);

    public Integer saveServer(Server server);
    public Integer updateServer(Server server);
    public Integer removeServer(Integer id);
}
