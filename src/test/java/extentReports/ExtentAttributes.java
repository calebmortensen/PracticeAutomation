package extentReports;

import java.awt.Desktop;
import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentAttributes {
	
	static WebDriver driver;

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("Extent_report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		//change order views of sparkreporter via ENUM ViewName  (Removed AUTHOR as an Example)
		sparkReporter.viewConfigurer().viewOrder().as(new ViewName[] {
				ViewName.DASHBOARD,
				ViewName.TEST,
				ViewName.EXCEPTION,
				ViewName.CATEGORY,
				ViewName.DEVICE,
				}).apply();
		
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		/*
		 * ExtentSparkReporterConfig config = sparkReporter.config();
		 * config.setTheme(Theme.DARK); config.setReportName("Report Name");
		 * config.setDocumentTitle("DOC Title");
		 * config.setTimeStampFormat("dd-MM-YYYY hh:mm:ss");
		 * config.setCss(".badge-primary{background-color:@da0b2b}"); config.setJs(
		 * "document.getElementsByClassName('logo')[0].style.display='none';");
		 */
		extentReports.setSystemInfo("OS ", System.getProperty("os.name"));
		extentReports.setSystemInfo("Java ", System.getProperty("java.version"));
		extentReports.setSystemInfo("Browser ", capabilities.getBrowserName() + " " + capabilities.getBrowserVersion());
		extentReports.setSystemInfo("App URL ", "www.hyrtutorials.com");
		extentReports.setSystemInfo("User Name  ", "John.SmithTest12345.com");
		extentReports.setSystemInfo("Password  ", "54321");
		
		//CONFIG via JSON (Recommended since it's a light-weight file)
		sparkReporter.loadJSONConfig(new File("./src/test/resources/extent-reports-config.json"));
		
		//CONFIG via XML
		//sparkReporter.loadXMLConfig(new File("./src/test/resources/extent-reports-config.xml"));
		
		extentReports.attachReporter(sparkReporter);
		
		extentReports
		.createTest("Test 1", "Test 1 description")
		.assignAuthor("Caleb")
		.assignCategory("Performance")
		.assignDevice("Chrome 119")
		.pass("PaSSed TeSt");
		
		extentReports
		.createTest("Test 2", "Test 2 description")
		.assignAuthor("Caleb")
		.assignCategory("Smoke")
		.assignDevice("Chrome 119")
		.pass("PASSED TeSt");
		
		extentReports
		.createTest("Test 3", "Test 3 description")
		.assignAuthor(new String[] {"Andy", "Burt", "Cletus"})
		.assignCategory("Sanity")
		.assignDevice("Chrome 119")
		.fail("FaIlEd TeSt");
		
		extentReports
		.createTest("Test 4", "Test 4 description")
		.assignCategory("Regression")
		.assignAuthor("Rebecca")
		.assignAuthor("PETER", "Sam")
		.assignDevice("Chrome 119")
		.assignDevice("Firefox 77")
		.fail("FAILED TeSt");
		
		extentReports.flush();
		driver.quit();
		Desktop.getDesktop().browse(new File("Extent_report.html").toURI());
		
	}

}
