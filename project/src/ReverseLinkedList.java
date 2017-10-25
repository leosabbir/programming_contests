

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(1);
		head.insert(2);
		head.insert(3);
		head.insert(4);
		head.insert(5);
		head.insert(6);
		head.insert(7);
		head.insert(4);
		head.insert(3);
		head.insert(2);
		head.insert(1);
		head.insert(99);
		head.insert(100);

		printReverseRecursive(head);

		head.print();
		LinkedListNode reversed = reverse(head).head;
		System.out.println();
		reversed.print();

		reversed = reverseRecursive2(head);
		System.out.println();
		reversed.print();

		reversed = reverseIterative(reversed);
		System.out.println();
		reversed.print();
	} // main

	//----------------------------------------------------------------------------------------------------
	
	/** 
	* Reverses the given linked list
	* This creates new linked list, original remains unchanged
	*/
	public static HeadTail reverse(LinkedListNode head) {
		if (head == null) {
			return null;
		}

		HeadTail ht = reverse(head.next);
		LinkedListNode newHead;
		LinkedListNode newTail;
		if (ht == null) {
			newHead = head.clone();
			newTail = newHead;
		} else {
			newHead = ht.head;
			newTail = head.clone();
			ht.tail.next = newTail;
		}
		return new HeadTail(newHead, newTail);
	} // reverse

	//----------------------------------------------------------------------------------------------------

	/**
	* Recursively print the linked list in reverse order
	*/
	public static void printReverseRecursive(LinkedListNode head) {
		if (head == null) {
			return;
		}

		printReverseRecursive(head.next);
		System.out.println(head.value);
	}

	//----------------------------------------------------------------------------------------------------

	/**
	* Reverses the given linked list.
	* Easier than above method
	* Modifies the original linked list
	*/
	public static LinkedListNode reverseRecursive2(LinkedListNode head) {
		return printReverseRecursive2Helper(head, null);
	}

	//----------------------------------------------------------------------------------------------------

	/**
	* Recursively reverses the linked list
	*/
	public static LinkedListNode reverseRecursive2Helper(LinkedListNode current, LinkedListNode prev) {
		if (current == null) {
			return prev;
		}

		LinkedListNode next = current.next;
		current.next = prev;
		return reverseRecursive2Helper(next, current);
	} // reverseRecursive2Helper

	//----------------------------------------------------------------------------------------------------

	/**
	* Iteratively reverses the given linked list.
	*/
	public static LinkedListNode reverseIterative(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode next = null;
		LinkedListNode current = head;

		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;
	} // reverseIterative

	//----------------------------------------------------------------------------------------------------

} // ReverseLinkedList

//----------------------------------------------------------------------------------------------------

class HeadTail {
	LinkedListNode head;
	LinkedListNode tail;

	public HeadTail(LinkedListNode head, LinkedListNode tail) {
		this.head = head;
		this.tail = tail;
	}
} // HeadTail

//----------------------------------------------------------------------------------------------------

class LinkedListNode {
	LinkedListNode next;
	int value;

	//----------------------------------------------------------------------------------------------------

	/**
	* Constructor
	*/
	public LinkedListNode(int value) {
		this.value = value;
	} // LinkedListNode

	//----------------------------------------------------------------------------------------------------

	/**
	* insert at the tail
	*/
	public void insert(int value) {
		LinkedListNode head = this;

		while(head.next != null) {
			head = head.next;
		}
		head.next = new LinkedListNode(value);
	} // insert

	//----------------------------------------------------------------------------------------------------

	/**
	* Clone the node
	*/
	public LinkedListNode clone() {
		return new LinkedListNode(value);
	} // clone

	//----------------------------------------------------------------------------------------------------

	/**
	* Print from current node to tail
	*/
	public void print() {
		LinkedListNode head = this;
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	} // print

} // LinkedListNode