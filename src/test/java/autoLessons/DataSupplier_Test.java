package autoLessons;

import org.testng.annotations.Test;

public class DataSupplier_Test {
  @Test(dataProvider = "dp10", dataProviderClass = autoLessons.DataSupplier.class) //extends class works the same
  public void DP_Test(String s) {
	  System.out.println(s);
  }
}
