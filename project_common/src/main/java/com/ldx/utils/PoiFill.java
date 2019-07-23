package com.ldx.utils;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

public class PoiFill {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    public void setSheet(int sheet){
        this.sheet = workbook.getSheetAt(sheet);
    }

    public XSSFSheet getSheet() {
        return sheet;
    }

    //追加
    public PoiFill addStringData(int Sheet,int row,int col,String data){
        Sheet sheetAt = workbook.getSheetAt(Sheet);
        Row row1 = sheetAt.getRow(row);
        Cell cell = row1.getCell(col);
        cell.setCellValue(cell.getStringCellValue()+data);

        return this;
    }

    public PoiFill addStringData(int row,int col,String data){
        Row row1 = this.sheet.getRow(row);
        Cell cell = row1.getCell(col);
        cell.setCellValue(cell.getStringCellValue()+data);
        return this;
    }
    //填充
    public PoiFill fillStringData(int row,int col,String data){
        Row row1 = this.sheet.getRow(row);
        Cell cell = row1.getCell(col);
        cell.setCellValue(data);
        return this;
    }
    public PoiFill fillStringData(int Sheet,int row,int col,String data){
        Sheet sheetAt = workbook.getSheetAt(Sheet);
        Row row1 = sheetAt.getRow(row);
        Cell cell = row1.getCell(col);
        cell.setCellValue(data);
        return this;
    }

    public PoiFill(InputStream inputStream) throws IOException {
        this.workbook = new XSSFWorkbook(inputStream);
    }
    public PoiFill(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }
    public XSSFWorkbook getWorkbook(){
        return this.workbook;
    }
}
