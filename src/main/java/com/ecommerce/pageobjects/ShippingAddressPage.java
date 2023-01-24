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
public class ShippingAddressPage extends Base {

	UserAction ua=new UserAction();
			
	@FindBy(id="BillingNewAddress_CountryId")
	WebElement selectCountry;
	
	@FindBy(id="BillingNewAddress_StateProvinceId")
	WebElement selectProvince;
	
	@FindBy(id="BillingNewAddress_City")
	WebElement inputCity;
	
	@FindBy(id="BillingNewAddress_Address1")
	WebElement addressLine1;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement zipCode;
	
	@FindBy(id="BillingNewAddress_ZipPostalCode")
	WebElement inputPhone;
	
	@FindBy(name="save")
	WebElement continueNext;
	
	ShippingAddressPage()
	{
	PageFactory.initElements(getDriver(), this);
	/* using driver from base class if driver in base class is static
	then only can be used here because static variable can be used 
	without created objects of corresponding classes inside static methods or 
	in non static methods of child class*/
	}
	
	public CheckOutPage addShippingAddress(String Country, String Province, String City, String addressLine, String zip, String phone)
	{
		ua.selectByVisibleText(Country, selectCountry);
		ua.selectByVisibleText(Province, selectProvince);
		ua.sendkeys(City, inputCity);
		ua.sendkeys(addressLine, addressLine1);
		ua.sendkeys(zip, zipCode);
		ua.sendkeys(phone, inputPhone);
		ua.click(continueNext);
		ua.acceptAlert();
		return new CheckOutPage();
				
	}
}
