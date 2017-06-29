/* File:    MatrixShortestDistanceRecursive.java
 * Created: 2017-06-28
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 Hogwarts.
 */

/**
 * Given a MxN matrix. Filled with 0's
 * There is one source location indicated by character '*'
 * There are one or more location where there is a Food. Indicated by '#'
 * Find the Shortest distance to any one of the Food location.
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class MatrixShortestDistanceRecursive {

  static  boolean pathFound = false;

  /**
   * driver method
   * @param args
   */
  public static void main(String[] args) {
    MatrixShortestDistanceRecursive sln = new MatrixShortestDistanceRecursive();

    char[][] input = new char[][]{
            {'*','X','#','X','#'},
            {'0','0','X','X','0'},
            {'0','0','0','X','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'}
    };

    System.out.println(sln.getFood(input));
  } // main

  // ---------------------------------------------------------------------------------------------------

  /**
   * Find shortest distance to food location
   * @param grid input matrix
   * @return shortest distance
   */
  public static int getFood(char[][] grid) {
    boolean sourceFound = false;
    int sourceR = 0, sourceC = 0; // Source Location
    // find source location
    for(int r = 0; r < grid.length; r++) {
      for(int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == '*') {
          sourceR = r;
          sourceC = c;
          sourceFound = true;
          break;
        }
      }
      if (sourceFound) break;
    } // end for find source location

    boolean[][] processed = new boolean[grid.length][grid[0].length];
    processed[sourceR][sourceC] = true;
    int len = expolorePath(grid, processed, sourceR, sourceC, 0, Integer.MAX_VALUE);

    return pathFound ? len : -1;
  } // getFood

  // ---------------------------------------------------------------------------------------------------

  /**
   * Recursive method.
   * explore path to destination food location from given location
   * @param grid input matrix
   * @param processed matrix indicating specifica locations have been processed
   * @param r current row
   * @param c current column
   * @param pathSize current pathSize at location r,c
   * @param shortestSoFar shortest path discovered so far
   * @return shortest path found
   */
  public static int expolorePath(char[][] grid, boolean[][] processed, int r, int c, int pathSize, int shortestSoFar) {
    if (grid[r][c] == '#') {
      pathFound = true;
      return pathSize;
    }

    int[] deltaR = {-1, 0, 1, 0};
    int[] deltaC = {0, 1, 0, -1};

    for(int i = 0; i <= 3; i++) {
      int neighborR = r + deltaR[i];
      int neighborC = c + deltaC[i];

      if (isPermitted(grid, neighborR, neighborC) && !processed[neighborR][neighborC]) {
        processed[neighborR][neighborC] = true;
        int len = expolorePath(grid, processed, neighborR, neighborC, pathSize+1, shortestSoFar);
        if ( len > -1) {
          shortestSoFar = Math.min(shortestSoFar, len);
        }
        processed[neighborR][neighborC] = false;
      }
    }
    return pathFound ? shortestSoFar : -1;
  } // expolorePath

  // ---------------------------------------------------------------------------------------------------

  /**
   * determine if a given location is permissible to move or not
   * @param grid input matrix
   * @param r given location's row
   * @param c given location's column
   * @return boolean whether the location is permitted or not
   */
  public static boolean isPermitted(char[][] grid, int r, int c) {
    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length) {
      return grid[r][c] != 'X';
    }
    return false;
  } // isPermitted

  // ---------------------------------------------------------------------------------------------------
}