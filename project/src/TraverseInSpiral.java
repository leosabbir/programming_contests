/* File:    TraverseInSpiral.java
 * Created: 2017-06-15
 * Author:  Sabbir Manandhar
 *
 * Copyright (c) 2017 Hogwarts.
 */

import java.util.Stack;

/**
 * Traverses a binary tree in Spiral Form from top to bottom
 *
 * @author Sabbir Manandhar
 * @version 1.0
 */
public class TraverseInSpiral {

  /**
   * internal class to represent node of the binary tree
   */
  public static class Node {
    Node left;
    Node right;
    int data;

    public Node(int data) {
      this.data = data;
    }

    public void print() {
      System.out.print(data + " ");
    }
  } // Node

  //----------------------------------------------------------------------------------

  /**
   * Traverses the given binary tree rooted at root node in spiral form
   * starting from the root node
   * @param root root node of the binary tree
   */
  public static void traverse(Node root) {
    if (root == null) {
      return;
    }

    Stack<Node> s1 = new Stack<Node>();
    Stack<Node> s2 = new Stack<Node>();
    s1.push(root);
    boolean toLeft = true;
    while (toLeft && !s1.empty() || !toLeft && !s2.empty()) {
      Node n = toLeft ? s1.pop() : s2.pop();
      n.print();
      if (toLeft) {
        if (n.right != null) s2.push(n.right);
        if (n.left != null) s2.push(n.left);
        if (s1.empty()) toLeft = false;
      } else {
        if (n.left != null) s1.push(n.left);
        if (n.right != null) s1.push(n.right);
        if (s2.empty()) toLeft = true;
      }
    }
  } // traverse

  //----------------------------------------------------------------------------------

  /**
   * driver method
   * @param args
   */
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(7);
    root.left.right = new Node(6);
    root.right.left = new Node(5);
    root.right.right = new Node(4);
    System.out.println("Spiral order traversal of Binary Tree is ");

    traverse(root);
  } // main

  //----------------------------------------------------------------------------------

} // TraverseInSpiral
