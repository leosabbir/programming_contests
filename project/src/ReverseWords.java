/* File:    ReverseWords.java
 * Created: 2017-08-02
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */


/**
 * Reverses the words in the given string
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class ReverseWords {

	public static void main(String[] args) {
		String input = "   world this hate I   ";
		System.out.println(reverseWords(input.toCharArray()));
	}

	//------------------------------------------------------------------------

	/**
	* Reverses all the words in the given string
	* @param in character array representing the string
	* @return String with words reversed.
	*/
	public static String reverseWords(char[] in) {
		reverseString(in, 0, in.length-1);

		int start = 0;
		int end = start;
		while(start <= in.length-1) {
			while(end < in.length && in[end] != ' ') {
				end++;
			}
			//if (end < in.length) {
				reverseString(in, start, end-1);
			//}
			start = end + 1;
			end = start;
		}
		return new String(in);
	} // reverseWords

	//------------------------------------------------------------------------

	/**
	* Reverses sub array of the give array starting from the start index 
	* to index hi
	* @param start start index of sub array to reverse
	* @param hi end index of sub array to reverse
	*/
	public static void reverseString(char[] in, int start, int hi) {
		while (start < hi) {
			char temp = in[start];
			in[start] = in[hi];
			in[hi] = temp;
			start++;
			hi--;
		}
	} // reverseString
	
}