package com.bhyf.controller.recharge;

import com.bhyf.pojo.command.recharge.UpdateOneCardBestPayStatisticsCommand;
import com.bhyf.pojo.qo.recharge.RechargeStatisticsQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.recharge.OneCardBestPayStatisticsService;
import com.rising.common.component.BaseController;
import com.rising.common.component.PaginQo;
import com.rising.common.page.Pagination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author caoy
 * @description 用户管理控制器
 * @company 碧海银帆
 * @date 2015年8月3日 下午2:45:44
 */
@Controller
@RequestMapping("/one_card_best_pay_statistics")
public class OneCardBestPayStatisticsController extends BaseController {


    @Resource
    private OneCardBestPayStatisticsService oneCardBestPayStatisticsService;


    /**
     * @param request
     * @param command
     * @param model
     * @return
     * @description 跳转用户列表
     * @author caoy
     * @date 2015年8月11日 上午10:41:08
     */
    @RequestMapping("to_one_card_best_pay_statistics_list")
    public String toEnterList(HttpServletRequest request,
                              Model model) {

        return "/recharge/one_card_best_pay_statistics.html";
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
    @RequestMapping("one_card_best_pay_statistics_list")
    @ResponseBody
    public DataGridResponse findUserList(HttpServletRequest request,
                                         @RequestParam(value = "page", required = true) Integer pageNo,
                                         @RequestParam(value = "rows", required = true) Integer pageSize,
                                         @ModelAttribute RechargeStatisticsQo qo,
                                         Model model) {

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = oneCardBestPayStatisticsService.findOneCardBestPayStatisticsPagination(pagination);
        return new DataGridResponse(pagination);
    }
    @RequestMapping("statistics_data")
    @ResponseBody
    public String findUserList(HttpServletRequest request,
                                         @RequestParam(value = "id", required = true) Integer id,
                                         Model model) {
        return oneCardBestPayStatisticsService.statisticsData(id);
    }
    @RequestMapping("update_one_card_best_pay_statistics")
    @ResponseBody
    public String findUserList(HttpServletRequest request,
                                        @ModelAttribute UpdateOneCardBestPayStatisticsCommand command,
                                         Model model) {
        return oneCardBestPayStatisticsService.updateOneCardBestPayStatistics(command);
    }
}
