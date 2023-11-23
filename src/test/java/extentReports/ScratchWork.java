package extentReports;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScratchWork {
	static WebDriver driver;

		
	public static void main(String[] args) {
		
		ScratchWork.SysInfo1();
		

}
	public static void SysInfo1() {
		//BROWSER Info - Capabilities is an Interface so we CANNOT create an Instance to it, but a Reference
		
		  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver();
		  Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();
		  String device = capabilities.getBrowserName() + " " +
		  capabilities.getBrowserVersion().substring(0,
		  capabilities.getBrowserVersion().indexOf("."));
		 
		  
		  
				
				//SYSTEM Info
				//System.getProperties().list(System.out);
		  System.out.println("OS: " + System.getProperty("os.name"));
		  System.out.println("Java Version: " + System.getProperty("java.version"));
		

	}
}