package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {

	@FindBy(css="[data-user-name='Dvori Doitsh']")
	WebElement myLine; 
	@FindBy(css="[data-hook='button-add-user']")
	WebElement addUserBtn;
	@FindBy(css="[data-hook='button-edit']")
	WebElement userLine;
	@FindBy(css="[data-user-name='d0533169784']")
	WebElement user1Line; 
	@FindBy(css="[data-hook='label-users-count']")
	WebElement usersNum; 	

	public UsersPage(WebDriver driver) {
		super(driver);
	}

	public void addNewUser() {
		click(addUserBtn);
	}

	public void openUserInfo() {
		sleep(1000);
		click(myLine);
	}

	public void openUser1Info() {
		sleep(1000);
		click(user1Line);		
	}

	public String getUserName() {
		String user = getText(userLine);
		return user;
	}

	/*
	 * Assertion methods
	 */

	/*
	 * This method checks how many user do you have
	 */
	public long getNumOfUsers() {
		String numOfUsers = getText(usersNum);
		long users = Long.parseLong(numOfUsers);
		return users;
	}
}
