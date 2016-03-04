public class Episode extends Media {

	private String title;
	private String year;
	private String season;
	private String number;
	boolean suspendedStatus;
	
	public Episode(String data) {
				
		// Splits the data into pieces and stores them in an array
		String[] temp1 = data.split("\\("); //Split for year
		String[] temp2 = data.split("\\{"); //Split for episode title
		String[] temp3 = data.split("#"); // Split for episode number and season number
		
		//If current line is an episode, it will contain a "{"
		if (data.contains("{")){
			
			if (data.contains("#")){
				this.season = temp3[1].substring(temp3[1].indexOf(".") - 1, temp3[1].indexOf("."));
				this.number = temp3[1].substring(temp3[1].indexOf(".") + 1, temp3[1].indexOf(")"));
			}
			else if (temp2[1] != null)
			{
				this.title = temp2[1].substring(0, temp2[1].indexOf("}")); //THIS IS WHERE IM STUCKKKKKKK, index out of range when I substring
			}
		}
	}
	
	public Episode(String title, String year, String season, String number, boolean suspendedStatus) {
		this.title = title;
		this.year = year;

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

}
