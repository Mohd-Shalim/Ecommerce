import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 */

/**
 * @author Admin
 *
 */
public class Amazon {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("chromedriver.exe", "C:\\Users\\Admin\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
		//ChromeOptions co= new ChromeOptions();
	    //co.addArguments("--headless");
		WebDriver driver=new ChromeDriver();
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mugs for coffee");
		driver.findElement(By.id("nav-search-submit-text")).click();
		Thread.sleep(3000);
		int i=0;
		List<WebElement> products=driver.findElements(By.className("a-price-whole"));
		for(WebElement p:products)
		{
			String price=p.getText();
		      i++;
		
			System.out.println(price);
		}
		System.out.println(i);
driver.quit();
	}

}
