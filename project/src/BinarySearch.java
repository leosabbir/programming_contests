/* File:    BinarySearch.java
 * Created: 2017-10-25
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2018 WorldLingo Inc.
 */

import java.util.List;
import java.util.ArrayList;

/**
 * Implements Iterative Binary Search
 * Implements Lower Limit Search
 * Implement Lower Bound Search
 * Implements Upper Limit Search
 * Implements Upper Bound Search
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class BinarySearch {



  public static void main(String[] args) {
                         //0  1  2   3   4   5   6   7   8   9  10  11  12  13  14   15   16
    int[] list = new int[]{1, 2, 5, 12, 17, 23, 24, 26, 45, 55, 77, 89, 91, 93, 95, 100, 113};
    verify(5, search(list, 23));
    verify(5, search(list, 23));
    verify(8, search(list, 45));
    verify(10, search(list, 77));
    verify(-1, search(list, 78));
    verify(14, search(list, 95));
    verify(16, search(list, 113));
    verify(0, search(list, 1));
    verify(-1, search(list, 3));
    verify(0, search(new int[]{3}, 3));
    verify(-1, search(new int[]{}, 3));
    verify(-1, search(new int[]{3}, 4));

                   //0  1  2  3  4  5  6  7  8  9  10 11 12 13  14  15  16  17  18  19  20  21  22  23  24  25  26  27  28   29
    list = new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3, 3,  4, 5, 8, 9, 10, 11, 11, 11, 33, 33, 44, 75, 87, 87, 87, 90, 90, 90, 90, 100};
    // Lower Limit Search
    verify(18, searchLowerLimit(list, 23));
    verify(0, searchLowerLimit(list, 1));
    verify(25, searchLowerLimit(list, 90));
    verify(29, searchLowerLimit(list, 100));
    verify(-1, searchLowerLimit(list, 101));
    verify(-1, searchLowerLimit(new int[]{}, 101));
    verify(0, searchLowerLimit(new int[]{10}, 9));
    verify(-1, searchLowerLimit(new int[]{10}, 11));

    // Lower Bound
    verify(29, searchLowerBound(list, 90));
    verify(12, searchLowerBound(list, 5));
    verify(-1, searchLowerBound(list, 100));
    verify(18, searchLowerBound(list, 11));
    verify(18, searchLowerBound(list, 25));
    verify(4, searchLowerBound(list, 1));

    // Upper Limit Search
    verify(17, searchUpperLimit(list, 23));
    verify(3, searchUpperLimit(list, 1));
    verify(28, searchUpperLimit(list, 90));
    verify(29, searchUpperLimit(list, 100));
    verify(29, searchUpperLimit(list, 101));
    verify(-1, searchUpperLimit(new int[]{}, 101));
    verify(-1, searchUpperLimit(new int[]{10}, 9));
    verify(0, searchUpperLimit(new int[]{10}, 11));

    // Upper Bound Search
    verify(17, searchUpperBound(list, 23));
    verify(-1, searchUpperBound(list, 1));
    verify(24, searchUpperBound(list, 90));
    verify(28, searchUpperBound(list, 100));
    verify(29, searchUpperBound(list, 101));
    verify(-1, searchUpperBound(new int[]{}, 101));
    verify(-1, searchUpperBound(new int[]{10}, 9));
    verify(0, searchUpperBound(new int[]{10}, 11));

  } // main

  //----------------------------------------------------------------------------------

  /**
   * Verify expected and actual values
   * @param expected
   * @param actual
   */
  private static void verify(int expected, int actual) {
    if (expected == actual) {
      //System.out.println("Success");
    } else {
      System.out.println("*** Failed");
    }
  } // verify

  //----------------------------------------------------------------------------------

  /**
   * Searches searchItem in the array using iterative binary search
   * @param a
   * @param searchItem
   * @return
   */
  public static int search(int[] a, int searchItem) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if(a[mid] == searchItem) return mid;
      else if(a[mid] > searchItem) hi = mid - 1;
      else lo = mid + 1;
    }

    return -1;
  } // search

  //------------------------------------------------------------------------------------

  /**
   * Lower limit is the number greater than or equal to searchItem with minimum index in the array
   * @param a
   * @param searchItem
   * @return
   */
  public static int searchLowerLimit(int[] a, int searchItem) {
  int lo = 0;
  int hi = a.length-1;

    if (hi == -1 || a[hi] < searchItem) { // no greater item, all items in the array are smaller than searchItem
    return -1;
  }

    while (lo <= hi) {
    int mid = (lo + hi)/2;

    if(a[mid] >= searchItem) {
      hi = mid - 1;
    } else {
      lo = mid + 1;
    }
  }

    return hi + 1;
} // searchLowerLimit

  //------------------------------------------------------------------------------------

  /**
   * Lower Bound is the number strictly greater than searchItem with minimum index in the array
   *
   * Only two changes required from above method
   * 1. if (hi == -1 || a[hi] < searchItem) ==> if (hi == -1 || a[hi] <= searchItem)
   * 2. if(a[mid] >= searchItem) ==> if(a[mid] > searchItem) {
   * @param a
   * @param searchItem
   * @return
   */
  public static int searchLowerBound(int[] a, int searchItem) {
    int lo = 0;
    int hi = a.length-1;

    if (hi == -1 || a[hi] <= searchItem) { // no greater item, all items in the array are smaller than searchItem
      return -1;
    }

    while (lo <= hi) {
      int mid = (lo + hi)/2;

      if(a[mid] > searchItem) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return hi + 1;
  } // searchLowerLimit

  //------------------------------------------------------------------------------------

  /**
   * Upper limit is the number smaller than or equal to searchItem with maximum index in the array
   * @param a
   * @param searchItem
   * @return
   */
  public static int searchUpperLimit(int[] a, int searchItem) {
    int lo = 0;
    int hi = a.length - 1;

    if (hi == -1 || a[0] > searchItem) { // no smaller item, all items in the array are greater than searchItem
      return -1;
    }

    while (lo <= hi) {
      int mid = (lo + hi)/2;

      if(a[mid] > searchItem) hi = mid - 1;
      else lo = mid + 1;
    }

    return lo - 1;
  } // searchUpperLimit

  //------------------------------------------------------------------------------------

  /**
   * Upper limit is the number strictly smaller than searchItem with maximum index in the array
   *
   * Only two changes required in above method
   * 1. if (hi == -1 || a[0] > searchItem) ==> if (hi == -1 || a[0] >= searchItem)
   * 2. if(a[mid] > searchItem) ==> if(a[mid] >= searchItem)
   * @param a
   * @param searchItem
   * @return
   */
  public static int searchUpperBound(int[] a, int searchItem) {
    int lo = 0;
    int hi = a.length - 1;

    if (hi == -1 || a[0] >= searchItem) { // no smaller item, all items in the array are greater than searchItem
      return -1;
    }

    while (lo <= hi) {
      int mid = (lo + hi)/2;

      if(a[mid] >= searchItem) hi = mid - 1;
      else lo = mid + 1;
    }

    return lo - 1;
  } // searchUpperBound

  //------------------------------------------------------------------------------------

  /**
  * Finds all the numbers in a sorted array in the given range
  * @param list input sorted array
  * @param @lowerLimit lower limit of the range
  * @param @upperLimit upper limit of the range
  * @return list of numbers in the range
  */
  public static List findElementsInRange(int[] list, int lowerLimit, int upperLimit) {
    List result = new ArrayList();

    int start = searchLowerLimit(list, lowerLimit);
    if (start == -1) {
        return result;
    }

    int end = searchUpperLimit(list, upperLimit);
    if(end == -1) {
        return result;
    }

    while(start <= end) {
        result.add(list[start++]);
    }

    return result;
  } // findElementesInRange

  //------------------------------------------------------------------------------------

} // BinarySearch
