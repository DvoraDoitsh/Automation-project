package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactInfoPage extends BasePage{

	@FindBy(css="[name='city']")
	WebElement cityField; 
	@FindBy(css="[name='country']")
	WebElement countryMenu;
	@FindBy(css="[name='street']")
	WebElement streetfield;
	@FindBy(css="[name='postal'] ")
	WebElement postalField;
	@FindBy(css="[name='state']")
	WebElement statefield;
	@FindBy(css="[data-hook='button-save']")
	WebElement saveBtn;
	@FindBy(css="[data-hook='button-cancel'] ")
	WebElement cancelBtn;
	@FindBy(css="[data-hook='state-input'] [data-hook='error-text']")
	WebElement errorMsg;


	public ContactInfoPage(WebDriver driver) {
		super(driver);		
	}

	/*
	 * this method edits contacts info of a user by fill text with the details and than click on save button 
	 */
	public void fillContactInfo(String city, String country, String street, String postal, String state) {
		fillText(cityField, city);
		select(countryMenu,country);
		fillText(streetfield, street);
		fillText(postalField, postal);
		fillText(statefield, state);
		click(saveBtn);
	}
	
	/*
	 * this method edits contacts info of a user and doesn't give all the details - the page have to return an error message
	 */
	public void fillContactInfoFail(String city, String country, String street) {
		fillText(cityField, city);
		select(countryMenu,country);
		fillText(streetfield, street);
		click(saveBtn);
	}
	/*
	 * Assertion methods
	 */

    /*
     * this method return the error message that comes if you miss detail in contact info of a user
     */
	public String getErrorMessage() {
		return getText(errorMsg);
	}
}
