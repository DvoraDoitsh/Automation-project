package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspacePage extends BasePage {

	@FindBy(css="[data-hook='button-edit']")
	WebElement profileLine;
	@FindBy(css="[data-hook='button-add-workspace']")
	WebElement addWorkspaceBtn;
    @FindBy(css="[data-hook='input-name']")
	WebElement workspaceField;
	@FindBy(css="[data-hook='button-save']")
	WebElement saveBtn;	
	@FindBy(css="[aria-label='Edit']")
	WebElement editWorkspaceBtn;	
	@FindBy(css="div[data-hook='button-delete']")
	WebElement garbageBtn;
	@FindBy(css="#success-confirm")
	WebElement deleteBtn;	
	@FindBy(css="[data-hook='workspaces-container'] [data-hook='label-name']")
	WebElement workspaceName;	
	
	public WorkspacePage(WebDriver driver) {
		super(driver);
	}
	
	public void addWorkSpace(String workspaceName) {
		click(addWorkspaceBtn);
		fillText(workspaceField, workspaceName);
		click(saveBtn);
	}
	
	/*
	 * This method edits workspace by click on the profile line and fill the workspace name and than click on save
	 */
	public void editWorkSpace(String workspaceName) {
		click(profileLine);
		fillText(workspaceField, workspaceName);
		click(saveBtn);
		}
	
	/*
	 * This method edits workspace by click on the profile line and clic on the garbage than click on delete
	 */
	public void deleteWorkSpace(String workspaceName) {
		click(profileLine);
		click(garbageBtn);
		click(deleteBtn);
	}
	
	/*
	 * Assertion methods
	 */
	
	/*
	 * this method checks if workspace exist
	 */
	public boolean checkIfWorkspaceExist(String expectedWorkspaceName) {		
		if (getText(workspaceName).equalsIgnoreCase(expectedWorkspaceName)) {
			return true;
		}
		return false;
	}
}
