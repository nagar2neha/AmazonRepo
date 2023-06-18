package practicePOMTestcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import Pages.DealsPage;
import Pages.CustomerServicePage;
import Pages.HomePage;
import Pages.LoginPage;

public class DealsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	DealsPage dealsPage;
	
	public DealsPageTest() {
		super();
	}

	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		dealsPage = new DealsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dealsPage = homePage.clickOnDealsLink();
	}
	@Test(priority=1)
	public boolean verifyDealsLabel() {
		return dealsPage.verifyDealsPage();
	}
	
	@Test(priority = 2)
	public void verifyAmazonDevicesLink() {
		dealsPage.verifySpeakersDeals();
	}


	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
