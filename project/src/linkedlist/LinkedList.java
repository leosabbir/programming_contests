package linkedlist;

public class LinkedList {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.insertTail(2);
		head.insertTail(3);
		head.insertTail(4);
		head.insertTail(5);
		head = head.delete(3);
		head.insertTail(6);
		head.insertTail(7);
		head.insertTail(8);
		head.insertTail(9);
		head.insertTail(10);
		head = head.delete(10);
		head.print();
		head.insertTail(1);
		head.print();
		head.ithItemFromLast(3);
	} // main
	
} // LinkedList

//----------------------------------------------------------------------------------------------------

/**
* Class representing node of linked list
*/
class Node {
	int value;
	Node next;

	/**
	* constructor
	*/
	public Node(int value) {
		this.value = value;
	} // Node

	//----------------------------------------------------------------------------------------------------

	/**
	* Inserts into the tail of the linked list
	*/
	public void insertTail(int value) {
		Node head = this;

		while (head.next != null) {
			head = head.next;
		}

		head.next = new Node(value);
	} // insertTail

	//----------------------------------------------------------------------------------------------------

	/**
	* Deletes the node with given value
	*/
	public Node delete(int value) {
		Node head = this;
		if (head.value == value) {
			head = head.next;
			return head;
		}

		while(head.next != null) {
			if (head.next.value == value) {
				head.next = head.next.next;
				return this;
			}
			head = head.next;
		}

		return this;
	} // delete

	//----------------------------------------------------------------------------------------------------

	/**
	* Prints the ith item node from the last node
	*/
	public void ithItemFromLast(int i) {
		ithItemFromLastRecursive(i, this);
	} // ithItemFromLast

	//----------------------------------------------------------------------------------------------------

	/**
	* Recursively the ith item node from last node and print
	*/
	private int ithItemFromLastRecursive(int i, Node node) {
		if (node == null) {
			return 0;
		}

		int count = ithItemFromLastRecursive(i, node.next);
		if (count == -1) {
			return -1;
		} else if (count+1 == i) {
			System.out.println(node.value);
			return -1;
		} else {
			return count + 1;
		}
	} // ithItemFromLastRecursive

	//----------------------------------------------------------------------------------------------------

	/**
	* print the linked list
	*/
	public void print() {
		Node head = this;

		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	} // print

	//----------------------------------------------------------------------------------------------------
} // Node