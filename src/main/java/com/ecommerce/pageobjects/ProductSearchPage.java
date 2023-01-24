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
public class ProductSearchPage extends Base{
	
	UserAction ua=new UserAction();

	@FindBy(id="small-searchterms")
	WebElement searchInputBox;

	@FindBy(xpath="//*[@class='button-1 search-box-button']")
	WebElement searchBtn;

	ProductSearchPage()
	{
		PageFactory.initElements(getDriver(), this);
		/* using driver from base class if driver in base class is static
		then only can be used here because static variable can be used 
		without created objects of corresponding classes inside static methods or 
		in non static methods of child class*/
	}

	public ProductSearchPage searchProduct() 
	{
		ua.isDisplayed(searchInputBox);
		ua.sendkeys("phone", searchInputBox);
		ua.isDisplayed(searchBtn);
		ua.click(searchBtn);
		return new ProductSearchPage();
	}
}
