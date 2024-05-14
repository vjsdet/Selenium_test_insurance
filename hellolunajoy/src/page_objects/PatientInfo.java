package src.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PatientInfo {

	private WebDriver driver;

	public PatientInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(id = "firstName")
	@CacheLookup
	WebElement txtFirstName;

	@FindBy(id = "lastName")
	@CacheLookup
	WebElement txtLastName;

	@FindBy(css = "[placeholder='MM/DD/YYYY']")
	@CacheLookup
	WebElement txtDOB;

	@FindBy(id = "mobileNumber")
	@CacheLookup
	WebElement txtMobileNumber;

	@FindBy(id = "email")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(xpath = "//button[@type='submit' and text()='Next']")
	@CacheLookup
	WebElement btnNext;

	public void enterFirstName(String firstName) {
		txtFirstName.sendKeys(firstName);
		src.common.Util.logInfo("Enter First Name");
	}

	public void enterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
		src.common.Util.logInfo("Enter Last Name");
	}

	public void enterDOB(String dob) {
		txtDOB.sendKeys(dob);
		src.common.Util.logInfo("Enter DOB");
	}

	public void enterMobileNumber(String mobileNumber) {
		txtMobileNumber.sendKeys(mobileNumber);
		src.common.Util.logInfo("Enter Mobile Number");
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
		src.common.Util.logInfo("Enter Email");
	}

	public void clickNextButton() {
		btnNext.click();
		src.common.Util.logInfo("Click Next Button");
	}
}
