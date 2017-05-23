import java.util.PriorityQueue;
import java.util.Comparator;

public class ContinuousMedian {
	
	PriorityQueue<Integer> lowers;
	PriorityQueue<Integer> uppers;

	public ContinuousMedian() {
		lowers = new PriorityQueue<Integer>(new Comparator<Integer>(){
			@Override
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});

		uppers = new PriorityQueue<Integer>();
	}

	public void compute(int[] numbers) {
		for (int i = 0; i < numbers.length ; i++) {
			if (lowers.size() == 0 || numbers[i] < lowers.peek()) {
				lowers.add(numbers[i]);
			} else {
				uppers.add(numbers[i]);
			}

			balance(lowers, uppers);
			System.out.println(getMedian(lowers, uppers));
		}
	}

	private void balance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		PriorityQueue<Integer> larger = lowers.size() > uppers.size() ? lowers : uppers;
		PriorityQueue<Integer> smaller = lowers.size() > uppers.size() ? uppers : lowers;

		if (larger.size() - smaller.size() > 1) {
			smaller.add(larger.poll());
		}
	}


	public double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> uppers) {
		PriorityQueue<Integer> larger = lowers.size() > uppers.size() ? lowers : uppers;
		PriorityQueue<Integer> smaller = lowers.size() > uppers.size() ? uppers : lowers;

		if (larger.size() - smaller.size() == 1) {
			return larger.peek();
		} else {
			return ((double)larger.peek() + lowers.peek())/2;
		}
	}

	public static void main(String[] args) {
		int[] numbers = {9, 3, 6, 7, 1, 5, 8, 3};

		ContinuousMedian median = new ContinuousMedian();
		median.compute(numbers);
	}


}