package com.bhyf.pojo.command.app;

import com.rising.common.component.BaseCommand;

/**
 * Created by admin on 2016/4/18.
 */
public class CreateHelpCommand extends BaseCommand{
    private String title;

    private String content;

    private Integer sortNum;

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
}
