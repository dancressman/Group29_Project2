import java.util.ArrayList;

public class Series extends Media {

	/** Stores the title of the series. */
	private String title;
	/** Stores the release year of the series. */
	private String beginYear;
	/** Stores the release year of the series. */
	private String endYear;
	/**
	 * Stores the episodes
	 */
	
	
	/*
	 * INCOMPLETE
	 * 
	 * TODO: Add JavaDoc comments!
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
			this.beginYear = pieces[1].substring(pieces[1].length() - 9, pieces[1].length()-5);
			
			if (pieces[1].contains("????"))
			this.endYear = pieces[1].substring(pieces[1].length() - 4, pieces[1].length());
		}
	}
	
	public Series(String title, String beginYear, String endYear,ArrayList<Episode> episodes) {
		
	}
	
	public Series copyOf() {
		ArrayList<Episode> blankEpisodes = new ArrayList<Episode>();

		Series copy = new Series(title, beginYear, endYear, blankEpisodes);

		return copy;

	}
	public String getTitle() {
		return title;
	}
	
	public String getBeginYear() {
		return beginYear;
	}
	
	public String getEndYear() {
		return endYear;
	}
	
	public ArrayList<Episode> getEpisodes() {
		return null;
	}
	
	public void setTitle(String title) {
		
	}
	
	public void setYear(String year) {
		
	}
	
	public void setEpisodes(ArrayList<Episode> episodes) {
		
	}
	
	public void addEpisode(Episode newEpisode) {
		
	}
	
	public void addEpisode(String title, String year, String season, String number, boolean suspendedStatus) {
		
	}
	
	
	public String toString(){
		return null;
	}
	
	/** 
	 * This method is used to sort Series objects based on their title. 
	 * <P> 
	 * Algorithm<br> 
	 * 1: Searches through each string for the first differing character<br>
	 * 2: Compares the two characters to see with comes first alphabetically or returns 0 if they are the same string<br>
	 * 3: Returns 1 or -1 based on which String comes first alphabetically<br>
	 * 
	 * @param             otherSeries      A series object to be compared to the series object called with compareTo                      
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

}
