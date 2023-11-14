package javaLessons;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Collections {

	
	List<String> words = List.of("Apple", "Bat", "Cat");
	/* IMMUTABLE
	 * words.size(); words.get(0); words.contains("Apple"); words.isEmpty();
	 */
	List<String> wordsArrayList = new ArrayList<String>(words);
	//wordsArrayList.@add("Dog"); //Allows duplicates
	
	List value = List.of("A", 'a', 1, 1.0);  //AutoBox
	
	//Iterator<String> iterator = words.iterator();
	
	/*
	 * while(iterator.hasNext()) { if(iterator.next().endsWith("at")) {
	 * iterator.remove(); } }
	 */
	
	Set<Integer> numbers = new HashSet<>();
	
	Queue<String> queue = new PriorityQueue<>();
	//queue.poll();
	//queue.offer("Apple");
	//queue.addAll(List.of("Zebra", "Monkey", "Cat"));
	//queue.poll(); - Goes through each time its run
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
