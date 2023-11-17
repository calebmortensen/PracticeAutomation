package autoLessons;

import org.testng.annotations.DataProvider;

public class DataSupplier {
	
	@DataProvider(indices = {0, 3})
	public String[] dp10(){
		String[] data = new String[] {
			"John",
			"Dave",
			"Pete",
			"George"
		};
		return data;
	}
	@DataProvider(indices = {0, 2})
	public String[] dp12(){
		String[] data = new String[] {
			"Rebecca",
			"Jane",
			"Jill",
			"Lisa"
		};
		return data;
	}
}
