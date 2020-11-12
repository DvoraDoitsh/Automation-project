package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPlanPage extends BasePage {

	@FindBy(css="[name='project_name']")
	WebElement projectNameField;
	@FindBy(css="[data-hook='button-color']")
	WebElement chooseColorBtn;
	@FindBy(css="[data-color-id='19']")
	WebElement chooseYellowBtn;
	@FindBy(css="[data-hook='button-submit']")
	WebElement addBtn;	
	@FindBy(css="[data-hook='error-text']")
	WebElement sameProjectError;
	
	public NewPlanPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * This method fills details of a new plan 
	 */
	public void newPlan(String projectName ) {
		fillText(projectNameField, projectName);
		click(addBtn);
		sleep(500);
	}
	
	/*
	 * This method return the error message after adding plan that already exist
	 */
	public String addSameProjectAssert() {
		return getText(sameProjectError);
	}
}
