import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
	
	/**
	 * Project #2

	 * CS 2334, Section 013
	 * Feb 19, 2016
	 * <P>
	 * This project creates a searchable database of media. Data can be added
	 * using a file, as the program can parse unfiltered data.
	 * </P>
	 * @version 1.0
	 */

	/**
	 * The main method, which drives the program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	
	/**
	 * The user interface, which will use text to find what the user wants to do.
	 * 
	 * @return The user's choice.
	 */
	public static int userInterface(Scanner scnr) {
		// TODO: Create interface
		
		return 0;
	}
	
	
	/**
	 * This method directs the user's choice to the appropriate method for
	 * resolution.
	 * 
	 * @param userChoice Choice from userInterface
	 * @param scnr The scanner
	 * @param database The main database
	 * @param matchesDatabase Database of search matches
	 * @param bufferedReader The BufferedReader
	 * @throws IOException
	 */
	public static void choiceHub(int userChoice, Scanner scnr, Database database, 
			Database matchesDatabase, BufferedReader bufferedReader) 
					throws IOException {
		
	}
	
	
	/**
	 * Creates a database from the unparsed file.
	 *
	 * @param br The BufferedReader.
	 * @return The constructed database.
	 * @throws IOException 
	 */
	public static void buildDatabase(Database database, BufferedReader br) throws IOException {
		
	}
	
	/**
	 * This searches the database for a movie and returns a list based on title or
	 * year.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 * @param matchesDatabase Database of search matches
	 * @return ArrayList<Movie> is returned so it can be used by the removeMovie
	 * method.
	 */
	
	public static ArrayList<Movie> searchDatabase(Scanner scnr, Database database, 
			Database matchesDatabase) {
		
		// TODO: Create method
		
		return null;
	}
	
	/**
	 * This method adds a movie to the database.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 */
	
	public static void add(Scanner scnr, Database database) {
		
	}
	
	/**
	 * This method removes a movie from the Database.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 * @param matchesDatabase Database of search matches
	 */
	
	public static void removeMovie(Scanner scnr, Database database, 
			Database matchesDatabase) {
		
	}
}
