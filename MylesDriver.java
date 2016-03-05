import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Driver {
	
	public static ArrayList<Movie> movieList = new ArrayList<Movie>();
	public static ArrayList<Series> seriesList = new ArrayList<Series>();
	public static ArrayList<Episode> episodeList = new ArrayList<Episode>();
	
	public static void main(String[] args) throws IOException{
		
		//This is for program arguments
		File fileName = null;
		if (0 < args.length) {
		   fileName = new File(args[0]);
		}
		
		String file = fileName.toString();

		readFile(file); //Read the file line by line and stores them into the arraylists declared above
		
		displayArrayList(seriesList); //A method I use for testing only, change the arraylist to test different ones (seriesList, movieList)
	
	}
	
	public static void readFile(String file) throws IOException{
		
		String nextline;
		String fileName = file;
		
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		
		nextline = br.readLine();
		
		while (nextline != null){
			
			
			/********* For Movies ********/  //uncommoent the code to use it
			//Media mediaObj = new Media(nextline);  
			//mediaList.add(mediaObj);
			
			
			/********* For Movies ********/  //uncommoent the code to use it
			//Movie movieObj = new Movie(nextline);  
			//movieList.add(movieObj);
			
			
			/********* For Series ********/   //uncommoent the code to use it
			Series seriesObj = new Series(nextline);
			if(!nextline.contains("{"))
				seriesList.add(seriesObj);
			
			
			/********* For Episodes ********/    //uncommoent the code to use it
			//Episode episodeObj = new Episode(nextline);
			//if(nextline.contains("{"))
				//episodeList.add(episodeObj);
			
			
			nextline = br.readLine();
		}
		
		br.close();
	}
	
	//Uncommoent the code to use it and change the arraylist type to episode, series, or movie, depending on what you are testing
	public static void displayArrayList(ArrayList<Series> listToBeDisplayed) {
		for (int i = 0; i < listToBeDisplayed.size();i++){ //listToBeDisplayed.size()
			//System.out.println(listToBeDisplayed.get(i).getTitle());  // For Series, episodes, or movies
			
			System.out.println(listToBeDisplayed.get(i).getTitle() + " ");
			//System.out.print(listToBeDisplayed.get(i).getSeason() + " ");
			//System.out.print(listToBeDisplayed.get(i).getSuspendedStatus() + " ");
			//System.out.println(listToBeDisplayed.get(i).getNumber());
			//System.out.println(listToBeDisplayed.get(i).getSeason());  //For episodes
			//System.out.println(listToBeDisplayed.get(i).getNumber());  //For episodes
			//System.out.println(listToBeDisplayed.get(i).getBegYear());  //For movie or episodes
			System.out.println(listToBeDisplayed.get(i).getBeginYear());  //For Series
			System.out.println(listToBeDisplayed.get(i).getEndYear());  //For Series
			//System.out.println(listToBeDisplayed.get(i).getReleaseMethod());  //For Movies
		}
	}
}
