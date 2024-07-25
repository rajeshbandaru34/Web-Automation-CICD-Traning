package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Web_Elements {

	//Login page
	@FindBy(xpath = "//input[@id='user-name']")public WebElement Username;
	@FindBy(xpath = "//input[@id='password']")public WebElement Password;
	@FindBy(xpath = "//input[@id='login-button']")public WebElement Login_Button;
	
	//homepage
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")public WebElement Add_To_cart;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")public WebElement Cart;
	@FindBy(xpath = "//button[@id='checkout']")public WebElement Checkout;
	
	//checkout
	@FindBy(xpath = "//input[@id='first-name']")public WebElement First_Name;
	@FindBy(xpath = "//input[@id='last-name']")public WebElement Last_Name;
	@FindBy(xpath = "//input[@id='postal-code']")public WebElement Postal_Code;
	@FindBy(xpath = "//input[@id='continue']")public WebElement Continue_Button;
	@FindBy(xpath = "//button[@id='finish']")public WebElement Finish_Button;
	@FindBy(xpath = "//button[@id='back-to-products']")public WebElement Back_To_home;
	
}
