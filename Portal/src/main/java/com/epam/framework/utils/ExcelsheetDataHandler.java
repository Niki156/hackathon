package com.epam.framework.utils;

import com.epam.framework.exceptions.ExcelsheetException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelsheetDataHandler {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelsheetDataHandler(String excelPath) {
        try {
            this.workbook = new XSSFWorkbook(excelPath);
        } catch (IOException e) {
            throw new ExcelsheetException("exception while initializing a work book ");
        }
    }

    public void setSheet(String sheetName) {
        this.sheet = this.workbook.getSheet(sheetName);
    }

    public String getStringCellData(int rowNum, int colNum) {
        return this.sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
    }

    public String getNumberCellData(int rowNum, int colNum) {
        return this.sheet.getRow(rowNum).getCell(colNum).getRawValue();
    }

    public void writeContentToCell(String content, int rowNum, int colNum) {
        this.sheet.getRow(rowNum).getCell(colNum).setCellValue(content);

    }

    public int getrowsCount() {
        return this.sheet.getLastRowNum();
    }

    public int getColCount() {
        return this.sheet.getRow(0).getLastCellNum();
    }

    public Object[][] getDetails(String sheetName) {

        setSheet(sheetName);
        int rowNum = getrowsCount();
        int colNum = getColCount();
        Object[][] data = new Object[rowNum][colNum];
        for (int i = 0; i < rowNum; i++)
            for (int j = 0; j < colNum; j++) {
                data[i][j] = getcellData(i + 1, j);
                sheet.getRow(i + 1).getCell(0).setCellValue("leela");
            }
        return data;
    }

    public String getcellData(int rowNum, int colNum) {
        XSSFRow row;
        XSSFCell cell;
        String cellText = " ";
        if (rowNum == -1)
            return cellText;
        else
            row = this.sheet.getRow(rowNum);
        if (row == null)
            return cellText;
        else
            cell = row.getCell(colNum);
        if (cell == null)
            return cellText;
        else if (cell.getCellType() == CellType.NUMERIC || cell.getCellType() == CellType.FORMULA)
            cellText = String.valueOf(getNumberCellData(rowNum, colNum));
        else if (cell.getCellType() == CellType.STRING)
            cellText = getStringCellData(rowNum, colNum);
        else if (cell.getCellType() == CellType.BLANK)
            cellText = " ";
        else if (cell.getCellType() == CellType.BOOLEAN)
            cellText = String.valueOf(cell.getBooleanCellValue());
        return cellText;
    }

    public static void main(String args[]) {
        ExcelsheetDataHandler excel = new ExcelsheetDataHandler("C:\\Users\\Leelakrishna_Boddapa\\Downloads\\demo.xlsx");

        excel.setSheet("Sheet2");
        int j = 2601;
        for (int i = 0; i < 500; i++) {
            String s = String.valueOf(j) + ".tiff";
            Row r = excel.sheet.createRow(i);
            Cell c = r.createCell(1);
            c.setCellValue((String) s);
        }
    }
}

