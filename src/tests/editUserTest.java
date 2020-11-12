package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.AddUserPage;
import pageObject.ContactInfoPage;
import pageObject.ProfilePage;
import pageObject.TimeLinePage;
import pageObject.UserPage;
import pageObject.UsersPage;


public class editUserTest extends BaseTest{

	@Test (description = "this test cheks if you can add a new user")
	public void tc01_addUserTest() {
		TimeLinePage tp = new TimeLinePage(driver);
		tp.openMyProfilePage();
		ProfilePage pp = new ProfilePage(driver);
		pp.goToUsersPage();
		UsersPage usp = new UsersPage(driver);
		long before = usp.getNumOfUsers();
		usp.addNewUser();
		AddUserPage aup = new AddUserPage(driver);
		aup.addUser("d0533169784");
		UsersPage usp1 = new UsersPage(driver);
		long after = usp1.getNumOfUsers();		
		Assert.assertEquals(after, before+1);
	}
	
	@Test (description = "this test cheks if you can edit contact info of a user")
	public void tc02_editContactInfo() {
		UsersPage usp = new UsersPage(driver);
		usp.openUserInfo();
		UserPage up = new UserPage(driver);
		up.openContactPage();
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.fillContactInfo("Ramat Gan", "IL", "Eli Hacohen", "9387453", "Israel");
		up.closePage();
	}
	
	@Test (description = "this test cheks if you can delete a user")
	public void tc03_deleteUser() {
		UsersPage usp = new UsersPage(driver);
		long before = usp.getNumOfUsers();
		usp.openUser1Info();
		UserPage up = new UserPage(driver);
		up.deleteUser();
		long after = usp.getNumOfUsers();
		Assert.assertEquals(after, before-1);
	}
	
	@Test (description = "this test cheks if you get an error message when you edit contact info of a user and missing details")
	public void tc04_editContactInfofailed() {
		UsersPage usp = new UsersPage(driver);
		usp.openUserInfo();
		UserPage up = new UserPage(driver);
		up.openContactPage();
		ContactInfoPage cip = new ContactInfoPage(driver);
		cip.fillContactInfoFail("Ramat Gan", "IL", "Eli Hacohen");		
		Assert.assertEquals(cip.getErrorMessage(), "State cannot be empty");		
	}
}
