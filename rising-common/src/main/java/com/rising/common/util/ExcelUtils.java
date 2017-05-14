package com.rising.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * EXCEL表格工具
 * 
 * @author zhurz
 */
public class ExcelUtils {

	/**
	 * 获取EXCEL(*.xls,*.xlsx)表格第一页所有的单元格字符串
	 * 
	 * @return
	 */
	public static List<List<String>> getExecelStringValues(File xlsFile) {
		List<List<String>> result = new ArrayList<List<String>>();
		if (xlsFile.isFile() && xlsFile.exists()) {
			try {
				// 97-2003 xls
				if (xlsFile.getName().toLowerCase().endsWith(".xls")) {
					result = getExecelStringValues1(xlsFile);
				}
				// 2007+ xlsx
				else if (xlsFile.getName().toLowerCase().endsWith(".xlsx")) {
					result = getExecelStringValues2(xlsFile);
				}
				// default
				else {
					result = getExecelStringValues1(xlsFile);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (BiffException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 获取EXCEL(*.xls)表格第一页所有的单元格字符串
	 * 
	 * @return
	 * @throws IOException
	 * @throws BiffException
	 */
	protected static List<List<String>> getExecelStringValues1(File xlsFile) throws BiffException, IOException {
		List<List<String>> result = new ArrayList<List<String>>();
		Workbook book = Workbook.getWorkbook(xlsFile);
		Sheet sheet = book.getSheet(0);
		int rowNum = sheet.getRows();
		int colNum = sheet.getColumns();
		for (int i = 0; i < rowNum; i++) {
			List<String> rowDate = new ArrayList<String>();
			int hasValueNum = 0;
			for (int j = 0; j < colNum; j++) {
				Cell cell = sheet.getCell(j, i);
				String cellText = cell.getContents();
				rowDate.add(cellText);
				if (StringUtils.isNotBlank(cellText)) {
					hasValueNum++;
				}
			}
			if (hasValueNum > 0) {
				result.add(rowDate);
			}
		}
		return result;
	}

	/**
	 * 获取EXCEL(*.xlsx)表格第一页所有的单元格字符串
	 * 
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	protected static List<List<String>> getExecelStringValues2(File xlsxFile) throws FileNotFoundException, IOException {
		List<List<String>> result = new ArrayList<List<String>>();
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(xlsxFile));
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowNum = sheet.getLastRowNum() + 1;
		int maxCol = 1;
		for (int i = 0; i < rowNum; i++) {
			List<String> rowDate = new ArrayList<String>();
			XSSFRow row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			int colNum = row.getLastCellNum();
			int hasValueNum = 0;
			maxCol = Math.max(colNum, maxCol);
			for (int j = 0; j < colNum; j++) {
				XSSFCell cell = row.getCell(j);
				String cellText = "";
				if (cell != null) {
					cell.setCellType(org.apache.poi.ss.usermodel.Cell.CELL_TYPE_STRING);
					cellText = cell.getStringCellValue();
				}
				rowDate.add(cellText);
				if (StringUtils.isNotBlank(cellText)) {
					hasValueNum++;
				}
			}
			if (hasValueNum > 0) {
				result.add(rowDate);
			}
		}
		for (List<String> list : result) {
			int less = maxCol - list.size();
			if (less > 0) {
				for (int x = 0; x < less; x++) {
					list.add("");
				}
			}
		}
		return result;
	}

}
