package com.bhyf.controller.recharge;

import com.alibaba.fastjson.JSON;
import com.bhyf.common.component.PaginQo;
import com.bhyf.pojo.qo.enter.EnterQo;
import com.bhyf.pojo.qo.recharge.RechargeStatisticsQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.recharge.RechargeOneCardRecordService;
import com.bhyf.service.interf.recharge.RechargeStatisticsService;
import com.rising.common.component.BaseController;
import com.rising.common.page.Pagination;
import com.rising.common.util.DateUtil;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by admin on 2016/4/14.
 */
@Controller
@RequestMapping("/recharge_statistics")
public class RechargeStatisticsController extends BaseController {

    @Resource
    private RechargeOneCardRecordService rechargeOneCardRecordService;
    @Resource
    private RechargeStatisticsService rechargeStatisticsService;



    @RequestMapping("to_recharge_chart")
    public String toEnterList(HttpServletRequest request,
                              Model model){
        model.addAttribute("date",DateUtil.formatDateTime(new Date(),"yyyy-MM"));
        return "/recharge/recharge_chart.html";
    }

    @RequestMapping("get_chart_data")
    @ResponseBody
    public String findUserList(HttpServletRequest request,
                               @ModelAttribute RechargeStatisticsQo qo,
                             Model model){
        return  rechargeStatisticsService.statisticsRechargeChartData(qo);
    }


}
