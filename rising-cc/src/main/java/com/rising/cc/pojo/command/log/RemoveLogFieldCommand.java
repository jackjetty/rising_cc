package com.rising.cc.pojo.command.log;

import com.rising.cc.common.component.BaseCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/8/29 10:10
 * 修改人：caizh
 * 修改时间：2015/8/29 10:10
 * 修改备注：
 */
public class RemoveLogFieldCommand extends BaseCommand{

    public void createCommand(EditLogFieldCommand command) {
        setId(Integer.parseInt(command.getId()));
    }
}
