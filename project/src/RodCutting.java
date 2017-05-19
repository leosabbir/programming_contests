

// http://www.geeksforgeeks.org/dynamic-programming-set-13-cutting-a-rod/
public class RodCutting {

	int[] prices = {1, 5, 8, 9, 10, 17, 17, 17, 17, 17, 17, 18, 18, 19, 19, 20, 20, 21, 23, 25, 25, 25, 25, 26, 26, 27, 28, 29, 30, 31, 32, 35, 36, 40, 45, 45, 50};

	public static void main(String[] args) {
		RodCutting rod = new RodCutting();
		rod.cutRods();
	}

	public void cutRods() {
		int[] mem = new int[prices.length + 1];
		System.out.println(this.cutRods(prices, mem, prices.length));
		System.out.println(this.cutRods2(prices, prices.length));
	}


	// TOP DOWN Memoization
	public int cutRods(int[] prices, int[] mem, int n) {
		if (n == 0) {
			return 0;
		}
		if (mem[n] > 0) {
			return mem[n];
		}
		int maxPrice = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			maxPrice = Math.max(maxPrice, prices[i] + cutRods(prices, mem, n - i - 1));
		}
		mem[n] = maxPrice;
		return maxPrice;
	}

	// BOTTOM UP 
	public int cutRods2(int[] prices, int n) {
		int[] mem = new int[prices.length+1];

		for (int i = 1;  i <= n; i++) {
			int maxPrice = Integer.MIN_VALUE;
			for (int j = 1; j <= i ; j++) {
				maxPrice = Math.max(maxPrice, prices[i-1] + mem[i-j]);
			}
			mem[i] = maxPrice;
		}
		return mem[n];
	}



	
}