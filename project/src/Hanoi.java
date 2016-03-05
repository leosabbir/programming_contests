

public class Hanoi {

  public static void main(String[] args) {
    moveDisks(5, 1, 3, 2);
  }

  public static void moveDisks(int n, int source, int destination, int buffer) {
    if (n == 1) {
      System.out.println("Move disk 1 from Tower " + source + " to Tower " + destination);
      return;
    }

    moveDisks(n-1, source, buffer, destination);
    System.out.println("Move disk " + n + " from Tower " + source + " to Tower " + destination);
    //moveDisks(1, source, destination, buffer);
    moveDisks(n-1, buffer, destination, source);
  }
}
