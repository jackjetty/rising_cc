package com.rising.cc.pojo.command.service;

import com.rising.cc.common.component.BaseCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/9/11 14:34
 * 修改人：caizh
 * 修改时间：2015/9/11 14:34
 * 修改备注：
 */
public class RemoveServicesCommand extends BaseCommand {
    public void create(EditServicesCommand command) {
        setId(Integer.parseInt(command.getId()));
    }
}
