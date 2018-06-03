/* File:    MaximumSquareSubMatrix.java
 * Created: 2018-06-02
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2018 https://manandharsabbirk.appspot.com
 */

package matrix;

import java.util.Arrays;

/**
 * 
 *
 * @author Sabbir Manandhar
 *			manandhar.sabbir@gmail.com
 * @version 1.0
 */  
public class MaximumSquareSubMatrix {

	//---------------------------------------------------------------------------------
    
    /**
    * main method
    */
    public static void main (String [] args) {
        System.out.println(computeNaive(new int[0][0]));
        System.out.println(computeDP(new int[0][0]));
        System.out.println(computeDP_2(new int[0][0]));

        int[][] matrix = {
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
        	{ 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1 }
        };
        
        System.out.println(computeNaive(matrix));
        System.out.println(computeDP(matrix));
        System.out.println(computeDP_2(matrix));

        int[][] matrix2 = {
        	{1, 1, 0, 1, 0},
        	{1, 1, 1, 1, 1},
        	{0, 1, 1, 1, 1},
        	{0, 1, 1, 1, 1},
        	{0, 1, 1, 1, 0}
        };

        System.out.println(computeNaive(matrix2));
        System.out.println(computeDP(matrix2));
        System.out.println(computeDP_2(matrix2));

    } // main

    //---------------------------------------------------------------------------------

    /**
    * Computes the maximum size sub matrix in the given matrix
    * This method is a naive method O((mn)^2)
    *
    * @param matrix intput m x n matrix filled with 1s and 0s
    * @return area of the maximum square sub matrix
    */
    public static int computeNaive(int[][] matrix) {
    	int ROWS = matrix.length;
    	int COLS = 0;
    	if (ROWS > 0) {
    		COLS = matrix[0].length;
    	}

    	int maxSize = 0;
    	for(int row = 0; row < ROWS; row++) {
    		for (int col = 0; col < COLS; col++) {
    			if (matrix[row][col] == 1) {
    				int diagR = row+1;
    				int diagC = col+1;
    				int size = 1;
    				while(diagR < ROWS && diagC < COLS && matrix[diagR][diagC] == 1) {
    					int r = diagR - 1;
    					boolean maxFound = false;
    					// check if all elements in column are 1 or not
    					while (r >= row) {
    						if (matrix[r][diagC] == 0) {
    							maxFound = true; // 0 found
    							break;
    						}
    						r--;
    					}
    					if (maxFound) {
    						break;
    					}
    					int c = diagC - 1;
    					// check if all elements in row are 1 or not
    					while(c >= col) {
    						if (matrix[diagR][c] == 0) {
    							maxFound = true; // 0 found
    							break;
    						}
    						c--;
    					}

    					if (!maxFound) {
    						size++;
    					} else {
    						break;
    					}
    					diagR++;
    					diagC++;
    				}

    				maxSize = Math.max(size, maxSize);
    			}
    		}
    	}
    	return maxSize * maxSize;
    } // computeNaive

    //---------------------------------------------------------------------------------

    /**
    * Computes the maximum size sub matrix in the given matrix
    * This method uses Dynamic Programming O(mn) time and O(mn) space
    *
    * @param matrix intput m x n matrix filled with 1s and 0s
    * @return area of the maximum square sub matrix
    */
    public static int computeDP(int[][] matrix) {
    	int ROWS = matrix.length;
    	int COLS = ROWS > 0 ? matrix[0].length : 0;;

    	int maxSize = 0;
        int[][] size = new int[ROWS][COLS];
        // sets the bottom most row as the input itself
        for(int c = 0; c < COLS; c++) {
        	if (maxSize == 0) {
        		maxSize = matrix[ROWS-1][c];
        	}
        	size[ROWS-1][c] = matrix[ROWS-1][c];
        }
        
        // sets the right most column as the input itself
        for(int r = 0; r < ROWS-1; r++) {
        	if (maxSize == 0) {
        		maxSize = matrix[r][COLS-1];
        	}
        	size[r][COLS-1] = matrix[r][COLS-1];
        }
        
        // computes all other upper values using dynamic programming
        for(int r = ROWS - 2; r >= 0; r--) {
            for (int c = COLS - 2; c >= 0; c--) {
                if (matrix[r][c] == 1) {
                	int right = size[r][c+1];
                	int bottom = size[r+1][c];
                	int diagonal = size[r+1][c+1];
                    size[r][c] = 1 + Math.min(bottom, Math.min(diagonal, right));
                    maxSize = Math.max(maxSize, size[r][c]);
                } else {
                    size[r][c] = 0;
                }
            }
        }
        return maxSize * maxSize;
    } // compuateDP

    //---------------------------------------------------------------------------------

    /**
    * Computes the maximum size sub matrix in the given matrix
    * This method uses Dynamic Programming O(mn) time and O(n) space
    *
    * @param matrix intput m x n matrix filled with 1s and 0s
    * @return area of the maximum square sub matrix
    */
    public static int computeDP_2(int[][] matrix) {
    	int ROWS = matrix.length;
    	int COLS = ROWS > 0 ? matrix[0].length : 0;;

    	int maxSize = 0;
        int[] size = new int[COLS];
        // sets the bottom most row as the input itself
        for(int c = 0; c < COLS; c++) {
        	if (maxSize == 0) {
        		maxSize = matrix[ROWS-1][c];
        	}
        	size[c] = matrix[ROWS-1][c];
        }
        //System.out.println(Arrays.toString(size));

        // computes all other upper values using dynamic programming
        for(int r = ROWS - 2; r >= 0; r--) {
        	int prev = size[COLS-1];
        	size[COLS-1] = matrix[r][COLS-1];
            for (int c = COLS - 2; c >= 0; c--) {
                if (matrix[r][c] == 1) {
                	int right = size[c+1];
                	int bottom = size[c];
                	int diagonal = prev;
                	prev = size[c];
                    size[c] = 1 + Math.min(bottom, Math.min(right, diagonal));
                    maxSize = Math.max(maxSize, size[c]);
                } else {
                    size[c] = 0;
                }
            }
            //System.out.println(Arrays.toString(size));
        }
        return maxSize * maxSize;
    } // compuateDP

} // MaximumSquareSubMatrix
