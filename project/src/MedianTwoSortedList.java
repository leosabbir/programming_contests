/* File:    MedianTwoSortedList.java
 * Created: 2017-11-07
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

/**
 * Median of two sorted list of equal length
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class MedianTwoSortedList {

  public static void main(String[] args) {
    int[] list1 = {1, 12, 26, 27, 28, 38};
    int[] list2 = {2, 13, 17, 26, 30, 45};

    float result = compute(list1, list2, 0, list1.length - 1, 0, list2.length - 1);
    System.out.println(result);
  } // main

  //-----------------------------------------------------------------------------------

  /**
   * Compute the Median of given two sorted list
   * @param list1
   * @param list2
   * @param start1
   * @param end1
   * @param start2
   * @param end2
   * @return
   */
  public static float compute(int[] list1, int[] list2, int start1, int end1, int start2, int end2) {

    if(end1 - start1 == 1) {
      return (Math.max(list1[start1], list2[start2]) + Math.min(list1[end1], list2[end2]))/2;
    }

    float median1, median2;


    int mid1 = getMid(start1, end1);
    int mid2 = getMid(start2, end2);

    median1 = getMedian(list1, start1, end1);
    median2 = getMedian(list2, start2, end2);

    if (median1 == median2) {
      return median1;
    }

    if (median1 < median2) {
      start1 = mid1;
      end2 = mid2;
    } else {
      end1 = mid1;
      start2 = mid2;
    }

    return compute(list1, list2, start1, end1, start2, end2);
  } // compute

  //---------------------------------------------------------------------------------------

  /**
   * Get Median of sub array of give list
   * @param list
   * @param start
   * @param end
   * @return
   */
  public static float getMedian(int[] list, int start, int end) {
    int mid = (start + end) / 2;
    if ((end - start + 1) % 2 == 0) {
      return (list[mid] + list[mid+1])/2;
    }
    return list[mid];
  } // getMedian

  //----------------------------------------------------------------------------------------

  /**
   * Gets the mid value between two index given
   * @param start
   * @param end
   * @return
   */
  public static int getMid(int start, int end) {
    int mid = (start + end) / 2;
    if ((end - start + 1) % 2 == 0) {
      return mid + 1;
    }
    return mid;
  } // getMid

} // MedianTwoSortedList
