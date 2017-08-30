package com.bhyf.controller.recharge;

import com.bhyf.model.recharge.RechargeComment;
import com.bhyf.pojo.command.recharge.CreateRechargeMoneyCommand;
import com.bhyf.pojo.command.recharge.UpdateRechargeCommentCommand;
import com.bhyf.pojo.command.recharge.UpdateRechargeMoneyStatusCommand;
import com.bhyf.pojo.dto.recharge.RechargeMoneyDto;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.recharge.RechargeCommentService;
import com.bhyf.service.interf.recharge.RechargeMoneyService;
import com.rising.common.component.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author caoy
 * @description 用户管理控制器
 * @company 碧海银帆
 * @date 2015年8月3日 下午2:45:44
 */
@Controller
@RequestMapping("/recharge_comment")
public class RechargeCommentController extends BaseController {

    @Resource
    private RechargeCommentService rechargeCommentService;

    /**
     * @param request
     * @param command
     * @param model
     * @return
     * @description 跳转用户列表
     * @author caoy
     * @date 2015年8月11日 上午10:41:08
     */
    @RequestMapping("to_recharge_comment")
    public String toEnterList(HttpServletRequest request,
                              Model model) {
        RechargeComment rechargeComment = rechargeCommentService.findRechargeComment();
        model.addAttribute("rechargeComment",rechargeComment);
        return "/recharge/recharge_comment.html";
    }

    /**
     * @param request
     * @param command
     * @param model
     * @return
     * @description 加载用户列表
     * @author caoy
     * @date 2015年8月11日 上午10:41:08
     */
    @RequestMapping("update_recharge_comment")
    @ResponseBody
    public String updateRechargeMoneyStatus(HttpServletRequest request,
                                         @ModelAttribute UpdateRechargeCommentCommand command,
                                         Model model) {
        return rechargeCommentService.updateRechargeComment(command);
    }

}
