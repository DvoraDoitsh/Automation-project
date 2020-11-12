package tests;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Utils;
import pageObject.LoginPage;

public class BaseTest {
	WebDriver driver;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\automation\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Utils u = new Utils();
		driver.get(u.readProperty("url"));	
	}
	
	@BeforeClass
	public void setupLogin() {
		//This method does login before each class
		LoginPage lp = new LoginPage(driver);
		lp.loginTest("d0527608500@gmail.com", "dvori996");
	}
	
	@AfterClass
	public void tearnDown() {
		driver.quit();
	}
}

