/**
* Computes the smallest window in which all characters in substring can be found
* reference: http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
*/
public class SmallestWindowContainingSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("a", "a")); // a
        System.out.println(minWindow("bba", "ab")); // ba
        System.out.println(minWindow("this is a test string", "tist")); // t stri
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("ADOBECODEBANC", "ABc")); // <empty>
    }

    /**
    * method to compute the smallest window
    * @param s main string in which window is to be found
    * @param t substring whose characters are to be found in the substring
    * @return min length window
    */
    public static String minWindow(String s, String t) {
        int[] PATTERN_STRING = new int[256];
        int[] MAIN_STRING = new int[256];
        
        int start = 0; // start of window
        int count = 0; // counter to count characters encountered that belongs to substring
        String minWin = "";
        
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            PATTERN_STRING[c]++;
        }
        
        for(int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            
            if (PATTERN_STRING[currentChar] > 0) { // character belongs to substring
                MAIN_STRING[currentChar]++;
                if(PATTERN_STRING[currentChar] >= MAIN_STRING[currentChar]) {
                    count++; // increment if new
                }
            } else {
                continue;
            }
            
            if (count == t.length()) { // window found
                while(true) { // minimize window by removing extraneous characters from front
                    char charAtStart = s.charAt(start);
                    if (PATTERN_STRING[charAtStart] == 0) { // character that does not belong to substring can be ignored
                        start++;
                    } else if (MAIN_STRING[charAtStart] > PATTERN_STRING[charAtStart]) { // characters that are extra in number
                        start++;
                        MAIN_STRING[charAtStart]--;
                    } else {
                        break;
                    }
                }
                if (minWin.length() == 0 || i - start + 1 < minWin.length()) {
                    minWin = s.substring(start, i+1);
                }
            }
        }
        return minWin;
    }
}