/**
 * 
 */
package com.ecommerce.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pageobjects.IndexPage;
import com.ecommerce.pageobjects.RegisterationPage;

/**
 * @author Admin
 *
 */
public class RegistrationPageTest extends Base {
    
	public IndexPage indexPage;
	public RegisterationPage registrationPage;
	
	
	
	@Test(dataProvider="registration",dataProviderClass = com.ecommerce.dataprovider.DataProviders.class)
	public void validateRegistration(HashMap<String, String> map)
	{
		indexPage=new IndexPage();
		//Log.info("entering details");
		registrationPage=indexPage.registrationBtn();
		String message=registrationPage.registration(map.get("gender"),
				map.get("firstName"),
				map.get("lastName"),
				map.get("day"),
				map.get("month"),
				map.get("year"),
				map.get("email"),
				map.get("company"),
				map.get("password"),
				map.get("confirmPassword"));
		//Log.info("checking registration status");
		
		map.entrySet().forEach(entry -> {
		    System.out.println(entry.getKey() + " " + entry.getValue());
		});

		Assert.assertEquals(message, "Your registration completed");
	}
	

}
