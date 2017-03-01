/* File:    SherlockPairs.java
 * Created: 2017-01-12
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class SherlockPairs {

  public static void main(String[] args) {
    int x = 1000000000;
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    while (T > 0) {
      int N = sc.nextInt();
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();
      while (N > 0) {
        int num = sc.nextInt();
        if (map.containsKey(num)) {
          map.put(num, map.get(num) + 1);
        } else {
          map.put(num, 1);
        }
        N--;
      }

      double sum = 0;
      for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        int occurence = entry.getValue();
        if (occurence > 1) {
          sum += occurence * (occurence - 1);
        }
      }
      System.out.println(sum);
      T--;
    }
  }
} // SherlockPairs
