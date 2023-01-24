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
public class IndexPage extends Base{ 
	UserAction ua=new UserAction();
	public IndexPage() 
	{
		PageFactory.initElements(getDriver(), this);
		/* using driver from base class if driver in base class is static
		then only can be used here because static variable can be used 
		without created objects of corresponding classes inside static methods or 
		in non static methods of child class*/
	}
	@FindBy(xpath="//*[@class='ico-register']")
	WebElement registrationBtn;
	
	@FindBy(xpath="//*[@class='ico-login']")
	WebElement loginBtn;
	
	@FindBy(linkText="Wishlist")
	WebElement wishListbtn;
	
	@FindBy(linkText="Shopping Cart")
	WebElement shoppingCartbtn;
	
	@FindBy(css="img[alt='nopCommerce demo store']")
	WebElement logoImg;
	
	@FindBy(css="input[class='search-box-text ui-autocomplete-input']")
	WebElement searchInputBox;
	
	@FindBy(css="button.button-1.search-box-button")
	WebElement searchBtn;
	
	@FindBy(css="a[href='/computers']")
	WebElement computerProductMenu;
	
	public String validateTitle()
	{
		String title=getDriver().getTitle();
		return title;
	}
	public boolean validateDisplaylogo()
	{
		boolean logo=ua.isDisplayed(logoImg);
		return logo;
	}
	public String validateLogoText()
	{
		String logoText=logoImg.getAttribute("alt");
		return logoText;
	}
	public RegisterationPage registrationBtn()
	{
		registrationBtn.click();
		return new RegisterationPage();
	}
	public LoginPage clickOnLogin()
	{
		ua.click(loginBtn);
		return new LoginPage();
	}
	public ProductSearchPage clickOneSarchButton()
	{
		ua.isDisplayed(searchBtn);
		ua.click(searchBtn);
		return new ProductSearchPage();
	}
	public void searchInputBox()
	{
		ua.isDisplayed(searchInputBox);
		ua.sendkeys("phone", searchInputBox);
		
	}
	public WishListPage clickOnWishList()
	{
		ua.isDisplayed(wishListbtn);
		ua.click(wishListbtn);
		return new WishListPage();
	}
	public CartPage clickOnShoppingCartButton()
	{
	    ua.isDisplayed(shoppingCartbtn);
	    ua.click(shoppingCartbtn);
	    return new CartPage();
	}
	public SearchResultPage computerProductCategory()
	{
		ua.isDisplayed(computerProductMenu);
		ua.click(computerProductMenu);
		return new SearchResultPage();
	}
}
