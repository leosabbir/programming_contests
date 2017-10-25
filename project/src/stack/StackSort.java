import java.util.Stack;

/**
* Sort the given Stack recursively
*/
public class StackSort {
	

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(25);
		stack.push(15);
		stack.push(35);
		stack.push(45);
		stack.push(10);
		stack.push(5);
		stack.push(0);
		stack.push(30);
		stack.push(40);

		//sortRecursive(stack);
		sortUsingAnotherStack(stack);

		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	} // main

	// ---------------------------------------------------------------------------------------------

	/**
	* Recursively pops all the elements from the stack
	* and insert back in sorted manner
	*/
	public static void sortRecursive(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		} else {
			int top = stack.pop();
			sort(stack);
			sortedInsertRecursive(stack, top);
		}
	} // sortRecursive

	// ---------------------------------------------------------------------------------------------

	/**
	* Inserts into stack in sorted manner.
	* If the top larger, recursively pops the larger item then insert at right place
	*/
	public static void sortedInsertRecursive(Stack<Integer> stack, int x) {
		if (stack.isEmpty() || stack.peek() < x) {
			stack.push(x);
			return;
		}
		int top = stack.pop();
		sortedInsert(stack, x);
		stack.push(top);
	} // sortedInsertRecursive

	// ---------------------------------------------------------------------------------------------

	/**
	* Iterative Method
	* Equivalent to above Recursive Approach
	*/
	public static void sortUsingAnotherStack(Stack<Integer> stack) {
		Stack<Integer> helperStack = new Stack<Integer>();
		while(!stack.isEmpty()) {
			helperStack.push(stack.pop());
		}

		while(!helperStack.isEmpty()) {
			int x = helperStack.pop();

			while(!stack.isEmpty() && stack.peek() > x) {
				helperStack.push(stack.pop());
			}
			stack.push(x);
		}
	} // sortUsingAnotherStack

	// ---------------------------------------------------------------------------------------------
} // StackSort