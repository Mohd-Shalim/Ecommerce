import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Links {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions co= new ChromeOptions();
		co.addArguments("--headless");
		ChromeDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		//driver.getDevTools();
		int i =0;
		int j=0;
		String url="https://www.flipkart.com/";
		driver.get(url);

		List<WebElement> links=driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr=links.iterator();
		System.out.println(links.size());
		while(itr.hasNext())
		{
			WebElement link= itr.next();
			String currentUrl	=link.getAttribute("href");
			if(currentUrl!=null && currentUrl.startsWith("http"))
			{
				driver.switchTo().newWindow(WindowType.WINDOW);

				driver.get(currentUrl);
				System.out.println(driver.getTitle()); 	
				driver.close();
				Set<String>wh=driver.getWindowHandles();
				Object[] arr=wh.toArray();
				driver.switchTo().window((String) arr[0]);
				i++;

			}
			else {
				j++;
			}


		}
		System.out.println("Number of Working links   :"+i);
		System.out.println("Broken Links   :"+j);
		driver.quit();


	}

}
