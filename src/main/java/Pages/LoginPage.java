package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "nav-link-accountList-nav-line-1")
	WebElement SignIn;
	
	@FindBy (id = "continue")
	WebElement Continue;
	
	@FindBy(id = "signInSubmit")
	WebElement submit;
	
	@FindBy (id = "createAccountSubmit")
	WebElement signUp;
	
	@FindBy(id = "nav-logo")
	WebElement logo;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validatelogoImage(){
		return logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		
	    SignIn.click();
		username.sendKeys(un);
		Continue.click();
		password.sendKeys(pwd);
		submit.click();
		return new HomePage();
		
	}
}
