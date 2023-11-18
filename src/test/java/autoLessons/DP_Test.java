package autoLessons;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DP_Test {
	public static WebDriver driver;
	public static WebElement element;
	public static Thread thread;
	public static WebDriverWait wait;
	// public static Select select;
	// public static boolean checked;
	public static SoftAssert softAssert;

	@Test(dataProvider = "loginTestData", timeOut = 40000, expectedExceptions = {NoSuchElementException.class}) // can use method name if dp not named
	//(dataProvider = "loginData", dataProviderClass = autoLessons.ExcelDataSupplier.class) //asserting an exception																							// dataprovider isn't
																	
	public void LoginTest(String userName, String password) throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Username']")));
		element.clear();
		element.click();
		element.sendKeys(userName);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Password']")));
		element.clear();
		element.click();
		element.sendKeys(password);
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
		element.click();
		element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")));
		//element.findElement(By.id("abcd")).click(); //expectedExceptions = {NoSuchElementException.class} //NEGATIVE TESTING
		driver.quit();
		// softAssert.assertAll();

	}

	@DataProvider(name = "loginTestData", parallel = true ) //parallel = true + also in XML add: data-provider-thread-count="3"
	public Object[][] loginData() {                         //
		Object[][] data = new Object[1][2]; // 2 Dimensional Array (username & password)
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		/*
		 * data[1][0] = "Admin"; data[1][1] = "admin1234";
		 * 
		 * data[2][0] = "prod"; data[2][1] = "admin123";
		 * 
		 * data[3][0] = "regression"; data[3][1] = "admin123";
		 * 
		 * data[4][0] = "smoke"; data[4][1] = "admin123";
		 * 
		 * data[5][0] = "done"; data[5][1] = "admin123";
		 */

		return data;
	}

}
