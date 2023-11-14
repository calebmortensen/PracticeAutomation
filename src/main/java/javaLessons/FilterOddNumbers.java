package javaLessons;

import java.util.List;
import java.util.stream.Collectors;

public class FilterOddNumbers {

	public static List<Integer> filterOddNumbers(List<Integer> numbers) {
		return numbers.stream()
		.filter(n -> n%2 != 0)   //filtering ODD numbers and works with NEGATIVE numbers
		.collect(Collectors.toList());  //converts stream into list
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
