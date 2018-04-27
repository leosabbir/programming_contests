/* File:    StringReplace.java
 * Created: 2018-04-27
 * Author:  xx Manandhar
 *
 * Copyright (c) 2018 WorldLingo Inc.
 */
package strings;

/**
 * Replace all the occurrences of 'AB' in the given string with 'C'
 *
 * @author xx Manandhar
 * @version 1.0
 */
public class ReplaceInString {

  public static void main(String[] args) {
    System.out.println(replace("ABxxAByy"));
    System.out.println(replace_2("ABxxAByy"));
    System.out.println(replace("xxAByy"));
    System.out.println(replace_2("xxAByy"));
    System.out.println(replace("xxAByyAB"));
    System.out.println(replace_2("xxAByyAB"));
    System.out.println(replace("xxyy"));
    System.out.println(replace_2("xxyy"));
    System.out.println(replace("ABxxAByyAB"));
    System.out.println(replace_2("ABxxAByyAB"));
  } // main

  //----------------------------------------------------------------------------------------------------

  /**
   * Replace occurrences of AB in given string with character C
   */
  public static String replace(String text) {
    char[] textArray = text.toCharArray();

    int i = 0;
    int j = 0;

    while (j < text.length() - 1) {
      if (textArray[j] == 'A' && textArray[j + 1] == 'B') {
        textArray[i++] = 'C';
        j += 2;
        continue;
      }
      textArray[i++] = textArray[j++];
    }

    if (j == text.length() - 1) {
      textArray[i++] = textArray[j++];
    }

    while (i < text.length()) {
      textArray[i++] = '\0';
    }
    return new String(textArray);
  } // replace

  //-----------------------------------------------------------------------------

  /**
   * Simpler and less complex method than above
   * @param text
   * @return replace text
   */
  public static String replace_2(String text) {
    char[] in = text.toCharArray();
    int i = 0, j = 0;

    while (j < in.length) {
      if (in[j] == 'A' && j < in.length - 1 && in[j + 1] == 'B') {
        in[i++] = 'C';
        j += 2;
      } else {
        in[i++] = in[j++];
      }
    }

    while (i < in.length) {
      in[i++] = '\0';
    }

    return new String(in);
  } // replace_2

} // ReplaceInString
