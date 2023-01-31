//In this class i need to 
//1) Make the process method be able to process the words properly. To compare the words to one another and choose which ones come up the most
//2) make it so that the addToMap method actually does add it to a map, and then show me the output of the map

package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;


public class Parser  {
	//This class goes through the file, takes out the ignore words, compares them together and adds them to a sorted map.
	Set<String> IgnoreWords = new TreeSet<>(); // The Words to take out
	Map<String, Integer> wordMap = new HashMap<>(); // A list of all the words in the map

	public Parser() {
		super();
		getIgnoreWords("ignorewords.txt");
	}

	public void getIgnoreWords(String filename) {
		// Read ignore words and add to TreeSet
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) // Read in a file
		{
			String line = null;

			while ((line = br.readLine()) != null) {  // For every line //N(log(n))

				if (!IgnoreWords.contains(line)) {   // If Ignorewords does not contain the word
					IgnoreWords.add(line);			//add it to the map
				}
			}//End of while loop
		}

		catch (IOException e) {
			System.out.println(ConsoleColour.RED_BOLD);
			System.out.println("Error reading ignore words");
			e.printStackTrace(System.out);
		}
	}//End of getIgnoreWords method

	public void parse(String filename) {

		try (BufferedReader br = new BufferedReader(new FileReader(filename))) // Read in a file
		{
			String line = null;

			while ((line = br.readLine()) != null) { 				// For every line //N(log(n))
				String[] words = line.split(" "); 					// Break up the words by their spaces
				for (String s : words) {							 // For each string s in the array words
					s = s.trim().replaceAll("[^a-zA-Z]", "").toLowerCase(); // Take out the special characters
					if (!IgnoreWords.contains(s)) 					// If Ignorewords does not contain the word
						addToMap(s); 								// Add it to the map

				}
			}//End of while loop

		}

		catch (IOException e) {
			System.out.println(ConsoleColour.RED_BOLD);
			System.out.println("Error parsing file");
			e.printStackTrace();
		}
	}//End of parse method

	public void addToMap(String s) {
		// This method builds the map, if the String is in the list, it adds 1.
		// Otherwise it sets it to 1.

		try {
			if (wordMap.containsKey(s)) {
				wordMap.put(s, wordMap.get(s) + 1);
			} else {
				wordMap.put(s, 1);
			}
		} catch (Exception e) {
			System.out.println(ConsoleColour.RED_BOLD);
			System.out.println("Error adding to map");
			
			e.printStackTrace();
		}

	}


	public Map<String, Integer> sortWordMap() {
		wordMap = compare(wordMap);
		System.out.println(wordMap);
		return wordMap;
	}
	//Compare the words based on how many times they appear in the text
	//Ref 1:
	public static Map<String, Integer> compare(Map<String, Integer> unsortMap) {
		List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());
		Collections.sort(list, new Comparator<Entry<String, Integer>>() {
			public int compare(Entry<String, Integer> o1,

					Entry<String, Integer> o2) {

				return o2.getValue().compareTo(o1.getValue());

			}
		});
		// This returns the sorted map, and for each entry in the list, returns the
		// value
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}//End of for loop

		return sortedMap;
	}//End of compare method

}//End of class

