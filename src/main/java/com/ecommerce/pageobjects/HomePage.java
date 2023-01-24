/**
 * 
 */
package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.base.Base;
import com.ecommerce.useractionclass.UserAction;

/**
 * @author Admin
 *
 */
public class HomePage extends Base
{     
	UserAction ua= new UserAction();
	
	@FindBy(css="input[class='search-box-text ui-autocomplete-input']")
	WebElement searchInputBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[text()='Log out']")
	WebElement logOut;
	
	HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	

	public void searchInputBox()
	{
		ua.isDisplayed(searchInputBox);
		ua.sendkeys("phone", searchInputBox);
		
	}
	
	public ProductSearchPage clickOneSarchButton()
	{
		ua.isDisplayed(searchBtn);
		ua.click(searchBtn);
		return new ProductSearchPage();
	}
	
	public IndexPage ClickOnlogOut()
	{
		ua.click(logOut);
		return new IndexPage();
	}
	
	

}
