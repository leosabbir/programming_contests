/* File:    MaxProduct.java
 * Created: 2017-01-16
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 WorldLingo Inc.
 */

/**
 * http://www.programcreek.com/2014/03/leetcode-maximum-product-subarray-java/
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class MaxProduct {

  public static void main(String[] args) {
    int[] inputs = {2, 3, -2, -12, 12, 0, 4, 0, -1, 10};
    System.out.println(compute(inputs));
  }

  public static int compute(int[] inputs) {
    int[] max = new int[inputs.length];
    int[] min = new int[inputs.length];

    max[0] = inputs[0];
    min[0] = inputs[0]; // if all positive, then this is not necessary
                        // if -ve numbers don't occur continuously, it is also not necessary
                        // when -ve numbers can occur contiguous, then it makes difference
    int result = inputs[0];
    for (int i = 1; i < inputs.length; i++ ) {
      if (inputs[i] > 0) {
        max[i] = Math.max(inputs[i], inputs[i] * max[i-1]);
        min[i] = Math.min(inputs[i], inputs[i] * min[i-1]);
      } else {
        max[i] = Math.max(inputs[i], inputs[i] * min[i-1]);
        min[i] = Math.min(inputs[i], inputs[i] * max[i-1]);
      }
      result = Math.max(result, max[i]);
    }

    return result;
  }
} // MaxProduct
