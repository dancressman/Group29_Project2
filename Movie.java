
public class Movie extends Media implements Comparable<Movie> {
	
	/** Stores the title of the movie. */
	private String title;
	/** Stores the release year of the movie. */
	private String year;
	/**
	 * Specifies which version of two movies with the same title is
	 * being referred to if there is more than one. 
	 */
	private String romanNumeral;
	/**
	 * Specifies the original method of release if it is anything other
	 * than in theatres (i.e. direct to video (V) or released to TV (TV).
	 */
	private String releaseMethod;
	
	/**
	 * Creates a new Movie by parsing unparsed data to fill in all fields.
	 * 
	 * @param data Unparsed data that contains all information about the movie.
	 */
	public Movie(String data) {
		// Creates an array of strings to hold the pieces
		String[] pieces = new String[3];
		
		// Splits the data into pieces and stores them in an array
		String[] temp = data.split("\\(");
		
		// Boolean determines if it has a releaseMethod
		boolean hasReleaseMethod = false;
		if (temp[temp.length - 1].equals("TV)") || temp[temp.length - 1].equals("V)"))
			hasReleaseMethod = true;
		
		/*
		 *  This code handles titles that have parentheses in them
		 */
		if (temp.length >= 3) {
			// Case if there is an optional releaseMethod
			if (hasReleaseMethod) {
				for (int i = 1; i < temp.length - 2; ++i) {
					temp[0] += "(" + temp[i];
				}

				temp[1] = temp[temp.length - 2];
				temp[2] = temp[temp.length - 1];
			}
			// Case if there is not
			else if (!hasReleaseMethod) {
				for (int i = 1; i < temp.length - 1; ++i) {
					temp[0] += "(" + temp[i];
				}

				temp[1] = temp[temp.length - 1];
			}
		}
		
		// This builds the actual pieces array that will be used to parse
		for (int index = 0; index < temp.length && index < 3; index++) {
			pieces[index] = temp[index];
		}
		
		/*
		 * Sets the title to the first piece of the string minus one,
		 * to get rid of the trailing " ".
		 */
		this.title = pieces[0].substring(0, pieces[0].length() - 1);
		
		//Case if a Roman numeral is required
		if (pieces[1].contains("/")) {
			/*
			 * Sets the year to the second piece up to the "/"
			 */
			this.year = pieces[1].substring(0, pieces[1].indexOf("/"));
			
			/*
			 * Sets the romanNumeral to the second piece between "/" and ")"
			 */
			this.romanNumeral = pieces[1].substring(pieces[1].indexOf("/") + 1, 
					pieces[1].indexOf(")"));
		}
		//Case if a Roman numeral is NOT required
		else {
			/*
			 * Sets the year to the second piece minus the trailing ")" or ") "
			 */
			this.year = pieces[1].substring(0, pieces[1].indexOf(")"));
			
			/*
			 * Sets the romanNumeral to null
			 */
			this.romanNumeral = null;
		}
		
		/*
		 * Stores releaseMethod using characters up to ")", if applicable
		 * Otherwise, stores null
		 */
		if (pieces[2] != null)
			this.releaseMethod = pieces[2].substring(0, pieces[2].indexOf(")"));
		else
			this.releaseMethod = null;
	}
	
	/**
	 * Creates a new Movie by moving the data given into the required fields.
	 * 
	 * @param title The title of the movie.
	 * @param year The release year of the movie.
	 * @param romanNumeral Number released that year  between movies with the 
	 * same name.
	 * @param releaseMethod The original method of release (V/TV).
	 */
	public Movie(String title, String year, String romanNumeral, String releaseMethod) {
		this.title = title;
		this.year = year;
		this.romanNumeral = romanNumeral;
		this.releaseMethod = releaseMethod;
	}
	
	/**
	 * Returns the title of the movie.
	 * 
	 * @return The title of the movie.
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Returns the release year of the movie.
	 * 
	 * @return The release year of the movie.
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * Returns the Roman numeral.
	 * 
	 * @return Number it was released that year between movies with the same name.
	 */
	public String getRomanNumeral() {
		return romanNumeral;
	}
	
	/**
	 * Returns the release method.
	 * 
	 * @return The original method of release (V/TV).
	 */
	public String getReleaseMethod() {
		return releaseMethod;
	}
	
	/**
	 * Sets the title of the movie.
	 * 
	 * @param title The new title of the movie.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Sets the release year of the movie.
	 * 
	 * @param year The new release year of the movie.
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * Changes the Roman numeral.
	 * 
	 * @param romanNumeral The new number it was released that year between 
	 * movies with the same name.
	 */
	public void setRomanNumeral(String romanNumeral) {
		this.romanNumeral = romanNumeral;
	}
	
	/**
	 * Sets the release method.
	 * 
	 * @param releaseMethod The correct original method of release (V/TV).
	 */
	public void setReleaseMethod(String releaseMethod) {
		this.releaseMethod = releaseMethod;
	}
	
	/**
	 * Compares to another movie.
	 * 
	 * @param otherMovie The movie to which it is being compared
	 * @return This movie's placement in regards to the other movie
	 */
	public int compareTo(Movie otherMovie) {
		// TODO: create method
		
		return 0;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		//Add title to string
		String movieString = this.title;
		
		//Add year to string
		movieString += " (" + this.year;
		
		//Add romanNumeral, if applicable
		if (this.romanNumeral != null)
			movieString += "/" + romanNumeral + ")";
		else
			movieString += ")";
		
		//Add releaseMethod, if applicable
		if (this.releaseMethod != null)
			movieString += " (" + releaseMethod + ")";
		
		return movieString;
	}
}
