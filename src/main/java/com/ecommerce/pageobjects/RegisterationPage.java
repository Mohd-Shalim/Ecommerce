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
public class RegisterationPage extends Base {

	UserAction ua=new UserAction();

	@FindBy(xpath="//div[@id='gender']//child::input[1]")
	WebElement maleRadioBtn;

	@FindBy(xpath="//div[@id='gender']//span[2]/input[1]")
	WebElement femaleRadioBtn;

	@FindBy(id="FirstName")
	WebElement firstNameInputBox;

	@FindBy(id="LastName")
	WebElement lastNameInputBox;

	@FindBy(name="DateOfBirthDay")
	WebElement dateSelect;

	@FindBy(name="DateOfBirthMonth")
	WebElement monthSelect;

	@FindBy(name="DateOfBirthYear")
	WebElement yearSelect;

	@FindBy(id="Email")
	WebElement inputEmail;

	@FindBy(id="Company")
	WebElement inputCompany;

	@FindBy(id="Newsletter")
	WebElement newsletterCheckbox;

	@FindBy(id="Password")
	WebElement passwordInput;

	@FindBy(name="ConfirmPassword")
	WebElement confirmPasswordInput;

	@FindBy(name="register-button")
	WebElement registrationBtn;

	@FindBy(css="div.result")
	WebElement ConfirmationText;

	@FindBy(xpath="//*[text()='Continue']")
	WebElement ContinueToHome;
	

	RegisterationPage()
	{

		PageFactory.initElements(getDriver(), this);
	}


	public String registration(String gender,
			String firstName,
			String lastName,
			String day,
			String month,
			String year,
			String email,
			String company,
			String password,
			String confirmPassword)
	{
		if(gender.equalsIgnoreCase("Mr"))
			ua.click(maleRadioBtn);
		else
			ua.click(femaleRadioBtn);
		ua.sendkeys(firstName, firstNameInputBox);
		ua.sendkeys(lastName, lastNameInputBox);
		ua.selectByVisibleText(day, dateSelect);
		ua.selectByVisibleText(month, monthSelect);
		ua.selectByVisibleText(year, yearSelect);
		ua.sendkeys(email, inputEmail);
		ua.sendkeys(company, inputCompany);
		ua.sendkeys(password, passwordInput);
		ua.sendkeys(confirmPassword, confirmPasswordInput);
		ua.click(registrationBtn);
		ua.explicitWait(ConfirmationText, 5);
		ua.isDisplayed(ConfirmationText);
		String confirmation= ConfirmationText.getText();
		return confirmation;
	}
	 public HomePage clickOnContinue()
	 {
		 ua.click(ContinueToHome);
		 return new HomePage();
		 
	 }
}