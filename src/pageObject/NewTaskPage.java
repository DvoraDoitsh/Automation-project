package pageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTaskPage extends BasePage {

	@FindBy(css="[data-hook='title']")
	List<WebElement> taskParametersTitle;
	@FindBy(css="[data-hook='input-container']")
	List<WebElement> taskParameters;	
	@FindBy(css="[data-value='888065']")
	WebElement inProgressBtn;	
	@FindBy(css="[data-hook='item-value']")
	List<WebElement> projectsList;
	@FindBy(css="[name='search_start_date']")
	WebElement fromDateslField;
	@FindBy(css="[name='email']")
	WebElement SelectFromDatelField;
	@FindBy(css="[name='search_end_date']")
	WebElement toDateslField;
	@FindBy(css="[name='email']")
	WebElement SelectToDatelField;
	
	public NewTaskPage(WebDriver driver) {
		super(driver);
	}
	
	public void addNewTask(String parameter){
		for (WebElement el : taskParameters) {
			if (getText(el).equalsIgnoreCase(parameter)) {
				click(el);
				click(inProgressBtn);
			}
		}
	}
}
