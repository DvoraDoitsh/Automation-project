package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.ProjectsPage;
import pageObject.ResetPassword;

public class LoginTest extends BaseTest {


	@Override  //This method override the setup login method
	public void setupLogin() {
	}

	@Test(dataProvider  = "getData", description = "This method checks if login fail when you dont insert the right details, this test using data provider") 
	public void tc01_loginFailed(String email, String password) {
		LoginPage lp = new LoginPage(driver);
		lp.loginTest(email, password);
		Assert.assertEquals(lp.getErorMsgLogin(), "Unable to log in. Please check your email and password.");		
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] myData = {
				{"d0527608500@gmail", "dvori996"},
				{"d0527608500@gmail.com", "dv96"},
				{"a@gmail.com", "dvori996"},
				{"d0527608500@gmail.com", "hjvjhvj"},
		};
		return myData;
	}

	@Test (description = "This method checks if you can reset you password")
	public void tc02_forgotPassTest() {
		LoginPage lp = new LoginPage(driver);
		lp.goToForgotPassword();
		ResetPassword rp = new ResetPassword(driver);
		rp.sendResetToEmail("d0527608500@gmail.com");
		System.out.println(lp.resetPassAssert());
	}

	@Test
	public void tc03_loginSucceed() {
		LoginPage lp = new LoginPage(driver);
		lp.loginTest("d0527608500@gmail.com", "dvori996");
		ProjectsPage pp = new ProjectsPage(driver);
		Assert.assertEquals(pp.checkLoginSucceed(), "Toggl Plan - Project Planning Calendar Tool");
	}
}
