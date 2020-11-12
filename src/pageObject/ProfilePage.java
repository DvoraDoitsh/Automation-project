package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {

	@FindBy(css="[name='name']")
	WebElement myNameField;
	@FindBy(css="[name='email']")
	WebElement myEmailField;
	@FindBy(css="[name='first_day_of_week']")
	WebElement startWeekMenu;
	@FindBy(css="[name='timezone']")
	WebElement timeZoneMenu;
	@FindBy(css="[data-hook='settings-done']")
	WebElement saveBtn;	
	@FindBy(css="[data-name='accounts']")
	WebElement workspaceeBtn;	
	@FindBy(css="[data-tab='users']")
	WebElement usersBtn;	
	
	public ProfilePage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * This method edits name, email, start day and location of the user by fill text select and click on save
	 */
	public void addMyDetails() {
		fillText(myNameField, "Dvori Doitsh");
		fillText(myEmailField, "d0527608500@gmail.com");
		select(startWeekMenu,"0");
		select(timeZoneMenu, "Asia/Tel_Aviv");
		click(saveBtn);
	}
	
	public void openWorkspace() {
		click(workspaceeBtn);
	}
	
	public void goToUsersPage() {
		click(usersBtn);
		sleep(500);
	}
	
	/*
	 * Assertion methods
	 */
	
	public String editProfileAssert() {
		String details = getText(myNameField) + "," + getText(myEmailField);
		return details;
	}

}
