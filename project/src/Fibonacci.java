
package fibonacci;

public class Fibonacci {

	public static void main(String[] args) {
		int n = 50;
		long now = System.currentTimeMillis();
		System.out.println(fib(n, new long[n+1]));
		System.out.println("Computed in: " + (System.currentTimeMillis()-now));
		now = System.currentTimeMillis();
		System.out.println(fib(n));
		System.out.println("Computed in: " + (System.currentTimeMillis()-now));
		now = System.currentTimeMillis();
		System.out.println(fib3(n));
		System.out.println("Computed in: " + (System.currentTimeMillis()-now));
	}

	public static long fib(int n) {
		if (n == 0) {
			return 0;
		} 

		if (n == 1) {
			return 1;
		}

		return fib(n-2) + fib(n-1);
	}
	
	public static long fib(int n, long[] mem) {
		if (n == 0 || n == 1) {
			mem[n] = n;
			return n;
		}

		if (mem[n] == 0) {
			mem[n] = fib(n-2, mem) + fib(n-1, mem);
		}
		return mem[n];
	}

	public static long fib3(int n) {
		long[] dp = new long[n+1];

		for (int i = 0; i <= n; i++) {
			if (i == 0 || i == 1) {
				dp[i] = i;
				continue;
			}
			dp[i] = dp[i-1] + dp[i-2];	
		}
		return dp[n];
	}
}