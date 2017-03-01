/* File:    TOH.java
 * Created: 2017-01-11
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.Stack;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class TOH {

  public static void main(String[] args) {
    int num = 4;
    hanoi(num, 'S', 'A', 'D');
    System.out.println();
    hanoiIterative(num);
  }

  public static void hanoi(int n, char source, char buffer, char destination) {
    if (n < 1) {
      //System.out.println("Move disk " + n + " from " + source + " to " + destination);
      return;
    }

    hanoi(n-1, source, destination, buffer);
    System.out.println("Move disk " + n + " from " + source + " to " + destination);
    hanoi(n-1, buffer, source, destination);
  }

  public static void hanoiIterative(int n) {
    Stack<Integer> src = new Stack<Integer>();
    Stack<Integer> aux = new Stack<Integer>();
    Stack<Integer> dest = new Stack<Integer>();

    char s = 'S', a = 'A', d = 'D';
    double moves = Math.pow(2, n) - 1;

    if (n % 2 == 0) {
      d = 'A';
      a = 'D';
    }

    for (int i = n; i > 0; i--) {
      src.push(i);
    }

    for (int i = 1; i <= moves; i++) {
      if (i % 3 == 1) {
        move(src, dest, s, d);
      } else if (i % 3 == 2) {
        move(src, aux, s, a);
      } else {
        move(aux, dest, a, d);
      }
    }
  }

  public static void move(Stack<Integer> src, Stack<Integer> dest, char s, char d) {
    if (src.isEmpty()) {
      int disk = dest.pop();
      src.push(disk);
      System.out.println("Move disk " + disk + " from " + d + " to " + s);
    } else if (dest.isEmpty()) {
      int disk = src.pop();
      dest.push(disk);
      System.out.println("Move disk " + disk + " from " + s + " to " + d);
    } else {
      int disk1 = src.pop();
      int disk2 = dest.pop();

      if (disk1 > disk2) {
        src.push(disk1);
        src.push(disk2);
        System.out.println("Move disk " + disk2 + " from " + d + " to " + s);
      } else {
        dest.push(disk2);
        dest.push(disk1);
        System.out.println("Move disk " + disk1 + " from " + s + " to " + d);
      }
    }

  }
} // TOH
