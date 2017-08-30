package com.bhyf.controller.enter;

import com.bhyf.pojo.dto.enter.BestPayRecordDto;
import com.bhyf.pojo.dto.enter.EnterBestPayRecordDto;
import com.bhyf.pojo.qo.enter.BestPayRecordQo;
import com.bhyf.pojo.qo.enter.EnterBestPayRecordQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.enter.BestPayRecordService;
import com.bhyf.service.interf.enter.EnterBestPayRecordService;
import com.rising.common.component.BaseController;
import com.rising.common.component.PaginQo;
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
@RequestMapping("/best_pay_record")
public class BestPayRecordController extends BaseController {


    @Resource
    private BestPayRecordService bestPayRecordService;


    /**
     * @param request
     * @param command
     * @param model
     * @return
     * @description 跳转用户列表
     * @author caoy
     * @date 2015年8月11日 上午10:41:08
     */
    @RequestMapping("to_best_pay_record_list")
    public String toEnterList(HttpServletRequest request,
                              Model model) {

        return "/enter/best_pay_record.html";
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
    @RequestMapping("best_pay_record_list")
    @ResponseBody
    public DataGridResponse findUserList(HttpServletRequest request,
                                         @RequestParam(value = "page", required = true) Integer pageNo,
                                         @RequestParam(value = "rows", required = true) Integer pageSize,
                                         @ModelAttribute BestPayRecordQo qo,
                                         Model model) {

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = bestPayRecordService.findBestPayRecordPagination(pagination);
        return new DataGridResponse(pagination);
    }

    @RequestMapping("export_best_pay_record_list")
    public void exportEnterBestPayRecordList(HttpServletRequest request, HttpServletResponse response,
                                      @ModelAttribute BestPayRecordQo qo
    ) {
        try {

            List<BestPayRecordDto> bestPayRecordDtoList = bestPayRecordService.findBestPayRecordByQo(qo);

            String filename = "翼支付订单流水记录.xlsx";
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
            cell.setCellValue("翼支付交易单号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 1);
            cell.setCellValue("翼支付网关平台交易流水号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("交易金额");
            cell.setCellStyle(style);
            cell = row.createCell((short) 3);
            cell.setCellValue("交易日期");
            cell.setCellStyle(style);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

            for (int i = 0; i < bestPayRecordDtoList.size(); i++)
            {
                row = sheet.createRow((int) i + 1);
                BestPayRecordDto enterBestPayRecord = bestPayRecordDtoList.get(i);
                // 第四步，创建单元格，并设置值
                row.createCell( 0).setCellValue(enterBestPayRecord.getTradeNo());
                row.createCell(1).setCellValue(enterBestPayRecord.getTranSeq());
                row.createCell(2).setCellValue(enterBestPayRecord.getMoney());
                row.createCell(3).setCellValue(DateUtil.formatDate(enterBestPayRecord.getTranDate()));

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
