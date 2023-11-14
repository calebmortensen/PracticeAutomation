package javaLessons;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		/*
		 * List.of(23, 43, 34, 45, 36, 48).stream() .filter(n -> n%2 == 0) .forEach(e
		 * ->System.out.println(e));
		 */

		List.of(23, 43, 34, 45, 36, 48).stream().filter(new EvenNumberPredicate()).forEach(new ConsumerExample());
	}

}

class EvenNumberPredicate implements Predicate<Integer> {

	public boolean test(Integer number) {
		return number % 2 == 0;
	}
}

class ConsumerExample implements Consumer<Integer> {
	public void accept(Integer number) {
		System.out.println(number);
	}
}
