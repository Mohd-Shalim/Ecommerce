/**
 * 
 */
package com.ecommerce.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Admin
 *
 */
public class ExtentManager {
	
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports report;
	public static ExtentTest test;
	 
	public static void setExtent()
	{
		String date= new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		String path= System.getProperty("user.dir")+"//ExtentReport//"+date+".html";
		htmlReporter =new ExtentSparkReporter(path);
//		try 
//		{
//			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
//		} 
//		catch (IOException e)
//		{
//			
//			e.printStackTrace();
//		}
		htmlReporter.config().setDocumentTitle("E-Commerce Project");
		htmlReporter.config().setReportName("My Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		report= new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Host", "Local");
		report.setSystemInfo("QA", "Mohd Salim");
		report.setSystemInfo("Browser", "Chrome");
		
	}
	public void endExtent()
	{
		report.flush();
	}
	

}
