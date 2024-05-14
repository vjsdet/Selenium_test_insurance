package src.common;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static src.common.ExtentTestManager.startTest;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class baseTest {
	public WebDriver driver;

	@BeforeMethod
	public void setUp(Method method) throws IOException, InterruptedException {
		FileReader reader = new FileReader("./hellolunajoy/common.properties");
		Properties prop = new Properties();
		prop.load(reader);
		String browser = prop.getProperty("browser");
		driver = Util.getBrowserDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://booking-dev.hellolunajoy.com/?referal=website-insurance-validation");		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String testMethodName = method.getName();
		String descriptiveTestName = method.getAnnotation(Test.class).description();
		startTest(testMethodName, descriptiveTestName);
	}

	@AfterMethod
	public void tearup() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

	public WebDriver getDriver() {
		return driver;
	}
}
