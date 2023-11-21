package autoLessons;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {
  SoftAssert softAssert = new SoftAssert(); //SoftAssertions continue and the softAssert.assertAll() at end of test case will compile all assertions
	
	@Test
	public void LaunchFacebook() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.name("email")).sendKeys("Test Text", Keys.ENTER);
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		
		
		// Title Assertion / HARD
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log into Facebook";
		assertEquals(actualTitle, expectedTitle, "Title is mismatched");

		// URL Assertion / SOFT all
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://www.facebook.com/";
		softAssert.assertNotEquals(actualUrl, expectedUrl, "URL is mismatched");

		// Text Assertion (entered username above) FAIL
		String actualText = driver.findElement(By.name("email")).getAttribute("value");
		String expectedText = "";
		softAssert.assertEquals(actualText, expectedText, "Username Text is mismatched");

		// Border Assertion - Selenium reads HEX value for CSS so need to convert to RGB     //FAIL
		String actualBorder = driver.findElement(By.name("email")).getCssValue("border");
		String expectedBorder = "1px solid rgb(240, 40, 73)"; // 1px solid #f02849 -> rgb(240,40,73) https://htmlcolorcodes.com/hex-to-rgb/
		softAssert.assertEquals(actualBorder, expectedBorder, "Username Border is mismatched");

		// Error Message Assertion
		//String actualErrorMessage = driver.findElement(By.xpath("(//div[@id='email_container']/div[last()]")).getText();
		//String expectedErrorMessage = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";
		//softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error Message is mismatched");
		
		driver.quit();
		softAssert.assertAll(); //Throws Exception at END of test
	}
}
