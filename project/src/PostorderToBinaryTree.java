

/*class Node {
  public int value;
  public Node left, right;

  public Node(int value) {
    this.value = value;
    this.left = this.right = null;
  }
}*/

public class PostorderToBinaryTree {

  // O(n^2)
  public static Node construct(int[] values, int from, int to) {
    if (to < from) {
      return null;
    } else if (to == from) {
      return new Node(values[to]);
    }
    Node root = new Node(values[to]);

    int i = to - 1;

    while(i >= from && root.value < values[i]) {
      if (i==from) {
        break;
      }
      i--;
    }
    root.left = construct(values, from, i);
    root.right = construct(values, i+1, to-1);

    return root;
  }

  public static void printInPostorder(Node root) {
    if (root == null) {
      return;
    }
    printInPostorder(root.left);
    System.out.println(root.value);
    printInPostorder(root.right);

  }

  public static Node construct(int values[]) {
    return construct(values, values.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }


  public static Node construct(int[] values, int index, int min, int max) {
    if (index < 0) {
      return null;
    }

    Node root = null;

    if (values[index] > min && values[index] < max) {
      root = new Node(values[index]);
      index = index - 1;
      if (index > 0) {
        root.left = construct(values, index - 1, min, values[index]);
        root.right = construct(values, index - 1, values[index], max);
      }
    }
    return root;

  }


  public static void main(String[] args) {
    int[] a = {2, 15, 10, 25, 39, 35, 30, 43,41, 46, 49, 47, 45, 40, 55, 65, 60, 80, 100, 90, 70, 50}; //{1, 7, 5, 50, 40, 10};
    Node root = construct(a);//construct(a, 0, a.length - 1);
    printInPostorder(root);
  }

}
