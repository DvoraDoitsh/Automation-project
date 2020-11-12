package pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
	
	protected WebDriver driver;
	WebDriverWait wait;
	Actions actions;
	
	BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
		wait = new WebDriverWait(driver, 15);
		actions = new Actions(driver);		
	}

	WebDriver getDriver() {
		return driver;
	}

	public WebDriverWait getWait() {
		return wait;
	}

	void fillText(WebElement el, String text) {
		el.clear();
		highlightElement(el, "blue");	
		sleep(300);
		el.sendKeys(text);
	}

	void click(WebElement el) {
		// hightlight
		highlightElement(el, "blue");	
		//sleep(1000);
		el.click();
	}

	String getText(WebElement el) {
		highlightElement(el, "orange");
		//sleep(300);
		return el.getText();
	}

	void alertOK(String text) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(text);
		alert.accept();
	}

	void alertOK() {
		getDriver().switchTo().alert().accept();
	}
	
	void moveMouse(WebElement el) {
		actions.moveToElement(el).build().perform();
	}
	
	void moveRightClicMouse(WebElement el) {
		actions.moveToElement(el).contextClick().build().perform();
	}
	
	void select(WebElement el, String value) {
		Select s = new Select(el);
		s.selectByValue(value);
	}

	void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void waitForVisiblityOfElement (List<WebElement> list) {
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}
	
	void waitForElementToBeClickble (WebElement el) {
		wait.until(ExpectedConditions.elementToBeClickable(el));
	}
	
	String getPageTitle() {
		return getDriver().getTitle();
	}	

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 */
	private void highlightElement(WebElement element, String color) {
			//keep the old style to change it back
			String originalStyle = element.getAttribute("style");
			String newStyle = "border: 1px solid " + color + ";" + originalStyle;
			JavascriptExecutor js = (JavascriptExecutor) driver;			
			// Change the style 
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
					element);
			// Change the style back after few miliseconds
			js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
					+ originalStyle + "');},400);", element);
		}
}

