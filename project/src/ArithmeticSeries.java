


public class ArithmeticSeries {

  public static void main(String[] args) {
    int[] a = {1,2,3,4,5,6,7,8,9};
    int[] a1 = {1,2,3,4,5,6,7,8,9,9};
    int[] a2 = {10,1,2,7,11,4,5,6,12,8,9,3};
    int[] a3 = {10,1,2,7,11,4,5,6,12,14,8,9,3};
    int[] a4 = {3,3,3,3,3,3,3,3,3,3,3,3,3};
    System.out.println(isAP(a));
    System.out.println(isAP(a1));
    System.out.println(isAP(a2));
    System.out.println(isAP(a3));
    System.out.println(isAP(a4));
  }

    public static boolean isAP(int[] a) {
      if (a.length <= 2) {
        return true;
      }
		    int max = a[0], min = a[0];

		// determine max and min
		// O(n)
		for (int i = 1; i < a.length; i++) {
			if (max < a[i]) max = a[i];
			if (min > a[i]) min = a[i];
		}

    // all elements are same
    if (min == max) {
      return true;
    }

    //common difference of the series
		int diff = (max - min)/(a.length - 1);

    
    if (diff == 0) {
      return false;
    }

		boolean[] aa = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			aa[i] = false;
		}

		for (int i = 0; i < a.length; i++) {
			int index = (a[i] - min)/diff;
			if (index >= a.length || aa[index]) {
				return false;
			} else {
				aa[index] = true;
			}
		}

		return true;

	}

}
