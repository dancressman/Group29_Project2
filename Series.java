import java.util.ArrayList;

public class Series extends Media implements Comparable<Series> {

	/** Stores the title of the series. */
	private String title;
	/** Stores the release year of the series. */
	private String beginYear;
	/** Stores the release year of the series. */
	private String endYear;
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
			this.endYear = pieces[1].substring(pieces[1].length() - 4, pieces[1].length());
		
		}
		this.episodes = new ArrayList<Episode>();
	}
	
	public Series(String title, String beginYear, String endYear, ArrayList<Episode> episodes) {
		this.title = title;
		this.beginYear = beginYear;
		this.endYear = endYear;
		this.episodes = episodes;
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
