/**
 * 
 */
package com.ecommerce.dataprovider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.ecommerce.utility.ExcelReader;
import com.ecommerce.utility.ExcelReader;

/**
 * @author Admin
 *
 */
public class DataProviders {

	ExcelReader excelReader=new ExcelReader();
	

	@DataProvider(name="credential")
	public Object[][] getCredential() throws IOException
	{
		int i,j;
		//String path=System.getProperty("user.dir")+"\\src\\test\\data.xlsx";
		int rows=excelReader.getRowCount("credential");
		int cols=excelReader.getColumnCount("credential");

		Object[][] data=new Object[rows][cols];
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				data[i][j]= excelReader.getCellData("credential", i+1, j);
			}
		}
		return data;
	}
	@DataProvider(name="registration")
	public Object[][] getExcelRegistration()
	{
		int i,j;
		int rows=excelReader.getRowCount("registration");
		int cols=excelReader.getColumnCount("registration");
		Object[][] data=new Object[rows][1];
		
		for(i=0;i<rows;i++)
		{   Map<String,String> map=new HashMap<>();
			for(j=0;j<cols;j++)
			{
				map.put(excelReader.getCellData("registration", 0, j),excelReader.getCellData("registration", i+1, j));
			}
			data[i][0]=map; 
			
		}
		return data;
	}
	
	public Object[][] getExcelProduct()
	{
		int i,j;
		int rows=excelReader.getRowCount("product");
		int cols=excelReader.getColumnCount("product");
		Object[][] data=new Object[rows][cols];
		for(i=0;i<rows;i++)
		{
			for(j=0;j<cols;j++)
			{
				data[i][j]= excelReader.getCellData("product", i+1, j);
			}
		}
		return data;
		
	}

}

