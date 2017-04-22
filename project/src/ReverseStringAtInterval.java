

public class ReverseStringAtInterval {

	public static void main(String[] args) {
		System.out.println(reverseStr("abcdefg", 2));
	}

    public static String reverseStr(String s, int k) {
        char[] trans = new char[s.length()];
        
        int cursor = 0;
        int start = 0;
        while(cursor < s.length()) {
            int end = cursor + k - 1;
            end = end >= s.length() ? s.length()-1 : end;
            for(int i = end; i >= start; i--) {
                trans[cursor++] = s.charAt(i);
            }
            start = end+1;
            if (start >= s.length()) {
                break;
            }
            end = cursor + k - 1;
            end = end >= s.length() ? s.length()-1 : end;
            for(int i = start; i <= end; i++) {
                trans[cursor++] = s.charAt(i);
            }
            start = end+1;
        }
        
        return new String(trans);
    }
}