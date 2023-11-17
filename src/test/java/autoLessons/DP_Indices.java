package autoLessons;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_Indices {
  @Test(dataProvider = "dp10")
  public void DP_Test(String s) {
	  System.out.println(s);
  }
  // Data Provider INDICES example
  

	@DataProvider(indices = {0, 2})
	public String[] dp10(){
		String[] data = new String[] {
			"John",
			"Dave",
			"Pete",
			"George"
		};
		return data;
	}
}
