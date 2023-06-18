package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.TestBase;

public class DealsPage extends TestBase{
	
	@FindBy(id= "slot-2")
	WebElement dealsLabel;
	
	@FindBy(linkText = "Amazon Devices")
	WebElement amazonDevices;
	
	@FindBy(xpath = "//div[text()='Echo Smart Speakers']")
	WebElement echoSmartSpeaker;
	
	public DealsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyDealsPage() {
		return dealsLabel.isDisplayed();
	}

	public void verifySpeakersDeals() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()",amazonDevices );
		jse.executeScript("arguments[0].scrollIntoView(true);", echoSmartSpeaker);
		echoSmartSpeaker.click();
		
		
	}
}
