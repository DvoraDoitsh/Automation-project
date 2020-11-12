package pageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectsPage extends RightMenuPage {

	@FindBy(css="[aria-label='Add New Plan']")
	WebElement addPlanBtn;
	@FindBy(css="[data-hook='item-name']")
	List<WebElement> projectsList;
	@FindBy(css=".sidebar-title-label")
	List<WebElement> areasTitle;
	@FindBy(css="[data-hook='project-view']")
	List<WebElement> plansList;
	@FindBy(css="[data-hook='settings']")
	WebElement setPlanBtn;
	@FindBy(css=".delete")
	WebElement moreActionsdelete;
	@FindBy(css="#success-confirm")
	WebElement yesdelete;
	@FindBy(css="#intercom-css-container")
	WebElement addTaskArea;

	public ProjectsPage(WebDriver driver) {
		super(driver);
	}

	public void addNewPlan() {
		click(addPlanBtn);	
	}

	public void addTaskFromCalender() {
		click(addTaskArea);
	}

	/*
	 * This method deletes plans by runing on the plans list and move mouse to the demand list than click on settings button and click on delete and confirm
	 */
	public void deleteProject(String ProjectName) {
		for (WebElement el : plansList) {
			if (getText(el).equalsIgnoreCase(ProjectName)) {
				moveMouse(el);
				click(setPlanBtn);
				click(moreActionsdelete);
				click(yesdelete);
			}
		}
	}
	/*
	 * Assertion methods
	 */

	/*
	 * This method checks if you are in the project planing calendar after login
	 */
	public String checkLoginSucceed() {
		return getPageTitle();
	}

	/*
	 * This method check if plan exist by running on the plans and looking for the  demand plan than it return true or false according the results
	 */
	public boolean checkIfProjectExist(String projectName) {
		for (WebElement el : projectsList) {
			if (getText(el).equalsIgnoreCase(projectName)) {
				return true;
			}
		}
		return false;
	}
}
