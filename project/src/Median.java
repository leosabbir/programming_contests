/* File:    Median.java
 * Created: 2017-02-09
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
public class Median {

  public static void main(String[] args) {
    //int[] x = {5, 3, 7, 9, 12, 23, 43, 45, 23, 12, 21, 3, 4, 5, 6};
    int[] x = {4, 3, 2, 1};
    int lo = 0;
    int hi = x.length-1;
    int pivot = partition(x, lo, hi);
    while (pivot != (x.length/2)) {
      //System.out.println(pivot + " : " + Arrays.toString(x));
      if (pivot < x.length/2) {
        lo = pivot+1;
      } else {
        hi = pivot-1;
      }
      pivot = partition(x, lo, hi);
    }
    //System.out.println(pivot + " : " + Arrays.toString(x));
    //System.out.println("Median: " + x[pivot]);
    if (x.length%2 == 1) {
      System.out.println(x[pivot]);
    } else {
      System.out.println((x[pivot]+x[pivot-1])/2.0);
    }
  }

  public static int partition(int[] nums, int low, int hi) {
    int pIndex = low;
    int pivot = nums[low];
    while (low < hi) {
      if ( nums[low + 1] <= pivot) {
        low++;
      } else if (nums[hi] >= pivot) {
        hi--;
      } else if (nums[low+1] > pivot && nums[hi] < pivot) {
        int temp = nums[low+1];
        nums[low+1] = nums[hi];
        nums[hi] = temp;

        low++;
        hi--;
      }
    }

    nums[pIndex] = nums[low];
    nums[low] = pivot;

    return low;
  }
} // Median
