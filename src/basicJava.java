import java.util.ArrayList;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class basicJava {

	public static void main(String[] args) {
		
		//Variables
		int myNum = 5;
		String myName = "Devansh";
		char letter = 'D';
		float dec = (float) 1.464564564565464564645645645;
		System.out.println(dec);
		boolean True = true;
		float dec2 = 1.464564564565464564645645645f;
		System.out.println(dec2);
		
		//Arrays
		int[] arr = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
		arr[4] = 5;
		
		int[] arr2 = {1,2,3,4,5};
		System.out.println(arr[2]);
		
		String[] names = {"Dev", "Udg", "Dar"};
		
		//FOR loops
		for (int i = 0; i < arr.length; i++) {
			System.out.println(i + " element is " + arr2[i]);
		}
		System.out.println();
		
		for (int i = 0; i < names.length; i++) {
			System.out.println(i + " element is " + names[i]);
		}
		
		System.out.println();
		
		//Enhanced FOR loop
		for (String s : names) {
			System.out.println(s);
		}
		
		System.out.println();
		
		//IF ELSE
		int[] myARR = {1,2,3,4,5,6,7,8,9};
		for (int a : myARR) {
			if (a % 2 == 0) {
				System.out.println(a);
			}
		}
		
		System.out.println();
		
		//ARRAY LIST(can increase the size of the array)
		ArrayList<String> a = new ArrayList();
		a.add("Dev");
		a.add("Udg");
		a.add("Dar");
		System.out.println(a.get(0));
		
		System.out.println();
		
		//String is an object in JAVA
		String s1 = new String("Welcome");
		String s2 = new String("Welcome");
		
		String s3 = "Hey I am Dev";
		String[] splitString = s3.split(" "); //converted to an array
		for (int i = 0; i < splitString.length; i++) {
			System.out.println(splitString[i].trim()); //.trim method will remove the whitespaces from left and right
	
		}
		
		System.out.println();
		
		basicJava b = new basicJava();
		b.getData();
		ImportMethod b1 = new ImportMethod();
		b1.getuserData();
		
		getData2();
		

	}
	
	public void getData() {
		System.out.println("Hello World");
	}
	
	public static void getData2() { //if static is there then no need to create an object to access the methods
		System.out.println("Hello static World");
	}

}
