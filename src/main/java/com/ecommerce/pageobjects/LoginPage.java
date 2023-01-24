/**
 * 
 */
package com.ecommerce.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.base.Base;
import com.ecommerce.useractionclass.UserAction;

/**
 * @author Admin
 * @param <HomePage>
 *
 */
public class LoginPage extends Base {
    
	UserAction ua=new UserAction();
	public Properties prop;
    
	public LoginPage()
	{
		PageFactory.initElements(getDriver(), this);
		/* using driver from base class if driver in base class is static
		then only can be used here because static variable can be used 
		without created objects of corresponding classes inside static methods or 
		in non static methods of child class*/
	}
     @FindBy(xpath="//*[@id='Email']")
     WebElement emailInputBox;
     
     @FindBy(xpath="//input[@id='Password']")
     WebElement passwordInputBox;
     
     @FindBy(xpath="//*[@for='RememberMe']")
     WebElement remembermeCheckBox;
     
     @FindBy(xpath="//*[@for='RememberMe']//following::a[@href='/passwordrecovery']")
     WebElement forgetPasswordLink;
     
     @FindBy(xpath="//button[contains(text(),'Log in')]")
     WebElement accountLogin;
    
     @FindBy(css="button.button-1.register-button")
     WebElement registerBtn;
     
     public HomePage login(String username, String password)
     {
    	 prop=new Properties();


 		try
 		{
 			//it is also correct=====>
 			//String path="./Configuration\\Config.properties";
 			String path=System.getProperty("user.dir")+"\\Configuration\\Config.properties";
 			FileInputStream	ip = new FileInputStream(path);
 			prop.load(ip);
 		} catch (IOException e)
 		{
 			e.printStackTrace();

 		}
    	 
    	 ua.sendkeys(username, emailInputBox);
    	 ua.sendkeys(password, passwordInputBox);
    	 ua.click(remembermeCheckBox);
    	 ua.click(accountLogin);
    	 return new HomePage();
    	
     }
     public RegisterationPage ClickOnRegister()
     {
    	 ua.click(registerBtn);
    	 return new RegisterationPage();
     }
 
}
