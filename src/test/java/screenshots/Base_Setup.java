package screenshots;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Setup {
	public static WebDriver driver;
	public static WebElement element;
	public static Thread thread;
	public static WebDriverWait wait;
	public static SoftAssert softAssert;
	public static String screenshotsSubFolderName;

	@Parameters("browserName")
	@BeforeTest
	public void InitializeBrowser(ITestContext context, @Optional("chrome") String browserName ) {
		switch(browserName.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Browsername is invalid");
			break;
		}
		driver.manage().window().maximize();
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	//DEPENDENCY INJECTION (instead of listeners in xml)
	@AfterMethod
	public void screenshotCapture(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
		}
	}

	public void captureScreenshot(String fileName) {
		if(screenshotsSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
		    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    screenshotsSubFolderName = myDateObj.format(myFormatObj);
		   
		}
			    
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/" + screenshotsSubFolderName + "/" + fileName);
		try {
			FileUtils.copyFile(sourceFile, destFile);
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
	}
}
