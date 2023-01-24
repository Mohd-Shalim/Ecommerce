/**
 * 
 */
package com.ecommerce.useractioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Admin
 *
 */
public interface UserActionInterface {
	// General Actions
	public boolean get(WebDriver driver,String url);
	public String getCurrentURL(WebDriver driver);
	public String getTitle(WebDriver driver);
	public boolean type(WebElement element, String text);
	public boolean click(WebElement element);
	public boolean isDisplayed(WebDriver driver, WebElement element);
	public boolean isSelected(WebDriver driver, WebElement element);
	public boolean isEnabled(WebDriver driver, WebElement element);
	//Drop down actions
	public boolean selectBySendkeys(String value,WebElement element);
	public boolean selectByIndex(WebElement element, int index);
	public boolean selectByValue(WebElement element,String value);
	public boolean selectByVisibleText(String visibletext, WebElement element);
	// Frame actions
	public boolean switchToFrameByIndex(WebDriver driver,int index);
	public boolean switchToFrameById(WebDriver driver,String idValue);
	public boolean switchToFrameByName(WebDriver driver,String nameValue);
	public boolean switchToDefaultFrame(WebDriver driver);
	// Methods from action class
    public boolean jsMouseOverElement(WebDriver driver, WebElement element);
	public void moveToElement(WebDriver driver, WebElement element);
	public boolean draganddrop(WebDriver driver,WebElement source, WebElement target);
	public boolean rightclick(WebDriver driver,WebElement ele);
	// Waits and timeout
	public void fluentWait(WebDriver driver,WebElement element, int timeOut);
	public void implicitWait(WebDriver driver, int timeOut);
	public void explicitWait(WebDriver driver, WebElement element, int timeOut);
	public void pageLoadTimeOut(WebDriver driver, int timeOut);
	public String getCurrentTime();
	//Screenshot
	public String screenShot(WebDriver driver, String filename);
	//Web Table, Data Provider
	public int getColumnCount(WebElement row);
	public int getRowCount(WebElement table);
	// window handling
	public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count);
	public boolean switchToNewWindow(WebDriver driver,String url);
	//Java Script Executor
	public boolean isAlertPresent(WebDriver driver);
	public boolean Alert(WebDriver driver);
	public void JSClick(WebDriver driver, WebElement element);
	public boolean findElement(WebDriver ldriver, WebElement element);
	boolean dragAndDropCordi(WebDriver driver, WebElement source, int x, int y);
	boolean slider(WebDriver driver, int x, int y);

}
