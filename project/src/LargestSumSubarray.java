

public class LargestSumSubarray {

	public static void main(String[] args) {
		int[] nums = {2, -3, 5, 4, -5, 6, 0, -1, 1, 0, -4, 1, 100};
		System.out.println(compute(nums));
		System.out.println(compute2(nums));
	}
	

	// O(n) solution
	public static int compute(int[] nums) {
		int n = nums.length;
		int[] maxSoFar = new int[n];
		int[] currentMaxEndingHere = new int[n];
		int start = 0, end = 0;

		maxSoFar[0] = nums[0];
		currentMaxEndingHere[0] = nums[0];

		for(int i = 1; i < n; i++) {
			int currentStart, currentEnd;
			if (nums[i] > currentMaxEndingHere[i-1] + nums[i]) {
				currentStart = i;
				currentEnd = i;
				currentMaxEndingHere[i] = nums[i];
			} else {
				currentStart = start;
				currentEnd = i;
				currentMaxEndingHere[i] = currentMaxEndingHere[i-1] + nums[i];
			}
			
			if (currentMaxEndingHere[i] > maxSoFar[i-1]) {
				start = currentStart;
				end = currentEnd;
				maxSoFar[i] = currentMaxEndingHere[i];
			} else {
				maxSoFar[i] = maxSoFar[i-1];
			}
		}

		System.out.println("[" + start + ", " + end + "]");
		return maxSoFar[n-1];
	}

	// O(n^2) solution
	public static int compute2(int[] nums) {
		int max = Integer.MIN_VALUE;
		int start = 0;
		int end = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum > max) {
					max = sum;
					start = i;
					end = j;
				}
			}			
		}

		System.out.println("[" + start + ", " + end + "]");
		return max;
	}
}