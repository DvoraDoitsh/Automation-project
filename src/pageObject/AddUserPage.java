package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddUserPage extends BasePage {

	@FindBy(css="[data-hook='input-name']")
	WebElement emailfield; 
	@FindBy(css="[data-hook='button-ok']")
	WebElement addBtn; 
	
	public AddUserPage(WebDriver driver) {
		super(driver);		
	}	
	/*
	 * This method adds a new user by fill email and than click on add button
	 */
	public void addUser(String email) {
		fillText(emailfield, email);
		click(addBtn);
		sleep(1000);
	}
}
