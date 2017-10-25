import java.util.*;

public class BinarySearch {

	public static void main(String[] args) {
		int[] list = new int[]{1, 2, 5, 12, 17, 23, 24, 26, 45, 55, 77, 89, 91, 93, 95, 100, 113};
		String res = search(list, 23) == 5 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(list, 23) == 5 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(list, 45) == 8 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(list, 77) == 10 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(list, 78) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(list, 95) == 14 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(list, 113) == 16 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(list, 1) == 0 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(list, 3) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(new int[]{3}, 3) == 0 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(new int[]{}, 3) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = search(new int[]{3}, 4) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);

		list = new int[]{1,1,1,1,2,2,3,3,3,3,4,5,8,9,10,11,11,11,33,33,44,75,87,87,87,90,90,90,90,100};
		res = searchLowerLimit(list, 23) == 18 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchLowerLimit(list, 1) == 0 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchLowerLimit(list, 90) == 25 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchLowerLimit(list, 100) == 29 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchLowerLimit(list, 101) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchLowerLimit(new int[]{}, 101) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchLowerLimit(new int[]{10}, 9) == 0 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchLowerLimit(new int[]{10}, 11) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);

		res = searchUpperLimit(list, 23) == 17 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchUpperLimit(list, 1) == 3 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchUpperLimit(list, 90) == 28 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchUpperLimit(list, 100) == 29 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchUpperLimit(list, 101) == 29 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchUpperLimit(new int[]{}, 101) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchUpperLimit(new int[]{10}, 9) == -1 ? "SUCCESS" : "FAILED";
		System.out.println(res);
		res = searchUpperLimit(new int[]{10}, 11) == 0 ? "SUCCESS" : "FAILED";
		System.out.println(res);
	} // main

	//-----------------------------------------------------------------------------------

	/**
	* Search an item equal to query item in the given list
	* @param list - list where we need to search
	* @param item - item to search in the list
	*/
	public static int search(int[] list, int item) {
		int lo = 0;
		int hi = list.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi)/2;

			if (list[mid] == item) {
				return mid; // item found
			} else if (list[mid] < item) {
				lo = mid + 1;
			} else { // list[mid] > item
				hi = mid - 1;
			}
		}
		return -1;
	} // search

	//----------------------------------------------------------------------------------

	/**
	* Search an item which is just larger than the given lowerlimit
	* @param list - list where we need to search
	* @param lowerLimit - lower limit
	*/
	public static int searchLowerLimit(int[] list, int lowerLimit) {
		int lo = 0;
		int hi = list.length - 1;

		if (hi == -1) {
			return -1;
		}

		int rightMost = list[hi];
		if (rightMost < lowerLimit) {
			return -1;
		}

		while(lo <= hi) {
			int mid = (lo+hi) / 2;

			if (list[mid] >= lowerLimit) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return hi + 1;
	} // searchLowerLimit

	//--------------------------------------------------------------------------------

	/**
	* Search an item which is just smaller than the given upper limit
	* @param list - list where we search
	* @param uppperLimit - upper limit
	*/
	public static int searchUpperLimit(int[] list, int upperLimit) {
		int lo = 0;
		int hi = list.length - 1;

		if (hi == -1) {
			return -1;
		}

		int leftMost = list[0];
		if (leftMost > upperLimit) {
			return -1;
		}

		while(lo <= hi) {
			int mid = (lo+hi) / 2;

			if (list[mid] > upperLimit) {
				hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo-1;
	} // searchUpperLimit

	//------------------------------------------------------------------------------

	/**
	* TODO find elements in given range using above two functions
	*/
	public static List<Integer> findElementsInRange(int[] list, int lowerLimit, int upperLimit) {
		List<Integer> result = new ArrayList<Integer>();
		return result;
	}
	
}