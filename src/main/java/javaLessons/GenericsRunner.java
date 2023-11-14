package javaLessons;

import java.util.List;

public class GenericsRunner {

	public static void main(String[] args) {
		MyCustomList<String> list = new MyCustomList<>();
		list.addelement("Element 1");
		list.addelement("Element 2");
		String value = list.get(0);

		// System.out.println(value);

		MyCustomList<Integer> list2 = new MyCustomList<>();
		list2.addelement(Integer.valueOf(5));
		list2.addelement(Integer.valueOf(7));
		Integer number = list2.get(0);
		// System.out.println(number);

		List<String> list3 = List.of("Apple", "Banana", "Cherry", "Cat", "Dog", "Bat");
		// printBasic(list3);
		// printBasicFP(list3);

		List<Integer> numbers = List.of(4, 6, 8, 13, 3, 15);
		// numbers.stream().forEach(element ->System.out.println(element));
		/*
		 * int sum = normalSum(numbers); System.out.println(sum);
		 */

		int sum = numbers.stream().reduce(0, (number1, number2) -> number1 + number2);
		System.out.println(sum);
	}

	private static int normalSum(List<Integer> numbers) {
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		return sum;
	}

	private static void printBasic(List<String> list3) {
		for (String string : list3) {
			if (string.endsWith("at"))
				System.out.printf(string + " ");
		}
	}

	private static void printBasicFP(List<String> list3) {
		list3.stream().forEach(element -> System.out.println(element));
	}
}
