/* File:    ArrayZigZag.java
 * Created: 2017-01-13
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
public class ArrayZigZag {

  public static void main(String[] args) {
    int[] input = {1, 2, 3, 4, 5, 1, 10, 9, 20, 15, 13};
    process(input);
    System.out.println(Arrays.toString(input));
  }

  public static void process(int[] input) {
    boolean flag = true;
    for (int i = 0; i < input.length-2; i++) {
      if (flag) {
        if (input[i] > input[i+1]) {
          swap(input, i);
        }
      } else {
        if (input[i] < input[i+1]) {
          swap(input, i);
        }
      }
      flag = !flag;
    }
  }

  public static void swap(int[] input, int i) {
    int temp = input[i];
    input[i] = input[i+1];
    input[i+1] = temp;
  }
} // ArrayZigZag
