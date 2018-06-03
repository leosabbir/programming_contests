/* File:    KthSmallest.java
 * Created: 2018-04-15
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2018 https://manandharsabbirk.appspot.com
 */
package matrix;
  
public class KthSmallest {

	//---------------------------------------------------------------------------------
    
    public static void main (String [] args) {
        int[][] matrix = new int[][]{{2, 7, 11, 20},
    								 {5, 8, 13, 27},
    								 {9, 21, 25, 30},
    								 {13, 30, 31, 35}};

    	System.out.println(findKthSmallest(matrix, 2)); // 5
    	System.out.println(findKthSmallest(matrix, 8)); // 13
    	System.out.println(findKthSmallest(matrix, 10)); // 21
    	System.out.println(findKthSmallest(matrix, 13)); // 30
    	System.out.println(findKthSmallest(matrix, 14)); // 30
    	System.out.println(findKthSmallest(matrix, 15)); // 31 
    	System.out.println(findKthSmallest(matrix, 16)); // 35
        
    } // main

    //---------------------------------------------------------------------------------

    /**
    * Finds the kth smallest item in the given matrix
    * @param matrix input matrix
    * @param k parameter k
    * @return kth smallest element in the matrix
    */
    public static int findKthSmallest(int[][] matrix, int k) {
    	int R = matrix.length;
    	int C = matrix[0].length;

    	int lo = matrix[0][0];
    	int hi = matrix[R-1][C-1] + 1;

    	while (lo < hi) { // O(log(hi-lo))
    		int mid = lo + (hi - lo) / 2;
    		int col = C - 1;
    		int count = 0;
    		
    		// this loop counts number of items which are less than or equal to mid
    		for (int row = 0; row < R; row++) { // O(R)
    			while(col >= 0 && matrix[row][col] > mid) {
    				col--;
    			}
    			count += col + 1;
    		}
    		if (count < k) {
    			lo = mid + 1;
    		} else {
    			hi = mid;
    		}
    	}
    	return lo;
    } // findKthSmallest

    //---------------------------------------------------------------------------------

} // KthSmallest
