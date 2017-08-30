package com.bhyf.controller.enter;

import com.bhyf.model.enter.BestPayRecord;
import com.bhyf.pojo.command.enter.UpdateEnterStatisticsCommand;
import com.bhyf.pojo.dto.enter.EnterRecordDetailDto;
import com.bhyf.pojo.dto.enter.EnterRecordDto;
import com.bhyf.pojo.dto.enter.EnterStatisticsDto;
import com.bhyf.pojo.qo.enter.EnterRecordQo;
import com.bhyf.pojo.qo.enter.EnterStatisticsQo;
import com.bhyf.pojo.response.DataGridResponse;
import com.bhyf.service.interf.enter.BestPayRecordService;
import com.bhyf.service.interf.enter.EnterRecordService;
import com.bhyf.service.interf.enter.EnterService;
import com.bhyf.service.interf.enter.EnterStatisticsService;
import com.rising.common.component.BaseController;
import com.rising.common.component.PaginQo;
import com.rising.common.page.Pagination;
import com.rising.common.util.DateUtil;
import com.rising.common.util.FileUtils;
import com.rising.common.util.JsonUtil;
import com.rising.common.util.PathUtil;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

/**
 * @author caoy
 * @description 用户管理控制器
 * @company 碧海银帆
 * @date 2015年8月3日 下午2:45:44
 */
@Controller
@RequestMapping("/enter_statistics")
public class EnterStatisticsController extends BaseController {

    @Resource
    private EnterStatisticsService enterStatisticsService;
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
    @RequestMapping("to_enter_statistics_list")
    public String toEnterList(HttpServletRequest request,
                              Model model) {

        return "/enter/enter_statistics.html";
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
    @RequestMapping("enter_statistics_list")
    @ResponseBody
    public DataGridResponse findUserList(HttpServletRequest request,
                                         @RequestParam(value = "page", required = true) Integer pageNo,
                                         @RequestParam(value = "rows", required = true) Integer pageSize,
                                         @ModelAttribute EnterStatisticsQo qo,
                                         Model model) {

        PaginQo paginQo = new PaginQo();
        paginQo.setPageNo(pageNo);
        paginQo.setPageSize(pageSize);

        Pagination pagination = this.createPagination(paginQo, qo);


        pagination = enterStatisticsService.findEnterStatisticsByPagination(pagination);
        return new DataGridResponse(pagination);
    }

    @RequestMapping("export_enter_statistics_list")
    public void exportEnterRecordList(HttpServletRequest request, HttpServletResponse response,
                                      @ModelAttribute EnterStatisticsQo qo
    ) {
        try {

            List<EnterStatisticsDto> enterRecordDtoList = enterStatisticsService.findEnterStatisticsByQo(qo);

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
            cell.setCellValue("报名项目名称");
            cell.setCellStyle(style);
            cell = row.createCell((short) 1);
            cell.setCellValue("报名类别");
            cell.setCellStyle(style);
            cell = row.createCell((short) 2);
            cell.setCellValue("报考名额");
            cell.setCellStyle(style);
            cell = row.createCell((short) 3);
            cell.setCellValue("报名人数");
            cell.setCellStyle(style);
            cell = row.createCell((short) 4);
            cell.setCellValue("考试金额");
            cell.setCellStyle(style);
            cell = row.createCell((short) 5);
            cell.setCellValue("收费总计");
            cell.setCellStyle(style);
            cell = row.createCell((short) 6);
            cell.setCellValue("翼支付收账总计");
            cell.setCellStyle(style);

            // 第五步，写入实体数据 实际应用中这些数据从数据库得到，

            for (int i = 0; i < enterRecordDtoList.size(); i++)
            {
                row = sheet.createRow((int) i + 1);
                EnterStatisticsDto enterStatisticsDto = enterRecordDtoList.get(i);
                // 第四步，创建单元格，并设置值
                row.createCell( 0).setCellValue(enterStatisticsDto.getEnterExamName());
                switch (enterStatisticsDto.getEnterCategory()){
                    case 1:
                        row.createCell(1).setCellValue("报名缴费");
                        break;
                    case 2:
                        row.createCell(1).setCellValue("报名");
                        break;
                    case 3:
                        row.createCell(1).setCellValue("缴费");
                        break;
                }
                row.createCell(2).setCellValue(enterStatisticsDto.getEnterNum());
                row.createCell(3).setCellValue(enterStatisticsDto.getEnterSumNum());
                row.createCell(4).setCellValue(enterStatisticsDto.getEnterMoney());
                row.createCell(5).setCellValue(enterStatisticsDto.getEnterSumMoney());
                row.createCell(6).setCellValue(enterStatisticsDto.getEnterBestPaySumMoney());
                row.createCell(6).setCellValue(enterStatisticsDto.getReconciliation());

            }

            wb.write(out);
            out.flush();
            // 操作结束关闭文件
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 导入对账数据
     * @param request
     * @param uploadFile
     * @param model
     * @return
     */
    @RequestMapping(value="/upload_file")
    @ResponseBody
    public String uploadFile(HttpServletRequest request,
                             @RequestParam("uploadFile") MultipartFile uploadFile,
                             Model model) throws IOException {


        BufferedReader reader = null;

        String destFileName = uploadFile.getOriginalFilename();
        List<BestPayRecord> bestPayRecordList = new ArrayList<>();
        File file = null;
        int line = 1;
        try {
            destFileName= FileUtils.getFileNameString(destFileName);//字符过滤
            destFileName=System.currentTimeMillis()+"_"+destFileName;
            file = new File(destFileName);
            uploadFile.transferTo(file);
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            Date date = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if(line == 1){
                    date = DateUtil.parseDateTime(tempString.split("\\|")[1],"yyyyMMdd");
                }else{
                    BestPayRecord bestPayRecord = new BestPayRecord(tempString,date);
                    bestPayRecordList.add(bestPayRecord);
                }
                line++;
            }
            reader.close();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        bestPayRecordService.saveBestPayRecordBatch(bestPayRecordList);
        Map<String, Object> map=new HashMap<String, Object>();
        map.put("status", "success");
        map.put("num", bestPayRecordList.size());
        return JsonUtil.parseObject(map, false);
    }

    @RequestMapping(value="/statistics_data")
    @ResponseBody
    public String statisticsData(HttpServletRequest request,
                             @RequestParam("id")Integer  enterId,
                             Model model){

        return enterStatisticsService.statisticsData(enterId);
    }
    @RequestMapping(value="/update_enter_statistics")
    @ResponseBody
    public String updateEnterStatistics(HttpServletRequest request,
                            @ModelAttribute UpdateEnterStatisticsCommand command,
                             Model model){

        return enterStatisticsService.updateEnterStatistics(command);
    }
}
