import java.util.ArrayList;
import java.util.Collections;

public class Database {

	/**
	 * The list of Movies in the database
	 */
	ArrayList<Movie> movieList;
	/**
	 * The list of Series in the database
	 */
	ArrayList<Series> seriesList;
	
	/**
	 * Creates a new Database.
	 */
	public Database() {
		movieList = new ArrayList<Movie>();
		seriesList = new ArrayList<Series>();
	}
	
	/**
	 * Creates a new Database from a previously established ArrayLists.
	 */
	public Database(ArrayList<Movie> movieList, ArrayList<Series> seriesList) {
		this.movieList = movieList;
		this.seriesList = seriesList;
	}
	
	/**
	 * 
	 * @return movieList
	 */
	public ArrayList<Movie> getMovieList() {
		return movieList;
	}
	
	/**
	 * 
	 * @return seriesList
	 */
	public ArrayList<Series> getSeriesList() {
		return seriesList;
	}
	
	/**
	 * Changes the movieList to one that is input.
	 * 
	 * If used at all, this will probably only be for organizing output data.
	 */
	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}
	
	/**
	 * Changes the seriesList to one that is input.
	 * 
	 * If used at all, this will probably only be for organizing output data.
	 */
	public void setSeriesList(ArrayList<Series> seriesList) {
		this.seriesList = seriesList;
	}
	
	/**
	 * 
	 * MOVIE TITLE SEARCH
	 * 
	 * Movies are imported into matchesDatabase as whole objects.
	 * 
	 * @param title
	 *            The title of the media.
	 * @return A list of all media objects containing that title element.
	 */
	public ArrayList<Movie> searchMovieTitle(String titleSearch) {
		
		// Creates new ArrayList to hold all potential matches
		ArrayList<Movie> matches = new ArrayList<Movie>();

		// Searches for potential matches in database
		for (Movie potentialMatch : movieList) {
			// Stores potential match title
			String matchTitle = potentialMatch.getTitle();

			// Adds potential match to List if the title contains the search value
			if (matchTitle.contains(titleSearch))
				matches.add(potentialMatch);
		}

		return matches;
	}
	
	/**
	 * 
	 * MOVIE TITLE SEARCH - EXACT
	 * 
	 * Movies are imported into matchesDatabase as whole objects.
	 * 
	 * @param title
	 *            The title of the media.
	 * @return A list of all media objects containing that title element.
	 */
	public ArrayList<Movie> searchMovieTitleExact(String titleSearch) {
		
		// Creates new ArrayList to hold all potential matches
		ArrayList<Movie> matches = new ArrayList<Movie>();

		// Searches for potential matches in database
		for (Movie potentialMatch : movieList) {
			// Stores potential match title
			String matchTitle = potentialMatch.getTitle();

			// Adds potential match to List if the title contains the search value
			if (matchTitle.equalsIgnoreCase(titleSearch))
				matches.add(potentialMatch);
		}

		return matches;
	}
	
	/**
	 * 
	 * SERIES TITLE SEARCH
	 * 
	 * Series are imported into matchesDatabase as empty COPY objects if they
	 * meet the criteria or if any of their episodes do. (No Episodes inside of
	 * them.)
	 * 
	 * Episodes that meet the criteria are then added to the empty copy objects.
	 * 
	 * @param title
	 *            The title of the media.
	 * @return A list of all media objects containing that title element.
	 */
	public ArrayList<Series> searchSeriesTitle(String titleSearch, 
			boolean includeEpisodes) {
		
		// Creates new ArrayList to hold all potential matches
		ArrayList<Series> matches = new ArrayList<Series>();

		// Searches for potential matches in database
		for (Series potentialMatch : seriesList) {
			// Stores potential match title
			String matchTitle = potentialMatch.getTitle();
			
			// Checked if Series gets added to list
			boolean seriesInList = false;
			
			// Blank copy of Series to potentially be added
			Series matchCopy = potentialMatch.copyOf();

			// Adds potential match to List if the title contains the search value
			if (matchTitle.contains(titleSearch)) {
				matches.add(matchCopy);
				seriesInList = true;
			}
			
			// Checks episodes, if required, with a very similar method
			if (includeEpisodes) {
				for (Episode potentialEpisode : potentialMatch.getEpisodes()) {
					String episodeTitle = potentialEpisode.getTitle();
					
					if (episodeTitle.contains(titleSearch)) {
						if (!seriesInList) {
							matches.add(matchCopy);
							seriesInList = true;
						}
						
						matchCopy.addEpisode(potentialEpisode);
					}
				}
			}
		}

		return matches;
	}
	
	/**
	 * 
	 * SERIES TITLE SEARCH - EXACT
	 * 
	 * Series are imported into matchesDatabase as empty COPY objects if they
	 * meet the criteria or if any of their episodes do. (No Episodes inside of
	 * them.)
	 * 
	 * Episodes that meet the criteria are then added to the empty copy objects.
	 * 
	 * @param title
	 *            The title of the media.
	 * @return A list of all media objects containing that title element.
	 */
	public ArrayList<Series> searchSeriesTitleExact(String titleSearch, 
			boolean includeEpisodes) {
		
		// Creates new ArrayList to hold all potential matches
		ArrayList<Series> matches = new ArrayList<Series>();

		// Searches for potential matches in database
		for (Series potentialMatch : seriesList) {
			// Stores potential match title
			String matchTitle = potentialMatch.getTitle();
			
			// Checked if Series gets added to list
			boolean seriesInList = false;
			
			// Blank copy of Series to potentially be added
			Series matchCopy = potentialMatch.copyOf();

			// Adds potential match to List if the title equalsIgnoreCase the search value
			if (matchTitle.equalsIgnoreCase(titleSearch)) {
				matches.add(matchCopy);
				seriesInList = true;
			}
			
			// Checks episodes, if required, with a very similar method
			if (includeEpisodes) {
				for (Episode potentialEpisode : potentialMatch.getEpisodes()) {
					String episodeTitle = potentialEpisode.getTitle();
					
					if (episodeTitle.equalsIgnoreCase(titleSearch)) {
						if (!seriesInList) {
							matches.add(matchCopy);
							seriesInList = true;
						}
						
						matchCopy.addEpisode(potentialEpisode);
					}
				}
			}
		}

		return matches;
	}
	
	/**
	 * 
	 * MOVIE YEAR SEARCH
	 * 
	 * Movies are imported into matchesDatabase as whole objects.
	 * 
	 * @param title
	 *            The title of the media.
	 * @return A list of all media objects containing that title element.
	 */
	public ArrayList<Movie> searchMovieYear(String yearSearch) {
		
		// Creates new ArrayList to hold all potential matches
		ArrayList<Movie> matches = new ArrayList<Movie>();

		// Searches for potential matches in database
		for (Movie potentialMatch : movieList) {
			// Stores potential match year
			String matchYear = potentialMatch.getYear();

			// Adds potential match to List if the year contains the search value
			if (matchYear.contains(yearSearch))
				matches.add(potentialMatch);
		}

		return matches;
	}
	
	/**
	 * 
	 * SERIES YEAR SEARCH
	 * 
	 * Series are imported into matchesDatabase as empty COPY objects if they
	 * meet the criteria or if any of their episodes do. (No Episodes inside of
	 * them.)
	 * 
	 * Series are considered to match the year if the year is anywhere in their
	 * range. If they have a "????", they are assumed to be ongoing.
	 * 
	 * Episodes that meet the criteria are then added to the empty copy objects.
	 * 
	 * @param year
	 *            The year of the media.
	 * @return A list of all media objects containing that title element.
	 */
	public ArrayList<Series> searchSeriesYear(String yearSearch, 
			boolean includeEpisodes) {
		
		// Creates new ArrayList to hold all potential matches
		ArrayList<Series> matches = new ArrayList<Series>();

		// Searches for potential matches in database
		for (Series potentialMatch : seriesList) {
			// Stores potential match year
			String matchBeginYear = potentialMatch.getYear();
			String matchEndYear = potentialMatch.getEndYear();
			
			// Converts years to int for finding Series ranges
			int matchBeginYearInt = Integer.parseInt(matchBeginYear);
			int matchEndYearInt = Integer.MAX_VALUE;
			if (!matchEndYear.contains("?")) // ???? means it HAS NOT ENDED - MAX_VALUE
				matchEndYearInt = Integer.parseInt(matchEndYear);
			int yearSearchInt = Integer.parseInt(yearSearch);
			
			// Checked if Series gets added to list
			boolean seriesInList = false;
			
			// Blank copy of Series to potentially be added
			Series matchCopy = potentialMatch.copyOf();

			// Adds potential match to List if the years contain the search value
			if (matchBeginYearInt <= yearSearchInt 
					&& matchEndYearInt >= yearSearchInt) {
				matches.add(matchCopy);
				seriesInList = true;
			}
			
			// Checks episodes, if required, with a very similar method
			if (includeEpisodes) {
				if (potentialMatch.getEpisodes() != null 
						&& potentialMatch.getEpisodes().size() > 0) {
					for (Episode potentialEpisode : potentialMatch.getEpisodes()) {
						String episodeYear = potentialEpisode.getYear();

						if (episodeYear.equals(yearSearch)) {
							if (!seriesInList) {
								matches.add(matchCopy);
								seriesInList = true;
							}

							matchCopy.addEpisode(potentialEpisode);
						}
					}
				}
			}
		}

		return matches;
	}

	/**
	 * Adds Movie to the database.
	 * 
	 * @param newMovie The movie being added.
	 */
	public Movie addMovie(Movie newMovie) {
		// Adds new Movie to movieList
		movieList.add(newMovie);
		
		return newMovie;
	}
	
	/**
	 * Adds Movie to the database where the user provides all information.
	 * 
	 * @param title The title of the movie.
	 * @param year The release year of the movie.
	 * @param romanNumeral Number released that year between movies with the 
	 * same name.
	 * @param releaseMethod The original method of release (V/TV).
	 */
	public Movie addMovie(String title, String year, String romanNumeral, 
			String releaseMethod) {
		// Builds a Movie based on the input specifications
		Movie newMovie = new Movie(title, year, romanNumeral, releaseMethod);
		// Adds new Movie to movieList
		movieList.add(newMovie);
		
		return newMovie;
	}
	
	/**
	 * Adds Movie to the database using the constructor that filters
	 * unparsed data.
	 * 
	 * @param data Unparsed data that contains all information about the media.
	 */
	public Movie addUnparsedMovie(String data) {
		// Builds a Movie using unparsed data
		Movie newMovie = new Movie(data);
		// Adds new Movie to movieList
		movieList.add(newMovie);
		
		return newMovie;
	}
	
	/**
	 * Adds series to the database
	 * @param newSeries
	 */
	public Series addSeries(Series newSeries) {
		// Adds new Series to seriesList
		seriesList.add(newSeries);
		
		return newSeries;
	}
	
	/**
	 * Adds series to the database
	 * @param title
	 * @param year
	 * @param episodes
	 */
	public Series addSeries(String title, String beginYear, String endYear, 
			ArrayList<Episode> episodes) {
		// Builds a Series based on the input specifications
		Series newSeries = new Series(title, beginYear, endYear, episodes);
		// Adds new Series to seriesList
		seriesList.add(newSeries);
		
		return newSeries;
	}
	 
	/**
	  * Adds Series to the database
	  * @param data
	  */
	public Series addUnparsedSeries(String data) {
		// Builds a Movie using unparsed data
		Series newSeries = new Series(data);
		// Adds new Movie to movieList
		seriesList.add(newSeries);
		
		return newSeries;
	}
	
	/**
	 * Adds episode to series in the database
	 * @param newEpisode
	 * @param series
	 */
	public Episode addEpisode(Episode newEpisode, Series series) {
		// Adds new Episode to Series
		series.addEpisode(newEpisode);
		
		return newEpisode;
	}
	
	/**
	 * Adds episode to series in the database
	 * @param title
	 * @param year
	 * @param season
	 * @param number
	 * @param suspendedStatus
	 * @param series
	 */
	public Episode addEpisode(String title, String year, String season, String number,
			boolean suspendedStatus, Series series) {
		// Builds a Movie based on the input specifications
		Episode newEpisode = new Episode(title, year, season, number, 
				suspendedStatus);
		// Adds new Episode to Series
		series.addEpisode(newEpisode);
		
		return newEpisode;
	}
	
	/**
	 * Adds episode to series in the database
	 * @param data
	 */
	public Episode addUnparsedEpisode(String data, Series series) {
		// Builds a Movie based on the input specifications
		Episode newEpisode = new Episode(data);
		// Adds new Episode to Series
		series.addEpisode(newEpisode);
		
		return newEpisode;
	}
	
	public void sortByTitle() {
		Collections.sort(movieList);
	}
	
	public void sortByYear() {
		YearComparator c = new YearComparator();
		
		Collections.sort(movieList, c);
		Collections.sort(seriesList, c);
	}
	
	/** 
	 * Removes movie from the database.
	 * 
	 * @param chosenMovie The movie chosen for removal.
	 */
	public void removeMovie(Movie chosenMovie) {
		movieList.remove(chosenMovie);
	}
	
	/** 
	 * Removes series from the database.
	 * 
	 * @param chosenSeries The series chosen for removal.
	 */
	public void removeSeries(Series chosenSeries) {
		seriesList.remove(chosenSeries);
	}
	
//	/** 
//	 * Removes episode from a series in the database.
//	 * 
//	 * @param chosenEpisode The episode chosen for removal.
//	 */
//	public void remove(Episode chosenEpisode, Series series) {
//		series.removeEpisode(chosenEpisode);
//	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// String that holds all information to be returned
		String databaseString = "";
		// Keeps track of the number of movies
		int moviePosition = 0;
		// Keeps track of the number of series
		int seriesPosition = 0;
		
		// If there are movies in the database, it runs through them all
		if (movieList.size() > 0) {
			databaseString += "\nMOVIES:\n";

			for (Movie item : movieList) {
				++moviePosition;
				databaseString += moviePosition + ". " + item.toString() + "\n";
			}
		}
		
		// If there are series in the database, it runs through them all
		if (seriesList.size() > 0) {
			databaseString += "\nSERIES:\n";

			for (Series item : seriesList) {
				++seriesPosition;
				databaseString += seriesPosition + ". " + item.toString() + "\n";
				
				if (item.getEpisodes() != null && item.getEpisodes().size() > 0) {
					for (Episode episode : item.getEpisodes()) {
						databaseString += "\t" + episode.getSeason() + "." + episode.getNumber() + ". "
								+ episode.toString() + "\n";
					}
				}
			}
		}
		
		if (movieList.size() == 0 && seriesList.size() == 0) {
			databaseString += "\nNO MATCHES";
		}
		
		return databaseString;
	}
}
