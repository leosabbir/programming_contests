import java.util.Map;
import java.util.HashMap;

// http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
public class CoinChange {
	
	private static int N = 500;
	private static int[] S = {1, 5, 10, 25, 100};
	private static int[][] mem = new int[S.length][N+1];

	private static Map<String, Integer> map = new HashMap<String, Integer>();

	public static void main(String[] args) {
		System.out.println(count(S, S.length-1, N));
		System.out.println("------------------");
		System.out.println(count2(S, S.length-1, N));
	}

	public static int count(int[] S, int m, int n) {
		if (n == 0) {
			return 1;
		}

		if (n < 0) {
			return 0;
		}

		if (n > 0 && m < 0) {
			return 0;
		}

		String key1 = (m-1) + "-" + n;
		if (!map.containsKey(key1)) {
			map.put(key1, count(S, m - 1, n));
		}

		String key2 = m + "-" + (n - S[m]);
		if(!map.containsKey(key2)) {
			map.put(key2, count(S, m, n - S[m]));
		}

		return map.get(key1) + map.get(key2);
	}

	public static int count2(int[] S, int m, int n) {
		for (int i = 0; i <= m ; i++) {
			mem[i][0] = 1;
		}

		for (int i = 0; i <= m ; i++) {
			for (int j = 1; j <= N; j++) {
				int x = i-1 < 0 ? 0 : mem[i-1][j];
				int y = j - S[i] < 0 ? 0 : mem[i][j-S[i]];
				//System.out.println(x+y);
				mem[i][j] = x + y;
			}
			System.out.println();
		}

		return mem[m][N];
	}
}