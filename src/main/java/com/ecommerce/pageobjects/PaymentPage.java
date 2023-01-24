/**
 * 
 */
package com.ecommerce.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.base.Base;

/**
 * @author Admin
 *
 */
public class PaymentPage extends Base {

	@FindBy(id="paymentmethod_1")
	WebElement paymentMethodCredit;
	
	@FindBy(css="button[name='save']")
	WebElement continueNext;
	PaymentPage()
	{
	PageFactory.initElements(getDriver(), this);
	/* using driver from base class if driver in base class is static
	then only can be used here because static variable can be used 
	without created objects of corresponding classes inside static methods or 
	in non static methods of child class*/
	}
	
}
