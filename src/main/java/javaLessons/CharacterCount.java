package javaLessons;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterCount {
	
	public static List<Integer> getCharacterCount(List <String> courses){
		if(courses ==null) {
			return List.of();
		}
	return courses.stream()
		//.map(str -> str.length())
		.map(String::length)    //method reference
		.collect(Collectors.toList());
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
