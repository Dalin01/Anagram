//package abcfinlab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//import org.junit.runner.JUnitCore;
//import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;

public class Anagram {
	
	// A HashMap for storing the result.
	private HashMap<Integer, HashMap<HashMap<Character, Integer>, ArrayList<String>>> outerMap = new HashMap<Integer, 
  			HashMap<HashMap<Character, Integer>, ArrayList<String>>>();
	
	public void getAnagram() {
      	   
      	Scanner myReader = readFile(); // read the input file
      	if (myReader != null) {
      		while (myReader.hasNextLine()) { // While reading each line from the file
      			// Convert to lower-case and strip every other characters except letters a-z
      			// Java is case sensitive so working with a particular case is necessary.
      			String data = myReader.nextLine().toLowerCase().replaceAll("[^a-z]", ""); // STEP 1
      			
      			// Character (key): characters in the word
      			// integer (value): number of occurrence of the character
      			HashMap<Character, Integer> charMap = new HashMap<Character, Integer>(); // STEP 2
      			
      			// Looping through the word, checking characters...
      			// if the Character is contained in the charMap (HashMap) (STEP 2)
      			// increment the occurrence by 1. Otherwise, put the character in charMap & assign
      			// a value of 1 to its occurrence.
			    for (int i = 0; i < data.length(); i++) { // STEP 3
			    	if (charMap.containsKey(data.charAt(i))) {
			    		charMap.put(data.charAt(i), charMap.get(data.charAt(i))+1);
			    	} else {
			    		charMap.put(data.charAt(i), 1);
			    	}
			    }

			    // STEP 4
			    // 1. Check if the length of the word is already contained in the outerMap (Result HashMap) as a key
			    // 2. If 1 is true, check if the  key (length of the word) contains the current charMap as key.
			    // 3. If 2 is true, add the string to the existing ArrayList of words. 
			    // 4. If 2 is false, create a new ArrayList, add the string and finally, add the new HashMap to outerMap
			    // 5. If 1 is false, create a new ArrayList, add the string to it, create a new HasMap, add the charMap &
			    // ArrayList to it and finally, put the length of the string and the newly created Map to outerMap
			    if (outerMap.containsKey(data.length())) {		        	
			    	if (outerMap.get(data.length()).containsKey(charMap)) {
			    		outerMap.get(data.length()).get(charMap).add(data);
			    	} else {
			    		ArrayList<String> newList = new ArrayList<String>();
			    		newList.add(data);
			    		outerMap.get(data.length()).put(charMap, newList);
			    	}
			    } else {
					ArrayList<String> newList = new ArrayList<String>();
					newList.add(data);
			      	HashMap<HashMap<Character, Integer>, ArrayList<String>> myMap = new HashMap<HashMap<Character, Integer>,			   
			      			ArrayList<String>>();
			      	myMap.put(charMap, newList); 
			      	outerMap.put(data.length(), myMap);
			    }
      		}
      		
      		printResult(outerMap); 

		    myReader.close(); // close the Scanner object.
		    
      	} else {
      		// console log error if Scanner Object is null
      		System.out.println("Error!");
      	}
     	
      	// runUnitTest(); // run the Unit Test. Not needed for the implementation.
	}
	
	/*
	public void runUnitTest() {
		// Run the test contained in the AnagramTest class
		Result result = JUnitCore.runClasses(AnagramTest.class);
		// print the failed tests, if any
        for (Failure failure : result.getFailures()) {
           System.out.println(failure.toString());
        }
        // print if the test was successful of not.
        System.out.println("Test was sucessful: " + result.wasSuccessful());        
	}*/
 
	public void printResult(HashMap<Integer, HashMap<HashMap<Character, Integer>, ArrayList<String>>> outerMap) {
		// prints the results to the console.
		for (Integer i : outerMap.keySet()) {
	    	  for (HashMap<Character, Integer> j : outerMap.get(i).keySet()) {
	    		  if (outerMap.get(i).get(j).size() > 1) {
	    			  System.out.println(outerMap.get(i).get(j));	    			  
	    		  }			  
	    	  }		    		  		    		  
	    }
	}

	public Scanner readFile() {
		// Return a Scanner object of the file.
		Scanner myReader = null;
		try {
			Scanner sc = new Scanner(System.in); //System.in is a standard input stream  
			System.out.print("Enter complete path plus file name with extension (.txt) to the file: ");  
			String str = sc.nextLine();
			File myObj = new File(str);
			myReader = new Scanner(myObj);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return myReader;
	}

	public HashMap<Integer, HashMap<HashMap<Character, Integer>, ArrayList<String>>> getResult() {
		// Return the result/anagram. Useful for running the Unit test.
		return outerMap;
	}
	
}
