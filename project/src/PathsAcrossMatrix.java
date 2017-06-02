/* File:    PathsAcrossMatrix.java
 * Created: 2017-06-01
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

import java.util.Arrays;

/**
 * TODO Insert Description of the Class
 * Apply Memoization
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class PathsAcrossMatrix {
  static int matrixSize = 5;

  public static void main(String[] args) {
    int count = compute(0, 0, 0, matrixSize - 1, new int[matrixSize][matrixSize])
            + compute(0, 0, matrixSize - 1, 0, new int[matrixSize][matrixSize])
            + compute(0, 0, matrixSize - 1, matrixSize - 1, new int[matrixSize][matrixSize]);
    System.out.println(count);
  }

  public static int compute(int cr, int cc, int row, int col, int[][] visited) {
    if (row == cr && col == cc) {
      return 1;
    } else if (cr == 0 && cc == matrixSize - 1) {
      return 0;
    } else if (cr == matrixSize - 1 && cc == 0) {
      return 0;
    } else if (cr == matrixSize - 1 && cc == matrixSize - 1) {
      return 0;
    } else if (cr >= matrixSize || cc >= matrixSize) {
      return 0;
    }
    visited[cr][cc] = 1;
    int sum = 0;
    if (cr+1 < matrixSize && visited[cr+1][cc] == 0) {
      sum += compute(cr + 1, cc, row, col, clone(visited));
    }

    if (cc+1 < matrixSize && visited[cr][cc+1] == 0) {
      sum += compute(cr, cc + 1, row, col, clone(visited));
    }

    if (cr-1 >= 0 && visited[cr-1][cc] == 0) {
      sum += compute(cr - 1, cc, row, col, clone(visited));
    }

    if (cc-1 >= 0 && visited[cr][cc-1] == 0) {
      sum += compute(cr, cc - 1, row, col, clone(visited));
    }

    return sum;
  }

  public static int[][] clone(int[][] orig) {
    int[][] copy = new int[orig.length][orig[0].length];

    for (int row = 0; row < orig.length; row++) {
      for(int col = 0; col < orig[0].length; col++) {
        copy[row][col] = orig[row][col];
      }
    }

    return copy;
  }
} // PathsAcrossMatrix
