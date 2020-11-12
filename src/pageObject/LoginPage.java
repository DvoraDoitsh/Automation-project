package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	@FindBy(css="[name='email']")
	WebElement emailField;
	@FindBy(css="[name='password']")
	WebElement passwordField;
	@FindBy(css=".auth-form__submit")
	WebElement loginBtn;
	@FindBy(css=".auth-form__forgot")
	WebElement forgotPasswordBtn;
	@FindBy(css=".auth__error--visible")
	WebElement errorLoginMsg;
	@FindBy(css="div:nth-child(3) .text--color-new-error")
	WebElement errorEmailMsg;
	@FindBy(css="div:nth-child(4) > div > div.row.p\\:items-center.text--color-new-error")
	WebElement errorPasswordMsg;
	@FindBy(css="data-hook='info-text'")
	WebElement resetPasswordMsg;
	@FindBy(css="[data-tooltip='My Profile']")
	WebElement loading;
    
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/*
	 * This test does login by fill text with email and user and click on login button
	 */
	public void loginTest(String email, String password) {
		fillText(emailField, email);
		fillText(passwordField, password);
		click(loginBtn);
		sleep(500);
		//waitForElementToBeClickble(loading);

	}
	
	/*
	 * This method click on forgot password button
	 */
	public void goToForgotPassword() {
		click(forgotPasswordBtn);
	}
	
	/*
	 * Assertion methods
	 */

	/*
	 * This method returns the error message when login fail
	 */
	public String getErorMsgLogin() {
		return getText(errorLoginMsg);
	}
	
	/*
	 * This method returns the message after doing reset password
	 */
	public String resetPassAssert() {
		return getText(resetPasswordMsg);
	}
}


