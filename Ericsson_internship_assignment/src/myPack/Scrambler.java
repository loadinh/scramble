package myPack;
/**
 *The class has a method that scrambles every word in a sentence, and returns it. 
 *
 *NOTE, that this solution could be improved by separately dealing with the punctuation
 *marks inside and at the end of the sentence. However, I believe this solution is 
 *sufficient for the purposes of the exercise.
 *E.g. "However," becomes "Hrevewo," and "period." becomes "pdoire.", hence the structure
 *of the sentence itself remains intact, and it is still a nice scrambling!
 *ALSO, the scramble method could be static, or we could add fields for storing the 
 *last input/output sentences etc.
 *
 *This "microproject" was created for the Ericsson summer 2015 internship assessment.
 *
 *@author Attila Dinh
 * */
public class Scrambler {
	
	/**
	 * Scrambles every word in the sentence: the first and last letters stay in place,
	 * but the order of the inner letters are reversed.
	 * 
	 *@param sentence - the String sentence that should be scrambled
	 *@return the scrambled String sentence
	 *@throws NullPointerException when called with null
	 **/
	public String scramble(String sentence) throws NullPointerException {
		
		//split into words
		String[] ArrayOfWords = sentence.split(" ");

		//the array that will hold the scrambled words
		String[] scrambledWords = new String[ArrayOfWords.length];
		
		//foreach word -> scramble!
		for (int i = 0; i < ArrayOfWords.length; i++) {
			
			String word = ArrayOfWords[i];
			
			//char array of the scrambled word
			char[] scrambledChars = new char[word.length()];
		
			//iterate over the word char-by-char in reverse order
			//and adding to the scrambledChars array in actual order!
			//BUT switching the beginning and the end of the word 
			for(int j = word.length()-1; j > -1 ; j--){
				
				int scrambleIndex;
				
				if(j == 0) scrambleIndex = 0;
				else if(j == word.length()-1) scrambleIndex = word.length()-1;
				else scrambleIndex = word.length()-1 - j; //e.g. 0 1 (2) 3 (4) 5 6 --> 2 = 6 - 4
				
				scrambledChars[scrambleIndex] = word.charAt(j);
			}
			
			//Add to scrambedWords array!
			scrambledWords[i] = String.valueOf(scrambledChars);
		}
		
		//Create a beautiful sentence from these scrambled words!
		StringBuffer scrambledSentence= new StringBuffer("");
		
		//Adding a space after each scrambled word to form a sentence!
		for (int i = 0; i < scrambledWords.length; i++) {
			scrambledSentence.append(scrambledWords[i] + " ");
		}
		
		//If the solution is not empty string, then the last space must be removed after the last word
		if (scrambledSentence.length() != 0) 
			scrambledSentence.deleteCharAt(scrambledSentence.length()-1);
		
		//return the solution
		return scrambledSentence.toString();
	}
	
	
}
