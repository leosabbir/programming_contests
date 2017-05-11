import java.util.List;
import java.util.LinkedList;

public class LongestStrictMonotone {
      public static void main(String[] args) {
        int[] a = {5, 2, 9, 0, 8, 4, 3, 1, 7, 6};
        find2(a);
      }

      // O(n^2) solution
      public static void find(int[] a) {
          int[] lengths = new int[a.length];
          int[] backPointer = new int[a.length];

          for(int i = 0; i < a.length; i++) {
                  lengths[i] = 1;
                  backPointer[i] = -1;
                  for(int j = 0; j < i; j++) {
                      if (a[j] < a[i]) {
                          if (lengths[j] >= lengths[i]) {
                              lengths[i] = lengths[j] + 1;
                              backPointer[i] = j;
                          }
                      }
                  }
          }

          int maxIndex = 0;
          for(int i = 1; i < a.length; i++) {
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
      }

      public static void find2(int[] a) {
          int[] lengths = new int[a.length];
          int n = 0;

          for (int i = 0; i < a.length; i++) {
              if (n > 0) {
                  int lo = 0;
                  int hi = n;
                  int mid = (hi-lo) / 2;
                  do {
                      if (lengths[mid] < a[i]) {
                          lo = mid + 1;
                          mid = (hi-lo) / 2;
                      } else if (lengths[mid] > a[i]) {
                          hi = mid - 1;
                          mid = (hi-lo) / 2;
                      } else { //equal
                          System.out.println(n);
                      }
                  } while(lo < hi);
                  if (lengths[lo] < a[i]) {
                      lengths[lo+1] = a[i];
                      n++;
                  } else {
                      lengths[lo] = a[i];
                  }
              } else {
                  lengths[n] = a[i];
                  n++;
              }
          }
          System.out.println(n);
      }
}
