package pageObject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RightMenuPage extends BasePage {

	@FindBy(css="[data-hook='board-view']")
	WebElement projectLine;
	@FindBy(css="[data-hook='board-view']")
	WebElement selectBoardLine;
	@FindBy(css="[data-hook='remove-button']")
	WebElement deleteBtn;
	@FindBy(css="#success-confirm")
	WebElement confirnDeleteBtn;	
	@FindBy(css="[data-path='me']")
	WebElement openProfileBtn;	
	@FindBy(css="[aria-label='Users']")
	WebElement openUsersBtn;

	public RightMenuPage(WebDriver driver) {
		super(driver);
	}

	public void goToBoardPage() {
		click(projectLine);
		click(selectBoardLine);
		sleep(1000);
	}

	public void deleteProject (String TaskName) {
		List<WebElement> list = driver.findElements(By.cssSelector("[data-hook='project-view']"));
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			if (getText(list.get(i)).equalsIgnoreCase(TaskName)) {
				sleep(500);
				moveMouse(list.get(i));
				sleep(500);
				List<WebElement> SettingsList = driver.findElements(By.cssSelector("[data-hook='settings']>button")); //
				click(SettingsList.get(i));
				click(deleteBtn);
				click(confirnDeleteBtn);
				break;
			}
		}
	}

	public void editPlan(String name, String newName) {
		List<WebElement> list = driver.findElements(By.cssSelector("[data-hook='project-view']"));
		for (int i = 0; i < list.size(); i++) {
			if (getText(list.get(i)).equalsIgnoreCase(name)) {
				sleep(500);
				moveMouse(list.get(i));
				sleep(500);
				List<WebElement> SettingsList = driver.findElements(By.cssSelector("[data-hook='settings']>button")); //
				click(SettingsList.get(i));
			}
		}
	}
	
	public void openMyProfilePage() {
		click(openProfileBtn);
		sleep(4000);
	}
	
	public void openUsersePage() {
		click(openUsersBtn);
		sleep(500);
	}
}
