package Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;

import BaseClass.TestBase;

public class SignUpPage extends TestBase{
	
	@FindBy(linkText = "Start here.")
	WebElement starthere;
	
	@FindBy(id = "ap_customer_name")
	WebElement name;
	
	@FindBy(id = "ap_email")
	WebElement phoneOrEmail;
	
	@FindBy(id = "ap_password")
	WebElement password;
	
	@FindBy(id = "ap_password_check")
	WebElement passwordAgain;
	
	@FindBy(id = "continue")
	WebElement Continue;
	
	@FindBy(id = "auth-continue")
	WebElement verifyemail;
	
	@FindBy(id = "auth-password-missing-alert")
	public WebElement passwordErr;
	
	@FindBy(id = "auth-password-mismatch-alert")
	public WebElement mismatchPassErr;
	
	@FindBy(xpath= "//h4[text()='E-mail address already in use']")
	public WebElement userExistErr;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public void signUp(String Name,String PhoneorEmail, String Password,String PasswordAgain ) {
		starthere.click();
		name.sendKeys(Name);
		phoneOrEmail.sendKeys(PhoneorEmail);
		password.sendKeys(Password);
		passwordAgain.sendKeys(PasswordAgain);
		Continue.click();
	}
	
	

}
