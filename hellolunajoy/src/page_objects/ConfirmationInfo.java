package src.page_objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationInfo {

	private WebDriver driver;

	public ConfirmationInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4>p")));
	}

	@FindBy(tagName = "h1")
	@CacheLookup
	WebElement heading;

	@FindBy(css = "h4>b")
	@CacheLookup
	WebElement headingInProgress;

	@FindBy(css = "h4>p")
	@CacheLookup
	WebElement headingInProgressMessage;

	public String getHeading() {
		return heading.getText();
	}

	public String getInProgressHeading() {
		return headingInProgress.getText();
	}
	
	public String getInProgressMessage() {
		return headingInProgressMessage.getText();
	}
}
