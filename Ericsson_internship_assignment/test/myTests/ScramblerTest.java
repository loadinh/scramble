package myTests;

import static org.junit.Assert.*;
import myPack.Scrambler;

import org.junit.Before;
import org.junit.Test;

/**
 * Testing the scramble method of the Scrambler class 
 * 
 * @author Attila Dinh
 * */
public class ScramblerTest {
	
	/**the class under test*/
	private Scrambler scrambler;
	
	/**Initialization before every test*/
	@Before
	public void setUp() throws Exception {
		scrambler = new Scrambler();
	}
	
	/**Normal usage with one word and a whole sentence*/
	@Test
	public void testScrambleReturnScrambled() {
		String inputWord = "Pandemic";
		String expectedWord = "Pimednac";
		
		assertEquals("Word is not scrambled correctly", expectedWord, scrambler.scramble(inputWord));
		
		//Sentence contains spaces, punctuation marks and words with all kinds of lengths!
		String inputSentence = "The series follows the adventures of Finn, a human boy, "
				+ "and his best friend and adoptive brother Jake, a dog.";
		
		String expectedSentence = "The seires fwollos the aerutnevds of Fnni, a hamun byo, "
				+ "and his bset fneird and avitpode behtorr Jeka, a dgo.";
		
		assertEquals("Sentence is not scrambled correctly", expectedSentence, scrambler.scramble(inputSentence));
	}

	/**For an empty string, it should simply return it*/ 
	@Test
	public void testScrambleWithEmptyString() {
		assertEquals("Empty string is problematic", "", scrambler.scramble(""));
	}
	
	/**Throwing exception when called with null*/
	@Test(expected = NullPointerException.class)
	public void testExceptionThrownWhenCalledWithNull() {
		scrambler.scramble(null);
	}
}

