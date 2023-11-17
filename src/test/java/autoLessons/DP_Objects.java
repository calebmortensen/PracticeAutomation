package autoLessons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DP_Objects {

	     //return types: (String, Integer, Float,)
		// -Object[]
		//-Object[][]
		//-Iterator<Object>
		//-Iterator<Object[]>
		
	
	
  @Test(dataProvider = "dp7")	
	public void arrayTest(String[] s) throws Exception{
		System.out.println(s[0]+" >> "+s[1]);
		/*
		 * for (int i = 0; i<s.length; i++) { System.out.println(s[i]); }
		 * System.out.println(">>>>>>>>>>>");
		 */
	  //System.out.println(s);
	}
	
	@DataProvider()
	public Object[] dp1(){
		String[] data = new String[] {
			"abcd",
			"xyz",
			"pqr"
		};
		return data;
	}
	
	@DataProvider()
	public Object[] dp2(){
		Integer[] data = new Integer[] {
			1,
			2,
			3
		};
		return data;
	}
	
	@DataProvider()
	public Object[] dp3(){
		Object[] data = new Object[] {
			1,
			"two",
			3
		};
		return data;
	}
	
	@DataProvider()
	public Object[][] dp4(){
		String[][] data = new String[][] {
			{"one", "two"},
			{"three","four"},
			{"five", "six"}
		};
		return data;
	}
	
	@DataProvider()
	public String[][] dp5(){          //multi-dimensional array
		String[][] data = new String[][] {
			{"one", "two", "852","abcd"},
			{"three","four"},
			{"five", "six", "123456"}
		};
		return data;
	}
	
	@DataProvider()
	public Iterator<String> dp6(){         //Collection
		List<String> data = new ArrayList<>();   //Set<String> data = new HashSet<>();
			data.add("Caleb");
			data.add("Joe");
			return data.iterator();
		}
	
	@DataProvider()
	public Iterator<String[]> dp7(){         
		Set<String[]> data = new HashSet<>(); 
			data.add(new String[] {"Caleb", "Mortensen"});
			data.add(new String[] {"Joe", "Dirt"});
			return data.iterator();
		}
}
