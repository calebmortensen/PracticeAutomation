package autoLessons;

import org.testng.annotations.Test;

public class ParallelTest3 {
 
@Test
  public void testMethod9() {
	  
	  System.out.println("ParallelTest Class 3 >> TestMethod9 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod99() {
	  
	  System.out.println("ParallelTest Class 3>> TestMethod99 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod999() {
	  
	  System.out.println("ParallelTest Class 3>> TestMethod999 >> " + Thread.currentThread().getId());
  }


@Test
  public void testMethod9999() {
	  
	  System.out.println("ParallelTest Class 3 >> TestMethod9999 >> " + Thread.currentThread().getId());
  }
}
