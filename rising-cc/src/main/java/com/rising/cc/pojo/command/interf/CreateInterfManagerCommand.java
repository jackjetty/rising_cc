package com.rising.cc.pojo.command.interf;

import com.rising.cc.common.component.BaseCommand;
import com.rising.cc.model.project.Engineering;

import javax.xml.crypto.dsig.CanonicalizationMethod;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/12/16 15:25
 * 修改人：caizh
 * 修改时间：2015/12/16 15:25
 * 修改备注：
 */
public class CreateInterfManagerCommand extends BaseCommand{
    private Integer envirId;
    private Integer enginId;
    private Integer interfMethodId;

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public Integer getEnginId() {
        return enginId;
    }

    public void setEnginId(Integer enginId) {
        this.enginId = enginId;
    }

    public Integer getInterfMethodId() {
        return interfMethodId;
    }

    public void setInterfMethodId(Integer interfMethodId) {
        this.interfMethodId = interfMethodId;
    }

    public void createCommand(EditInterfManagerCommand command) {
        setEnvirId(command.getEnvirId());
        setEnginId(command.getEnginId());
        setInterfMethodId(command.getInterfMethodId());
    }
}
