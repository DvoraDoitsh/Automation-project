package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.NewPlanPage;
import pageObject.ProjectsPage;

public class EditPlanTest extends BaseTest {
	
	@Test (description = "this test cheks if you can add new plan")
	public void tc_01addPlanTest() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addNewPlan();
		NewPlanPage npp = new NewPlanPage(driver);
		npp.newPlan("My first project");		
		Assert.assertEquals(pp.checkIfProjectExist("My first project"), true);		
	}
	
	@Test (description = "this test cheks if you can delete plans")
	public void tc02_dletePlanTest() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.deleteProject("My first project");
		Assert.assertEquals(pp.checkIfProjectExist("My first project"), false);
	}
	
	@Test (description = "this test cheks if you can not add plan that already exist")
	public void tc_03addSamePlanTest() {
		ProjectsPage pp = new ProjectsPage(driver);
		pp.addNewPlan();
		NewPlanPage npp = new NewPlanPage(driver);
		npp.newPlan("Add same plan test");
		pp.addNewPlan();
		npp.newPlan("Add same plan test");		
		Assert.assertEquals(npp.addSameProjectAssert(), "*Project name is already used");
	}
}
