/* File:    MatrixShortestDistanceBFS.java
 * Created: 2017-06-28
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 Hogwarts.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a MxN matrix. Filled with 0's
 * There is one source location indicated by character '*'
 * There are one or more location where there is a Food. Indicated by '#'
 * Find the Shortest distance to any one of the Food location.
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class MatrixShortestDistanceRecursiveBFS {
  /**
   * driver method
   * @param args
   */
  public static void main(String[] args) {
    MatrixShortestDistanceRecursiveBFS sln = new MatrixShortestDistanceRecursiveBFS();

    char[][] input = new char[][]{
            {'0','X','#','X','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'},
            {'0','0','X','X','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','*','X','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','X',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0',},
            {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','X','#',},
    };

    /*char[][] input = new char[][]{
            {'*','X','#','X','#'},
            {'0','0','X','X','0'},
            {'0','0','0','X','0'},
            {'0','0','0','0','0'},
            {'0','0','0','0','0'}
    };*/

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
    int[][] pathLenths = new int[grid.length][grid[0].length];

    return explorePath(grid, processed, pathLenths, sourceR, sourceC);
  } // getFood

  // ---------------------------------------------------------------------------------------------------

  /**
   * BFS  method.
   * explore path to destination food location from given location
   * @param grid input matrix
   * @param processed matrix indicating specifica locations have been processed
   * @param r current row
   * @param c current column
   * @return shortest path found
   */
  public static int explorePath(char[][] grid, boolean[][] processed, int[][] pathLen, int r, int c) {
    Queue<int[]> ngbs = new LinkedList<int[]>();
    ngbs.add(new int[]{r, c});

    while(!ngbs.isEmpty()) {
      int[] ngb = ngbs.poll();
      int currentR = ngb[0];
      int currentC = ngb[1];

      int currLen = pathLen[currentR][currentC];
      if (grid[currentR][currentC] == '#') {
        return currLen;
      }

      int[] deltaR = {-1, 0, 1, 0};
      int[] deltaC = {0, 1, 0, -1};

      for(int i = 0; i <= 3; i++) {
        int neighborR = currentR + deltaR[i];
        int neighborC = currentC + deltaC[i];

        if (isPermitted(grid, neighborR, neighborC) && !processed[neighborR][neighborC]) {
          pathLen[neighborR][neighborC] = currLen + 1; // set length of neighbor
          ngbs.add(new int[]{neighborR, neighborC});
          processed[neighborR][neighborC] = true;
        }
      }

    }
    return -1;
  } // explorePath

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