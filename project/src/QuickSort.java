

public class QuickSort {

  public static void main(String[] args) {
    int[] a = {34, 2, 25, 1, 0, 45, 123, 23, 45, 66, 77};
    sort(a, 0, a.length-1);
    for (int x : a) {
      System.out.print(x + " ");
    }
  }


  public static void sort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }

    int pivotIndex = partition(a, lo, hi);
    sort(a, lo, pivotIndex - 1);
    sort(a, pivotIndex + 1, hi);
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
}
