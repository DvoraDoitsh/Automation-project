package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ProfilePage;
import pageObject.TimeLinePage;

public class EditProfileTest extends BaseTest {
	
	@Test
	(description = "this test cheks if you can edit your details")
	public void tc01_editDetailsTest() {
		TimeLinePage tp = new TimeLinePage(driver);
		tp.openMyProfilePage();
		ProfilePage pfp = new ProfilePage(driver);
		pfp.addMyDetails();		
		tp.openMyProfilePage();
		Assert.assertEquals(pfp.editProfileAssert(), "Dvori Doitsh , d0527608500@gmail.com");
	}	
}
