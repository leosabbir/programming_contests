/* File:    MoveZeroes.java
 * Created: 2017-02-03
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.Arrays;

/**
 * http://blog.gainlo.co/index.php/2016/11/18/uber-interview-question-move-zeroes/
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class MoveZeroes {

  public static void main(String[] args) {
    int[] nums = {0, 0, 2, 45, 0, 6, 3, 5, 2, 0, 0, 23, 0, 67};
    move(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void move(int[] nums) {
    int start = 0;
    int end = nums.length-1;

    while (start < end) {
      while (nums[start] != 0) {
        start++;
      }

      while (nums[end] == 0) {
        end--;
      }

      if (start < end) {
        nums[start] = nums[end];
        nums[end] = 0;
      } else {
        return;
      }

    }
  }
} // MoveZeroes
