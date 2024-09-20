package com.hangileye.lifetouch.utill;

import com.hangileye.lifetouch.model.common.ExcelModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Slf4j
public class Excel {

    public static void ExcelExport(HttpServletResponse response, HttpServletRequest request, String[] header, ExcelModel excelModel, String[] list) throws IOException {




        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = null;
        XSSFCell cell = null;
        XSSFRow row = null;


        //Font
        Font fontHeader = workbook.createFont();
        fontHeader.setFontName("맑은 고딕");
        fontHeader.setFontHeight((short) (9 * 20));
        fontHeader.setBold(true);

        Font fontSearch = workbook.createFont();
        fontSearch.setFontName("맑은 고딕");
        fontSearch.setFontHeight((short) (9 * 20));
        fontSearch.setBold(true);

        Font font9 = workbook.createFont();
        font9.setFontName("맑은 고딕");
        font9.setFontHeight((short) (9 * 20));

        // 페이지 명 세팅
        CellStyle pageNameStyle = workbook.createCellStyle();
        pageNameStyle.setAlignment(HorizontalAlignment.CENTER);
        pageNameStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        pageNameStyle.setBorderRight(BorderStyle.THIN);
        pageNameStyle.setBorderLeft(BorderStyle.THIN);
        pageNameStyle.setBorderTop(BorderStyle.THIN);
        pageNameStyle.setBorderBottom(BorderStyle.THIN);
        pageNameStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.index);
        pageNameStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        pageNameStyle.setFont(fontSearch);

        // 엑셀 헤더 세팅
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headerStyle.setBorderRight(BorderStyle.THIN);
        headerStyle.setBorderLeft(BorderStyle.THIN);
        headerStyle.setBorderTop(BorderStyle.THIN);
        headerStyle.setBorderBottom(BorderStyle.THIN);
        headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headerStyle.setFont(fontSearch);

        // 엑셀 바디 세팅
        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setAlignment(HorizontalAlignment.CENTER);
        bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        bodyStyle.setBorderRight(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setFont(font9);

        sheet = workbook.createSheet("통계");

        int cellCnt = 0;
        int rowCnt = 0;

        row = sheet.createRow(rowCnt++);
        for (int i = 0; i < header.length; i++) {
            cell = row.createCell(i);
            cell.setCellStyle(headerStyle);
            cell.setCellValue(header[i]);
            sheet.setAutoFilter(new CellRangeAddress(0, 0, 0, header.length - 1));
            sheet.createFreezePane(0, 1);
            sheet.setColumnWidth(i, 3000);
        }

        // 바디 정보 구성
        for (String colData : list) {
            cellCnt = 0;
            row = sheet.createRow(rowCnt++);
            String[] rowData = colData.split("/");
            for (String col : rowData) {
                cell = row.createCell(cellCnt++);
                cell.setCellStyle(bodyStyle);
                cell.setCellValue(col);
            }
        }


        //파일명
        String fileName = excelModel.getFileName() + "_" + excelModel.getSearchStart().replaceAll("-","") + "~" + excelModel.getSearchEnd().replaceAll("-","")  + ".xlsx";
        String encodeFileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8).replaceAll("\\+", "%20");

        response.setHeader("Content-Disposition", encodeFileName);

        response.setContentType("application/vnd.ms-excel");

        // Excel 파일 응답으로 출력
        OutputStream out = response.getOutputStream();
        try {
            workbook.write(out);
        } catch (Exception e) {
            log.error(e.toString());
        } finally {
            out.close();
            workbook.close();
        }
    }
}
