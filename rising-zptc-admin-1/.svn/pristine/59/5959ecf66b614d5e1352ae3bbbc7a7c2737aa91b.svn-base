package com.bhyf.controller.enter;

import com.bhyf.model.enter.EnterRecord;
import com.bhyf.pojo.dto.enter.EnterRecordDetailDto;
import com.bhyf.pojo.dto.enter.EnterRecordDto;
import com.bhyf.service.interf.enter.EnterRecordService;
import com.bhyf.util.CSVUtils;
import com.bhyf.util.PoiUtil;
import com.rising.common.component.BaseController;
import com.rising.common.component.PaginQo;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.enter.EnterService;
import com.rising.common.page.Pagination;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author caoy
 * @description 用户管理控制器
 * @company 碧海银帆
 * @date 2015年8月3日 下午2:45:44
 */
@Controller
@RequestMapping("/enter_record")
public class EnterRecordController extends BaseController {

    @Resource
    private EnterService enterService;

    @Resource
    private EnterRecordService enterRecordService;


    /**
     * @param request
     * @param command
     * @param model
     * @return
     * @description 跳转用户列表
     * @author caoy
     * @date 2015年8月11日 上午10:41:08
     */
    @RequestMapping("to_enter_record_list")
    public String toEnterList(HttpServletRequest request,
                              Model model) {

        return "/enter/enter_record.html";
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
    @RequestMapping("enter_record_list")
    @ResponseBody
    public DataGridResponse findUserList(HttpServletRequest request,
                                         @RequestParam(value = "page", required = true) Integer pageNo,
                                         @RequestParam(value = "rows", required = true) Integer pageSize,
                                         @ModelAttribute EnterRecordQo qo,
                                         Model model) {

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);


        pagination = enterRecordService.findEnterRecordByPagination(pagination);
        return new DataGridResponse(pagination);
    }
    @RequestMapping("find_enter_record_detail")
    @ResponseBody
    public EnterRecordDetailDto findUserList(HttpServletRequest request,
                                         @RequestParam(value = "id", required = true) Integer id,
                                         Model model) {



        EnterRecordDetailDto dto = enterRecordService.findEnterRecordById(id);
        return dto;
    }

    @RequestMapping("export_enter_record_list")
    public void exportEnterRecordList(HttpServletRequest request, HttpServletResponse response,
                                      @ModelAttribute EnterRecordQo qo
    ) {
        try {

            List<EnterRecordDto> enterRecordDtoList = enterRecordService.findEnterRecordByQo(qo);

            String filename = "报名记录报表.xlsx";
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
            cell.setCellValue("缴费单号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("报名人");
            cell.setCellStyle(style);
            cell = row.createCell((short) 3);
            cell.setCellValue("考试类别");
            cell.setCellStyle(style);
            cell = row.createCell((short) 4);
            cell.setCellValue("报名人身份证号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 5);
            cell.setCellValue("学号");
            cell.setCellStyle(style);
            cell = row.createCell((short) 6);
            cell.setCellValue("缴费金额");
            cell.setCellStyle(style);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

            for (int i = 0; i < enterRecordDtoList.size(); i++)
            {
                row = sheet.createRow((int) i + 1);
                EnterRecordDto enterRecordDto = enterRecordDtoList.get(i);
                // 第四步，创建单元格，并设置值
                row.createCell( 0).setCellValue(enterRecordDto.getTradeNo());
                row.createCell(1).setCellValue(enterRecordDto.getPayNo());
                row.createCell(2).setCellValue(enterRecordDto.getUserName());
                switch (enterRecordDto.getEnterCategory()){
                    case 1:
                        row.createCell(3).setCellValue("报名缴费");
                        break;
                    case 2:
                        row.createCell(3).setCellValue("报名");
                        break;
                    case 3:
                        row.createCell(3).setCellValue("缴费");
                        break;
                }
                row.createCell(4).setCellValue(enterRecordDto.getIdNum());
                row.createCell(5).setCellValue(enterRecordDto.getStuNo());
                row.createCell(6).setCellValue(enterRecordDto.getPayMoney());
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
