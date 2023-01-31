

package ie.gmit.dip;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Menu {

	//Firstly declare the variables
	private int numwords = 0; 
	private Scanner sc = new Scanner(System.in);
	private boolean mainLoop = true;
	private Parser parser = new Parser();
	private String inputFileName = "";
	
	public Menu() { // Constructor

	}

	public static String[] chooseFile(Scanner sc) throws IOException { // This method lets the user input his file choice
		String[] fileArray = new String[1000000];		//Create a new array of Strings, max 1 million words
		String filename = sc.nextLine();

		Scanner inputFile = new Scanner(new File(filename));

		System.out.println("you have chosen " + filename);
		int i = 0;
		while (inputFile.hasNextLine()) { // This reads the file line by line and puts it out ** need to put it into a new File									
			fileArray[i++] = inputFile.nextLine();

		}

		System.out.println(fileArray);
		inputFile.close();
		return fileArray;

	}//End of chooseFile method

	public void start()  throws IOException {
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
		System.out.println("***************************************************************************");
		System.out.println("You have started using the Simple Word Cloud Generator..");
		System.out.println("Please follow the Menu below in order, to create you're very own Word Cloud!!");
		System.out.println("********************************************************************************");

		System.out.println("********************************************************************************");
		
		int choice;
		while (mainLoop) {//This is the options for the menu
			System.out.println(ConsoleColour.BLUE_BOLD_BRIGHT);
			System.out.println("      ");
			System.out.println("1) Choose file");
			System.out.println("2) Choose how much words to generate");
			System.out.println("3) Execute program and start word cloud genreation");
			System.out.println("4) Choose Save Loaction");
			System.out.println("5) Exit program");
			

			choice = sc.nextInt();

			switch (choice) {
			case 1:
				// This allows the user to enter a file location
				System.out.println("Please Enter File path");
				sc.nextLine();
				
				inputFileName = sc.nextLine();
				System.out.println("You have selected --> " + inputFileName);
				break;

			case 2:
				//This allows the user to specify the number of words to display
				System.out.println("Please enter a number, MAX 30, for the word cloud generation");
			
				numwords = sc.nextInt();
				if (numwords > 30) {
					numwords = 0;
					System.out.println(ConsoleColour.RED_BOLD);
					System.out.println("Number too high please press 2, and try again");
				}
					
				
				break;

			case 3:
				// This starts the generation of the word cloud
				System.out.println("Programme complete! Ready to be saved"); 
				if (inputFileName.length() > 0) {		//If the File still have Strings to read
					parser.parse(inputFileName);		// Parse through the file
					;
				} else {
					System.out.println(ConsoleColour.RED_BOLD);
					System.out.println("No file selected");
				}
				break;

			case 4:
				// This generates the word cloud and then allows the user to select a save location
				System.out.println("Enter Save Location");
				Map<String, Integer> wordMap = parser.sortWordMap();	//Create a new map and sort it
				String nameChoice = sc.next();							//This sets where to save the file
				ReallySimpleWordCloud wordcloud = new ReallySimpleWordCloud();	//This draws the cloud
				try {
					
					wordcloud.DrawCloud(wordMap, numwords, nameChoice);
					
				} catch (Exception e) {
					System.out.println(ConsoleColour.RED_BOLD);
					System.out.println("Error saving WordCloud");
					e.printStackTrace();
				}
				System.out.println("Word Cloud Generation complete!");
				break;

			case 5:
				// Case 5 exits the program
				System.out.println("Exiting program...");
				mainLoop = false;
				break;

			default:
				System.out.println("Error please try again");
			}//End of switch statement
		}//End of while loop
		sc.close();
	}//End of Start method

}//End of class
