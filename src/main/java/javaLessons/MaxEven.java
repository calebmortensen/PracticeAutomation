package javaLessons;

import java.util.List;
import java.util.Optional;

public class MaxEven {

	public static int findMaxEven(List<Integer> numbers) {
		if (numbers == null) {
			return 0;
		}
		
		Optional<Integer> maxEven = numbers.stream()
		.filter(number -> number % 2 == 0)
		.max(Integer::compare);
		
		return maxEven.orElse(0);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
