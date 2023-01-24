

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Admin
 *
 */
public class exl {

	DataFormatter format=new DataFormatter();
	public  FileInputStream fis;
	public XSSFWorkbook workbook;

	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	String path=System.getProperty("user.dir")+"\\src\\test\\data.xlsx";


	public exl()
	{

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
		int index=workbook.getSheetIndex(sheetName);
		int rowCount=0;
		if(index==-1)
		{

			return rowCount;
		}
		else
		{
			sheet=workbook.getSheetAt(index);
			rowCount=sheet.getLastRowNum();
			return rowCount;
		}
	}
	public int getColumnCount(String sheetName)
	{
		int index=workbook.getSheetIndex(sheetName);
		int columnCount=0;
		if(index==-1)
		{
			return columnCount;
		}
		else
		{
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(0);
			columnCount=row.getLastCellNum();
			return columnCount;
		}
	}
	public String getCellData(String sheetName,int rowNum, int colNum)
	{    
		sheet= workbook.getSheet(sheetName);
		//row	= sheet.getRow(rowNum);
		//cell= row.getCell(colNum);
		String s= format.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
		return s;




	}




//registration
	//credential
	public static void main(String[] args) {
		exl e=new exl();
//String p=e.getCellData("registration", 1, 5);
//System.out.println(p);
				int cols=e.getColumnCount("registration");
				int rows=e.getRowCount("registration");
				int i,j=0;
				Object[][] data= new Object[rows][1];
				
				for(i=0;i<rows;i++)
				{   Map<String,String> map=new HashMap<>();
					for(j=0;j<cols;j++)
					{
						map.put(e.getCellData("registration", 0, j),e.getCellData("registration", i+1, j));
						//System.out.println(map);
						
					}
					data[i][0]=map;
					map.entrySet().forEach(entry -> {
					    System.out.println(entry.getKey() + " " + entry.getValue());
					});
					System.out.println("==============================================");
				}
				
				
				for(i=0;i<2;i++)
				{
					for(j=0;j<1;j++)
					{
					System.out.println(data[i][j]);
				}}
	}}
