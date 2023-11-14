package javaLessons;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class DirectoryScanRunner {

	public static void main(String[] args) throws IOException {
		
		//Path currentDirectory = Paths.get(".");
		//Files.walk(currentDirectory, 2).forEach(System.out::println);
		
		//Files.list(Paths.get(".")).forEach(System.out::println);

		//Predicate<? super Path> predicate = path -> String.valueOf(path).contains(".java");
		
		//BiPredicate<Path, BasicFileAttributes> matcher = (path,attributes) -> String.valueOf(path).contains(".java");
		
		//BiPredicate<Path, BasicFileAttributes> matcherDir = (path,attributes) -> attributes.isDirectory();
		
		//Files.find(currentDirectory, 4, matcherDir).forEach(System.out::println);
		
		//Path pathFileToRead = Paths.get("./src/data.txt");
		//List<String> lines = Files.readAllLines(pathFileToRead);
		//System.out.println(lines);
		
		//lines uses a stream
		//Files.lines(pathFileToRead).forEach(System.out::println);
		
		//Files.lines(pathFileToRead).map(String::toLowerCase).filter(str ->str.contains("a")).forEach(System.out::println);
	
	Path pathFileToWrite = Paths.get("./src/data-write.txt");
	List<String> list = List.of("Apple", "Boy", "Cat", "Dog", "Elephant");
	Files.write(pathFileToWrite, list);
	
	}

}
