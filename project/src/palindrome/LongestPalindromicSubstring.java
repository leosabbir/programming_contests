/*
* Computes longest palindromic substring
* 
* @author Sabbir Kumar Manandhar
*			manandhar.sabbir@gmail.com
*/
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String text = "abacabadefghi";
		System.out.println(compute(text));
	} // main

	//-------------------------------------------------------------------------------------------

	/**
	* Computes the longest palindromic substring in the given input text
	*
	* all single characters are palindromic in themselves
	* 
	* text[i,j] is palindromic if text[i] == text[j] and text[i+1, j-1] is palindromic
	*
	* @param text input text
	*/
	public static String compute(String text) {
		int n = text.length();
		boolean[][] table = new boolean[n][n];

		int start = 0;
		int maxLength = 1;

		// all single characters are palindromic
		for (int i = 0; i < n; i++) {
			table[i][i] = true;
		}

		// compute palindromic substring of length 2
		for (int i = 0; i < n - 1; i++) {
			if(text.charAt(i) == text.charAt(i+1)) {
				table[i][i+1] = true;
				maxLength = 2;
				start = i;
			}
		}


		for (int gap = 2; gap < n; gap++) {
			for (int l = 0, h = gap; h < n; l++, h++) {
				if (table[l+1][h-1] && text.charAt(l) == text.charAt(h)) {
					table[l][h] = true;
					if(maxLength < gap + 1) {
						maxLength = gap + 1;
						start = l;
					}
				}
			}
		}

		return text.substring(start, start + maxLength);
	} // compute
	
} // LongestPalindromicSubstring