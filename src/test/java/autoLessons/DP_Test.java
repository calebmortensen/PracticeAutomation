package autoLessons;

import java.time.Duration;

import org.openqa.selenium.By;
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
	//public static Select select;
	//public static boolean checked;
	public static SoftAssert softAssert;
		
  @Test(dataProvider = "loginData", dataProviderClass = autoLessons.ExcelDataSupplier.class) //can use method name if dataprovider isn't given a name
  public void LoginTest(String userName, String password) throws Exception{	
	  
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
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[normalize-space()='Dashboard']")));
			driver.quit();
			//softAssert.assertAll(); 
			
					
		}
  			@DataProvider(name="loginTestData")
  			public Object[][] loginData() {
  				Object[][] data = new Object[1][2];  // 2 Dimensional Array (username & password) [2][2]
  				data[0][0] = "Admin";
  				data[0][1] = "admin123";
  				
				/*
				 * data[1][0] = "Admin"; data[1][1] = "admin123"; //FAIL w/wrong password
				 */  				
  				return data;
  			}
  			
  						
  			
  			
  }
