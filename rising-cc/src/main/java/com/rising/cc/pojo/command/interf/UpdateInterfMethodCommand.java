package com.rising.cc.pojo.command.interf;

import com.rising.cc.common.component.BaseCommand;

/**
 * 项目名称：bhyf-cc
 * 类描述：
 * 创建人：caizh
 * 创建时间：2015/11/17 10:05
 * 修改人：caizh
 * 修改时间：2015/11/17 10:05
 * 修改备注：
 */
public class UpdateInterfMethodCommand extends BaseCommand{
    private String method;
    private String methodName;
    private String namespace;
    private Integer dataType;
    private Integer useType;
    private Integer encoding;

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


    public void createCommand(EditInterfMethodCommand command) {
        setId(Integer.valueOf(command.getId()));
        setMethod(command.getMethod());
        setMethodName(command.getMethodName());
        setDataType(command.getDataType());
        setNamespace(command.getNamespace());
        setEncoding(command.getEncoding());
        setUseType(command.getUseType());
    }
}
