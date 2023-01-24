
 


import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
 
public class Capabilities {
 
     WebDriver driver = null;
 	
 
 	@BeforeMethod
 	public void setUp() {
      	ChromeOptions co = new ChromeOptions();
      	co.setCapability(CapabilityType.BROWSER_NAME, "chrome");
      	co.setCapability(CapabilityType.BROWSER_VERSION, "92.0");
      	co.setCapability(CapabilityType.PLATFORM_NAME, "Windows 11");
      	Proxy prox=new Proxy();
      	prox.setAutodetect(false);
      	prox.setHttpProxy("104.225.220.233:80");
      	co.setCapability(CapabilityType.PROXY, prox);
      	//co.setCapability(CapabilityType.SET_WINDOW_RECT, "1024x768");
      	//co.setCapability("build", "DialogBoxes And Pop-ups Selenium JAVA");
      	//sco.setCapability("name", "DialogBoxes And Pop-ups Selenium JAVA");
        WebDriverManager.chromedriver().setup();
      	driver = new ChromeDriver(co);
		          	
 	}
 	@Test
 	void info()
 	{
 		driver.get("http://www.google.com");
 		String title=driver.getTitle();
 		Assert.assertEquals(title, "Google");
 	}
    
 	//@AfterMethod
 	public void closeDriver() {
      	driver.quit();
 	}
}


