package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.base.Base;

public class ConfirmationPage extends Base{
	
	
	@ FindBy(className="confirm-order-next-step-button")
	WebElement confirmButton;
	@FindBy(xpath="//*[text()='Your order has been successfully processed!']")
	WebElement successMessage;
	
	public ConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public String captureMessage()
	{
		
		String message=successMessage.getText();
		return message;
	}

}
