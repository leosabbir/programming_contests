
/**
* Count the number of Set bits in a given UNSIGNED integer
*
* Reference: http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
*/
public class CountSetBits {

	/**
	* Driver method
	*/
	public static void main(String[] args) {
		System.out.println(count2(15)); // 1111
		System.out.println(count2(16)); // 10000
	} // main

	// --------------------------------------------------------------
	 
	/**
	* Brian Kernighan’s Algorithm
	*/
	public static int count(int number) {
		int count = 0;

		while(number > 0) {
			number = number & (number - 1);
			count++;
		}

		return count;
	} // count

	// --------------------------------------------------------------

	/*
	* Alternative method
	* Checks each bit, bit by bit
	*/
	public static int count2(int number) {
		int count = 0;

		for (int i = 0; i < Integer.SIZE ; i++) {
			if ((number & (1 << i)) > 0) {
				count++;
			}
		}
		return count;
	} // count2

	// --------------------------------------------------------------

} // CountSetBits