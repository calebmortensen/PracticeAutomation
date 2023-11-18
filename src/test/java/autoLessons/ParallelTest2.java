package autoLessons;

import org.testng.annotations.Test;

public class ParallelTest2 {
 
@Test
  public void testMethod5() {
	  
	  System.out.println("ParallelTest Class 2 >> TestMethod5 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod6() {
	  
	  System.out.println("ParallelTest Class 2>> TestMethod6 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod7() {
	  
	  System.out.println("ParallelTest Class 2>> TestMethod7 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod8() {
	  
	  System.out.println("ParallelTest Class 2 >> TestMethod8 >> " + Thread.currentThread().getId());
  }
}
