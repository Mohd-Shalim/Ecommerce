/**
 * 
 */
package com.ecommerce.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ecommerce.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Admin
 *
 */
public class Base {
	public static  ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	public Properties prop;
	
	public WebDriver getDriver()
	{
		return driver.get();
	}
	
	
	
	@BeforeSuite
	public void beforeSuit()
	{
		
		ExtentManager.setExtent();
	}

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser)
	{
		prop=new Properties();


		try
		{
			//it is also correct=====>
			//String path="./Configuration\\Config.properties";
			String path=System.getProperty("user.dir")+"\\Configuration\\Config.properties";
			FileInputStream	ip = new FileInputStream(path);
			prop.load(ip);
		} catch (IOException e)
		{
			e.printStackTrace();

		}
		switch (browser.toLowerCase())
		{
		case "chrome":
		{
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			getDriver().manage().deleteAllCookies();
			//driver.manage().window().maximize();
			getDriver().get(prop.getProperty("url"));
			break;
		}
		case "firefox":
		{
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			getDriver().manage().deleteAllCookies();
			//driver.manage().window().maximize();
			getDriver().get(prop.getProperty("url"));
			break;
		}
		case "edge":
		{
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			getDriver().manage().deleteAllCookies();
			//getDriver().manage().window().maximize();
			getDriver().get(prop.getProperty("url"));
			break;

		}
		default:
		{
			WebDriverManager.chromedriver().setup();
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			getDriver().get(prop.getProperty("url"));
			break;
		}
	  }
	}




	@AfterMethod
	public void tearDown()
	{
		getDriver().quit();
	}

}
