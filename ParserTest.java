import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

	@Test
	public void test() {
		//Builds new movie for testing purposes
		Movie movie = new Movie("Test (1234/I) (TV)");
		Movie movie2 = new Movie("Test2", "2345", "II", "V");
		
		/*
		 * Can you do multiple tests at once? None of this will run.
		 * I definitely should've figured this out before the lab period.
		 */
		System.out.println(movie.getTitle());
		System.out.println(movie2.getTitle());
		
		assertEquals(movie.getTitle(), "Test");
		assertEquals(movie.getYear(), "1234");
		assertEquals(movie.getRomanNumeral(), "I");
		assertEquals(movie.getReleaseMethod(), "TV");
	}

}
