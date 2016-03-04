import java.util.Comparator;

/** 
 * Project #2 
 * CS 2334, Section 013 
 * Mar 3, 2016 
 * <P> 
 * This class will be used to sort an ArrayList of Media objects
 * based on their release dates 
 * </P> 
 * @version 1.0 
 */
 
public class YearComparator implements Comparator<Media> {

	/** 
	 * This method is used to sort Media objects based on their release date. 
	 * <P> 
	 * Algorithm<br> 
	 * 1: Searches through each string for the first differing character<br>
	 * 2: Compares the two characters to see with comes first chronologically or returns 0 if they are the same string<br>
	 * 3: Returns 1 or -1 based on which String comes first chronologically<br>
	 * 
	 * @param             media1      A Media object from an ArrayList to be compared to another
	 * @param 			  media2      Another Media object from an ArrayList                        
	 * @return            int         The method returns an integer after comparing the two 
	 * 								  parameters and determining if one contains an earlier
	 * 								  or later date than the other. 
	 * <dt><b>Conditions:</b> 
	 * <dd>PRE  -         The two parameters passed are unsorted in their ArrayList 
	 * <dd>POST -         After running through the method, the Collections class will use 
	 * 					  the returned value to sort the two objects in their ArrayList
	 */
	 
	@Override
	public int compare(Media media1, Media media2) {
		
		int i = 0;
		
		/*checks for the the first character in a String that differs*/
		while(media1.getYear().charAt(i) == media2.getYear().charAt(i) 
				       && i < (media1.getYear().length() - 1)){
			++i;
		}
		
		/*returns 0 if the two medias have the same release date*/
		if (i ==  (media1.getYear().length() - 1)){
			return 0;
		}
		/*returns -1 if media1 comes after media2 chronologically*/
		else if (media1.getYear().charAt(i) > media2.getYear().charAt(i)){
			return -1;
		}
		/*returns 1 if media 1 comes before media2 chronologically*/
		else{
			return 1;
		}
	}
}
