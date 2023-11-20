package listeners;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

@Listeners({ITestListenerClass.class})
public class TestClass {
	
	@Test
	public void testMethod1() {

		System.out.println("TestClass >> TestMethod1 >> " + Thread.currentThread().getId());
	}

	@Test
	public void testMethod2() {

		System.out.println("TestClass >> TestMethod2 >> " + Thread.currentThread().getId());
		AssertJUnit.assertTrue(false);
	}

	@Test(timeOut = 1000)
	public void testMethod3() throws Exception {
		Thread.sleep(2000);
		System.out.println("TestClass >> TestMethod3 >> " + Thread.currentThread().getId());
	}

	@Test(dependsOnMethods = "testMethod3")
	public void testMethod4() {

		System.out.println("TestClass >> TestMethod4 >> " + Thread.currentThread().getId());
	}
}
