/**
 * 
 */
package com.ecommerce.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pageobjects.IndexPage;
import com.ecommerce.pageobjects.RegisterationPage;

/**
 * @author Admin
 *
 */
public class IndexPageTest extends Base{
	private IndexPage ip;
	private RegisterationPage rp;
	
	@Test(priority=3)
	public void validateDisplayLogo()
	{   
		ip=new IndexPage();
		boolean logo = ip.validateDisplaylogo();
		Assert.assertTrue(logo);
		
	
	}
	@Test(priority=3)
	void verifyLogoText()
	{    
		ip=new IndexPage();
		String expectedTital= "nopCommerce demo store";
		String actualTital= ip.validateLogoText();
		Assert.assertEquals(actualTital, expectedTital);
		
	}
	@Test(priority=1)
	public void verifyTitle()
	{
		ip=new IndexPage();
		String expectedLogo="nopCommerce demo store";
		String actualLogo=ip.validateTitle();
		Assert.assertEquals(actualLogo, expectedLogo);
	}
	@Test
	public void RegistrationbtnTest()
	{
		   ip=new IndexPage();
            ip.registrationBtn();
	}
}
