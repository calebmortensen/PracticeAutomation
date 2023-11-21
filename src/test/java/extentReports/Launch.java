package extentReports;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class Launch extends Base_Setup {
  SoftAssert softAssert = new SoftAssert(); //SoftAssertions continue and the softAssert.assertAll() at end of test case will compile all assertions
	
	@Test (testName = "TestFacebook", groups = {"smoke"})
	public void LaunchFacebook() throws Exception {
		
		driver.get("https://www.facebook.com/");
		extentTest.info("Navigated to Url");
		driver.findElement(By.name("email")).sendKeys("Test Text", Keys.ENTER);
		extentTest.info("Entered text in Email field");
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		
		
		// Title Assertion / HARD
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log into Facebook";
		AssertJUnit.assertEquals(actualTitle, expectedTitle, "Title is mismatched");
		extentTest.pass("Assertion is passed for webpage title");

		// URL Assertion / SOFT all
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		softAssert.assertNotEquals(actualUrl, expectedUrl, "URL is mismatched");

		// Text Assertion (entered username above) FAIL
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "";
		AssertJUnit.assertEquals(actualText, expectedText, "Username Text is mismatched");

		// Border Assertion - Selenium reads HEX value for CSS so need to convert to RGB     //FAIL
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder = "1px solid rgb(240, 40, 73)"; // 1px solid #f02849 -> rgb(240,40,73) https://htmlcolorcodes.com/hex-to-rgb/
		AssertJUnit.assertEquals(actualBorder, expectedBorder, "Username Border is mismatched");

		// Error Message Assertion
		//String actualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/div[last()]")).getText();
		//String expectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		//softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message is mismatched");
		
		driver.quit();
		softAssert.assertAll(); //Throws Exception at END of test
	}
	

	@Test(testName = "OrangeHRM", groups = {"sanity", "smoke", "regression"}, dataProvider = "loginTestData")
	public void OrangeHRMLoginTest(String userName, String password) throws Exception {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		extentTest.info("Navigated to Url");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
}
