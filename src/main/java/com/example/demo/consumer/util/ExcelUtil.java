package com.example.demo.consumer.util;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hpsf.WritingNotSupportedException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import share.constant.ExcelConstant;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ZERO
 * @version V1.0
 * @description 表格转换
 * @package com.example.demo.consumer.util
 * @date 2018 08-06 20:31
 */
public class ExcelUtil {

    /**
     * SSHF表格转换
     * @param title 标题
     * @param map 列头数据
     * @param jsonArray 表数据
     * @param dateParam 默认时间
     * @param colWidth 列宽
     * @param outputStream 输出流
     */
    public void exportExcel(String title, Map<String, String> map, JSONArray jsonArray,
                            String dateParam, int colWidth, OutputStream outputStream) {

        if (null == dateParam) {
            dateParam = ExcelConstant.DATEFORMAT;
        }
        // 创建一个工作簿
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        hssfWorkbook.createInformationProperties();
        hssfWorkbook.getDocumentSummaryInformation().setCompany("名称头");
        // 创建表格属性
        SummaryInformation summaryInformation = hssfWorkbook.getSummaryInformation();
        summaryInformation.setAuthor("ZERO");
        summaryInformation.setApplicationName("导出程序");
        summaryInformation.setLastAuthor("最后保存者！！！");
        summaryInformation.setComments("增加xls文件作者信息！");
        summaryInformation.setTitle("poi导出文件标题！");
        summaryInformation.setSubject("POI导出Excel");
        summaryInformation.setCreateDateTime(new Date());
        // 表头样式
        HSSFCellStyle titleStyle = hssfWorkbook.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 字体
        HSSFFont titleFont = hssfWorkbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setBoldweight((short) 700);
        titleStyle.setFont(titleFont);
        // 创建列头样式
        HSSFCellStyle headerStyle = hssfWorkbook.createCellStyle();
        headerStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        headerStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        // 创建列头字体
        HSSFFont headerFont = hssfWorkbook.createFont();
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        headerStyle.setFont(headerFont);
        // 创建单元格
        HSSFCellStyle cellStyle = hssfWorkbook.createCellStyle();
        cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        // 单元格字体样式
        HSSFFont cellFont = hssfWorkbook.createFont();
        cellFont.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(cellFont);
        // 生成一个(带标题)表格
        HSSFSheet sheet = hssfWorkbook.createSheet();
        // 声明一个画图的顶级管理器
        HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
        // 定义注释的大小和位置,详见文档
        HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(0, 0, 0, 0, (short) 4, 2, (short) 6, 5));
        // 设置注释内容
        comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));
        // 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
        comment.setAuthor("JACK");

        // 设置列宽
        int minBytes = colWidth < ExcelConstant.COLWIDTH ? ExcelConstant.COLWIDTH : colWidth;
        int[] arrColWidth = new int[map.size()];
        // 产生表格标题行， 以及设置列宽
        String[] properties = new String[map.size()];
        String[] headers = new String[map.size()];
        int rowIndex = 0;
        for (Iterator<String> iter = map.keySet().iterator(); iter.hasNext();) {
            String fileName = iter.next();

            properties[rowIndex] = fileName;
            headers[rowIndex] = fileName;

            int bytes = fileName.getBytes().length;
            arrColWidth[rowIndex] = bytes < minBytes ? minBytes : bytes;
            // 精确控制列宽
            sheet.setColumnWidth(rowIndex, (int) (arrColWidth[rowIndex] + 0.72) * 256);
            rowIndex ++;
        }
        // 遍历集合数据， 产生数据行
        int rowIndexs = 0;
        for (Object object : jsonArray) {
            // 设置每页条数
            if (rowIndex == ExcelConstant.PAGENUMBER || rowIndex == 0) {
                if (rowIndex != 0) {
                    // 如果数据超过了， 则在第二页显示
                    sheet = hssfWorkbook.createSheet();
                }
                //表头 从1开始
                HSSFRow titleRow = sheet.createRow(1);
                titleRow.createCell(0).setCellValue(title);
                titleRow.getCell(0).setCellStyle(titleStyle);
                sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, map.size() - 1));

                // 列头 rowIndex = 1
                HSSFRow headerRow = sheet.createRow(1);
                for (int i = 0; i < headers.length; i++) {
                    headerRow.createCell(i).setCellValue(headers[i]);
                    headerRow.getCell(i).setCellStyle(headerStyle);
                }

                // 数据内容从 rowIndex = 2开始
                rowIndex = 2;
            }
            JSONObject jo = (JSONObject) JSONObject.toJSON(jsonArray);
            HSSFRow dataRow = sheet.createRow(rowIndex);
            for (int i = 0; i < properties.length; i++) {
                HSSFCell newCell = dataRow.createCell(i);

                Object o = jo.get(properties[i]);
                String cellValue = "";
                if (o == null) {
                    cellValue = "";
                } else if (o instanceof Date) {
                    cellValue = new SimpleDateFormat(ExcelConstant.DATEFORMAT).format(o);
                } else {
                    cellValue = o.toString();
                }
                newCell.setCellValue(cellValue);
                newCell.setCellStyle(cellStyle);
            }
            rowIndex++;
        }
        try {
            hssfWorkbook.write(outputStream);
            summaryInformation.write(outputStream);
             hssfWorkbook.close();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WritingNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
