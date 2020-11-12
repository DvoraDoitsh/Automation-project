package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.BoardPage;
import pageObject.TimeLinePage;

public class EditStatusTest extends BaseTest {
	
	@Test (description = "this test cheks if you can hide status")
	public void tc01_hideStatus() {
		TimeLinePage tp = new TimeLinePage(driver);
		tp.goToBoardPage();
		BoardPage bp= new BoardPage(driver);
		bp.hideStatus();
		Assert.assertEquals(bp.checkIfStatusIsHidden("Done"), true);
	}
	
	@Test(description = "this test cheks if you can unhide status")
	public void tc02_unhideStatus() {
		BoardPage bp= new BoardPage(driver);
		bp.unhideStatus();
		Assert.assertEquals(bp.checkIfStatusIsHidden("Done"), false);
	}
}
