package pathwithsum;

public class PathsWithSum {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(-3);
		
		root.left.left = new Node(3);
		root.left.right = new Node(2);
		root.right.right = new Node(11);

		root.left.left.left = new Node(3);
		root.left.left.right = new Node(-2);
		root.left.right.right = new Node(1);

		root.left.right.right.right = new Node(5);
		
		System.out.println(countPaths(root, 8));
	}


	public static int countPaths(Node root, int targetSum) {
		if (root == null) {
			return 0;
		}

		int rootPathsCount = countPathWithSumFromNode(root, targetSum, 0);
		int leftPathsCount = countPaths(root.left, targetSum);
		int righttPathsCount = countPaths(root.right, targetSum);

		return rootPathsCount + leftPathsCount + righttPathsCount;
	}



	public static int countPathWithSumFromNode(Node node, int targetSum, int currentSum) {
		if (node == null) {
			return 0;
		}

		currentSum += node.value;
		int totalPaths = 0;
		if (currentSum == targetSum) {
			totalPaths++;
		}

		totalPaths += countPathWithSumFromNode(node.left, targetSum, currentSum);
		totalPaths += countPathWithSumFromNode(node.right, targetSum, currentSum);

		return totalPaths;
	}
	
}


class Node {
	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
	}
}