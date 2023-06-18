package practicePOMTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.DealsPage;
import Pages.CustomerServicePage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	CustomerServicePage groceryPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		loginPage = new LoginPage();
		dealsPage = new DealsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Amazon.ca: Low Prices – Fast Shipping – Millions of Items","Home page title not matched");
	}
	@Test(priority=2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	@Test(priority=3)
	public void verifyCustomerServiceLinkTest() {
		homePage.clickOncustomerServiceLink();
	}
	@Test(priority = 4)
	public void verifyDealsLinkTest() {
		dealsPage = homePage.clickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
