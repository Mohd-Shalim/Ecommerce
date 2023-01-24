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
public class CartPage extends Base {
	
	UserAction ua= new UserAction();
	

	@FindBy(id="//tr/td[@class='quantity'][1]")
	WebElement totalUnits;
	
	@FindBy(xpath="//tr/td[@class='unit-price'][1]")
	WebElement unitPrice;
	
	@FindBy(xpath="//tr/td[@class='subtotal'][1]")
	WebElement subtotal;
	
	@FindBy(id="updatecart")
	WebElement updateCart;
	
	@FindBy(css="label[for='termsofservice']")
	WebElement termsCheckBox;
	
	@FindBy(id="checkout")
	WebElement checkOutBtn;
	
	CartPage()
	{

		PageFactory.initElements(getDriver(), this);
	}
	/* using driver from base class if driver in base class is static
	then only can be used here because static variable can be used 
	without created objects of corresponding classes inside static methods or 
	in non static methods of child class*/
	public boolean priceChecking()
	{
		ua.sendkeys("3", totalUnits);
		ua.click(updateCart);
		
		double t=Double.parseDouble(subtotal.getText());
		double u= Double.parseDouble(unitPrice.getText());
		int i= Integer.parseInt(totalUnits.getText());
		
		if(t==i*u)
		{
			
			return true;
		}
		else
		{
			return false;
		}	
	}
		
	public ShippingAddressPage clickOnCheckOut()
	{
		ua.click(termsCheckBox);
		ua.click(checkOutBtn);
		return new ShippingAddressPage();
	}
		
		
		
	}


