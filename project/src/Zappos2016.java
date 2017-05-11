import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;


public class Zappos2016 {

	private List<Integer> processed = new ArrayList<Integer>();
	private Queue<Integer> queue = new LinkedList<Integer>();

	// for backtracking the path
	private Map<Integer, Integer> operationPointer = new HashMap<Integer, Integer>();
	private List<Operation> operations = new ArrayList<Operation>();

	int source;
	int destination;

	public static void main(String[] args) {

		new Zappos2016().runIterative2(4284, 1131);	// example test case
		new Zappos2016().runIterative2(53453, 24);	// GIven test case
		new Zappos2016().runIterative2(1337, 5555);	// given test case
		new Zappos2016().runIterative2(2625, 2687);	// just a test
		//extra
		new Zappos2016().runIterative2(0, 1);		// extra test case
		new Zappos2016().runIterative2(999997, 1);	// just a test
		new Zappos2016().runIterative2(525, 163534);	// extra test case
		new Zappos2016().runIterative2(1, 999997);		//given test case. my implementation took very very long time
	}

	/**
	public void runRecursive(int num1, int num2) {
		if (num1 == num2) {
			System.out.println(true);
			return;
		} else {
			List<Integer> temp = multiplicantionComb(num1);
			processed.add(num1);
			if(check(temp, num2)) {
				System.out.println(true);
				return;
			}
			this.addToQueue(temp);

			temp = addComb(num1);
			if(check(temp, num2)) {
				System.out.println(true);
				return;
			}
			this.addToQueue(temp);

			temp = bitSwapp(num1);
			if(check(temp, num2)) {
				System.out.println(true);
				return;
			}
			this.addToQueue(temp);
			num1 = queue.remove();
			run(num1, num2);
		}
		//System.out.println(false);
	}
	**/

	public void runIterative2(int num1, int num2) {
		this.source = num1;
		this.destination = num2;

		this.queue.add(num1);
		while (!this.queue.isEmpty()) {
			num1 = this.queue.remove();

			/*if (num1 == num2) {
				this.tracePath(num2);
				return;
			}*/

			boolean bounded = num1 < num2 ? (num1 >= this.source && num1 <= num2) : (num1 <= this.source || num1 >= num2);
			if (processed.contains(num1) || !bounded) {
				continue;
			}

			processed.add(num1);
			if (getBitsSwappedNumbers(num1) || getMultipliedNumbers(num1) || getAddedNumbers(num1) ) {
				this.tracePath(num2);
				return;
			}
		}
		System.out.println("No Solution\n");
	}


	/** Prints the path from source to destination ***/
	public void tracePath(int num) {
		Integer index = this.operationPointer.get(num);
		Operation operation = this.operations.get(index);

		int chainLength = 0;

		Stack<String> outputs = new Stack<String>();
		outputs.push("Value: " + num);
		chainLength++;
		outputs.push(operation.toString());
		do {
			num = operation.getParent();
			if (num == this.source) {
				outputs.push("Initial Value: " + num);
				chainLength++;
				break;
			} else {
				outputs.push("Value: " + num);
				chainLength++;
			}
			index = this.operationPointer.get(operation.getParent());
			operation = this.operations.get(index);
			outputs.push(operation.toString());
		} while (num != this.source);

		while(!outputs.isEmpty()) {
			System.out.println(outputs.pop());
		}
		System.out.println("Chain Length: " + chainLength);
		System.out.println();
	}

	public boolean getAddedNumbers(int num) {
		//List<Integer> results = new ArrayList<Integer>();

		char[] str = String.valueOf(num).toCharArray();

		for (int i = 0; i < str.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < str.length; j++) {
				sb.append(str[j]);
				int addend = Integer.parseInt(sb.toString());
				int result = num + addend;

				if (result != num) {
					if (!this.operationPointer.containsKey(result)) {
						this.queue.add(result);
						this.operations.add(new Operation(num, 0, addend, -1));
						this.operationPointer.put(result, this.operations.size()-1);
						if (result == this.destination) {
							return true;
						}
					}

				}
			}
		}
		return false;
	}


	public boolean getMultipliedNumbers(int num) {
		//List<Integer> results = new ArrayList<Integer>();

		int n = 10;
		int a = num / n;
		int b = num % n;
		while( a > 0 ) {
			int temp = a * b;

			if (!this.operationPointer.containsKey(temp)) {
				this.queue.add(temp);
				this.operations.add(new Operation(num, 1, a, b));
				this.operationPointer.put(temp, this.operations.size()-1);
				if (temp == this.destination) {
					return true;
				}
			}

			n = n * 10;
			a = num / n;
			b = num % n;
		}
		return false;
	}

	public boolean getBitsSwappedNumbers(int num) {
		//List<Integer> results = new ArrayList<Integer>();

		for (int i = 0; i < Integer.toBinaryString(num).length(); i++) {
			int swapped = swap(num, i, i+1);
			//if (swapped != num && !results.contains(swapped)) {
			if (swapped != num) {
				if (!this.operationPointer.containsKey(swapped)) {
					this.queue.add(swapped);
					this.operations.add(new Operation(num, 2, i, i+1));
					this.operationPointer.put(swapped, this.operations.size()-1);
					if (swapped == this.destination) {
						return true;
					}
				}
			}
		}

		return false;
	}

	/* Reference: Stackoverflow */
	public static int swap(int i, int pos1, int pos2) {

	    int bit1 = (i >> pos1) & 1;
	    int bit2 = (i >> pos2) & 1;

	    if (bit1 == bit2) {
	        return i;
	    }

	    int mask = (1 << pos1) | (1 << pos2);

	    return i ^ mask;
	}
}
