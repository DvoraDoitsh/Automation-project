package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BoardPage extends RightMenuPage {

	@FindBy(css="[data-hook='add-task']")
	WebElement addTaskBtn;
	@FindBy(css="[data-hook='remove']>span")
	WebElement deleteBtn;
	@FindBy(css="[data-hook='hide']")
	WebElement hidaBtn;
	@FindBy(css="[data-hook='unhide']")
	WebElement unhidaBtn;
	@FindBy(css="[data-hook='footer-spacer']")
	WebElement openTask;
	@FindBy(css="[data-hook='add-status']")
	WebElement addStatusBtn;
	@FindBy(css="[data-hook='hidden-statuses-container']")
	WebElement addStatusField;
	@FindBy(css="[data-status-name='Done'] [data-hook='context-menu']")
	WebElement doneSettingsBtn;
	@FindBy(css="[data-hook='hidden-statuses'] [data-hook='context-menu']")
	WebElement hideSettingsBtn;
	@FindBy(css="[data-hook='remove']")
	WebElement removeBtn;
	@FindBy(css="[data-hook='context-menu']")
	WebElement settingsBtn1;
	@FindBy(css="[data-hook='move-tasks']")
	WebElement moveBtn;
	@FindBy(css="[data-value='11']")
	WebElement inprogressBtn;
	
	public BoardPage(WebDriver driver) {
		super(driver);		
	}

	public void openTask() {
		click(addTaskBtn);
	}

	/*
	 * This method deletes tasks by click on setting move mouse to tatus and right click than click on the delete and confirm
	 */
	public void deleteTask (String TaskName) {
		List<WebElement> list = driver.findElements(By.cssSelector("[data-hook='name']"));
		for (WebElement el : list) {
			waitForVisiblityOfElement(list);
			moveRightClicMouse(el);	
			waitForElementToBeClickble(deleteBtn);
			click(deleteBtn);
			sleep(500);
			break;
		}		
	}

	/*
	 * This method open a task that already exist by click on the task
	 */
	public void editTask(String taskName) {
		List<WebElement> list = driver.findElements(By.cssSelector("[data-hook='name']"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(taskName)) {
				click(el);
			}
		}
	}

	public void editPlan(String name, String newName) {
		List<WebElement> list = driver.findElements(By.cssSelector("[data-hook='project-view']"));
		for (int i = 0; i < list.size(); i++) {
			if (getText(list.get(i)).equalsIgnoreCase(name)) {
				waitForVisiblityOfElement(list);
				moveMouse(list.get(i));
				wait.until(ExpectedConditions.presenceOfElementLocated((By) list.get(i)));
				List<WebElement> SettingsList = driver.findElements(By.cssSelector("[data-hook='settings']>button")); //
				click(SettingsList.get(i));
			}
		}					
	}

	/*
	 * This method change status for all tasks in the status by click on setting move mouse to change status and click on the status
	 */
	public void moveAllTasks() {
		click(settingsBtn1);
		moveMouse(moveBtn);
		List<WebElement> list = driver.findElements(By.cssSelector(".p:flex-auto p:mr-4"));
		for (WebElement el : list) {
			if (getText(el).equalsIgnoreCase(" In progress")) {
				click(el);
			}
		}
	}

	public void addStatus(String statusName) {
		click(addStatusBtn);
		sleep(500);
		fillText(addStatusField, statusName);
	}

	public void deleteStatus() {
		click(doneSettingsBtn);
		click(deleteBtn);		
	}

	public void hideStatus() {
		click(doneSettingsBtn);
		click(hidaBtn);
	}

	public void unhideStatus() {
		click(hideSettingsBtn);
		click(unhidaBtn);
	}

	/*
	 * Assertion methods
	 */

	/*
	 * This method check if task exist by running on the tasks and look for the  demand task than it return true or false according the results
	 */
	public boolean checkIfTaskExist(String taskName) {
		List<WebElement> list = driver.findElements(By.cssSelector("[data-hook='name']"));
		System.out.println(list.size());
		System.out.println("checkIfTaskExist: " + list.size());
		for (WebElement el : list) {
			System.out.println(getText(el));
			if (getText(el).equalsIgnoreCase(taskName)) {
				return true;
			}
		}
		return false;
	}

	public boolean checkIfStatusExist(String statusName) {
		List<WebElement> list = driver.findElements(By.cssSelector("[data-hook='status-name']"));
		System.out.println(list.size());
		System.out.println("checkIfTaskExist: " + list.size());
		for (WebElement el : list) {
			System.out.println(getText(el));
			if (getText(el).equalsIgnoreCase(statusName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkIfStatusIsHidden(String statusName) {
		List<WebElement> list = driver.findElements(By.cssSelector("[data-hook='hidden-statuses']"));
		for (WebElement el : list) {
			System.out.println(getText(el));
			if (getText(el).equalsIgnoreCase(statusName)) {
				return true;
			}
		}
		return false;
	}
}


