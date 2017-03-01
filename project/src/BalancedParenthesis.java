/* File:    BalancedParenthesis.java
 * Created: 2017-01-10
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.Arrays;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class BalancedParenthesis {

  public static void main(String[] args) {
    print(4);
  }

  public static void print(int n) {
    print(n, n, new char[n*2], 0);
  }

  public static void print(int l, int r, char[] str, int index) {
    if (l < 0 || r < 0) {
      return;
    }

    if (l == 0 && r == 0) {
      System.out.println(new String(str));
    } else {
      if (l > 0) {
        str[index] = '(';
        print(l-1, r, str, index+1);
      }

      if (r > l) {
        str[index] = ')';
        print(l, r-1, str, index+1);
      }
    }


  }
} // BalancedParenthesis
