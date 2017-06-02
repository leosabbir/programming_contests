
/**
* Class that sorts an array using Quick Sort algorithm
*
* @author Sabbir Manandhar <manandhar.sabbir@gmail.com>
*/
public class QuickSort {

/**
 * driver method
 */
  public static void main(String[] args) {
    int[] a = {34, 2, 25, 1, 0, 45, 123, 23, 45, 66, 77};
    sort(a, 0, a.length-1);
    for (int x : a) {
      System.out.print(x + " ");
    }
  } // main
  
  // ---------------------------------------------------------

  /**
  * Recursive method that uses partition method to partition input
  * array
  * @param a input array to sort
  * @param lo index from where sorting will be initiated
  * @param hi index upto where sorting will be done
  */
  public static void sort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int pivotIndex = partition(a, lo, hi);
    sort(a, lo, pivotIndex - 1);
    sort(a, pivotIndex + 1, hi);
  } // sort

  // ------------------------------------------------------------

  /**
  * method to partition the input array from index lo to hi
  * @param a input array to partition
  * @param lo index from where partition will be started
  * @param hi index upto where partition will be done
  */
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

  } // partition

  // -------------------------------------------------

  /**
  * helper method to swap two indices of an array
  * @param a input array
  * @param i firt index to swap
  * @param j second index to swap
  */
  public static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  } // swap

} // QuickSort
