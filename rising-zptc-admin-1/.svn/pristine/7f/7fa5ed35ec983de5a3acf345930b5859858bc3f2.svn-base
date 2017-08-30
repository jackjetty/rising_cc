package com.bhyf.model.recharge;

import com.bhyf.pojo.command.recharge.UpdateRechargeCommentCommand;
import com.rising.common.component.BaseModel;

/**
 * Created by admin on 2016/4/13.
 */
public class RechargeComment extends BaseModel{
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void create(UpdateRechargeCommentCommand command) {
        setComment(command.getComment());
    }
}
