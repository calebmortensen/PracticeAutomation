package screenshots;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
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

public class Screenshot_Test extends Base_Setup{
	
	@Test(testName = "LoginTest", dataProvider = "loginTestData")
	public void LoginTest(String userName, String password) throws Exception {
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
		driver.quit();
	}
	
	@Test(testName = "LoginTest1", dataProvider = "loginTestData1")
	public void LoginTest1(String userName, String password) throws Exception {
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
		driver.quit();

	}

	@DataProvider(name = "loginTestData")
	public Object[][] loginData() {
		Object[][] data = new Object[1][2];
		data[0][0] = "Admin";
		data[0][1] = "admin123";

		return data;
	}

	@DataProvider(name = "loginTestData1") 
		public Object[][] loginData1() {
		Object[][] data = new Object[1][2];
		data[0][0] = "Fail_ME";                 //FAIL
		data[0][1] = "admin123";

		return data;
	}

}
