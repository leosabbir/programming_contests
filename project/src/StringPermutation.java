import java.util.Arrays;

public class StringPermutation {

	public static void main(String[] args) {
		permute("AA".toCharArray(), new StringBuffer(), 0);
		System.out.println();
		permute2("the".toCharArray());
	}


	// http://www.geeksforgeeks.org/print-all-permutations-of-a-string-with-duplicates-allowed-in-input-string/

	public static void permute(char[] in, StringBuffer out, int cursor) {
		if (cursor == in.length) {
			System.out.println("Permutation Found: " + out.toString());
			return;
		}

		for (int i = cursor; i < in.length; i++) {
			out.append(in[i]);
			
			char temp = in[cursor];
			in[cursor] = in[i];
			in[i] = temp;
			
			permute(in, out, cursor+1);
			
			in[i] = in[cursor];
			in[cursor] = temp;

			out.deleteCharAt(out.length()-1);	
		}
		//System.out.println(out.toString());
		//out.deleteCharAt(out.length() - 1);
	}

	public static void permute2(char[] in) {
		permute2(in, new StringBuilder(), new boolean[in.length]);
	}

	public static void permute2(char[] in, StringBuilder out, boolean[] used) {
		if (out.length() == in.length) {
			System.out.println(out.toString());
		}

		for (int i = 0; i < in.length ; i++) {
			if (used[i]) {
				continue;
			}

			out.append(in[i]);
			used[i] = true;
			permute2(in, out, used);
			used[i] = false;
			out.setLength(out.length() - 1);
		}
 	}
	
}