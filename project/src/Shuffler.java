import java.util.Random;

/**
 * This is a Shuffler class that can be used to shuffle given input array
 * uniformly
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class Shuffler {
	private Random random;

	/**
     * Constructor to Shuffler instance.
     * initializes the variable random
     *
     */
	public Shuffler() {
		random = new Random();
	} // Shuffler

	//----------------------------------------------------------------------------

	/**
	 * returns random number between two given range
	 * @param lo lower limit of the range
	 * @param hi upper limit of the range
	 */
	private int getRandom(int lo, int hi) {
		return random.nextInt(hi - lo + 1) + lo;
	} // getRandom

	//----------------------------------------------------------------------------

	/**
	 * swaps two items in the given array
	 * @param nums input array in which swapping will be done
	 * @param i first index to swap
	 * @param j second index to swap
	 */
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	} // swap

	//----------------------------------------------------------------------------

	/**
	 * methods that shuffles the given array
	 * @param nums array to shuffle 
	 */
	public void shuffle(int[] nums) {
		for (int i = 0; i < nums.length - 1 ; i++ ) {
			int rand = getRandom(i, nums.length-1);
			swap(nums, i, rand);
		}
	} // shuffle

	//----------------------------------------------------------------------------

	/**
	 * driver method
	 */
	public static void main(String[] args) {
		int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Shuffler shuffler = new Shuffler();
		shuffler.shuffle(nums);

		for (int item : nums) {
			System.out.print(item + " ");
		}
	} // main

	//----------------------------------------------------------------------------
} // Shuffler