package javaLessons;

import java.util.Scanner;

public class Sc {

	public static void main(String[] args) {
		System.out.println("Enter username: ");
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		

		String userName = myObj.nextLine(); // Read user input
		System.out.println("Username is: " + userName); // Output user input

	}

}
