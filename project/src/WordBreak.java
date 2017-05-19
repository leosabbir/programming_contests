/* File:    WordBreak.java
 * Created: 2017-01-12
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * http://www.geeksforgeeks.org/word-break-problem-using-backtracking/
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class WordBreak {

  public static String[] dictionary = {"mobile", "samsung", "sam", "sung", "man", "mango", "icecream", "and", "go",
                                      "i", "like", "ice", "cream"};

  public static boolean contains(String word) {
    return Arrays.asList(dictionary).contains(word);
  }

  // http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
  public static boolean canBeBroken(String input) {
    if (input.length() == 0) return true;
    for (int i = 1; i <= input.length(); i++) {
      String prefix = input.substring(0, i);
      if (contains(prefix) && canBeBroken(input.substring(i))) {
        return true;
      }
    }
    return false;
  }

  // http://www.geeksforgeeks.org/word-break-problem-using-backtracking/
  public static void getSentences(String input, StringBuilder sb) {
    if (input.length() == 0) {
      System.out.println(sb.toString());
      return;
    }

    for (int i = 1; i <= input.length(); i++) {
      String prefix = input.substring(0, i);
      if (contains(prefix)) {
        getSentences(input.substring(i), sb.append(prefix).append(' '));
        sb.deleteCharAt(sb.length()-1);
        sb.delete(sb.length() - prefix.length(), sb.length());
      }
    }
  }

  public static void main(String[] args) {
    System.out.println(canBeBroken("ilikesamsungice"));

    getSentences("ilikesamsung", new StringBuilder());
    System.out.println();
    getSentences("ilikeicecreamandmango", new StringBuilder());
  }
} // WordBreak
