import java.util.ArrayList;

public class Series extends Media implements Comparable<Series> {

	/** Stores the title of the series. */
	private String title;
	/** Stores the year the series began to air. */
	private String year;
	/** Stores the year the series stopped airing. */
	private String endYear;
	
	/**
	 * Stores the episodes
	 */
	private ArrayList<Episode> episodes;
	
	/**
	 * Creates a new Series by parsing unparsed data to fill in all fields.
	 * 
	 * @param data Unparsed data that contains all information about the series.
	 */
	
	public Series(String data) {
		// Creates an array of strings to hold the pieces
		String[] pieces = new String[5];
		
		// Splits the data into pieces and stores them in an array
		String[] temp = data.split("\\(");
		
		//Checks to see if the line doesnt contain an episode, if it doesnt then its a series title
		if (!data.contains("{")){
			pieces[0] = temp[0];
			pieces[1] = temp[1];
			
			this.title = pieces[0].substring(1, pieces[0].length() - 2);
			this.year = pieces[1].substring(pieces[1].length() - 9, pieces[1].length()-5);
			this.endYear = pieces[1].substring(pieces[1].length() - 4, pieces[1].length());
		
		}
		this.episodes = new ArrayList<Episode>();
	}
	
	/**
	 * Creates a new Series by moving the data given into the required fields.
	 * 
	 * @param title The title of the series.
	 * @param year The release year of the series.
	 * @param endYear The last year the series aired.
	 * @param episodes Array list that holds the episodes.
	 */
	public Series(String title, String year, String endYear, ArrayList<Episode> episodes) {
		this.title = title;
		this.year = year;
		this.endYear = endYear;
		this.episodes = episodes;
	}
	
	
	/**
	 * Creates a copy of the episode arraylist which is then used for searching
	 * 
	 * @return copy returns the copy of the object.
	 */
	public Series copyOf() {
		ArrayList<Episode> blankEpisodes = new ArrayList<Episode>();

		Series copy = new Series(title, year, endYear, blankEpisodes);

		return copy;
	}
	
	/**
	 * Returns the title of the series.
	 * 
	 * @return title The title of the series.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the starting year of the series.
	 * 
	 * @return year The first year of the series.
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Returns the ending year of the series.
	 * 
	 * @return year The last year of the series.
	 */
	public String getEndYear() {
		return endYear;
	}
	
	/**
	 * Returns the episodes of the series.
	 * 
	 * @return episodes The episodes of the series.
	 */
	public ArrayList<Episode> getEpisodes() {
		return episodes;
	}
	
	/**
	 * Sets the title of the series.
	 * 
	 * @param title The new title of the series.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sets the starting year of the series.
	 * 
	 * @param year The new starting year of the series.
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Sets the ending year of the series.
	 * 
	 * @param endYear The new ending year of the series.
	 */
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	
	/**
	 * Sets the episodes of the series.
	 * 
	 * @param episodes The new episodes of the series.
	 */
	public void setEpisodes(ArrayList<Episode> episodes) {
		this.episodes = episodes;
	}
	
	/**
	 * Adds new episodes to a file.
	 * 
	 * @param newEpisode The new episodes of the series.
	 */
	public void addEpisode(Episode newEpisode) {
		this.episodes.add(newEpisode);
	}
	
	/**
	 * Adds new episodes to a file with parameters.
	 * 
	 * @param title The title of the new episode.
	 * @param year The release year of the new episode.
	 * @param season The season of the new episode.
	 * @param number The number of the new episode.
	 * @param suspendedStatus If the episode was suspended or not.
	 */
	public void addEpisode(String title, String year, String season, String number, boolean suspendedStatus) {
		Episode newEpisode = new Episode(title, year, season, number, suspendedStatus);
		
		this.episodes.add(newEpisode);
	}
	
	/** 
	 * This method is used to sort Series objects based on their title. 
	 * <P> 
	 * Algorithm<br> 
	 * 1: Searches through each string for the first differing character<br>
	 * 2: Compares the two characters to see with comes first alphabetically or returns 0 if they are the same string<br>
	 * 3: Returns 1 or -1 based on which String comes first alphabetically<br>
	 * 
	 * @param             otherSeries      A series object to be compared to the Movie object called with compareTo                      
	 * @return            int         The method returns an integer after comparing the two 
	 * 								  objects and determining which title comes first alphabetically.
	 *  
	 * <dt><b>Conditions:</b> 
	 * <dd>PRE  -         The two objects compared are unsorted in their ArrayList 
	 * <dd>POST -         After running through the method, the Collections class will use 
	 * 					  the returned value to sort the two objects in their ArrayList
	 */
	@Override
	public int compareTo(Series otherSeries) {
		int i = 0;
		
		/*checks for the the first character in a String that differs between two titles*/
		while(otherSeries.getTitle().charAt(i) == this.title.charAt(i) && i < (this.title.length() - 1)){
			++i;
		}
		
		/*returns 0 if it is the same string*/
		if (i == this.title.length() - 1){
			return 0;
		}
		/*returns -1 if otherSeries comes after the compared series alphabetically*/
		else if (otherSeries.getTitle().charAt(i) > this.title.charAt(i)){
			return -1;
		}
		/*returns 1 if otherSeries comes before the compared series alphabetically*/
		else{
			return 1;
		}
	}
	
	/**
	 * This method takes the object information and turns it into a string.
	 * 
	 * @return seriesString The returned series as a string.
	 */
	public String toString(){
		// Begin seriesString
		String seriesString = "SERIES: ";

		// Add title to string
		seriesString += this.title;

		// Add begin year to string
		seriesString += " (" + this.year;

		// Add end year to string
		if (this.endYear.contains("?"))
			seriesString += "-UNSPECIFIED)";
		else
			seriesString += "-" + this.endYear + ")";

		return seriesString;
	}

}
