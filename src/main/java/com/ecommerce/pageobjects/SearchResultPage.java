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
public class SearchResultPage extends Base {

	UserAction ua=new UserAction();
	
	@FindBy(xpath="//input[@id='q']")
	WebElement refineSearchBOx;
	
	@FindBy(xpath="//div[@class='inputs reversed']//following::input[1]")
	WebElement advanceSearchCheckBox;
	
	@FindBy(css="select[id='cid']")
	WebElement categorySelectDropDown;
	
	@FindBy(css="select[id='mid']")
	WebElement  manufecturerSelectDropDown;
	
	@FindBy(xpath="//label[@for='sid']//following::button[@type='submit']")
	WebElement refineSearchBtn;
	
	@FindBy(xpath="//*[@id='products-orderby']")
	WebElement sortByDropDown;
	
	@FindBy(xpath="//*[@id='products-pagesize']")
	WebElement productPaginationDropDown;
	
	@FindBy(xpath="//*[text()='Add to cart'][1]")
	WebElement addToCartbtn;
	
	@FindBy(css="//p[@class='content']")
	WebElement displayMessage;
	
	@FindBy(xpath="//*[text()='shopping cart']")
	WebElement proceedtoAddToCart;
	
	
	SearchResultPage()
	{
		PageFactory.initElements(getDriver(), this);
		/* using driver from base class if driver in base class is static
		then only can be used here because static variable can be used 
		without created objects of corresponding classes inside static methods or 
		in non static methods of child class*/
		
	}
	public String advanceSearch()
	{
		ua.sendkeys("books", refineSearchBOx);
		ua.click(advanceSearchCheckBox);
		ua.selectByVisibleText("Books", categorySelectDropDown);
		ua.selectByVisibleText("All", manufecturerSelectDropDown);
		ua.click(refineSearchBtn);
		ua.click(addToCartbtn);
		ua.isDisplayed(displayMessage);
		String message=displayMessage.getText();
		return message;
		
	}
	public CartPage proceedToCart()
	{
		ua.click(addToCartbtn);
		return new CartPage();
	}
	
}
