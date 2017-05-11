

public class Solution {

  public static void main(String[] args) {
      squares(1, 100);
  }

  public static void squares(int start, int end) {
    Double root = Math.sqrt(start);
    int sqRoot = root.intValue();

    if (sqRoot * sqRoot == start) {
      System.out.print(start + " ");
    }

    int sqNumber = sqRoot * sqRoot + 2 * sqRoot + 1;

    while(sqNumber <= end) {
        System.out.print(sqNumber + " ");
        sqRoot++;
        sqNumber = sqRoot * sqRoot + 2 * sqRoot + 1;
    }
  }

}
