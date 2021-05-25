/**
 * 
 */
// package abcfinlab;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;

/**
 * @author Darlington
 *
 */
public class AnagramTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	@Test
	public void anagramTest() {

		Anagram testAnagram = new Anagram();
		testAnagram.getAnagram();

		HashMap<Integer, HashMap<HashMap<Character, Integer>, ArrayList<String>>> result =
				testAnagram.getResult();
				
		for (Integer i : result.keySet()) {
			if (i%2 == 0 && i < result.size()/2) {
				 for (HashMap<Character, Integer> j : result.get(i).keySet()) {
		    		  if (result.get(i).get(j).size() > 1) {	    			  
				    	  //System.out.println(j + " " + result.get(i).get(j));
				    	  ArrayList<String> myValue = result.get(i).get(j);	

				    	  for (int z=0; z<myValue.size(); z++) {
				    		  char ta[] = myValue.get(z).toCharArray();

				    		  Arrays.sort(ta);

				    		  myValue.set(z, new String(ta));
				    	  }
				    	  				    	 
			    		  boolean boo = true;
			    		  String test = myValue.get(0);
			    		  for (int m = 0; m<myValue.size(); m++) {
			    			  if (test != myValue.get(m)) {
			    				  break;
			    			  }
			    		  }

			    		  assertEquals(true, boo);
		    		  }    		  
		    	  }
			}
	    }
		
	}



}
