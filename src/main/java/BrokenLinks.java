import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws InterruptedException, IOException, MalformedURLException, NullPointerException {
		WebDriverManager.chromedriver().setup();
		//ChromeOptions co= new ChromeOptions();
	    //co.addArguments("--headless");
		ChromeDriver driver=new ChromeDriver();
	
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.getDevTools();
		int i =0;
		
	    String home="http://www.amazon.com";
		driver.get(home);
		List<WebElement> links=driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr=links.iterator();
		
		System.out.println(links.size());
	    while(itr.hasNext())
	    {
	    	WebElement link= itr.next();
	    	String currentUrl	=link.getAttribute("href");
	    	
	    		URL url= new URL(currentUrl); 
	    		HttpURLConnection huc= (HttpURLConnection)url.openConnection();
	    		huc.setRequestMethod("HEAD");
	    		
	    		
	    		
	    		huc.connect();
	    		int responseCode=huc.getResponseCode(); 
	    	
	    	if(responseCode>=400) {	
	    			System.out.println("brokeen link  :"+currentUrl+"responseCode:  " +responseCode);
	    			i++;
	    	}
	    	
	    
	    }
	   
	    System.out.println("Broken Links   :"+i);
	    driver.quit();
		
 
	}

}
