package extentReports;

import java.awt.Desktop;
import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentAttributes {

	public static void main(String[] args) throws Exception {
		ExtentReports extentReports = new ExtentReports();
		File file = new File("Extent_report.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
		/*
		 * ExtentSparkReporterConfig config = sparkReporter.config();
		 * config.setTheme(Theme.DARK); config.setReportName("Report Name");
		 * config.setDocumentTitle("DOC Title");
		 * config.setTimeStampFormat("dd-MM-YYYY hh:mm:ss");
		 * config.setCss(".badge-primary{background-color:@da0b2b}"); config.setJs(
		 * "document.getElementsByClassName('logo')[0].style.display='none';");
		 */
		
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
		Desktop.getDesktop().browse(new File("Extent_report.html").toURI());
	}

}
