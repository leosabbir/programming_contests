/* File:    LargestSumSubarray.java
 * Created: 2017-11-08
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

/**
 * Compute the maximum sum sub array from the given array of integers
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class LargestSumSubarray {

  public static void main(String[] args) {
    int[] nums = {2, -3, 5, 4, -5, 6, 0, -1, 100, 1, 0, -4, 1};
    System.out.println(compute(nums));
    System.out.println(computeKadane(nums));
    System.out.println(compute2(nums));

    nums = new int[]{-5, -6, -3};
    System.out.println(compute(nums));
    System.out.println(computeKadane(nums));
    System.out.println(compute2(nums));
  }


  // O(n) solution
  // Dynamic Programming
  public static int compute(int[] nums) {
    int n = nums.length;
    int[] maxSoFar = new int[n];
    int[] currentMaxEndingHere = new int[n];
    int start = 0, end = 0;

    maxSoFar[0] = nums[0];
    currentMaxEndingHere[0] = nums[0];

    for (int i = 1; i < n; i++) {
      int currentStart, currentEnd;
      if (nums[i] > currentMaxEndingHere[i - 1] + nums[i]) {
        currentStart = i;
        currentEnd = i;
        currentMaxEndingHere[i] = nums[i];
      } else {
        currentStart = start;
        currentEnd = i;
        currentMaxEndingHere[i] = currentMaxEndingHere[i - 1] + nums[i];
      }

      if (currentMaxEndingHere[i] > maxSoFar[i - 1]) {
        start = currentStart;
        end = currentEnd;
        maxSoFar[i] = currentMaxEndingHere[i];
      } else {
        maxSoFar[i] = maxSoFar[i - 1];
      }
    }

    System.out.println("[" + start + ", " + end + "]");
    return maxSoFar[n - 1];
  } // compute

  //----------------------------------------------------------------------------------------

  /**
   * Kadane's Algorithm
   * def kadane(nums) :
   *   max_current = max_global = nums[0]
   *   for i from 1, len(nums) - 1:
   *     max_current = max(nums[i], max_current + nums[i])
   *     max_global = max(max_global, max_current)
   * <p>
   *   return max_global
   * <p>
   * This method is similar to the above DP approach. Only it does not use arrays.
   */
  public static int computeKadane(int[] nums) {
    int maxSoFar = Integer.MIN_VALUE;
    int maxEndingHere = nums[0];
    int start = 0, end = 0;

    int currentStart = 0;
    int currentEnd = 0;
    for (int i = 1; i < nums.length; i++) {
      if (maxEndingHere + nums[i] > nums[i]) {
        maxEndingHere += nums[i];
        currentEnd = i; // current item increases the sum, so increase end index
      } else {
        maxEndingHere = nums[i];
        // new sub array with max sum. So changes indeces of start and end
        currentStart = i;
        currentEnd = i;
      }

      if (maxEndingHere > maxSoFar) {
        maxSoFar = maxEndingHere;
        // global max sum has changed. Change pointer to start and end of sub array
        start = currentStart;
        end = currentEnd;
      }
    }
    System.out.println("[" + start + ", " + end + "]");
    return maxSoFar;
  } // computeKadane

  //---------------------------------------------------------------------------------------------

  // O(n^2) solution
  public static int compute2(int[] nums) {
    int max = Integer.MIN_VALUE;
    int start = 0;
    int end = 0;
    for (int i = 0; i < nums.length; i++) {
      int sum = 0;
      for (int j = i; j < nums.length; j++) {
        sum += nums[j];
        if (sum > max) {
          max = sum;
          start = i;
          end = j;
        }
      }
    }

    System.out.println("[" + start + ", " + end + "]");
    return max;
  } // compute2
} // LargestSumSubarray