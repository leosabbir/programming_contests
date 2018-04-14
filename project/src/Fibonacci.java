/* File:    NumberOfSubsetsWithTargetSum.java
 * Created: 2017-04-13
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 manandharsabbirk.appspot.com
 */

/**
 * Computes Number of Sub-sets that have sums to targetSUm
 *
 * @author Sabbir Manandhar manandhar.sabbir@gmail.com
 * @version 1.0
 */
public class Fibonacci {

	/**
	* main method
	*/
	public static void main(String[] args) {
		int n = 50;
		long now = System.currentTimeMillis();
		System.out.println(fib_memoization(n, new long[n+1]));
		System.out.println("Computed with Memoization in: " + (System.currentTimeMillis()-now));
		now = System.currentTimeMillis();
		//System.out.println(fib_recursion(n));
		System.out.println("Computed with Recursion in: " + (System.currentTimeMillis()-now));
		now = System.currentTimeMillis();
		System.out.println(fib_dp(n));
		System.out.println("Computed with DP in: " + (System.currentTimeMillis()-now));
		now = System.currentTimeMillis();
		System.out.println(fib_dp_modified(n));
		System.out.println("Computed with modified DP in: " + (System.currentTimeMillis()-now));
	} // main

	//--------------------------------------------------------------------------

	/**
	* Compute nth Fibonacci number using Recursion
	*/
	public static long fib_recursion(int n) {
		if (n == 0) {
			return 0;
		} 

		if (n == 1) {
			return 1;
		}

		return fib_recursion(n-2) + fib_recursion(n-1);
	} // fib

	//--------------------------------------------------------------------------
	
	/**
	* Compute nth Fibonacci number using memoization
	*/
	public static long fib_memoization(int n, long[] mem) {
		if (n == 0 || n == 1) {
			mem[n] = n;
			return n;
		}

		if (mem[n] == 0) {
			mem[n] = fib_memoization(n-2, mem) + fib_memoization(n-1, mem);
		}
		return mem[n];
	} // fib

	//--------------------------------------------------------------------------

	/**
	* Compute nth Fibonacci number using DP
	*/
	public static long fib_dp(int n) {
		long[] dp = new long[n+1];

		for (int i = 0; i <= n; i++) {
			if (i == 0 || i == 1) {
				dp[i] = i;
				continue;
			}
			dp[i] = dp[i-1] + dp[i-2];	
		}
		return dp[n];
	} // fib3

	//--------------------------------------------------------------------------

	/**
	* Compute nth Fibonacci number using modified DP
	*/
	public static long fib_dp_modified(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		long first = 0;
		long second = 1;

		int k = 2;
		do {
			long temp = first + second;
			first = second;
			second = temp;
			if (k == n) {
				return second;
			}
			k++;
		} while (true);
	} // fib4

	//--------------------------------------------------------------------------
} // Fibonacci