

public class PatternSearch {

	public static void main(String[] args) {
		String text = "jklmabcdefghijklabcdefghijklm";
		String pattern = "jklm";

		int[] z = computeZ(pattern + "$" + text);
		for (int i = 0; i < z.length ; i++) {
			if (z[i] == pattern.length()) {
				System.out.println(i - pattern.length() - 1);
			}
		}
	}


	// O(n) time
	public static int[] computeZ(String input) {
		int[] z = new int[input.length()];
		int n = input.length();
		z[0] = 0;

		int index = 1;
		int left = 0, right = 0;

		for (int i = 1; i < n; i++) {
			if (i > right) {
				// no Z-box so far
				left = right = i;
				while(right < n && input.charAt(right - left) == input.charAt(right)) {
					right++;
				}
				z[i] = right - left;
				right--;
			} else {
				// we are inside the z-box
				int k = i - left;
				int zk = z[k];

				if (i + zk < right) {
					// z value does not reach the end of the Z-box
					z[i] = zk;
				} else {
					// Z Value toches the end of the Z-box
					left = i;
					while (right < n && input.charAt(right - left) == input.charAt(right)) {
						right++;
					}
					z[i] = right - left;
					right--;
				}
			}
		}

		return z;
	}
}