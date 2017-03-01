/* File:    ProductOfAllExceptSelf.java
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
public class ProductOfAllExceptSelf {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5,6};
    System.out.println(Arrays.toString(compute(nums)));
    System.out.println(Arrays.toString(compute_1(nums)));
  }

  public static int[] compute_1(int[] input) {
    int[] left = new int[input.length];
    int[] right = new int[input.length];
    int[] result = new int[input.length];

    left[0] = 1;
    for (int i = 1; i < input.length; i++) {
      left[i] = left[i-1] * input[i-1];
    }

    right[input.length - 1] = 1;
    for (int i = input.length-2; i >= 0; i--) {
      right[i] = input[i+1] * right[i+1];
    }

    for (int i = 0; i < input.length; i++) {
      result[i] = left[i] * right[i];
    }


    return result;
  }

  public static int[] compute(int[] input) {
    int[] result = new int[input.length];

    result[0] = 1;
    for (int i = 1; i <= input.length - 1; i++) {
      result[i] = result[i-1] * input[i-1];
    }
    //System.out.println(Arrays.toString(result));
    int right = 1;
    for (int i = input.length-2; i >= 0; i--) {
      right = right * input[i+1];
      result[i] = right * result[i];
    }

    return result;
  }
} // ProductOfAllExceptSelf
