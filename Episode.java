public class Episode extends Media implements Comparable<Episode> {

	/** Stores the title of the episode. */
	private String title;
	/** Stores the year the episode was released. */
	private String year;
	/** Stores the season the episode was in. */
	private String season;
	/** Stores the episode number. */
	private String number;
	/** States where the episdoe was suspended or not. */
	boolean suspendedStatus;
	
	/**
	 * Creates a new Episode by parsing unparsed data to fill in all fields.
	 * 
	 * @param data Unparsed data that contains all information about the episode.
	 */
	public Episode(String data) {
				
		/* Splits the data into pieces and stores them in an array */
		
		/* Split for episode title */
		String[] temp2 = data.split("\\{");
		
		/* Split for episode number and season number */
		String[] temp3 = data.split("#"); 
		
		if (data.contains("{")){

			if (data.contains("#")){
				this.season = temp3[1].substring(temp3[1].indexOf(".") - 1, temp3[1].indexOf("."));
				this.number = temp3[1].substring(temp3[1].indexOf(".") + 1, temp3[1].indexOf(")"));
				this.title = temp2[1].substring(0, temp2[1].indexOf("("));
			}
			else if (temp2.length == 3){
				this.title = temp2[2].substring(0, temp2[2].indexOf("}"));
				}
				else {
					this.title = temp2[1].substring(0, temp2[1].indexOf("}"));
				}
			if(data.contains("SUSPENDED"))
				suspendedStatus = true;
			else
				suspendedStatus = false;
			
			this.year = data.substring(data.length() - 4, data.length());
		}
	}
	
	/**
	 * Creates a new Episode by moving the data given into the required fields.
	 * 
	 * @param title The title of the episode.
	 * @param year The release year of the episode.
	 * @param season The season the episode was in.
	 * @param number The number the episode was.
	 * @param suspendedStatus Determines whether the episode was suspended or not.
	 */
	public Episode(String title, String year, String season, String number, boolean suspendedStatus) {
		this.title = title;
		this.year = year;
		this.season = season;
		this.number = number;
		this.suspendedStatus = suspendedStatus;
	}
	
	/**
	 * Returns the title of the episode.
	 * 
	 * @return title The title of the episode.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the year of the episode.
	 * 
	 * @return year The first year of the series.
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Returns the season of the episode.
	 * 
	 * @return season The season of the episode.
	 */
	public String getSeason() {
		return season;
	}
	
	/**
	 * Returns the number of the episode.
	 * 
	 * @return number The number of the episode.
	 */
	public String getNumber() {
		return number;
	}
	
	/**
	 * Returns whether or not the episode was suspended
	 * 
	 * @return suspendedStatus Whether or not the episode was suspended.
	 */
	public boolean getSuspendedStatus() {
		return suspendedStatus;
	}
	
	/**
	 * Sets the title of the episode.
	 * 
	 * @param title The new title of the episode.
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * This method takes the object information and turns it into a string.
	 * 
	 * @return episodeString The returned episode as a string.
	 */
	public String toString() {
		// Begin episodeString
		String episodeString = "EPISODE: ";

		// Add title to string
		episodeString += this.title;

		// Add year to string
		if (this.year.contains("?"))
			episodeString += " (UNSPECIFIED)";
		else
			episodeString += " (" + this.year + ")";

		return episodeString;
	}
	
	/** 
	 * This method is used to sort Episode objects based on their title. 
	 * <P> 
	 * Algorithm<br> 
	 * 1: Searches through each string for the first differing character<br>
	 * 2: Compares the two characters to see with comes first alphabetically or returns 0 if they are the same string<br>
	 * 3: Returns 1 or -1 based on which String comes first alphabetically<br>
	 * 
	 * @param             otherEpisode      A episode object to be compared to the Movie object called with compareTo                      
	 * @return            int         The method returns an integer after comparing the two 
	 * 								  objects and determining which title comes first alphabetically.
	 *  
	 * <dt><b>Conditions:</b> 
	 * <dd>PRE  -         The two objects compared are unsorted in their ArrayList 
	 * <dd>POST -         After running through the method, the Collections class will use 
	 * 					  the returned value to sort the two objects in their ArrayList
	 */
	@Override
	public int compareTo(Episode otherEpisode) {
		
		int i = 0;
		
		/*checks for the the first character in a String that differs between two titles*/
		while(otherEpisode.getTitle().charAt(i) == this.title.charAt(i) && i < (this.title.length() - 1)){
			++i;
		}
		
		/*returns 0 if it is the same string*/
		if (i == (this.title.length() - 1)){
			return 0;
		}
		/*returns -1 if otherEpisode comes after the compared episode alphabetically*/
		else if (otherEpisode.getTitle().charAt(i) > this.title.charAt(i)){
			return -1;
		}
		/*returns 1 if otherEpisode comes before the compared episode alphabetically*/
		else{
			return 1;
		}
	}
}
