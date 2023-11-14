package javaLessons;

import java.util.List;

public class MethodReferencesRunner {
	
	//Method References can be used with Static & Instance Methods
	
	public static void print(Integer number) {
		System.out.println(number);
	}

	public static void main(String[] args) {
		List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
		.map(s -> s.length())
		.forEach(s -> System.out.println(s));

		List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
		.map(s -> s.length())
		.forEach(System.out::println); //Shortcut for the forEach above
		
		List.of("Ant", "Bat", "Cat", "Dog", "Elephant").stream()
		.map(String::length) //Method reference
		.forEach(MethodReferencesRunner::print); //Shortcut Class::method
		
		Integer max = List.of(23,45,67,34).stream()
		.filter(n -> n % 2 == 0) //replace with a method reference below
		.max((n1,n2) -> Integer.compare(n1,n2)) //replace with a method reference below
		.orElse(0);
		System.out.println(max);
				
		Integer max1 = List.of(23,45,67,34).stream()
				.filter(MethodReferencesRunner::isEven) //Method Reference
				.max(Integer::compare)                  //Method Reference
				.orElse(0);
				System.out.println(max1);
	}
	
	public static boolean isEven(Integer number) {
		return number %2 ==0;
	}

}
