package src.page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InsuranceInfo {

	private WebDriver driver;

	public InsuranceInfo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("isPrimarySubscriber")));
	}

	@FindBy(css = "[placeholder='Search Address']")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(css = "div[class='pac-container pac-logo hdpi']")
	@CacheLookup
	WebElement lstAddress;

	@FindBy(xpath = "//label[@for='appointmentTypeId']/following-sibling::div")
	@CacheLookup
	WebElement txtTreatment;

	@FindBy(xpath = "//label[@for='insuranceId']/following-sibling::div")
	@CacheLookup
	WebElement txtInsurance;
	
	@FindBy(id = "isPrimarySubscriber")
	@CacheLookup
	WebElement chkPrimaryPolicyHolder;
	
	@FindBy(xpath = "//label[@for='gender']/following-sibling::div")
	@CacheLookup
	WebElement txtGender;
		
	@FindBy(id = "policyNumber")
	@CacheLookup
	WebElement txtPolicyNumber;
	
	@FindBy(id = "groupPolicyNumber")
	@CacheLookup
	WebElement txtGroupPolicyNumber;
	
	@FindBy(id = "termsAgreement")
	@CacheLookup
	WebElement chktermsAgreement;
	
	@FindBy(xpath = "//input[@type='file'][1]")
	@CacheLookup
	WebElement fileInsuranceCardFront;
	
	@FindBy(xpath = "(//input[@type='file'])[2]")
	@CacheLookup
	WebElement fileInsuranceCardBack;
	
	@FindBy(xpath = "//button[@type='submit' and text()='Next']")
	@CacheLookup
	WebElement btnNext;

	public void enterAddress(String address) throws InterruptedException {
		txtAddress.sendKeys(address);
		Thread.sleep(2000);
		txtAddress.sendKeys(Keys.ARROW_DOWN);
		lstAddress.click();
		Thread.sleep(2000);
		src.common.Util.logInfo("Select Address");
	}

	public void enterTreatment(String treatment) {
		txtTreatment.click();
		selectOption(treatment);
		src.common.Util.logInfo("Select Treatment");
	}
	
	public void enterInsurance(String Insurance) {
		txtInsurance.click();
		selectOption(Insurance);
		src.common.Util.logInfo("Select Insurance");
	}

	public void selectGender(String gender) {
		txtGender.click();
		selectOption(gender);
		src.common.Util.logInfo("Select Gender");
	}
	
	public void selectOption(String name) {
		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content' and text()='" + name + "']")).click();
		src.common.Util.logInfo("Select dropdown option");
	}
	
	public void selectPrimaryPolicyHolder() {
		chkPrimaryPolicyHolder.click();
		src.common.Util.logInfo("Enter Primary Policy Holder Details");
	}
	
	public void enterPolicyNumber(String policyNumber) {
		txtPolicyNumber.sendKeys(policyNumber);
		src.common.Util.logInfo("Enter Policy Number");
	}
	
	public void enterGroupPolicyNumber(String groupPolicyNumber) {
		txtGroupPolicyNumber.sendKeys(groupPolicyNumber);
		src.common.Util.logInfo("Enter GroupPolicy Number");
	}
	
	public void selectTermsAgreement() {
		chktermsAgreement.click();
		src.common.Util.logInfo("Select Terms & Agreement");
	}
	
	public void selectInsuranceCardFront(String imageName) {
		String imagePath = System.getProperty("user.dir") + "\\hellolunajoy\\src\\images\\"+imageName;
		fileInsuranceCardFront.sendKeys(imagePath);
		src.common.Util.logInfo("Upload Insurance Card Front Image");
	}
	
	public void selectInsuranceCardBack(String imageName) {
		String imagePath = System.getProperty("user.dir") + "\\hellolunajoy\\src\\images\\"+imageName;
		fileInsuranceCardBack.sendKeys(imagePath);
		src.common.Util.logInfo("Upload Insurance Card Back Image");
	}
	
	public void clickNextButton() {
		btnNext.click();
		src.common.Util.logInfo("Click on Next Button");
	}
}
