package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPassword extends BasePage {
	
	@FindBy(css="[name='email']")
	WebElement emailField;
	@FindBy(css=".button-v2 ")
	WebElement sendBtn;
	
	public ResetPassword(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * This method fill text with email in order to get reset password email
	 */
	public void sendResetToEmail(String email) {
		fillText(emailField, email);
		click(sendBtn);
	}
}