package javaLessons;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cubes {
	
	//returns a list of cubed numbers
	
	public static List<Integer> getCubesOfFirstNumbers(int n){
		return IntStream.range(1, n + 1)
		.map(number -> number * number * number)
		.boxed()
		.collect(Collectors.toList());
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
