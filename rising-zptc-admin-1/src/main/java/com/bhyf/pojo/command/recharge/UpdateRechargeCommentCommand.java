package com.bhyf.pojo.command.recharge;

import com.rising.common.component.BaseCommand;

/**
 * Created by admin on 2016/4/13.
 */
public class UpdateRechargeCommentCommand extends BaseCommand {

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
