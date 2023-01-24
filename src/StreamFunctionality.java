import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamFunctionality {

	public static void main(String[] args) {

		// count the elements in an array which start with "a"

		List<String> names = new ArrayList<String>();
		names.add("Dev");
		names.add("Abhi");
		names.add("Abhisar");
		names.add("Udhav");
		names.add("darshan");
		int sum = 0;
		for (int i = 0; i < names.size(); i++) {
			if (names.get(i).startsWith("A")) {
				sum += 1;
			}
		}

		System.out.println(sum);

		// using java streams
		// there is no life for intermediate op if there is no terminal op

		Long c = names.stream().filter(s -> s.startsWith("A")).count(); // before using filter method first convert the
																		// list to
																		// stream() (here s will iterate through the
																		// list)
																		// datatype of count is Long
																		// startsWith operator returns true or false.
																		// .count method will only work if the operators
																		// is returning true/false
		System.out.println(c);

		long d = Stream.of("Dev", "Abhi", "Abhisar", "Udhav", "darshan").filter(s -> // // making a stream compatible
		{
			s.startsWith("A");
			return true;
		}).count();
		System.out.println(d);

		// print all the names in the list with length greater than 4
		names.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		System.out.println("---------------------------------------------------------------");
		// if u want only some results
		names.stream().filter(s -> s.length() > 4).limit(1).forEach(s -> System.out.println(s));

		System.out.println("---------------------------------------------------------------");

		// MAP method
		// print names of length > 4 in UPPERCASE and last letter as a
		Stream.of("Abhijit", "Sagar", "Udhav", "Darshan", "Rama", "Puma").filter(s -> s.endsWith("a"))
				.map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));

		System.out.println("---------------------------------------------------------------");

		// print names which have first letter as "A" with uppercase and sorted
		Stream.of("Aankur", "Abhijit", "Sagar", "Udhav", "Darshan", "Rama", "Puma", "Akshar", "Andu")
				.filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).sorted().forEach(s -> System.out.println(s));

		System.out.println("---------------------------------------------------------------");

		// Merging 2 arrayList and then sorting
		List<String> list1 = Arrays.asList("Aankur", "Abhijit", "Sagar", "Udhav", "Darshan", "Rama", "Puma", "Akshar",
				"Andu");
		List<String> list2 = Arrays.asList("Dev", "Abhi", "Abhisar", "Henil", "Bakri");

		Stream<String> newStream = Stream.concat(list1.stream(), list2.stream());
		//newStream.sorted().forEach(s -> System.out.println(s));

		// Match method
		// Check if "Dev" is present in the above combined list or not (return boolean)
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Dev")); // .anyMatch return boolean value
		System.out.println(flag);
		Assert.assertTrue(flag);

		// Collect method
		// used to collect the results and convert it back to the list and print the first element
		List<String> converted = Stream.of("Abhijit", "Sagar", "Udhav", "Darshan", "Rama", "Puma")
				.filter(s -> s.endsWith("a")).map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(converted.get(0));
		
		System.out.println("---------------------------------------------------------------");
		
		//Assignment
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,2,3,4,5,6,4);
		// print unique number from this array
		//sort the array
		numbers.stream().distinct().forEach(s -> System.out.println(s));
		numbers.stream().sorted().forEach(s -> System.out.println(s));
	}

}
