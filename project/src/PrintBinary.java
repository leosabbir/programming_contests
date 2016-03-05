

public class PrintBinary {

  public static void printBinary(int n) {
    if ( n > 0) {
      printBinary(n/2);
      System.out.print(n%2);
    }
  }

  public static long getBinary(int n) {
    if ( n > 0) {

      return n%2 + 10 *  getBinary(n/2);
    }
    return 0;
  }

  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    printBinary(n);
    System.out.println("\n" + getBinary(n));
  }


}
