package com.bhyf.service.interf.recharge;


import com.bhyf.model.recharge.RechargeComment;
import com.bhyf.pojo.command.recharge.UpdateRechargeCommentCommand;

/**
 * Created by admin on 2016/4/13.
 */
public interface RechargeCommentService {

    public RechargeComment findRechargeComment();


    String updateRechargeComment(UpdateRechargeCommentCommand command);
}
