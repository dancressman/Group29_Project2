public class Episode extends Media implements Comparable<Episode> {

	private String title;
	private String year;
	private String season;
	private String number;
	boolean suspendedStatus;
	
	public Episode(String data) {
				
		// Splits the data into pieces and stores them in an array
		//String[] temp1 = data.split("\\("); //Split for year
		String[] temp2 = data.split("\\{"); //Split for episode title
		String[] temp3 = data.split("#"); // Split for episode number and season number
		
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
	
	public Episode(String title, String year, String season, String number, boolean suspendedStatus) {
		this.title = title;
		this.year = year;
		this.season = season;
		this.number = number;
		this.suspendedStatus = suspendedStatus;
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
		this.title = title;
	}

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
