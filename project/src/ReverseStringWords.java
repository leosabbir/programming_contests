

public class ReverseStringWords {

	public static void main(String[] args) {
		System.out.println(reverse("  I    am  Lord    Voldemort.   I have come finish the noble work of the great Salazaar Slytherine. "));
	}


	public static String reverse(String original) {
		char[] transformed = new char[original.length()];

		int start = 0, end;
		int cursor = 0;
		for (int i = 0; i <= original.length() ; i++) {
			if (i == original.length()) {
				for (int j = i-1; j >= start ; j--) {
					transformed[cursor++] = original.charAt(j);
				}

			} else if (original.charAt(i) == ' ') {
				for (int j = i-1; j >= start ; j--) {
					transformed[cursor++] = original.charAt(j);
				}
				transformed[cursor++] = ' ';
				start = i+1;
			}
		}

		return new String(transformed);

	}
	
}