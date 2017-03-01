/* File:    RadixSort.java
 * Created: 2016-12-28
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2016 WorldLingo Inc.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class RadixSort {

  public static void main(String[] args) {
    int[] input = {9, 12, 36, 35, 34, 38, 1, 15, 1, 9, 9, 36, 35, 135, 1254};

    input = sort(input);

    for (int x : input) {
      System.out.print(x + " ");    }
  }

  public static int[] sort(int[] input) {

    int place = 0;
    boolean finish = false;
    while (!finish) {
      finish = true;
      System.out.println(place);
      Queue<Integer>[] buckets = new Queue[10];

      int mod = place == 0 ? 10 : place * 10;
      int div = place == 0 ? 1 : place;
      for (int value : input) {

        int dig = (value % mod) / div;
        finish = !finish ? finish : dig == 0;
        if (buckets[dig] == null) {
          buckets[dig] = new LinkedList<Integer>();
        }
        buckets[dig].add(value);
      }

      int index = 0;
      for (int i = 0; i < 10; i++) {
        while(buckets[i] != null && !buckets[i].isEmpty()) {
          input[index++] = buckets[i].remove();
        }
      }
      place = mod;
    }
    return input;
  }

} // RadixSort

class Node {
  int value;
  Node next;

  public Node(int value) {
    this.value = value;
  }
}
