

public class SubstringsWithKDistinctCharacters {

	public static void main(String[] args) {
		String text = "abc";
		int k = 3;
		System.out.println(compute(text, k));
	} // main

	//----------------------------------------------------------------------------------------------------

	/**
	* Compute number of substrings with distinct character count
	*/
	public static int compute(String text, int k) {
		int counter = 0;
		for(int start = 0; start < text.length(); start++) {
			int[] counts = new int[256];
			counts[text.charAt(start)]++;
			int distinctCount = 1;
			if (distinctCount == k) counter++;
			for (int end = start+1; end < text.length(); end++) {
				char c = text.charAt(end);
				if (counts[c] == 0) {
					distinctCount++;
				}
				counts[c]++;
				if (distinctCount == k) {
					counter++;
				} else if (distinctCount > k) {
					break;
				} else {
					continue;
				}
			}
		}
		return counter;
	} // compute
	
} // SubstringsWithKDistinctCharacters