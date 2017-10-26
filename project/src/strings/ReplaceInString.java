package strings;

public class ReplaceInString {
	
	public static void main(String[] args) {
		String result = replace("xxxAByyyAB");
		System.out.println(result);
	} // main

	//----------------------------------------------------------------------------------------------------

	/**
	* Replace occurences of AB in given string with character C
	*/
	public static String replace(String text) {
		char[] textArray = text.toCharArray();

		int i = 0;
		int j = 0;

		while(j < text.length()-1) {
			if (textArray[j] == 'A' && textArray[j+1] == 'B') {
				textArray[i++] = 'C';
				j += 2;
				continue;
			}
			textArray[i++] = textArray[j++];
		}

		if (j == text.length() - 1) {
			textArray[i++] = textArray[j++];
		}

		if (i < text.length()) {
			textArray[i] = '\n';
		}
		return new String(textArray);
	} // replace
	
} // ReplaceInString