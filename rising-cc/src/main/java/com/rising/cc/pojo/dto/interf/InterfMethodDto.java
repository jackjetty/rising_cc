package com.rising.cc.pojo.dto.interf;

import com.rising.cc.common.component.BaseModel;

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
public class InterfMethodDto extends BaseModel{
    private String method;
    private String methodName;
    private String namespace;
    private int dataType;
    private int useType;
    private int encoding;
    private Boolean isEnable;
    private String specification;
    private List<InterfInfoDto> interfInfoList;

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

    public List<InterfInfoDto> getInterfInfoList() {
        return interfInfoList;
    }

    public void setInterfInfoList(List<InterfInfoDto> interfInfoList) {
        this.interfInfoList = interfInfoList;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }
}