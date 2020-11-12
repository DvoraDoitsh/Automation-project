package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditTaskPage extends BasePage{

	@FindBy(css="[name='search_name']")
	WebElement nameField;
	@FindBy(css="[data-hook='name-editor']")
	WebElement editNameField;
	@FindBy(css="[data-hook='comments-editor'] p")
	WebElement commentField;
	@FindBy(css="[data-hook='save-button']")
	WebElement sentBtn;
	@FindBy(css=".task-notes p")
	WebElement noteField;
	@FindBy(css="[data-hook='header'] [data-hook='close']")
	WebElement closeBtn;	
	@FindBy(css="[data-hook='status-value']")
	WebElement statusField;
	@FindBy(css="[data-value='930352']")
	WebElement doneStatus;	
	
	public EditTaskPage(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * This method fills name note and comment in a task by fill text and than click on close task
	 */
	public void addTask(String name, String note, String comment) {
		fillText(nameField, name);
		fillText(noteField, note);
		fillText(commentField, comment);
		click(sentBtn);
		click(closeBtn);
	}
	
	/*
	 * This method edits name and status in an exist task 
	 */
	public void changeNameAndStatus(String taskName) {
		fillText(nameField, taskName);
		click(statusField);
		click(doneStatus);
		click(closeBtn);
	}
}
