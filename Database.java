import java.util.ArrayList;

public class Database {

	ArrayList<Media> database;
	
	/**
	 * Creates a new Database.
	 */
	public Database() {
		database = new ArrayList<Media>();
	}
	
	/**
	 * Creates a new Database from a previously established ArrayList.
	 */
	public Database(ArrayList<Media> oldDatabase) {
		database = oldDatabase;
	}
	
	/**
	 * Searches for media containing a title element.
	 * 
	 * @param title The title of the media.
	 * @return A list of all media objects containing that title element.
	 */
	public ArrayList<Media> searchTitle(String titleSearch) {
		
		// TODO: Build method
		
		return null;
		
	}
	
	/**
	 * Searches for media released in a specific year.
	 * 
	 * @param year The release year of the media.
	 * @return A list of all media objects released in that year.
	 */
	public ArrayList<Media> searchYear(String yearSearch) {
		return null;
	}
	
	/**
	 * Adds new movie to the database.
	 * 
	 * @param newMovie The movie being added.
	 */
	public void addMovie(Movie newMovie) {
		//Adds new Media to the database
		database.add(newMovie);
	}
	
	/**
	 * Adds a movie to the database where the user provides all information.
	 * 
	 * @param title The title of the movie.
	 * @param year The release year of the movie.
	 * @param romanNumeral Number released that year between movies with the 
	 * same name.
	 * @param releaseMethod The original method of release (V/TV).
	 */
	public void addMovie(String title, String year, String romanNumeral, 
			String releaseMethod) {
		
	}
	
	/**
	 * Adds Media to the database using the constructor that filters
	 * unparsed data.
	 * 
	 * @param data Unparsed data that contains all information about the media.
	 */
	public void addUnparsedMovie(String data) {
		
	}
	
	/**
	 * Adds series to the database
	 * @param newSeries
	 */
	public void addSeries(Series newSeries) {
		
	}
	
	/**
	 * Adds series to the database
	 * @param title
	 * @param year
	 * @param episodes
	 */
	public void addSeries(String title, String year, ArrayList<Episode> episodes) {
		
	}
	 /**
	  * Adds series to the database
	  * @param data
	  */
	public void addSeries(String data) {
		
	}
	
	/**
	 * Adds episode to series in the database
	 * @param newEpisode
	 * @param series
	 */
	public void addEpisode(Episode newEpisode, Series series) {
		
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
	public void addEpisode(String title, String year, String season, String number,
			boolean suspendedStatus, Series series) {
		
	}
	
	/**
	 * Adds episode to series in the database
	 * @param data
	 */
	public void addEpisode(String data) {
		
	}
	
	/** 
	 * Removes movie from the database.
	 * 
	 * @param chosenMovie The movie chosen for removal.
	 */
	public void removeMovie(Movie chosenMovie) {
		database.remove(chosenMovie);
	}
	
	/** 
	 * Removes series from the database.
	 * 
	 * @param chosenSeries The series chosen for removal.
	 */
	public void remove(Series chosenSeries) {
		database.remove(chosenSeries);
	}
	
	/** 
	 * Removes episode from a series in the database.
	 * 
	 * @param chosenEpisode The episode chosen for removal.
	 */
	public void remove(Episode chosenEpisode, Series series) {
		database.remove(chosenEpisode);
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return null;
	}
}
