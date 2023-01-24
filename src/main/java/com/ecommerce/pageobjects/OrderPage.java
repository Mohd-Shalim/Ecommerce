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
public class OrderPage extends Base {
	
	
	UserAction ua=new UserAction();
	
	
	
	@FindBy(css=".button-1.payment-info-next-step-button")
	WebElement continueNext;
    
	OrderPage()
	{
		PageFactory.initElements(getDriver(), this);
		
	}
	    public ConfirmOrderPage clickOnContinue()
	    {
	    	ua.click(continueNext);
	    	return new ConfirmOrderPage();
	    }
}
