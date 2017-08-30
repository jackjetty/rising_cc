package com.bhyf.controller.recharge;

import com.bhyf.pojo.dto.enter.EnterStatisticsDto;
import com.bhyf.pojo.dto.recharge.RechargeOneCardRecordDetailDto;
import com.bhyf.pojo.dto.recharge.RechargeOneCardRecordDto;
import com.bhyf.pojo.qo.enter.EnterStatisticsQo;
import com.rising.common.component.PaginQo;
import com.bhyf.model.recharge.RechargeComment;
import com.bhyf.pojo.command.recharge.UpdateRechargeCommentCommand;
import com.bhyf.pojo.dto.recharge.RechargeMoneyDto;
import com.bhyf.pojo.qo.enter.EnterQo;
import com.bhyf.pojo.qo.recharge.RechargeOneCardRecordQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.recharge.RechargeCommentService;
import com.bhyf.service.interf.recharge.RechargeOneCardRecordService;
import com.rising.common.component.BaseController;
import com.rising.common.page.Pagination;
import com.rising.common.util.DateUtil;
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
@RequestMapping("/recharge_one_card_record")
public class RechargeOneCardRecordController extends BaseController {

    @Resource
    private RechargeOneCardRecordService rechargeOneCardRecordService;

    /**
     * @param request
     * @param command
     * @param model
     * @return
     * @description 跳转用户列表
     * @author caoy
     * @date 2015年8月11日 上午10:41:08
     */
    @RequestMapping("to_recharge_one_card_record")
    public String toEnterList(HttpServletRequest request,
                              Model model) {
        return "/recharge/recharge_one_card_record.html";
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
    @RequestMapping("recharge_one_card_record_list")
    @ResponseBody
    public DataGridResponse findUserList(HttpServletRequest request,
                                         @RequestParam(value="page",required=true) Integer pageNo,
                                         @RequestParam(value="rows",required=true) Integer pageSize,
                                         @ModelAttribute RechargeOneCardRecordQo qo,
                                         Model model) {
        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);
        rechargeOneCardRecordService.findRechargeOneCardRecordByPagination(pagination);
        return new DataGridResponse(pagination);
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
    @RequestMapping("find_recharge_one_card_record_detail")
    @ResponseBody
    public RechargeOneCardRecordDetailDto findUserList(HttpServletRequest request,
                                                       @ModelAttribute RechargeOneCardRecordQo qo,
                                                       Model model) {
        RechargeOneCardRecordDetailDto dto =   rechargeOneCardRecordService.findRechargeOneCardRecordDetailByQo(qo);
        return dto;
    }
    @RequestMapping("export_recharge_one_card_record_list")
    public void exportEnterRecordList(HttpServletRequest request, HttpServletResponse response,
                                      @ModelAttribute RechargeOneCardRecordQo qo
    ) {
        try {

            List<RechargeOneCardRecordDto> rechargeOneCardRecordDtoList = rechargeOneCardRecordService.findRechargeOneCardRecordByQo(qo);

            String filename = "充值记录报表.xlsx";
            filename = new String(filename.getBytes("GB2312"), "ISO-8859-1");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);

            ServletOutputStream out = response.getOutputStream();

            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("报名记录");
            HSSFRow row = sheet.createRow((int) 0);
            HSSFCellStyle style = wb.createCellStyle();
            style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

            HSSFCell cell = row.createCell((short) 0);
            cell.setCellValue("交易编号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 1);
            cell.setCellValue("手机号码");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("卡号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 3);
            cell.setCellValue("金额");
            cell.setCellStyle(style);
            cell = row.createCell((short) 4);
            cell.setCellValue("交易结果");
            cell.setCellStyle(style);
            cell = row.createCell((short) 5);
            cell.setCellValue("充值时间");
            cell.setCellStyle(style);
            cell = row.createCell((short) 6);
            cell.setCellValue("持卡人姓名");
            cell.setCellStyle(style);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

            for (int i = 0; i < rechargeOneCardRecordDtoList.size(); i++)
            {
                row = sheet.createRow((int) i + 1);
                RechargeOneCardRecordDto rechargeOneCardRecordDto = rechargeOneCardRecordDtoList.get(i);
                // 第四步，创建单元格，并设置值
                row.createCell( 0).setCellValue(rechargeOneCardRecordDto.getTradeNo());
                row.createCell( 1).setCellValue(rechargeOneCardRecordDto.getPayMobile());
                row.createCell( 2).setCellValue(rechargeOneCardRecordDto.getCardNo());
                row.createCell( 3).setCellValue(rechargeOneCardRecordDto.getRechMoney());
                if(rechargeOneCardRecordDto.getStatus()!= null) {
                    switch (rechargeOneCardRecordDto.getStatus()) {
                        case 0:
                            row.createCell(4).setCellValue("待支付");
                            break;
                        case 1:
                            row.createCell(4).setCellValue("成功");
                            break;
                        case 2:
                            row.createCell(4).setCellValue("失败");
                            break;
                    }
                }else{
                    row.createCell(4).setCellValue("");
                }
                row.createCell( 5).setCellValue(DateUtil.formatDateTime(rechargeOneCardRecordDto.getRechTime(),"yyyy-MM-dd HH:mm:ss"));
                row.createCell( 6).setCellValue(rechargeOneCardRecordDto.getCardHolder());

            }

            wb.write(out);
            out.flush();
            // 操作结束关闭文件
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
