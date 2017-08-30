package com.bhyf.controller.recharge;

import com.bhyf.pojo.dto.enter.BestPayRecordDto;
import com.bhyf.pojo.dto.recharge.OneCardRecordDto;
import com.bhyf.pojo.qo.enter.BestPayRecordQo;
import com.bhyf.pojo.qo.recharge.OneCardRecordQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.enter.BestPayRecordService;
import com.bhyf.service.interf.recharge.OneCardRecordService;
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
@RequestMapping("/one_card_record")
public class OneCardRecordController extends BaseController {


    @Resource
    private OneCardRecordService oneCardRecordService;


    /**
     * @param request
     * @param command
     * @param model
     * @return
     * @description 跳转用户列表
     * @author caoy
     * @date 2015年8月11日 上午10:41:08
     */
    @RequestMapping("to_one_card_record_list")
    public String toEnterList(HttpServletRequest request,
                              Model model) {

        return "/recharge/one_card_record.html";
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
    @RequestMapping("one_card_record_list")
    @ResponseBody
    public DataGridResponse findUserList(HttpServletRequest request,
                                         @RequestParam(value = "page", required = true) Integer pageNo,
                                         @RequestParam(value = "rows", required = true) Integer pageSize,
                                         @ModelAttribute OneCardRecordQo qo,
                                         Model model) {

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);

        pagination = oneCardRecordService.findOneCardRecordPagination(pagination);
        return new DataGridResponse(pagination);
    }

    @RequestMapping("export_one_card_record_list")
    public void exportEnterBestPayRecordList(HttpServletRequest request, HttpServletResponse response,
                                      @ModelAttribute OneCardRecordQo qo
    ) {
        try {

            List<OneCardRecordDto> oneCardRecordDtoList = oneCardRecordService.findOneCardRecordByQo(qo);

            String filename = "一卡通订单流水记录.xlsx";
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
            cell.setCellValue("一卡通充值交易流水号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 1);
            cell.setCellValue("卡户个人编号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("交易金额");
            cell.setCellStyle(style);
            cell = row.createCell((short) 3);
            cell.setCellValue("交易日期");
            cell.setCellStyle(style);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

            for (int i = 0; i < oneCardRecordDtoList.size(); i++)
            {
                row = sheet.createRow((int) i + 1);
                OneCardRecordDto oneCardRecordDto = oneCardRecordDtoList.get(i);
                // 第四步，创建单元格，并设置值
                row.createCell( 0).setCellValue(oneCardRecordDto.getStaSID());
                row.createCell(1).setCellValue(oneCardRecordDto.getPerCode());
                row.createCell(2).setCellValue(oneCardRecordDto.getMonDeal());
                row.createCell(3).setCellValue(DateUtil.formatDate(oneCardRecordDto.getDealTime()));

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
