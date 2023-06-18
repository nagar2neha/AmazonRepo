package practicePOMTestcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import Pages.SignUpPage;
import TestDataClass.DataFile;
import TestDataClass.Xls_Reader;


public class SignUpTest extends TestBase{
	SignUpPage signupPage;
	DataFile df;
	
	public SignUpTest() {
		super();
	}
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
	    df = new DataFile();
	    signupPage = new SignUpPage();
	}
	@Test(priority = 1)
	public void signUpwithoutPassword() {
		//signupPage.signUp(Name, PhoneorEmail,Password, PasswordAgain);
		signupPage.signUp(df.Name, df.PhoneorEmail, "","");
		System.out.println(df.passwordErr);
		Assert.assertEquals(df.passwordErr, signupPage.passwordErr.getText());
		System.out.println(signupPage.passwordErr.getText());
		
	}
	@Test(priority = 2)
	public void signUpwithmismatchPassword() {
		
		signupPage.signUp(df.Name, df.PhoneorEmail, df.password,df.passwordagain);
		//System.out.println(df.passwordErr);
		Assert.assertEquals(df.mismatchErr, signupPage.mismatchPassErr.getText());
		//System.out.println(signupPage.passwordErr.getText());
		
	}
	@Test(priority = 3,dataProvider = "dp")
	public void signUpwithExistingUser(String Name,String PhoneorEmail, String Password,String PasswordAgain) {
		signupPage.signUp(Name, PhoneorEmail,Password, PasswordAgain);
		//signupPage.signUp(df.Name, df.PhoneorEmail, "","");
		System.out.println(df.userExistErr);
		Assert.assertEquals(df.userExistErr, signupPage.userExistErr.getText());
		System.out.println(signupPage.userExistErr.getText());
				
	}
	@DataProvider
	  public Object[][] dp() {
		  Xls_Reader r = new Xls_Reader("C:\\QA\\Testing\\SignupTestData.xlsx");
		  return new Object[][] {
			  //new Object[] {r.getCellData("Sheet1", "Name", 3),r.getCellData("Sheet1", "Mobile No or email", 3),r.getCellData("Sheet1", "Password", 3),r.getCellData("Sheet1", "Password Again", 3)},
			  //new Object[] {r.getCellData("Sheet1", "Name", 4)},{r.getCellData("Sheet1", "Mobile No or email", 4)},{r.getCellData("Sheet1", "Password", 4)},{r.getCellData("Sheet1", "Password Again", 4)},
			  new Object[] {r.getCellData("Sheet1", "Name", 5),r.getCellData("Sheet1", "Mobile No or email", 5),r.getCellData("Sheet1", "Password", 5),r.getCellData("Sheet1", "Password Again", 5)},
		  };
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
