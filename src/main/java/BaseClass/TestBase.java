package BaseClass;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import UtilityClass.TestUtil;
import UtilityClass.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;

	public class TestBase {
		
		public static WebDriver driver;
		public static Properties prop;
		public  static EventFiringWebDriver e_driver;
		public static WebDriverEventListener eventListener;
		
		public TestBase(){
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream("C:\\QA\\SeleniumWorkSpace\\PracPomMaven\\src\\main\\java\\ConfigClass\\config.properties");
				prop.load(ip);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		public static void initialization(){
			String browserName = prop.getProperty("browser");
			
			if(browserName.equals("chrome")){
				//System.setProperty("webdriver.chrome.driver", "/Users/amitv/Downloads/ChromeSetup.exe");	
				WebDriverManager.chromedriver().setup();
		       	driver = new ChromeDriver(); 
			}
			else if(browserName.equals("Firefox")){
				//System.setProperty("webdriver.gecko.driver", "/Users/amitv/Documents/SeleniumServer/geckodriver");	
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver(); 
			}
			
		
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		}
		
}
