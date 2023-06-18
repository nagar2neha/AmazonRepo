package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//span[text()='Hello, Neha']")
	WebElement userNameLabel;
	
	@FindBy(linkText ="Deals Store")
	WebElement dealsLink;
	
	@FindBy(linkText = "Customer Service")
	WebElement customerServiceLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	public CustomerServicePage clickOncustomerServiceLink(){
		customerServiceLink.click();
		return new CustomerServicePage();
	}
	
}
