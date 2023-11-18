package autoLessons;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class ParallelTest {
 
@Test
  public void testMethod1() {
	  
	  System.out.println("ParallelTest Class >> TestMethod1 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod2() {
	  
	  System.out.println("ParallelTest Class >> TestMethod2 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod3() {
	  
	  System.out.println("ParallelTest Class >> TestMethod3 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod4() {
	  
	  System.out.println("ParallelTest Class >> TestMethod4 >> " + Thread.currentThread().getId());
  }
}
