import java.util.Stack;

public class TreeTraversals {



  /**
  1. if root = null, return. Nothing to do
  2. initialize empty Stack
  3. push root into stack
  4. set current = current.left and push current into stack until current != null
  5. current = pop stack and visit it
  6. current = current.right and push to stack if current != null
  7.



  */
  public void inOrderWithoutRecursion(Node root) {
    if (root == null) {
      return;
    }
    Stack<Node> stack = new Stack<Node>();
    Node current = root;

    stack.push(current);
    do {
      while (current != null) {
        current = current.left;
        if (current != null) {
          stack.push(current);
        }
      }

      if (!stack.isEmpty()) {
        current = stack.pop();
        current.print();
        current = current.right;
        if (current != null) {
          stack.push(current);
        }
      }
    } while (!stack.isEmpty());

    System.out.println();
  }

  public void postOrderWithoutRecursion(Node root) {
    if (root == null) {
      return;
    }
    Stack<Node> stack = new Stack<Node>();
    Node current = root;

    while (current != null) {
      stack.push(current);
      current = current.left;
    }

    while (!stack.isEmpty()) {
      current = stack.pop();
      Node toVisit = current;

      current = current.right;
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      toVisit.print();
    }

    System.out.println();
  }

  /***
                          20
                 10                      30
            5          15           25          35
        2     7    12    17      22   27     32    37
  **/

  public static void main(String[] args) {
      Node root = new Node(20);
      root.left = new Node(10);
      root.right = new Node(30);
      root.left.left = new Node(5);
      root.left.right = new Node(15);
      root.left.left.left = new Node(2);
      root.left.left.right = new Node(7);
      root.left.right.left = new Node(12);
      root.left.right.right = new Node(17);

      root.right.left = new Node(25);
      root.right.right = new Node(35);

      root.right.left.left = new Node(22);
      root.right.left.right = new Node(27);

      root.right.right.left = new Node(32);
      root.right.right.right = new Node(37);

      TreeTraversals traverse = new TreeTraversals();
      traverse.inOrderWithoutRecursion(root); //2 5 7 10 12 15 17 20 22 25 27 30 32 35 37

      traverse.postOrderWithoutRecursion(root);//  2 7 5 12 17 15 10 22 27 25 32 37 35 30 20
  }

}

class Node {
  public Node left, right;
  public int value;

  public Node(int value) {
    this.value = value;
  }

  public void print() {
    System.out.print(value + " ");
  }
}
