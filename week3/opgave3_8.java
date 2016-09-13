package week3;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class opgave3_8 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Please enter your name: ");
		String name = scanner.nextLine();
		
		System.out.println(reverseWords(name));
		
        scanner.close();

	}
	
	public static String reverseWords (String s) 
	{
	    String delimiter = " ";
	    List<String> words = Arrays.asList(s.split(delimiter));
	    Collections.reverse(words);
	    return String.join("," + delimiter, words);
	}


}
