
public class Episode {

	String title;
	String year;
	String season;
	String number;
	boolean suspendedStatus;
	
	public Episode() {
		// TODO Auto-generated constructor stub
	}
	
	public Episode(String title, String year, String season, String number, boolean suspendedStatus) {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getSeason() {
		return season;
	}
	
	public String getNumber() {
		return number;
	}
	
	public boolean getSuspendedStatus() {
		return suspendedStatus;
	}
	
	public void setTitle(String title) {
		
	}
	
	/** 
	 * This method is used to sort Episode objects based on their title. 
	 * <P> 
	 * compareTo<br> 
	 * This method is used by the Collections class to sort an ArrayList of Episode Objects based on their titles<br> 
	 * @param             otherEpisode      A series object to be compared to the Episode object called with compareTo                      
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
