package com.rising.cc.model.interf;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.model.project.Engineering;
import com.rising.cc.pojo.command.interf.CreateInterfManagerCommand;
import com.rising.cc.pojo.command.interf.DeleteInterfManagerCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:15
 * 修改人：caizh
 * 修改时间：2015/11/17 10:15
 * 修改备注：
 */
public class InterfManager extends BaseModel{
    private Integer envirId;
    private Engineering engineering;
    private InterfMethod interfMethod;

    public Integer getEnvirId() {
        return envirId;
    }

    public void setEnvirId(Integer envirId) {
        this.envirId = envirId;
    }

    public Engineering getEngineering() {
        return engineering;
    }

    public void setEngineering(Engineering engineering) {
        this.engineering = engineering;
    }

    public InterfMethod getInterfMethod() {
        return interfMethod;
    }

    public void setInterfMethod(InterfMethod interfMethod) {
        this.interfMethod = interfMethod;
    }

    public boolean createInterfManager(CreateInterfManagerCommand command) {
        engineering = new Engineering();
        engineering.setId(command.getEnginId());
        interfMethod = new InterfMethod();
        interfMethod.setId(command.getInterfMethodId());
        setEnvirId(command.getEnvirId());
        setEngineering(engineering);
        setInterfMethod(interfMethod);
        return true;
    }

    public boolean deleteInterfManager(DeleteInterfManagerCommand command) {
        setId(command.getId());
        return true;
    }
}
