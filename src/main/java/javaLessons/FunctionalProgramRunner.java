package javaLessons;

import java.util.List;

public class FunctionalProgramRunner {

	
	public static void main(String[] args) {
		List<String> list = List.of("Apple", "Banana", "Cat", "Dog");
		//printBasic(list);
		//printWithFP(list);
		
		List<Integer> numbers = List.of(4,6,8,13,3,15);
		
		/*
		 * numbers.stream() .forEach(element -> System.out.println(element));
		 */
		
		int sum = fpSum(numbers);
		System.out.println(sum);
		
		
		//normalSum(numbers);
	}

	private static int fpSum(List<Integer> numbers) {
		return numbers.stream()
				//.filter(number -> number%2 == 1)
				.reduce(0, (number1, number2) -> number1 + number2);
	}

	private static void normalSum(List<Integer> numbers) {
		int sum = 0;
		for(int number: numbers) {
			sum += number;
		}
		System.out.println(sum);
	}
	
	private static void printBasic(List<String> list) {
		for(String st: list) {
			System.out.println(st);
		}
	}
	//Functional Programming  -> Lambda Expression (think of -> as 'returns'
	private static void printWithFP(List<String> list) {
		list.stream()
		.filter(element -> element.endsWith("at"))
		.forEach(
				element -> System.out.println(element));
	}
}
