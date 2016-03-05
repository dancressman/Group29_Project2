import java.util.ArrayList;

public class Series extends Media implements Comparable<Series> {

	/** Stores the title of the series. */
	private String title;
	/** Stores the release year of the series. */
	private String year;
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
			this.year = pieces[1].substring(pieces[1].length() - 9, pieces[1].length()-5);
			this.endYear = pieces[1].substring(pieces[1].length() - 4, pieces[1].length());
		
		}
		this.episodes = new ArrayList<Episode>();
	}
	
	public Series(String title, String year, String endYear, ArrayList<Episode> episodes) {
		this.title = title;
		this.year = year;
		this.endYear = endYear;
		this.episodes = episodes;
	}
	
	public Series copyOf() {
		ArrayList<Episode> blankEpisodes = new ArrayList<Episode>();

		Series copy = new Series(title, year, endYear, blankEpisodes);

		return copy;

	}
	public String getTitle() {
		return title;
	}
	
	public String getYear() {
		return year;
	}
	
	public String getEndYear() {
		return endYear;
	}
	
	public ArrayList<Episode> getEpisodes() {
		return episodes;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public void setEndYear(String endYear) {
		this.endYear = endYear;
	}
	
	public void setEpisodes(ArrayList<Episode> episodes) {
		this.episodes = episodes;
	}
	
	public void addEpisode(Episode newEpisode) {
		this.episodes.add(newEpisode);
	}
	
	public void addEpisode(String title, String year, String season, String number, boolean suspendedStatus) {
		Episode newEpisode = new Episode(title, year, season, number, suspendedStatus);
		
		this.episodes.add(newEpisode);
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
			seriesString += this.endYear + ")";

		return seriesString;
	}

}
