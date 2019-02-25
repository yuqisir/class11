package com.itheima.utils;
/**
 * 系统数据导出Excel 生成器
 * @version 1.0
 */


import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class ExcelFileGenerator {

	private final int SPLIT_COUNT = 15000; //Excel每个工作簿的行数

	private ArrayList fieldName = null; //excel标题数据集

	private ArrayList fieldData = null; //excel数据内容	

	private HSSFWorkbook workBook = null;

	/**
	 * 构造器
	 * @param fieldName 结果集的字段名
	 */
	public ExcelFileGenerator(ArrayList fieldName, ArrayList fieldData) {

		this.fieldName = fieldName;
		this.fieldData = fieldData;
	}

	/**
	 * 创建HSSFWorkbook对象
	 * @return HSSFWorkbook
	 */
	public HSSFWorkbook createWorkbook() {

		workBook = new HSSFWorkbook();
		int rows = fieldData.size();
		int sheetNum = 0;

		if (rows % SPLIT_COUNT == 0) {
			sheetNum = rows / SPLIT_COUNT;
		} else {
			sheetNum = rows / SPLIT_COUNT + 1;
		}

		for (int i = 1; i <= sheetNum; i++) {
			HSSFSheet sheet = workBook.createSheet("Page " + i);
			HSSFRow headRow = sheet.createRow((short) 0);
			HSSFFont font;
			for (int j = 0; j < fieldName.size(); j++) {
				HSSFCell cell = headRow.createCell((short) j);
				//添加样式
				cell.setCellType(HSSFCell.CELL_TYPE_STRING);
				//cell.setCellStyle(HSSFCell.);
				//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
				
				//设置样式：首先创建一个样式的对象
				HSSFCellStyle cellStyle = workBook.createCellStyle();
				//设置excel表格的宽度
				sheet.setColumnWidth((short)j, (short)6000);
				
				//设置字体加粗
				font = workBook.createFont();
				//font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
				font.setBold(true);
				//设置字体颜色变"红"
				Short color = HSSFColor.RED.index;
				font.setColor(color);
				
				//将设置完成的font字体放入到cellStyle
				cellStyle.setFont(font);
				
				if(fieldName.get(j) != null){
					//将样式存放到excel的cell的表格中
					cell.setCellStyle(cellStyle);
					cell.setCellValue((String) fieldName.get(j));
				}else{
					cell.setCellStyle(cellStyle);
					cell.setCellValue("-");
				}
			}

			for (int k = 0; k < (rows < SPLIT_COUNT ? rows : SPLIT_COUNT); k++) {
				if (((i - 1) * SPLIT_COUNT + k) >= rows)
					break;
				HSSFRow row = sheet.createRow((short) (k + 1));
				//将数据内容放入excel单元格
				ArrayList rowList = (ArrayList) fieldData.get((i - 1)
						* SPLIT_COUNT + k);
				for (int n = 0; n < rowList.size(); n++) {
					HSSFCell cell = row.createCell((short) n);
					//cell.setEncoding(HSSFCell.ENCODING_UTF_16);
					if(rowList.get(n) != null){
						cell.setCellValue((String) rowList.get(n).toString());
					}else{
						cell.setCellValue("");
					}
				}
			}
		}
		return workBook;
	}

	public void expordExcel(OutputStream os) throws Exception {
		workBook = createWorkbook();
		workBook.write(os);
		os.close();
	}

}
