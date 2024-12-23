package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	public String getDataFromExcel(String sheetName,int rowNum,int celNum) throws Exception
	{
		
		FileInputStream fisobj=new FileInputStream("./TestScriptData/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fisobj);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).toString();
		wb.close();
		return data;
		
	}
	public int  getRowCount(String SheetName) throws Throwable
	{
		FileInputStream fisobj=new FileInputStream("./TestScriptData/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fisobj);
		int RowNum=wb.getSheet(SheetName).getLastRowNum();
		wb.close();
		return RowNum;
	}
	public void SetDataintoExcel(String sheetName,int rowNum,int celNum) throws Throwable
	{
		FileInputStream fisobj=new FileInputStream("./TestScriptData/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fisobj);
		wb.getSheet(sheetName).getRow(rowNum).getCell(celNum);
		
		FileOutputStream filewrite=new FileOutputStream("./TestScriptData/TestScriptData.xlsx");
		wb.write(filewrite);
		wb.close();
		
	}
	
	
	
	
	
	
	
	
	
	

}
