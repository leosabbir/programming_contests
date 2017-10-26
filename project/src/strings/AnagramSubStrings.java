package strings;

public class AnagramSubStrings {
	
	public static void main(String[] args) {
		String text = "bacdgabcda";
		String patt = "abcd";
		compute(text, patt);
	} // main

	//---------------------------------------------------------------------------------------------

	/**
	* Computes and prints the location of Anagram Substring
	* @param text string in which substrings are to be searched
	* @param patt substring whose permutations are to be searched
	*/
	public static void compute(String text, String patt) {
		int LENGTH = patt.length();

		int[] hashPattern = new int[26];
		int[] hashText = new int[26];

		for (int i = 0; i < LENGTH; i++ ) {
			hashPattern[patt.charAt(i) - 'a']++;
		}

		int currentWindowStart = 0;
		for (int i = 0; i < text.length(); i++ ) {
			int currentHashIndex = text.charAt(i) - 'a';
			// current window length is greater than LENGTH
			if (i - currentWindowStart + 1 > LENGTH) {
				hashText[text.charAt(currentWindowStart) - 'a']--;
				currentWindowStart++;
			} 
			// current character still belongs to the permutaion
			else if (hashPattern[currentHashIndex] > hashText[currentHashIndex]) {
				hashText[currentHashIndex]++;
				// window length matches the permuation
				// match found
				if (i - currentWindowStart + 1 == LENGTH) {
					//System.out.println(text.substring(currentWindowStart, currentWindowStart + LENGTH));
					System.out.println(currentWindowStart);
					hashText[text.charAt(currentWindowStart) - 'a']--;
					currentWindowStart++;
				}
			// current character does not belong to permuation	
			} else {
				hashText[currentHashIndex]++;
				while(hashPattern[currentHashIndex] < hashText[currentHashIndex]) {
					hashText[text.charAt(currentWindowStart) - 'a']--;
					currentWindowStart++;
				}
			}
		}
	} // compute

	//---------------------------------------------------------------------------------------
} // AnagramSubStrings