

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
	}
	
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
	}

	public static void printReverseRecursive(LinkedListNode head) {
		if (head == null) {
			return;
		}

		printReverseRecursive(head.next);
		System.out.println(head.value);

	}

}

class HeadTail {
	LinkedListNode head;
	LinkedListNode tail;

	public HeadTail(LinkedListNode head, LinkedListNode tail) {
		this.head = head;
		this.tail = tail;
	}
}

class LinkedListNode {
	LinkedListNode next;
	int value;

	public LinkedListNode(int value) {
		this.value = value;
	}

	public void insert(int value) {
		LinkedListNode head = this;

		while(head.next != null) {
			head = head.next;
		}
		head.next = new LinkedListNode(value);
		
	}

	public LinkedListNode clone() {
		return new LinkedListNode(value);
	}

	public void print() {
		LinkedListNode head = this;
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
}