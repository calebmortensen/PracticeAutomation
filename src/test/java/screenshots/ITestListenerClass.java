package screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends Base_Setup implements ITestListener{
     //this gets added to the xml as a listener on fail, unless Dependency Injection is used
	@Override
	public void onTestFailure(ITestResult result) {
		//System.out.println(result.getTestContext().getName() + "_" + result.getMethod().getMethodName());
		//captureScreenshot(result.getTestContext().getName() + "_" + result.getMethod().getMethodName() + ".jpg");
		//captureScreenshot(result.getName() + ".jpg");
		//captureScreenshot(result.getTestName() + ".jpg");
		//captureScreenshot(result.getMethod().getMethodName + ".jpg");
		
	}

}
