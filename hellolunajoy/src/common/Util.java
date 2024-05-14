package src.common;

import org.testng.Assert;

import com.aventstack.extentreports.Status;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Util {
	public static void verifyNewWindowUrl(WebDriver driver, String expurl) {
		String originalWindow = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!originalWindow.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				String unreadmsgs = driver.getCurrentUrl();
				src.common.Util.logInfo("The current url :" + unreadmsgs);
				Assert.assertTrue(unreadmsgs.contains(expurl));
				driver.close();
				driver.switchTo().window(originalWindow);
			}
		}
	}

	public static void logInfo(String message) {
		ExtentTestManager.getTest().log(Status.INFO, message);
	}

	public static WebDriver getBrowserDriver(String browser) {
		WebDriver driver = null;
		if (browser == null)
			browser = "chrome";
		switch (browser) {
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case "edge":
			System.setProperty("webdriver.edge.driver", ".\\hellolunajoy\\edgedriver.exe");
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(edgeOptions);
			break;
		case "chrome":
		default:
			System.setProperty("webdriver.chrome.driver", ".\\hellolunajoy\\chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(chromeOptions);
			break;
		}
		return driver;
	}

	public static String getBaseURL(String urlValue) throws MalformedURLException {
		URL url = new URL(urlValue);
		String path = url.getFile().substring(0, url.getFile().lastIndexOf('/'));
		String baseURL = url.getProtocol() + "://" + url.getHost() + path;
		return baseURL;
	}
}
