/**
* Computes minimum number of insertions required to convert the given text into
* palindromic text
*
* @Author Sabbir Manandhar
*		manandhar.sabbir@gmail.com
*/
public class MinimumInsertions {

	public static void main(String[] args) {
		String text = "abcde";
		System.out.println(text + " : " + compute(text) + " DP: " + computeDP(text));

		text = "abcba";
		System.out.println(text + " : " + compute(text) + " DP: " + computeDP(text));

		text = "abcdefghixhgfedcbaz";
		System.out.println(text + " : " + compute(text) + " DP: " + computeDP(text));

		text = "abefwtdgwkrtkwdefrba";
		System.out.println(text + " : " + compute(text) + " DP: " + computeDP(text));
	} // main

	//---------------------------------------------------------------------------------------------	

	/**
	* Using Recursion
	*/
	public static int compute(String text) {
		int l = 0;
		int h = text.length() - 1;

		if (h < 1) {
			return 0;
		}

		if (text.charAt(l) == text.charAt(h)) {
			return compute(text.substring(l+1, h));
		} else {
			return 1 + Math.min(compute(text.substring(l, h)), compute(text.substring(l+1, h+1)));
		}

	}

	//------------------------------------------------------------------------------------------------

	/**
	* Using Dynamic Programming
	* 
	* Construct a table to size n X n
	* Any cell [i,j] represents number of changes required to make the string text[i,j] palindrome
	* 
	* cell[i][j] = min |  cell[i-1][j-1]
	*                  |  min cell[i][j-1], cell[i-1][j] 
	* 
	* final answer is for text[0, n]. So cell[0][n-1] is the answer
	*/
	public static int computeDP(String text) {
		int n = text.length();
		int[][] dp = new int[n][n];

		int gap = 1;
		for(; gap < n; gap++) {
			for(int l = 0, h = gap; l < n && h < n; l++, h++) {
				if (text.charAt(l) == text.charAt(h)) {
					dp[l][h] = dp[l+1][h-1];
				} else {
					dp[l][h] = Math.min(dp[l+1][h], dp[l][h-1]) + 1;
				}
			}
		}

		return dp[0][n-1];
	} // computeDP


} // MinimumInsertions