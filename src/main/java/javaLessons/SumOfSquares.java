package javaLessons;

import java.util.List;

public class SumOfSquares {
	
	//Find the Square of numbers and sum them up
	
	public static long sumOfSquares(List<Integer> numbers) {
		if(numbers == null) {
			return 0;
		}
		return numbers.stream()
		.mapToLong(number -> number * number)
		.sum();
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
