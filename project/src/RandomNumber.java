/* File:    RandomNumber.java
 * Created: 2017-02-06
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

package com.worldlingo;

import java.util.Random;

/**
 * TODO Insert Description of the Class
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class RandomNumber {

  public static void main(String[] args) {
    for (int i = 0; i < 100; i++) {
      System.out.println(newGenerator());
    }
  }

  public static int newGenerator() {
    Double x = defaultGenerator() * 1.0;

    int newStart = 0;
    int newEnd = 5;

    x = x * newEnd / 4 + newStart;
    return (int)Math.round(x);
  }

  public static int defaultGenerator() {
    int start = 0;
    int end = 4;
    Random random = new Random();
    int rand = random.nextInt(end - start + 1) + start;

    return rand;
  }
} // RandomNumber
