import java.util.ArrayList;

public class Series extends Media {

	/** Stores the title of the movie. */
	private String title;
	/** Stores the release year of the movie. */
	private String year;
	/**
	 * Stores the episodes
	 */
	private ArrayList<Episode> episodes;

	/*
	 * INCOMPLETE
	 * 
	 * TODO: Add JavaDoc comments!
	 */
	
	public Series(String data) {
		
	}
	
	public Series(String title, String year, ArrayList<Episode> episodes) {
		
	}
	
	public String getTitle() {
		return null;
	}
	
	public String getYear() {
		return null;
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
	
	/** 
	 * This method is used to sort Series objects based on their title. 
	 * <P> 
	 * compareTo<br> 
	 * This method is used by the Collections class to sort an ArrayList of Series Objects based on their titles<br> 
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
	
	public String toString(){
		return null;
	}

}
