package com.PageObjectModel.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	String path;
	public static FileInputStream fis=null;
	public static XSSFWorkbook workbook=null;
	public static XSSFSheet sheet=null;
	public static  XSSFCell cell=null;
	public static  XSSFRow row=null;
	public static String runMode;
	
	
//	public ExcelReader(String path){
//		
//		this.path=path;
//		try {
//			fis=new FileInputStream(path);
//			workbook=new XSSFWorkbook(fis);
//			sheet=workbook.getSheetAt(0);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	}
//	
	
/////  returns row count of a sheet
	
	public  static int getRowCount(String testName){
		
		String path=System.getProperty("user.dir")+
				"\\src\\test\\resources\\Test Data\\Test Data.xlsx";
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sheetName=testName.trim();
		
		int index=workbook.getSheetIndex(sheetName);
		if(index==-1){
			return 0;
		}
		else{
			sheet=workbook.getSheetAt(index);
			int num=sheet.getLastRowNum()+1;
			return num;
		}
		
	}
	
	public static String getCellData(String suiteName,String testName){
		
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\Test Data\\Test Execution Sheet.xlsx";
		String sheetName=suiteName.trim();
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		int rowNum=sheet.getLastRowNum();
		for(int i=1;i<=rowNum;i++){
			String data=sheet.getRow(i).getCell(0).getStringCellValue().trim();
			if(data.equals(testName.trim())){
				runMode=sheet.getRow(i).getCell(1).getStringCellValue().trim();
				break;
			}
		}
		//String data=sheet.getRow(rowNum).getCell(1).getStringCellValue();
		return runMode;
	}
	
	


@SuppressWarnings("static-access")
public static  ArrayList<String> getLocator(String testName,int step){
		
		String path=System.getProperty("user.dir")+
				"\\src\\test\\resources\\Test Data\\Test Data.xlsx";
		String sheetName=testName.trim();
		try {
			fis=new FileInputStream(path);
			workbook=new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		ArrayList<String> data=new ArrayList<String>();
		int col=sheet.getRow(0).getLastCellNum();
		int rNum=step;
		
		//System.out.println(col);
		for(int i=0;i<col-1;i++){
			cell=sheet.getRow(rNum).getCell(i+1);
//			if(cell.getCellTypeEnum().equals("NUMERIC")){
//				Double v=cell.getNumericCellValue();
//				data.add(v.toString().trim());
//			}
			cell.setCellType(cell.CELL_TYPE_STRING);
			data.add(cell.getStringCellValue().trim());
			}
		//String data=sheet.getRow(rowNum).getCell(1).getStringCellValue();
		//return data;
		//System.out.println(data.toString());
		return data;
	}
	
}
