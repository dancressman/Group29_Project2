
public class Media {
	
	/** Stores the title of the media. */
	private String title;
	/** Stores the release year of the media. */
	private String year;
	
	/**
	 * Creates a new Movie by parsing unparsed data to fill in all fields.
	 * 
	 * @param data Unparsed data that contains all information about the movie.
	 */
	public Media() {
		
	}
	
	/**
	 * Returns the title of the media.
	 * 
	 * @return The title of the media.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the release year of the media.
	 * 
	 * @return The release year of the media.
	 */
	public String getYear() {
		return year;
	}
	/**
	 * Sets the title of the media.
	 * 
	 * @param title The new title of the media.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sets the release year of the media.
	 * 
	 * @param year The new release year of the media.
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return title + " " + year;
	}

}
