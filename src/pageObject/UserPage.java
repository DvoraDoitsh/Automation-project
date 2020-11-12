package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPage extends BasePage {

	@FindBy(css="[data-hook='user-menu'] [data-hook='button-delete']")
	WebElement deletaBtn; 
	@FindBy(css="#success-confirm")
	WebElement confirmDeletaBtn;  
	@FindBy(css="[data-hook='button-close']")
	WebElement closeBtn; 
	@FindBy(css="[data-hook='workspace-owner-edit-contact']")
	WebElement openContactBtn; 	
	
	public UserPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * This method deletes user by click on delete and confirm
	 */
	public void deleteUser() {
		click(deletaBtn);
		click(confirmDeletaBtn);
		sleep(1000);
	}
	
	public void closePage() {
		click(closeBtn);
	}
	
	public void openContactPage() {
		click(openContactBtn);
	}
}
