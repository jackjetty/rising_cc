package com.bhyf.service.impl.recharge;

import com.bhyf.dao.recharge.RechargeCommentDao;
import com.bhyf.model.recharge.RechargeComment;
import com.bhyf.pojo.command.recharge.UpdateRechargeCommentCommand;
import com.bhyf.service.interf.recharge.RechargeCommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by admin on 2016/4/13.
 */
@Service
public class RechargeCommentServiceImpl implements RechargeCommentService {

    @Resource
    private RechargeCommentDao rechargeCommentDao;

    @Override
    public RechargeComment findRechargeComment() {

        rechargeCommentDao.findRechargeComment();

        return rechargeCommentDao.findRechargeComment();
    }

    @Override
    public String updateRechargeComment(UpdateRechargeCommentCommand command) {
        RechargeComment rechargeComment = new RechargeComment();
        rechargeComment.create(command);
        rechargeCommentDao.updateRechargeComment(rechargeComment);
        return "success";
    }
}
