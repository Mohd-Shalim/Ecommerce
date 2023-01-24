/**
 * 
 */
package com.ecommerce.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ecommerce.base.Base;
import com.ecommerce.pageobjects.IndexPage;
import com.ecommerce.pageobjects.LoginPage;


/**
 * @author Admin
 *
 */
public class LoginPageTest extends Base {
	
	public LoginPage loginPage;
	public IndexPage indexPage;
	
	
	@Test(dataProvider = "credential", dataProviderClass = com.ecommerce.dataprovider.DataProviders.class)
	 public void loginAccount(String username, String password)
	 {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnLogin();
		
		loginPage.login(username,password);
		 
		 
	 }

}
