package com.rising.cc.service.interf.interf;

import com.rising.common.page.Pagination;
import com.rising.cc.pojo.command.interf.CreateInterfMethodCommand;
import com.rising.cc.pojo.command.interf.RemoveInterfMethodCommand;
import com.rising.cc.pojo.command.interf.UpdateInterfMethodCommand;
import com.rising.cc.pojo.dto.interf.InterfManagerDto;
import com.rising.cc.pojo.dto.interf.InterfMethodDto;
import com.rising.cc.pojo.qo.interf.InterfMethodQo;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:57
 * 修改人：caizh
 * 修改时间：2015/11/17 10:57
 * 修改备注：
 */
public interface InterfMethodService {
    public Pagination findInterfMethodByPagination(Pagination pagination);
    public String saveInterfMethod(CreateInterfMethodCommand createInterfMethodCommand);
    public String updateInterfMethod(UpdateInterfMethodCommand updateInterfMethodCommand);
    public String removeInterfMethod(RemoveInterfMethodCommand removeInterfMethodCommand);

    public List<InterfMethodDto> findInterfMethodByQo(InterfMethodQo interfMethodQo);
}
