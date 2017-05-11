

public class IsBalancedTree {

	// O(n^2) time
	/**public static int getHeight(Node root) {
		if (root ==  null) {
			return 0;
		} else {
			return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
		}
	}

	public static boolean isBlanced(Node root) {
		if (root == null) {
			return true;
		}

		int diff = Math.abs(getHeight(root.left) - getHeight(root.right));
		if (diff > 1) {
			return false;
		}

		return isBlanced(root.left) && isBlanced(root.right);
	}**/


	// O(n) time
	public static int getHeight(Node root) {
		if (root ==  null) {
			return 0;
		} else {
			int leftHeight = getHeight(root.left);
			if (leftHeight == -1) { // not balanced
				return -1;
			}

			int rightHeight = getHeight(root.right);
			if (rightHeight == -1) { // not balanced
				return -1;
			}

			int diff = leftHeight - rightHeight;
			if (Math.abs(diff) > 1) {
				return -1; // not balanced
			}
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static boolean isBlanced(Node root) {
		if (root == null) {
			return true;
		}

		int height = getHeight(root);
		if (height == -1) {
			return false;
		}
		return true;
	}
	

}

class Node {
	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
	}
}