/* File:    WordBreak.java
 * Created: 2017-05-18
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class WordBreak2 {

  static Set<String> dict = new HashSet<String>();

  static List<String> results = new ArrayList<String>();

  static {
    dict.add("i");
    dict.add("like");
    dict.add("sam");
    dict.add("sung");
    dict.add("samsung");
    dict.add("mobile");
    dict.add("ice");
    dict.add("cream");
    dict.add("icecream");
    dict.add("man");
    dict.add("go");
    dict.add("mango");
    dict.add("and");
  }

  public static String listToSentence(List<String> words) {
    StringBuilder sb = new StringBuilder();
    for (String word : words) {
      sb.append(word + " ");
    }
    return sb.toString();
  }

  // http://www.geeksforgeeks.org/word-break-problem-using-backtracking/
  public static void wordBreak(String input, int cursor, List<String> sent) {
    if (cursor == input.length()) {
      results.add(listToSentence(sent));
      return;
    }

    StringBuilder currentWord = new StringBuilder();
    while (cursor < input.length()) {
      currentWord.append(input.charAt(cursor++));
      if (dict.contains(currentWord.toString())) {
        sent.add(currentWord.toString());
        wordBreak(input, cursor, sent); // check if remaining words can be broken into valid words
        sent.remove(sent.size()-1);
      }
    }
  }

  public static void main(String[] args) {
    String input = "ilikeicecreamandmango";
    input = "ilikesamsungmobile";
    wordBreak(input, 0, new ArrayList<String>());
    for (String sent : results) {
      System.out.println(sent);
    }
  }

} // WordBreak2
