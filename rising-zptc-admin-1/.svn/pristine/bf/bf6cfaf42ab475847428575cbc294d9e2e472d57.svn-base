package com.bhyf.model.enter;

import com.bhyf.common.component.BaseModel;
import com.bhyf.pojo.command.enter.CreateEnterCommand;
import com.bhyf.pojo.command.enter.RemoveEnterCommand;
import com.bhyf.pojo.command.enter.UpdateEnterCommand;
import com.bhyf.pojo.command.enter.UpdateEnterStatusCommand;
import com.rising.common.util.DateUtil;
import com.rising.common.util.PropertiesUtils;
import com.rising.common.util.StringUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.Properties;

/**
 * Created by admin on 2016/4/11.
 */
public class Enter extends BaseModel {

    private static Properties properties= PropertiesUtils.getProps("/properties/other.properties");
    private static String basePicturePath = properties.getProperty("enter_picture_path");

    /*
    报名考试名称
     */
    private String enterExamName;
    /*
    考试编号
     */
    private String enterExamNum;
    /*
    考试分类：1：报名缴费；2：报名；3：缴费；
     */
    private Integer enterCategory;
    /*
    用户分类:0：老师；1：学生；2：校外人员；
     */
    private Integer userCategory;
    /*
    开始时间
     */
    private Date beginTime;
    /*
    结束时间
     */
    private Date endTime;
    /*
    考试报名图片
     */
    private String imageUrl;
    /*
    考试说明
     */
    private String decscription;
    /*
    可报名人数
     */
    private Integer enterNum;
    /*
    已报名人数
     */
    private Integer enterSumNum;
    /*
    考试地点
     */
    private String enterPlace;
    /*
    考试费用
     */
    private Double enterMoney;
    /*
    状态：0：失效；1：有效；80：删除；
     */
    private Integer status;

    public String getEnterExamNum() {
        return enterExamNum;
    }

    public void setEnterExamNum(String enterExamNum) {
        this.enterExamNum = enterExamNum;
    }

    public String getEnterExamName() {
        return enterExamName;
    }

    public void setEnterExamName(String enterExamName) {
        this.enterExamName = enterExamName;
    }

    public Integer getEnterCategory() {
        return enterCategory;
    }

    public void setEnterCategory(Integer enterCategory) {
        this.enterCategory = enterCategory;
    }

    public Integer getUserCategory() {
        return userCategory;
    }

    public void setUserCategory(Integer userCategory) {
        this.userCategory = userCategory;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDecscription() {
        return decscription;
    }

    public void setDecscription(String decscription) {
        this.decscription = decscription;
    }

    public Integer getEnterNum() {
        return enterNum;
    }

    public void setEnterNum(Integer enterNum) {
        this.enterNum = enterNum;
    }

    public Integer getEnterSumNum() {
        return enterSumNum;
    }

    public void setEnterSumNum(Integer enterSumNum) {
        this.enterSumNum = enterSumNum;
    }

    public String getEnterPlace() {
        return enterPlace;
    }

    public void setEnterPlace(String enterPlace) {
        this.enterPlace = enterPlace;
    }

    public Double getEnterMoney() {
        return enterMoney;
    }

    public void setEnterMoney(Double enterMoney) {
        this.enterMoney = enterMoney;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean create(CreateEnterCommand command) {
        setEnterExamName(command.getEnterExamName());
        setEnterExamNum(command.getEnterExamNum());
        setEnterCategory(command.getEnterCategory());
        setUserCategory(command.getUserCategory());
        setBeginTime(DateUtil.parseDateTime(command.getBeginTime(),"yyyy-MM-dd"));
        setEndTime(DateUtil.parseDateTime(command.getEndTime(),"yyyy-MM-dd"));
        setEnterMoney(command.getEnterMoney());
        setEnterNum(command.getEnterNum());
        setDecscription(command.getDecscription());
        setEnterPlace(command.getEnterPlace());
        setImageUrl(basePicturePath +command.getImageUrl());
        setStatus(1);
        setEnterSumNum(0);
        setCreateTime(new Date());
        return true;
    }

    public boolean update(UpdateEnterCommand command) {
        setEnterExamName(command.getEnterExamName());
        setEnterExamNum(command.getEnterExamNum());
        setEnterCategory(command.getEnterCategory());
        setUserCategory(command.getUserCategory());
        setBeginTime(DateUtil.parseDateTime(command.getBeginTime(),"yyyy-MM-dd"));
        setEndTime(DateUtil.parseDateTime(command.getEndTime(),"yyyy-MM-dd"));
        setEnterMoney(command.getEnterMoney());
        setEnterNum(command.getEnterNum());
        setDecscription(command.getDecscription());
        setEnterPlace(command.getEnterPlace());
        if(StringUtils.isNotBlank(command.getImageUrl())){
            setImageUrl(basePicturePath+command.getImageUrl());
        }
        setId(command.getEnterId());
        return true;
    }

    public boolean updateStatus(UpdateEnterStatusCommand command) {
        setId(command.getId());
        setStatus(command.getStatus());
        return true;
    }

    public void remove(RemoveEnterCommand command) {
        setId(command.getId());
        setStatus(80);
    }
}
