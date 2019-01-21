package com.PageObjectModel.Base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

import com.PageObjectModel.Utilities.ExcelReader;
import com.PageObjectModel.Utilities.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BasePage {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties prop = new Properties();
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public ExtentReports report = ExtentManager.getInstance();
	public static ExtentTest test;
	public static String browser;
	public static boolean elementPresent = false;
	public static Actions actOnElement = null;
	public static Robot rt = null;

	public static void initialization() {

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// if(System.getenv("Browser")!=null &&
		// !System.getenv("Browser").isEmpty()){
		//
		// browser = System.getenv("Browser");
		// }else{
		//
		// browser = prop.getProperty("Browser");
		//
		// }

		// prop.setProperty("Browser", browser);

		if (prop.get("Browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");

			driver = new ChromeDriver();
			log.debug("Chrome Launched....");
		}

		else if (prop.get("Browser").equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\main\\resources\\executables\\InternetExplorer.exe");

			driver = new InternetExplorerDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
		log.debug("Launched the  " + prop.getProperty("URL"));
		//testExecution("test_login");
		driver.findElement(By.xpath("//*[text()='User Name']/following-sibling::div/input")).sendKeys("raypk");
		driver.findElement(By.xpath("//*[text()='Password']/following-sibling::div/input")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='submit' and @value='Login']")).click();
	}

	public static void clickOnElement(WebElement element) {

		element.click();
		// test.log(LogStatus.INFO, "clicking on ");
	}

	public static void enteringValue(WebElement element, String val) {

		element.sendKeys(val);
		// test.log(LogStatus.INFO, "entering value into ");
	}

	public static void checkElement(WebElement element) {
		elementPresent = element.isDisplayed();

	}

	public static void moveToElement(WebElement element) {
		actOnElement = new Actions(driver);
		actOnElement.moveToElement(element).build().perform();
		;
	}

	public static void moveMouse(int movements) {

		try {
			rt = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 1; i <= movements; i++)
			rt.keyPress(KeyEvent.VK_DOWN);

	}

	public static void testExecution(String testCase) {

		String testName = testCase;
		ArrayList<String> data = new ArrayList<String>();
		String locatorType = null;
		String locatorValue = null;
		String action = null;
		String testData = null;
		WebElement element = null;

		int totalSteps = ExcelReader.getRowCount(testName);
		for (int i = 1; i < totalSteps; i++) {

			data = ExcelReader.getLocator(testName, i);
			action = data.get(0).trim();
			locatorType = data.get(2);
			locatorValue = data.get(3).trim();
			testData = data.get(4).trim();

			if (action.equals("SwithTo")) {
				Set<String> windows = driver.getWindowHandles();
				windows.remove(driver.getWindowHandle());
				driver.switchTo().window(windows.iterator().next());
			} else if (action.equals("EnterDataInto")) {
				element = findElement(locatorType, locatorValue);
				enteringValue(element, testData);
			} else if (action.equals("IsDisplayed")) {
				element = findElement(locatorType, locatorValue);
				checkElement(element);
			} else if (action.equals("MoveMouseToElement")) {
				element = findElement(locatorType, locatorValue);
				moveToElement(element);
			} else if (action.equals("ClickOn")) {
				element = findElement(locatorType, locatorValue);
				clickOnElement(element);
			} else if (action.equals("MoveMousePointer")) {
				moveMouse(Integer.parseInt(testData));
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static WebElement findElement(String locatorType, String locatorValue) {
		String Type = locatorType;
		String Value = locatorValue;
		WebElement element = null;

		if (Type.equals("Id")) {
			element = driver.findElement(By.id(Value));
		} else if (Type.equals("Xpath")) {
			element = driver.findElement(By.xpath(Value));
		} else if (Type.equals("Name")) {
			element = driver.findElement(By.name(Value));
		} else if (Type.equals("LinkText")) {
			element = driver.findElement(By.linkText(Value));
		}

		return element;
	}

	public static void tearDown() {
		//testExecution("gotoLogout");
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		driver.quit();
		log.debug("Browser closed...");
	}

}
