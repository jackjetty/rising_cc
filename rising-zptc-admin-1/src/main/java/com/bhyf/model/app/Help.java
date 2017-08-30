package com.bhyf.model.app;

import com.bhyf.pojo.command.app.CreateHelpCommand;
import com.bhyf.pojo.command.app.UpdateHelpCommand;
import com.rising.common.component.BaseModel;

/**
 * Created by admin on 2016/4/18.
 */
public class Help extends BaseModel{

    private String title;

    private String content;

    private Integer sortNum;

    private Integer status;

    public Integer getSortNum() {
        return sortNum;
    }

    public void setSortNum(Integer sortNum) {
        this.sortNum = sortNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean create(CreateHelpCommand command) {

        setTitle(command.getTitle());
        setSortNum(command.getSortNum());
        setContent(command.getContent());
        setStatus(1);
        return true;
    }

    public boolean update(UpdateHelpCommand command) {
        setId(command.getId());
        setTitle(command.getTitle());
        setSortNum(command.getSortNum());
        setContent(command.getContent());
        return true;
    }
}
