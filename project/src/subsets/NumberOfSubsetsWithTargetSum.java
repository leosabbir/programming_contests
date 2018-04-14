/* File:    NumberOfSubsetsWithTargetSum.java
 * Created: 2018-04-13
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2018 manandharsabbirk.appspot.com
 */

package subsets;

import java.util.HashMap;
import java.util.Map;

/**
 * Computes Number of Sub-sets that have sums to targetSUm
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class NumberOfSubsetsWithTargetSum {

  /**
   * main method
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{
            2, 4, 6, 14, 2, 2, 2, 3, 3, 1, 1, 1, 4, 4, 5, 6, 7, 15, 16, 10, 2, 4, 6, 14,
            2, 2, 2, 3, 3, 1, 1, 1, 4, 4, 5, 6, 7, 15, 16, 10, 2, 4, 6, 14, 2, 2, 2, 3,
            3, 1, 1, 1, 4, 4, 5, 6, 7, 15, 16, 10, 2, 4, 6, 14, 2, 2, 2, 3, 3, 1, 1, 1,
            4, 4, 5, 6, 7, 15, 16, 10 };
    int targetSum = 16;

    // without DP
    long current = System.currentTimeMillis();
    System.out.println(compute(input, targetSum, 0));
    System.out.println("Recursive without DP took: " + (System.currentTimeMillis() - current) + " milliseconds");

    // with DP
    current = System.currentTimeMillis();
    System.out.println(computeDP(input, targetSum, new HashMap<String, Integer>(), 0));
    System.out.println("Recursive with DP took: " + (System.currentTimeMillis() - current) + " milliseconds");
  } // main

  //---------------------------------------------------------------------------------------------------

  /**
   * Recursively computes the number of sub sets
   * Does not use dynamic programming
   * @param input
   * @param targetSum
   * @param cursor
   * @return number of sub sets
   */
  public static int compute(int[] input, int targetSum, int cursor) {
    if (targetSum == 0) {
      return 1;
    }

    if (cursor == input.length) {
      return 0;
    }

    if (targetSum < 0) {
      return 0;
    }

    int toReturn;
    if (input[cursor] > targetSum) {
      toReturn = compute(input, targetSum, cursor + 1);
    } else {
      toReturn = compute(input, targetSum, cursor + 1) + compute(input, targetSum - input[cursor], cursor + 1);
    }
    
    return toReturn;
  } // compute

  //---------------------------------------------------------------------------------------------------

  /**
   * Recursively computes the number of sub sets
   * Uses Dynaimc Programming
   * @param input
   * @param targetSum
   * @param mem
   * @param cursor
   * @return number of sub sets
   */
  public static int computeDP(int[] input, int targetSum, Map<String, Integer> mem, int cursor) {
    String key = cursor + ":" + targetSum;
    if (mem.containsKey(key)) return mem.get(key);
    if (targetSum == 0) {
      return 1;
    }

    if (cursor == input.length) {
      return 0;
    }


    if (targetSum < 0) {
      return 0;
    }

    int toReturn;
    if (input[cursor] > targetSum) {
      toReturn = computeDP(input, targetSum, mem, cursor + 1);
    } else {
      toReturn = computeDP(input, targetSum, mem, cursor + 1) + computeDP(input, targetSum - input[cursor], mem, cursor + 1);
    }
    mem.put(key, toReturn);
    return toReturn;
  } // computeDP

} // NumberOfSubsetsWithTargetSum
