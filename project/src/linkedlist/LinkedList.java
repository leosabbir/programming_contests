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
	}
	
}

class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
	}

	public void insertTail(int value) {
		Node head = this;

		while (head.next != null) {
			head = head.next;
		}

		head.next = new Node(value);
	}

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
	}

	public void print() {
		Node head = this;

		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}