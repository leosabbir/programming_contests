
public class StringPermutation {

	public static void main(String[] args) {
		permute("thee".toCharArray(), new StringBuffer(), 0);
	}


	// http://www.geeksforgeeks.org/print-all-permutations-of-a-string-with-duplicates-allowed-in-input-string/

	public static void permute(char[] in, StringBuffer out, int cursor) {
		if (cursor == in.length) {
			System.out.println("Permutation Foudn: " + out.toString());
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
	
}