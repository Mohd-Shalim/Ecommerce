/**
 * 
 */
package com.ecommerce.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Admin
 *
 */
public class ExcelReader {

	public DataFormatter format;
	public FileInputStream fis;
	public XSSFWorkbook workbook;

	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cellData;
	String path=System.getProperty("user.dir")+"\\src\\test\\data.xlsx";


	public ExcelReader()
	{
		format=new DataFormatter();
		//String excelExtension= path.substring(path.indexOf("."));

		try {
			fis= new FileInputStream(path);

			workbook= new XSSFWorkbook(fis);
			fis.close();



		} 
		catch (FileNotFoundException e1) 
		{

			e1.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public int getRowCount(String sheetName)
	{
		//int index=workbook.getSheetIndex(sheetName);
		//sheet=workbook.getSheetAt(index);
		sheet=workbook.getSheet(sheetName);				
		int rowCount=sheet.getLastRowNum();
		return rowCount;
	}
      
	public int getColumnCount(String sheetName)
	{


		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(0);
		int columnCount=row.getLastCellNum();
		return columnCount;
	}

	public String getCellData(String sheetName,int rowNum, int colNum)
	{    
		sheet= workbook.getSheet(sheetName);
		row	= sheet.getRow(rowNum);
		cellData= row.getCell(colNum);
		String value= format.formatCellValue(cellData);
		return value;




	}


}
