package com.bhyf.controller.recharge;

import com.bhyf.pojo.command.recharge.CreateRechargeMoneyCommand;
import com.bhyf.pojo.command.recharge.UpdateRechargeMoneyStatusCommand;
import com.bhyf.pojo.dto.enter.EnterStatisticsDto;
import com.bhyf.pojo.dto.recharge.RechargeMoneyDto;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.bhyf.pojo.qo.enter.EnterStatisticsQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.enter.EnterStatisticsService;
import com.bhyf.service.interf.recharge.RechargeMoneyService;
import com.rising.common.component.BaseController;
import com.rising.common.component.PaginQo;
import com.rising.common.page.Pagination;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author caoy
 * @description 用户管理控制器
 * @company 碧海银帆
 * @date 2015年8月3日 下午2:45:44
 */
@Controller
@RequestMapping("/recharge_money")
public class RechargeMoneyController extends BaseController {

    @Resource
    private RechargeMoneyService rechargeMoneyService;

    /**
     * @param request
     * @param command
     * @param model
     * @return
     * @description 跳转用户列表
     * @author caoy
     * @date 2015年8月11日 上午10:41:08
     */
    @RequestMapping("to_recharge_money_list")
    public String toEnterList(HttpServletRequest request,
                              Model model) {

        return "/recharge/recharge_money.html";
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
    @RequestMapping("recharge_money_list")
    @ResponseBody
    public DataGridResponse findUserList(HttpServletRequest request,
                                         Model model) {
        List<RechargeMoneyDto> rechargeMoneyDtoList = rechargeMoneyService.findRechargeMoney();
        return new DataGridResponse(rechargeMoneyDtoList.size(),rechargeMoneyDtoList);
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
    @RequestMapping("save_recharge_money")
    @ResponseBody
    public String saveRechargeMoney(HttpServletRequest request,
                                         @ModelAttribute CreateRechargeMoneyCommand command,
                                         Model model) {
        String result =  rechargeMoneyService.saveRechargeMoney(command);
        return result;
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
    @RequestMapping("update_recharge_money_status")
    @ResponseBody
    public String updateRechargeMoneyStatus(HttpServletRequest request,
                                         @ModelAttribute UpdateRechargeMoneyStatusCommand command,
                                         Model model) {
        String result =  rechargeMoneyService.updateRechargeMoneyStatus(command);
        return result;
    }

}
