package assignment_2;

import java.util.*;
import java.io.*;

public class TextAnalysis16 {
	public String[] wordsFromFile;
	public int indexNumber=0;
	// Import text
	// Split text into an array
	// This program allows you to analyse text



	public TextAnalysis16(String sourceFileName, int maxNoOfWords) {

		Scanner input;
		try {
			input = new Scanner (new File(sourceFileName));
			wordsFromFile = new String[maxNoOfWords];

			while (input.hasNextLine()){				 // While there are more lines in the file, this loop passes them into the array "tokens".

				String[] tokens = input.next().split("[^a-zA-Z]+");
				for (int m = 0;m<tokens.length;m++){
					wordsFromFile[indexNumber] = tokens[m];

					indexNumber++;
				}
			}

			input.close();
			//line.split("[^a-zA-Z]+");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int wordCount(){ // Returns the last indexNumber used by the constructor. 
		return indexNumber;
	}

	public int frequency(String word){ // Counts how many times a word occurs in the text file.
		int countFreq = 0;
		for (int i = 0;i<indexNumber;i++){
			if (word.equals(wordsFromFile[i])){
				countFreq++;
			}

		}return countFreq;
	}
	public boolean contains(String word1, String word2){ // Tests if two words appears after each other in the text file.

		for (int i = 0;i<indexNumber-1;i++){
			if ((word1.toUpperCase().equals(wordsFromFile[i].toUpperCase()))
					&& (word2.toUpperCase().equals(wordsFromFile[i+1].toUpperCase()))){
				return true;
			}

		}return false;
	}
}