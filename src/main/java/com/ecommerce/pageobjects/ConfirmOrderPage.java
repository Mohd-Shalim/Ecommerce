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
public class ConfirmOrderPage extends Base {
	
	UserAction ua= new UserAction();
	
	@FindBy(css="button.payment-info-next-step-button")
	WebElement continueButton;
	ConfirmOrderPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public ConfirmationPage clickOnContinue()
	{
		ua.click(continueButton);
		return new ConfirmationPage();
	}
}