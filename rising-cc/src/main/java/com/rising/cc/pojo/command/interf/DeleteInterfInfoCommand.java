package com.rising.cc.pojo.command.interf;

import com.rising.cc.common.component.BaseCommand;
import com.rising.cc.common.component.BaseModel;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:01
 * 修改人：caizh
 * 修改时间：2015/11/17 10:01
 * 修改备注：
 */
public class DeleteInterfInfoCommand extends BaseCommand{

    public void createCommand(EditInterfInfoCommand command) {
        setId(Integer.valueOf(command.getId()));
    }
}
