

public class TelephoneWords {

	char[][] alphabets = {
							{'0'},
							{'1'},
							{'A', 'B', 'C'},
							{'D', 'E', 'F'},
							{'G', 'H', 'I'},
							{'J', 'K', 'L'},
							{'M', 'N', 'O'},
							{'P', 'R', 'S'},
							{'T', 'U', 'V'},
							{'W', 'X', 'Y'}
						};

	public char getChar(int keyPadNum, int pos) {
		return alphabets[keyPadNum][pos-1];
	}

	public void compute(char[] number, int cursor, StringBuilder sb) {
		if (cursor == number.length) {
			System.out.println(sb.toString());
			return;
		}

		for (char c : alphabets[Integer.parseInt(number[cursor]+"")]) {
			sb.append(c);
			compute(number, cursor+1, sb);
			sb.setLength(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		TelephoneWords words = new TelephoneWords();
		words.compute("401".toCharArray(), 0, new StringBuilder());
	}
}