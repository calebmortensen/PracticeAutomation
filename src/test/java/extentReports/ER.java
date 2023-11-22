package extentReports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ER {

	static WebDriver driver;
	public static String screenshotsSubFolderName;
	
	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("er_report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		String base64Code = captureScreenshot();
		String path = captureScreenshot("Google.jpg");
		//BASE64 does NOT have a PREVIEW in REPORT
		//Test Level
		extentReports.createTest("Screenshot Test 1", "This is for EMBEDDING screenshot in REPORT at test level")
		.info("This in an info message")
		.addScreenCaptureFromBase64String(base64Code, "Google HOMEPAGE 1");
		
		extentReports.createTest("Screenshot Test 2", "his is for EMBEDDING screenshot in REPORT at test level")
		.info("This in an info message 2")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage 1")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage 2")
		.addScreenCaptureFromBase64String(base64Code, "Google homepage 3");
		
		extentReports.createTest("Screenshot Test 3", "This is for attaching the screenshot FROM FOLDER at test level")
		.info("This in an info message")
		.addScreenCaptureFromPath(path, "Google HomePAGE 3");
		
		extentReports.createTest("Screenshot Test 4", "This is for attaching the screenshot FROM FOLDER at test level")
		.info("This in an info message")
		.addScreenCaptureFromPath(path, "Google HOMEpage <1>")
		.addScreenCaptureFromPath(path, "Google HOMEpage <2>")
		.addScreenCaptureFromPath(path, "Google HOMEpage <3>");
		
		//LOG LEVEL (FAILS)
		extentReports.createTest("Screenshot Test 5", "This is for attaching the screenshot EMBEDDED at LOG level")
		.info("This in an info message 5")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code).build())
		.fail("Fail with Embedded image", MediaEntityBuilder.createScreenCaptureFromBase64String(base64Code, "GoOgLe HoMePaGe").build());
		
		extentReports.createTest("Screenshot Test 6", "This is for attaching the screenshot FROM FOLDER at LOG level")
		.info("This in an info message 6")
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail("Fail with image from Folder", MediaEntityBuilder.createScreenCaptureFromPath(path, "google HOMEpage").build());
		
		Throwable t = new Throwable("This is a Throwable Exception"); //ONLY available at LOG LEVEL
		extentReports.createTest("Screenshot Test 7", "This is for attaching the screenshot FROM FOLDER at LOG level")
		.info("This in an info message 7")
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path).build())
		.fail(t, MediaEntityBuilder.createScreenCaptureFromPath(path, "google HOMEpage").build());
		
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("er_report.html").toURI());
	}
	//OVERLOADED METHODS
	public static String captureScreenshot(String fileName) {
		if (screenshotsSubFolderName == null) {
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
		return destFile.getAbsolutePath();
	}
	
	//Returns BASE64 image
	public static String captureScreenshot() {
		if (screenshotsSubFolderName == null) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			screenshotsSubFolderName = myDateObj.format(myFormatObj);
		}
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		String base64Code = takesScreenshot.getScreenshotAs(OutputType.BASE64);
		return base64Code;
	}

}
