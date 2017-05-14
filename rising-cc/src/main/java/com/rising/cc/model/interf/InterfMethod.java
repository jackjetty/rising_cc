package com.rising.cc.model.interf;

import com.rising.cc.common.component.BaseModel;
import com.rising.cc.pojo.command.interf.CreateInterfMethodCommand;
import com.rising.cc.pojo.command.interf.RemoveInterfMethodCommand;
import com.rising.cc.pojo.command.interf.UpdateInterfMethodCommand;

import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:05
 * 修改人：caizh
 * 修改时间：2015/11/17 10:05
 * 修改备注：
 */
public class InterfMethod extends BaseModel{
    private String method;
    private String methodName;
    private String namespace;
    private int dataType;
    private int useType;
    private int encoding;
    private Boolean isEnable;
    private String specification;
    private List<InterfInfo> interfInfoList;

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getUseType() {
        return useType;
    }

    public void setUseType(int useType) {
        this.useType = useType;
    }

    public int getEncoding() {
        return encoding;
    }

    public void setEncoding(int encoding) {
        this.encoding = encoding;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public List<InterfInfo> getInterfInfoList() {
        return interfInfoList;
    }

    public void setInterfInfoList(List<InterfInfo> interfInfoList) {
        this.interfInfoList = interfInfoList;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public boolean createInterfMethod(CreateInterfMethodCommand command) {
        if(StringUtils.isBlank(command.getMethod()))
            return false;
        setMethod(command.getMethod());
        setMethodName(command.getMethodName());
        setDataType(command.getDataType());
        setNamespace(command.getNamespace());
        setEncoding(command.getEncoding());
        setUseType(command.getUseType());
        setIsEnable(true);
        return true;
    }

    public boolean updateInterfMethod(UpdateInterfMethodCommand command) {
        if(command.getId() == null || command.getId() ==0)
            return false;
        setId(command.getId());
        setMethod(command.getMethod());
        setMethodName(command.getMethodName());
        setDataType(command.getDataType());
        setNamespace(command.getNamespace());
        setEncoding(command.getEncoding());
        setUseType(command.getUseType());
        return true;
    }

    public boolean removeInterfMethod(RemoveInterfMethodCommand command) {
        if(command.getId() == null || command.getId() ==0)
            return false;
        setId(command.getId());
        setIsEnable(false);
        return true;
    }
}
