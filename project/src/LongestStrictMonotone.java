/* File:    MedianTwoSortedList.java
 * Created: 2017-11-07
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

/**
 * Compute Length of longest increasing monotone sub sequence
 * in the given array
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class LongestStrictMonotone {

  public static void main(String[] args) {
    int[] a = {5, 2, 9, 0, 8, 4, 3, 1, 7, 6};
    find(a);
    find2(a);
  } // main

  //-----------------------------------------------------------------------------

  /**
   * Solution using Dynamic Programming
   * O(n^2) solution
   *
   * for i from 0 to n-1 :
   *    lengths[i] = 1
   *    for j from 0 to i - 1 :
   *      if a[j] < a[i] and lengths[j] >= lengths[i]
   *        lengths[i] = lengths[j] + 1
   * return lengths[n-1]
   *
   * @param a input array
   */
  public static void find(int[] a) {
    int[] lengths = new int[a.length];
    int[] backPointer = new int[a.length];

    for (int i = 0; i < a.length; i++) {
      lengths[i] = 1;
      backPointer[i] = -1;
      for (int j = 0; j < i; j++) {
        if (a[j] < a[i]) {
          if (lengths[j] >= lengths[i]) {
            lengths[i] = lengths[j] + 1;
            backPointer[i] = j;
          }
        }
      }
    }

    int maxIndex = 0;
    for (int i = 1; i < a.length; i++) {
      if (lengths[i] >= lengths[maxIndex]) {
        maxIndex = i;
      }
    }
    System.out.println("Length: " + lengths[maxIndex]);
    System.out.print("Sequence: ");
    int index = maxIndex;
    do {
      System.out.print(a[index] + " ");
      index = backPointer[index];
    } while (index > -1);

    System.out.println();
  } // find

  //-------------------------------------------------------------------------------

  /**
   * Improvises above solution to get O(n logn) solution
   * @param a
   */
  public static int find2(int[] a) {
    int[] lengths = new int[a.length];
    int n = 0;

    lengths[n++] = a[0];

    for (int i = 1; i < a.length; i++) {
      if (a[i] < lengths[0]) { // new smallest item
        lengths[0] = a[i];
      } else if (a[i] > lengths[n-1]) { // largest item will go to the end
        lengths[n++] = a[i];
      } else { // find index where the current element should go
        lengths[getCeiling(lengths, 0, n-1, a[i])] = a[i];
      }
    }
    return n;
  } // find2

  //----------------------------------------------------------------------------------

  /**
   * helper method that finds the index of an element which is just greater
   * than query item in the input array
   * @param a input array
   * @param lo
   * @param hi
   * @param item query iterm
   * @return
   */
  public static int getCeiling(int[] a, int lo, int hi, int item) {
    if (lo == hi) {
      return lo;
    }
    int mid = (lo+hi)/2;

    if(a[mid] < item) {
      return getCeiling(a, mid+1, hi, item);
    } else {
      return getCeiling(a, lo, mid, item);
    }
  } // getCeiling

} // LongestStrictMonotone
