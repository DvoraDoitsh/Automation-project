package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.ProfilePage;
import pageObject.TimeLinePage;
import pageObject.WorkspacePage;

public class EditWorkspaceTests extends BaseTest {

	@Test (description = "this test cheks if you can add new worspace")
	public void tc01_addWorkspace() {
		TimeLinePage tp = new TimeLinePage(driver);
		tp.openMyProfilePage();
		ProfilePage pp = new ProfilePage(driver);
		pp.openWorkspace();
		WorkspacePage wp = new WorkspacePage(driver);
		wp.editWorkSpace("Office");
		Assert.assertEquals(wp.checkIfWorkspaceExist("office"), true);
	}

	@Test (description = "this test cheks if you can eddit an exist worspace")
	public void tc02_editWorkspace() {
		WorkspacePage wp = new WorkspacePage(driver);
		wp.editWorkSpace("Home");
		Assert.assertEquals(wp.checkIfWorkspaceExist("Home"), true);
	}

	@Test (description = "this test cheks if you can delete a worspace")
	public void tc03_deleteWorkspace() {
		WorkspacePage wp = new WorkspacePage(driver);
		wp.deleteWorkSpace("Home");
		Assert.assertEquals(wp.checkIfWorkspaceExist("Home"), false);
	}
}
