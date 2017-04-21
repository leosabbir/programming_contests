/* File:    SelectKthMinium.java
 * Created: 2017-03-20
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
public class SelectKthMinimum {

  public static void main(String[] args) {
    for (int i = 1; i <= 13; i++) {
//    for (int i = 7; i <= 7; i++) {
      int[] nums = new int[]{2, 9, 6, 5, 7, 2, 12, 47, 56, 1, 2, 2, 4};
//    System.out.println("Partition: " + partition(nums, 1, nums.length-1));
      //quickSort(nums, 0, nums.length-1);

      int index = select(nums, 0, nums.length - 1, i);
      //System.out.println(Arrays.toString(nums));
      System.out.println(nums[index]);
    }
  }

  public static void quickSort(int[] nums, int left, int right) {
    if (left >= right) return;

    int pivot = partition(nums, left, right);
    quickSort(nums, left, pivot-1);
    quickSort(nums, pivot+1, right);
  }


  public static int select(int[] nums, int left, int right, int kthSmallest) {
    if (left == right) {
      return left;
    }
    int itemIndex = left + kthSmallest - 1;
    int pivot = partition(nums, left, right);

    if (itemIndex == pivot) {
      return pivot;
    } else if (pivot > itemIndex) {
      return select(nums, left, pivot-1, kthSmallest);
    } else {
      return select(nums, pivot + 1, right, itemIndex - pivot);
    }
  }

  public static int partition(int[] a, int lo, int hi) {
    int pivot = a[lo];
    int i = lo;
    int j = hi+1;

    while (lo < hi) {
      while (a[++i] < pivot) {
        if (i == hi) {
          break;
        }
      }

      while (a[--j] > pivot) {
        if ( j == lo) {
          break;
        }
      }

      if ( j <= i) {
        break;
      }

      swap(a, i, j);
    }

    swap(a, lo, j);
    return j;

  }

  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

} // SelctionAlg
