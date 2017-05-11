

public class ShiftedSortedList {

	public static void main(String[] args) {
		int[] list = {9, 9, 9, 9, 9, 9, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		int k = findK(list);
		System.out.print("k: " + k);
		int q = 18;
		int res = search(list, q, 0, k);
		if (res == -1) {
			res = search(list, q, k+1, list.length-1);
		}
		System.out.println(res);
	}
	

	public static int search(int[] list, int item, int start, int end) {
		
		while (start <= end) {
			int mid = (start + end)/2;
			//System.out.println(mid + " : " + list[mid] + " : " + item + " : " + (item == list[mid]));
			if (item == list[mid]) {
				return mid;
			} else if (item < list[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	public static int findK(int[] list) {
		int lo = 0;
		int hi = list.length-1;

		while (lo < hi) {
			int mid = (lo + hi)/2;

			if (mid == lo) {
				return mid;
			}

			if (list[lo] > list[mid]) {
				hi = mid;
			} else {
				lo = mid;
			}
		}

		return lo;
	}
}