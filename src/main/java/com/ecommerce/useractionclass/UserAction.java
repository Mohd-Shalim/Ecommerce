/**
 * 
 */
package com.ecommerce.useractionclass;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ecommerce.base.Base;
import com.ecommerce.useractioninterface.UserActionInterface;

/**
 * @author Admin
 *
 */
public class UserAction extends Base {

	public boolean get(String url) 
	{
		boolean flag=false;
		try
		{
			getDriver().navigate().to(url);
			flag= true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Launched URL successfully  : "+url);
			else
				System.out.println("Failed to launch URL  : "+url);
		}
	}

	public String getCurrentURL() {
		boolean flag=false;
		String url = null;

		try
		{
			url=getDriver().getCurrentUrl();
			flag=true;
			return url;
		}
		catch(Exception e)
		{
			return null;

		}
		finally
		{
			if(flag)
				System.out.println("Current URL is: "+url);

			else
				System.out.println("Current URL is NULL");
		}
	}

	
	public String getTitle() {
		
		return null;
	}


	
	public boolean type(WebElement element, String text) {
		boolean flag= false; 
		try 
		{
			flag=element.isDisplayed();
			element.clear();
			element.sendKeys(text);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Successfully entered text");
			else
				System.out.println("Unable to enter text");
		}
	}


	public boolean isDisplayed( WebElement element) {
		boolean flag=false;
		try 
		{
			flag=element.isDisplayed();
			
	    }
		catch(Exception e)
		{
			
		}
		finally
		{
			if(flag)
				System.out.println("Element is Displayed");
			else
				System.out.println("Hidden Element");
		}
		return flag;
		
	}

	
	public boolean isSelected( WebElement element) {
		boolean flag=false;
		flag=element.isSelected();
		if(flag)
			System.out.println("Element is selected");
		else
			System.out.println("Element is not selected");
		return flag;
	}

	
	public boolean isEnabled( WebElement element) {
		boolean flag=false;
		flag= element.isEnabled();
		if(flag)
			System.out.println("Element is enabled");
		else
			System.out.println("Element is not enabled");
		return flag;
	}

	
	public boolean sendkeys(String value, WebElement element) {
		boolean flag=false;
		try
		{
			element.sendKeys(value);
			flag=true;
		}
		catch(Exception e)
		{
		   	
		}
		finally 
		{
			if(flag)
				System.out.println("Selected value");
			else
				System.out.println("Value not Selected");
		}
	return flag;
	}

	
	public boolean selectByIndex(WebElement element, int index) {
		boolean flag=false;
		try
		{
			Select select= new Select(element);
			select.selectByIndex(index);
			flag= true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Drop Down Selected by Index");
			else
				System.out.println("Unable to Select Drop Down by Index");
		}
	}

	
	public boolean selectByValue(WebElement element, String value) {
		boolean flag=false;
		try
		{
			Select select= new Select(element);
			select.selectByValue(value);
			flag= true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Drop Down Selected by Value");
			else
				System.out.println("Unable to Select Drop Down by Value");
		}
	}

	
	public boolean selectByVisibleText(String visibleText, WebElement element)
	{
		boolean flag=false;
		try
		{
			Select select= new Select(element);
			select.selectByVisibleText(visibleText);
			flag= true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Drop Down Selected by Visible Text");
			else
				System.out.println("Unable to Select Drop Down by VIsible Text");
		}
	}
	
	public boolean switchToFrameByIndex( int index) {
		boolean flag=false;
		try
		{
			getDriver().switchTo().frame(index);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Successfully Switched to frame\""+ index +"\" by Index");
			else
				System.out.println("Unable to switch to frame by Index  :  "+index);
		}
	}

	
	public boolean switchToFrameById( String idValue) {
		boolean flag=false;
		try
		{
			getDriver().switchTo().frame(idValue);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Successfully Switched to frame\""+ idValue +"\" by Id");
			else
				System.out.println("Unable to switch to frame by Index  :  "+idValue);
		}
	}

	
	public boolean switchToFrameByName( String name) {
		boolean flag=false;
		try
		{
			getDriver().switchTo().frame(name);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Successfully Switched to frame\""+ name +"\" by Index");
			else
				System.out.println("Unable to switch to frame by Index  :  "+name);
		}
	}

	
	public boolean switchToDefaultFrame() {
		boolean flag=false;
		try
		{
			getDriver().switchTo().defaultContent();
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Successfully Switched to default frame");
			else
				System.out.println("Unable to switch to default frame");
		}

	}

	
	public boolean jsMouseOverElement( WebElement element) {
		boolean flag=false;
		try
		{
			JavascriptExecutor js=(JavascriptExecutor)getDriver();
			js.executeScript("argument[0].scrollIntoView(true);", element);
			Actions act= new Actions(getDriver());
			act.moveToElement(element).build().perform();
			flag=true;
			return true;
		}
		catch(Exception e)
		{

			return false;
		}
		finally
		{
			if(flag)
			{
				System.out.println("Moved to element using JS Executor");
			}
		}

	}

	
	public void moveToElement( WebElement element) {
		boolean flag=false;
		try
		{
			Actions act= new Actions(getDriver());
			act.moveToElement(element).build().perform();
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(flag)
				System.out.println("Moved to Element using Actions Class");
		}
	}



	
	public boolean dragAndDropCordi( WebElement source, int x, int y) 
	{
		boolean flag=false;
		try
		{
			new Actions(getDriver()).dragAndDropBy(source, x, y);
			Thread.sleep(5000);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally 
		{
			if(flag)
				System.out.println("Drag and Drop to cordinate");
			else
				System.out.println("Drag and drop failed to cordinate");
		}

	}

	
	public boolean draganddrop( WebElement source, WebElement target) {
		boolean flag=false;
		try
		{
			/* 
			Actions act=new Actions(getDriver());
			act.dragAndDrop(source, target);*/
			//or
			new Actions(getDriver()).dragAndDrop(source, target);

			flag= true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Drag and drop Successful");
			else
				System.out.println("Drag and drop failed");
		}

	}

	
	public boolean slider( int x, int y) {

		try
		{
			new Actions(getDriver()).scrollByAmount(x, y);

			return true;
		}
		catch(Exception e)
		{
			return false;

		}

	}

	
	public boolean rightclick( WebElement element) {
		boolean flag=false;
		try
		{
			new Actions(getDriver()).contextClick(element).build().perform();
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if(flag)
				System.out.println("Right click Performed on  :  "+element.getText());
			else
				System.out.println("Unable to perform right click");
		}
	}

	
	public void fluentWait( WebElement element, int timeOut) {
		try
		{
			Wait<WebDriver> wait= new FluentWait<WebDriver>(getDriver())
					.withTimeout(Duration.ofSeconds(timeOut))
					.pollingEvery(Duration.ofSeconds(2))
					.ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));

		}
			catch(Exception e)
			{

			}
		}

		
		public void implicitWait( int timeOut) {
			getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));

		}

		
		public void explicitWait( WebElement element, int timeOut) {
			
				WebDriverWait wait=new WebDriverWait(getDriver(),Duration.ofSeconds(timeOut));
			    wait.until(ExpectedConditions.visibilityOf(element));
		}

		
		public void pageLoadTimeOut( int timeOut) {
			getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		}

		
		public String getCurrentTime() {
		String currentDateTime=new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
			return currentDateTime;
		}

		
		public String screenShot( String filename) {
			String currentDateTime=new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
			TakesScreenshot screenshot =(TakesScreenshot)getDriver();
			File src=screenshot.getScreenshotAs(OutputType.FILE);
			File destination= new File(System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + currentDateTime + ".png");
			try
			{
				FileUtils.copyFile(src, destination);
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
			// This new path for jenkins
			String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
					+ currentDateTime + ".png";
			return newImageString;
		}

		
		public int getColumnCount(WebElement row) {
			List<WebElement> columns=row.findElements(By.tagName("td"));
			int i=columns.size();
			System.out.println("Total colums : "+i);
			Iterator<WebElement> it=columns.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next().getText());
			}
			return i;
		}

		
		public int getRowCount(WebElement row) {
			
			List<WebElement> columns=row.findElements(By.tagName("tr"));
			int i=columns.size()-1;
			System.out.println("Total colums : "+i);
			Iterator<WebElement> it=columns.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next().getText());
			}
			return i;
		}
		

		
		public boolean switchWindowByTitle(String windowTitle, int count) {
			boolean flag=false;
			try
			{
				Set<String> windowSet=getDriver().getWindowHandles();
				String[] windowString=windowSet.toArray(new String[0]);
				getDriver().switchTo().window(windowString[count-1]);
				if(getDriver().getTitle().equals(windowTitle))
				{
					flag=true;
				}
				
			}
			catch(Exception e)
			{
				  
			}
			finally
			{
				if(flag)
				
					System.out.println("Navigated to window by Title : "+getDriver().getTitle());
				
				else
					System.out.println("No such window opened");
			}
			return flag;
		}

		
		public boolean switchToNewWindow( String url) {
			boolean flag=false;
			try
			{
				getDriver().switchTo().newWindow(WindowType.TAB);
				getDriver().get(url);
				flag=true;
				
			}
			catch(Exception e)
			{
				
			}
			finally
			{
				if(flag)
					System.out.println("Navigate to URL"+getDriver().getCurrentUrl());
			}
			return flag;
		}

		
		

		
		public boolean isAlertPresent() {
			
				try 
				{ 
					getDriver().switchTo().alert(); 
					return true; 
				}   // try 
				catch (NoAlertPresentException Ex) 
				{ 
					return false; 
				}   // catch 
			}
		

		public boolean acceptAlert() {
			 boolean flag =false;
			 Alert alert = null;
			 
			
			try 
			{
				alert=getDriver().switchTo().alert();	
				alert.accept();
				flag= true;
				return true;
			}
			catch(NoAlertPresentException e)
			{   
				e.printStackTrace();
				return false;
			}
			finally
			{
				if(flag)
				{
					System.out.println("Alert Handled");
				}
				else
					System.out.println("No alert Presesnt");
			}
			
		}

		public void JSClick( WebElement element) {
			
			JavascriptExecutor js=(JavascriptExecutor)getDriver();
			js.executeScript("arguments[0].click();", element);
			new Actions(getDriver()).click().build().perform();
		}

		public boolean findElement( WebElement element) {
			boolean flag=false;
			try
			{
				element.isDisplayed();
				flag=true;
		        
			}
			catch(Exception e)
			{
				
			}
			finally
			{
				if(flag)
					System.out.println("Element found sussessfully  at :"+ element.getRect());
				else
					System.out.println("Unable to locate element");
			}
			return flag;
		}

		public boolean click(WebElement element) {
			boolean flag=false;
			try
			{
				Actions act= new Actions(getDriver());
				act.moveToElement(element).click().build().perform();
				flag=true;
				return true;
			}
			catch(Exception e)
			{
				return false;
			}
			finally
			{
				if(flag)

					System.out.println("Clicked webelement sussessfully");
				else
					System.out.println("Unable to click webelement");
			}
		}

		}

	
