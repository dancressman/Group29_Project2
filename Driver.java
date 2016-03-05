import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
	 * @version 2.0
	 */

	/**
	 * The main method, which drives the program.
	 * 
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// Creates the Database that will be used to store Movies
		Database database = new Database();
		// Creates the Database that will be used to store matches from
		// searches.
		Database matchesDatabase = new Database();



		// Creates a scanner, to be used for user input
		Scanner scnr = new Scanner(System.in);

		// Welcomes user
		System.out.println("Welcome to the Movie Database!");

		// Priming read - gets user's choice from their input
		int userChoice;
		userChoice = userInterface(scnr);

		/*
		 * Sentinel loop that reads user's choice from userInput method, runs
		 * the respective chosen method, or quits if a non-positive value is
		 * entered.
		 */
		while (userChoice > 0) {

			choiceHub(userChoice, scnr, database, matchesDatabase);

			// Runs userInterface again so another choice can be made (Sentinel)
			userChoice = userInterface(scnr);
		}

		System.out.println("Thank you for using the Movie Database!");

		// Closes Scanner and BufferedReader
		scnr.close();
	}
	
	
	/**
	 * The user interface, which will use text to find what the user wants to do.
	 * 
	 * @return The user's choice.
	 */
	public static int userInterface(Scanner scnr) {
		// This integer will reflect the user's choice
		int userChoice = 0;

		// User's choices are read to them
		System.out.println("\nPlease choose a number, or input \"-1\" to finish.");
		System.out.println("1. Add items from unparsed file.");
		System.out.println("2. Search for media in the database.");
		System.out.println("3. Add media to the database.");
//		System.out.println("4. Remove media from the database.");

		// User choice stored from chosen integer
		userChoice = scnr.nextInt();
		scnr.nextLine();

		return userChoice;
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
			Database matchesDatabase) 
					throws IOException {

		// Choosing 1 builds the database from unparsed file
		if (userChoice == 1) {
			/*
			 * Builds the database from the file by passing the Database by
			 * sharing and reading the file through the BufferedReader.
			 */
			buildDatabase(database, scnr);
		}

		// Choosing 2 allows user to search the database for a Movie
		else if (userChoice == 2) {
			searchHub(scnr, database, matchesDatabase);
		}

		// Choosing 3 allows user to add a Movie to the database
		else if (userChoice == 3) {
			addHub(scnr, database);
		}

//		// Choosing 4 allows the user to remove a Movie from the database
//		else if (userChoice == 4) {
//			removeHub(scnr, database, matchesDatabase);
//		}

		// Any other choice prompts an error message
		else {
			System.out.println("Invalid input. Please choose again.");
		}
	}
	
	
	/**
	 * Creates a database from the unparsed file.
	 *
	 * @param br The BufferedReader.
	 * @return The constructed database.
	 * @throws IOException 
	 */
	public static void buildDatabase(Database database, Scanner scnr) throws IOException {
		// Ask for media type
		System.out.println("Type of media?");
		System.out.println("1. Movies");
		System.out.println("2. Series and/or Episodes");
		String mediaInput = scnr.nextLine();
		
		/*
		 * Makes an easy way to change the media type.
		 * (Should be ENUM, but I didn't want to try to figure that out 
		 * right now.)
		 * 
		 * Works with a variety of answers!
		 * (Probably too many answers!)
		 * 
		 * MEDIA SWITCH
		 * 0 = INVALID
		 * 1 = MOVIES
		 * 2 = SERIES/EPISODES
		 */
		int mediaSwitch = 0; // Changes depending on type of media; decides what runs
		if (mediaInput.equals("1") || mediaInput.equalsIgnoreCase("M") 
				|| mediaInput.equalsIgnoreCase("MOVIE")
				|| mediaInput.equalsIgnoreCase("MOVIES")) {
			mediaSwitch = 1;
		}
		else if (mediaInput.equals("2") || mediaInput.equalsIgnoreCase("S") 
				|| mediaInput.equalsIgnoreCase("SERIES")
				|| mediaInput.equalsIgnoreCase("E")
				|| mediaInput.equalsIgnoreCase("EPISODE")
				|| mediaInput.equalsIgnoreCase("EPISODES")
				|| mediaInput.equalsIgnoreCase("SERIES AND EPISODES")
				|| mediaInput.equalsIgnoreCase("SERIES OR EPISODES")
				|| mediaInput.equalsIgnoreCase("SERIES AND/OR EPISODES")) {
			mediaSwitch = 2;
		}
		
		// Ask for file name
		System.out.print("File name: ");
		String filename = scnr.nextLine();
		
		// Creates a FileReader and BufferedReader to read the file
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		
		// Priming read that puts the first line into String nextline
		String nextline;
		nextline = br.readLine();
		
		// Adds Movies from file to database
		if (mediaSwitch == 1) {
			/*
			 * Sentinel loop that reads in the file and creates a new Movie
			 * using the addUnparsedMovie function of Database, which then
			 * automatically adds the Movie to the database. The loop stops when
			 * it receives a NULL by reading the end of the file.
			 */
			while (nextline != null) {
				database.addUnparsedMovie(nextline);

				nextline = br.readLine();
			}
			System.out.println("Database successfully built!");
		}
		
		// Adds Series/Episodes from file to database
		else if (mediaSwitch == 2) {
			/*
			 * Sentinel loop that reads in the file and creates a new Series
			 * using the addUnparsedSeries function of Database, which then
			 * automatically adds the Series to the database. When the Series
			 * is added, it adds Episodes using the "{" character until all
			 * Episodes are added.
			 * 
			 * The loop stops when it receives a NULL by reading the end 
			 * of the file.
			 */
			while (nextline != null) {
				Series series = database.addUnparsedSeries(nextline);
				nextline = br.readLine();
				
				while (nextline != null && nextline.contains("{")) {
					database.addUnparsedEpisode(nextline, series);
					nextline = br.readLine();
				}
			}
			System.out.println("Database successfully built!");
		}
		
		else {
			System.out.println("Invalid input. Returning to main menu.");
		}

		br.close();
	}
	
	/**
	 * This searches the database for Media and returns a list based on title or
	 * year.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 * @param matchesDatabase Database of search matches
	 * @return Database is returned so it can be used by the removeMovie
	 * method.
	 * @throws IOException 
	 */
	
	public static Database searchHub(Scanner scnr, Database database, 
			Database matchesDatabase) throws IOException {
		
		// Clears matchesDatabase
		matchesDatabase = new Database(); 
		
		/*
		 * QUESTION 1 determines what Media is being searched for
		 * 
		 * MEDIA SWITCH
		 * 0 = INVALID
		 * 1 = MOVIES
		 * 2 = SERIES/EPISODES
		 * 3 = BOTH
		 */
		int mediaSwitch = searchQuestion1(scnr);
		
		/*
		 * QUESTION 2 determines which parameters are used
		 * 
		 * PARAMETER SWITCH
		 * 0 = INVALID
		 * 1 = TITLE
		 * 2 = YEAR
		 * 3 = BOTH
		 */
		int parameterSwitch = searchQuestion2(scnr);
		
		/*
		 * Optional QUESTION 3 asks if they want exact matches for title searches
		 * 
		 * PRECISION SWITCH
		 * 0 = INVALID
		 * 1 = EXACT
		 * 2 = PARTIAL
		 */
		int precisionSwitch = 0;
		
		if (parameterSwitch == 1 || parameterSwitch == 3) {
			precisionSwitch = searchQuestion3(scnr);
		}
		
		/*
		 * Optional QUESTON 4 asks if they want to include episodes in search
		 * 
		 * EPISODE SWITCH
		 * 0 = INVALID
		 * 1 = YES
		 * 2 = NO
		 */
		int episodeSwitch = 0;
		
		if (mediaSwitch == 2 || mediaSwitch == 3) {
			episodeSwitch = searchQuestion4(scnr);
		}
		
		// Turns episodeSwitch into a more useful boolean
		boolean includeEpisodes = false;
		
		if (episodeSwitch == 1)
			includeEpisodes = true;
		
		// SEARCHING
		String titleSearch; // Holder for Title
		String yearSearchFull; // Holder for Year
		
		// TITLE SEARCH
		if (parameterSwitch == 1 || parameterSwitch == 3) {
			System.out.print("Title: ");
			titleSearch = scnr.nextLine();
			
			/*
			 * MOVIE TITLE SEARCH
			 * 
			 * Movies are imported into matchesDatabase as whole objects.
			 */
			if (mediaSwitch == 1 || mediaSwitch == 3) {
				ArrayList<Movie> matches = database.searchMovieTitle(titleSearch);
				
				for (Movie match : matches) {
					matchesDatabase.addMovie(match);
				}
			}
			
			/*
			 * SERIES TITLE SEARCH
			 * 
			 * Series are imported into matchesDatabase as empty COPY objects
			 * if they meet the criteria or if any of their episodes do. (No
			 * Episodes inside of them.)
			 * 
			 * Episodes that meet the criteria are then added to the empty
			 * copy objects.
			 */
			if (mediaSwitch == 2 || mediaSwitch == 3) {
				ArrayList<Series> matches = database.searchSeriesTitle(titleSearch, 
						includeEpisodes);
				
				for (Series match : matches) {
					matchesDatabase.addSeries(match);
				}
			}
		}
		
		// YEAR SEARCH
		if (parameterSwitch == 2 || parameterSwitch == 3) {
			System.out.print("Year (As \"XXXX\", as \"XXXX, YYYY, ZZZZ\", or "
					+ "as \"XXXX-YYYY\"): ");
			yearSearchFull = scnr.nextLine();
			
			// yearSearchFull converted to ArrayList<Integer>
			ArrayList<Integer> yearsToSearch = new ArrayList<Integer>();
			
			//Searches MULTIPLE YEARS
			if (yearSearchFull.contains(",")) {
				String[] pieces = yearSearchFull.split(", ");
				
				for (String yearString : pieces) {
					int year = Integer.parseInt(yearString);
					
					yearsToSearch.add(year);
				}
			}
			
			// Searches for RANGE OF YEARS
			else if (yearSearchFull.contains("-")) {
				String[] pieces = yearSearchFull.split("-");
				int startYear = Integer.parseInt(pieces[0]);
				int endYear = Integer.parseInt(pieces[1]);
				
				for(int index = startYear; index <= endYear; ++index) {
					yearsToSearch.add(index);
				}
			}
			
			// Searches SINGLE YEAR
			else {
				int year = Integer.parseInt(yearSearchFull);
				
				yearsToSearch.add(year);
			}
			
			// Loops through ALL YEARS in yearsToSearch
			for (Integer yearSearchInt : yearsToSearch) {
				
				// Makes a String so it can be passed
				String yearSearch = yearSearchInt.toString();

				/*
				 * MOVIE YEAR SEARCH
				 * 
				 * Movies are imported into matchesDatabase as whole objects.
				 */
				if (mediaSwitch == 1 || mediaSwitch == 3) {
					ArrayList<Movie> matches = database.searchMovieYear(yearSearch);

					for (Movie match : matches) {
						matchesDatabase.addMovie(match);
					}
				}

				/*
				 * SERIES YEAR SEARCH
				 * 
				 * Series are imported into matchesDatabase as empty COPY
				 * objects if they meet the criteria or if any of their episodes
				 * do. (No Episodes inside of them.)
				 * 
				 * Series are considered to match the year if the year is
				 * anywhere in their range. If they have a "????", they are
				 * assumed to be ongoing.
				 * 
				 * Episodes that meet the criteria are then added to the empty
				 * copy objects.
				 */
				if (mediaSwitch == 2 || mediaSwitch == 3) {
					ArrayList<Series> matches = database.searchSeriesYear(yearSearch, includeEpisodes);

					for (Series match : matches) {
						matchesDatabase.addSeries(match);
					}
				}
			}
		}
		
		// SORTS MATCHES
		System.out.println("Sort by");
		System.out.println("1. Title");
		System.out.println("2. Year");
		String sortInput = scnr.nextLine();
		
		// Sorts by Title
		if (sortInput.equals("1") || sortInput.equalsIgnoreCase("T")
				|| sortInput.equalsIgnoreCase("TITLE")) {
			matchesDatabase.sortByTitle();
		}
		// Sorts by Year
		if (sortInput.equals("2") || sortInput.equalsIgnoreCase("Y") 
				|| sortInput.equalsIgnoreCase("YEAR")) {
			matchesDatabase.sortByYear();
		}
		
		// PRINTS MATCHES
		System.out.println(matchesDatabase.toString());
		
		// Output if any required fields are invalid.
		if (mediaSwitch == 0 
				|| parameterSwitch == 0 
				|| ((parameterSwitch == 1 || parameterSwitch == 3) 
						&& precisionSwitch == 0)
				|| ((mediaSwitch == 2 || mediaSwitch == 3) && episodeSwitch == 0)) {
			System.out.println("One or more inputs were invalid.");
		}
		
		// SAVING TO FILE
		System.out.println("Save file? (Y/N) ");
		String saveInput = scnr.nextLine();
		
		if (saveInput.equalsIgnoreCase("Y") || saveInput.equalsIgnoreCase("YES")) {
			System.out.println("File name: ");
			String outfileName = scnr.nextLine();
			
			FileWriter outfile = new FileWriter(outfileName);
			BufferedWriter bw = new BufferedWriter(outfile);
			bw.write(matchesDatabase.toString());
			bw.newLine();
			bw.close();
		}
		
		return matchesDatabase;
	}
	
	public static int searchQuestion1(Scanner scnr) {
		// QUESTION 1 determines what Media is being searched for
		System.out.println("Searched media: ");
		System.out.println("1. Movies");
		System.out.println("2. Series/Episodes");
		System.out.println("3. Both");
		String mediaInput = scnr.nextLine();
		
		/*
		 * MEDIA SWITCH
		 * 0 = INVALID
		 * 1 = MOVIES
		 * 2 = SERIES/EPISODES
		 * 3 = BOTH
		 */
		int mediaSwitch = 0;
		
		if (mediaInput.equals("1") || mediaInput.equalsIgnoreCase("M") 
				|| mediaInput.equalsIgnoreCase("MOVIE")
				|| mediaInput.equalsIgnoreCase("MOVIES")) {
			mediaSwitch = 1;
		}
		else if (mediaInput.equals("2") || mediaInput.equalsIgnoreCase("S") 
				|| mediaInput.equalsIgnoreCase("SERIES")
				|| mediaInput.equalsIgnoreCase("E")
				|| mediaInput.equalsIgnoreCase("EPISODE")
				|| mediaInput.equalsIgnoreCase("EPISODES")
				|| mediaInput.equalsIgnoreCase("SERIES AND EPISODES")
				|| mediaInput.equalsIgnoreCase("SERIES OR EPISODES")
				|| mediaInput.equalsIgnoreCase("SERIES AND/OR EPISODES")) {
			mediaSwitch = 2;
		}
		else if (mediaInput.equals("3") || mediaInput.equalsIgnoreCase("B") 
				|| mediaInput.equalsIgnoreCase("BOTH")) {
			mediaSwitch = 3;
		}
		
		return mediaSwitch;
	}
	
	public static int searchQuestion2(Scanner scnr) {
		// QUESTION 2 determines which parameters are used
		System.out.println("Seach parameters: ");
		System.out.println("1. Title");
		System.out.println("2. Year");
		System.out.println("3. Both");
		String parameterInput = scnr.nextLine();

		/*
		 * PARAMETER SWITCH
		 * 0 = INVALID
		 * 1 = TITLE
		 * 2 = YEAR
		 * 3 = BOTH
		 */
		int parameterSwitch = 0;
		
		if (parameterInput.equals("1") || parameterInput.equalsIgnoreCase("T") 
				|| parameterInput.equalsIgnoreCase("TITLE")) {
			parameterSwitch = 1;
		}
		else if (parameterInput.equals("2") || parameterInput.equalsIgnoreCase("Y") 
				|| parameterInput.equalsIgnoreCase("YEAR")) {
			parameterSwitch = 2;
		}
		else if (parameterInput.equals("3") || parameterInput.equalsIgnoreCase("B") 
				|| parameterInput.equalsIgnoreCase("BOTH")) {
			parameterSwitch = 3;
		}
		
		return parameterSwitch;
	}
	
	public static int searchQuestion3(Scanner scnr) {
		// Optional QUESTION 3 asks if they want exact matches for title searches
		System.out.println("Search for exact or partial matches? ");
		System.out.println("1. Exact");
		System.out.println("2. Partial");
		String precisionInput = scnr.nextLine();
		
		/*
		 * PRECISON SWITCH
		 * 0 = INVALID
		 * 1 = EXACT
		 * 2 = PARTIAL
		 */
		int precisionSwitch = 0;
		
		if (precisionInput.equals("1") || precisionInput.equalsIgnoreCase("E") 
				|| precisionInput.equalsIgnoreCase("EXACT")) {
			precisionSwitch = 1;
		}
		else if (precisionInput.equals("2") || precisionInput.equalsIgnoreCase("P") 
				|| precisionInput.equalsIgnoreCase("PARTIAL")) {
			precisionSwitch = 2;
		}
		
		return precisionSwitch;
	}

	public static int searchQuestion4(Scanner scnr) {
		// Optional QUESTON 4 asks if they want to include episodes in search
		System.out.println("Include episode titles in search and output?");
		System.out.println("1. Yes");
		System.out.println("2. No");
		String episodeInput = scnr.nextLine();
		
		/*
		 * EPISODE SWITCH
		 * 0 = INVALID
		 * 1 = YES
		 * 2 = NO
		 */
		int episodeSwitch = 0;
		
		if (episodeInput.equals("1") || episodeInput.equalsIgnoreCase("Y") 
				|| episodeInput.equalsIgnoreCase("YES")) {
			episodeSwitch = 1;
		}
		else if (episodeInput.equals("2") || episodeInput.equalsIgnoreCase("N") 
				|| episodeInput.equalsIgnoreCase("NO")) {
			episodeSwitch = 2;
		}
		
		return episodeSwitch;
	}
		
	/**
	 * This method adds Media to the database.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 */
	public static void addHub(Scanner scnr, Database database) {
		// Asks for which type of Media they are choosing
		System.out.println("What kind of media would you like to add?");
		System.out.println("1. Movie");
		System.out.println("2. Series");
		System.out.println("3. Episode");
		String input = scnr.nextLine();
		
		// Add Movie
		if (input.equals("1") 
				|| input.equalsIgnoreCase("M")
				|| input.equalsIgnoreCase("MOVIE")) {
			addMovie(scnr, database);
		}
		// Add Series
		else if (input.equals("2") 
				|| input.equalsIgnoreCase("S")
				|| input.equalsIgnoreCase("SERIES")) {
			addSeries(scnr, database);
		}
		// Add Episode
		else if (input.equals("3") 
				|| input.equalsIgnoreCase("E")
				|| input.equalsIgnoreCase("EPISODE")) {
			addEpisode(scnr, database);
		}
		// Any other command
		else{
			System.out.println("Invalid input. Returning to main menu.");
		}
	}
	
	
	/**
	 * This method adds a Movie to the database.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 */
	
	public static void addMovie(Scanner scnr, Database database) {
		// Title is entered
		System.out.print("Please enter the title of the film you wish to add: ");
		String title = scnr.nextLine();

		// Year is entered
		System.out.print("Please enter the year: ");
		String year = scnr.nextLine();

		// Roman numeral is entered
		System.out.print("If applicable, please enter the number this "
				+ "film was with that title this year, or press ENTER: ");
		String romanNumeral = scnr.nextLine();

		// Release method is entered
		System.out.print("If applicable, please type either \"V\" for "
				+ "\"direct to video\" or \"TV\" for \"direct to " 
				+ "television\", or press ENTER: ");
		String releaseMethod = scnr.nextLine();

		// New Movie is created according to specifications
		Movie newMovie = new Movie(title, year, romanNumeral, releaseMethod);

		// New Movie is added to the database
		database.addMovie(newMovie);
	}
	
	
	/**
	 * This method adds a Series to the database.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 */
	
	public static void addSeries(Scanner scnr, Database database) {
		// Title is entered
		System.out.print("Please enter the title of the series you wish to add: ");
		String title = scnr.nextLine();

		// Beginning year is entered
		System.out.print("Please enter the year it started: ");
		String beginYear = scnr.nextLine();

		// Ending year is entered
		System.out.print("Please enter the year it ended: ");
		String endYear = scnr.nextLine();

		// New Series is created according to specifications
		Series newSeries = new Series(title, beginYear, endYear, null);

		// New Series is added to the database
		database.addSeries(newSeries);
	}
	
	
	/**
	 * This method adds an Episode to a Series in the database.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 */
	
	public static void addEpisode(Scanner scnr, Database database) {
		//Series is taken note of
		System.out.print("Please enter the name of the series this is from: ");
		String seriesName = scnr.nextLine();
		
		//Finds the Series in the database
		Series series = database.searchSeriesTitle(seriesName, false).get(0);
		
		// Title is entered
		System.out.print("Please enter the title of the episode you wish to add: ");
		String title = scnr.nextLine();

		// Year is entered
		System.out.print("Please enter the year it came out: ");
		String year = scnr.nextLine();

		// Season is entered
		System.out.print("In which Season did it occur? ");
		String season = scnr.nextLine();
		
		// 	Number is entered
		System.out.print("What number was it in that Season? ");
		String number = scnr.nextLine();
		
		// Suspended status is entered
		System.out.print("Is it suspended? (Y/N) ");
		String suspendedAnswer = scnr.nextLine();
		
		// Suspended status is stored as boolean
		boolean suspendedStatus = false;
		if (suspendedAnswer.equalsIgnoreCase("Y") 
				|| suspendedAnswer.equalsIgnoreCase("YES")
				|| suspendedAnswer.equals("1"))
			suspendedStatus = true;
		

		// New Episode is created according to specifications
		Episode newEpisode = new Episode(title, year, season, number, suspendedStatus);

		// New Episode is added to the series
		series.addEpisode(newEpisode);
	}
	

	/**
	 * UNUSED METHOD
	 * This method removes a movie from the Database.
	 * 
	 * @param scnr The scanner
	 * @param database The main Database
	 * @param matchesDatabase Database of search matches
	 */
	
//	public static void removeHub(Scanner scnr, Database database, 
// Database matchesDatabase) {
//		// Asks for which type of Media they are choosing
//		System.out.println("What kind of media would you like to remove?");
//		System.out.println("1. Movie");
//		System.out.println("2. Series");
//		System.out.println("3. Episode");
//		String input = scnr.nextLine();
//
//		// Add Movie
//		if (input.equals("1") || input.equalsIgnoreCase("M") || input.equalsIgnoreCase("MOVIE")) {
//			removeMovie(scnr, database);
//		}
//		// Add Series
//		else if (input.equals("2") || input.equalsIgnoreCase("S") || input.equalsIgnoreCase("SERIES")) {
//			removeSeries(scnr, database);
//		}
//		// Add Episode
//		else if (input.equals("3") || input.equalsIgnoreCase("E") || input.equalsIgnoreCase("EPISODE")) {
//			removeEpisode(scnr, database);
//		}
//		// Any other command
//		else {
//			System.out.println("Invalid input. Returning to main menu.");
//		}
//	}
	
	// TODO: Add removal methods
}
