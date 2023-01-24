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
public class CheckOutPage extends Base {

	UserAction ua= new UserAction();
	@FindBy(xpath="//input[contains(@value,'Ground___Shipping.FixedByWeightByTotal')]")
	WebElement groundPay;
	@FindBy(css="button.button-1.shipping-method-next-step-button")
	WebElement continueButton;
	
	public CheckOutPage()
	{

		PageFactory.initElements(getDriver(), this);
	
	/* using driver from base class if driver in base class is static
	then only can be used here because static variable can be used 
	without created objects of corresponding classes inside static methods or 
	in non static methods of child class*/
	
	}
	public OrderPage paymentMethod()
	{
		ua.click(groundPay);
		ua.click(continueButton);
		return new OrderPage();
		
	}
}
