/**
* Computes the length of the longest palindromic subsequece of input text
*
* @Author Sabbir Manandhar
*		manandhar.sabbir@gmail.com
*/
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String text = "abcdefghijkl";
		System.out.println(compute(text));

		text = "abcdefghijkla";
		System.out.println(compute(text));
	}

	//-----------------------------------------------------------------------------------------------

	/**
	* Computes the length of the longest palindromic subsequence of input text
	* Uses dynamic programming, Bottom-Up 
	* 
	* table[i,i] = 1  => because single characters are palindrome in themselves
	* 
	* if text[l] == text[h]  ==> end characters are equal and are part of palindromic string
	* 	table[l,h] = 2 + table[l+1, h-1]
	* else 
	* 	table[l,h] = max |	table[l+1, h]
	*					 |	table[l, h-1]
	*
	* @param text input text
	*/
	public static int compute(String text) {
		int n = text.length();
		int[][] table = new int[n][n];


		// single characters are palindromic
		for (int i = 0; i < n; i++ ) {
			table[i][i] = 1;
		}

		for (int gap = 1; gap < n; gap++) {
			for (int l = 0, h = gap; l < n && h < n; l++, h++) {
				if (text.charAt(l) == text.charAt(h)) {
					table[l][h] = 2 + table[l+1][h-1];
				} else {
					table[l][h] = Math.max(table[l+1][h], table[l][h-1]);
				}
				
			}
		}

		return table[0][n-1];
	} // compute
	
}