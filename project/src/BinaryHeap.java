


public class BinaryHeap {

	int[] data;
	int size;

	public static void main(String[] args) {
		BinaryHeap heap = new BinaryHeap();
		heap.getMin();
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(40);
		heap.getMin();
		heap.getMin();
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(40);
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.insert(100);
		heap.insert(100);
		heap.insert(100);
		heap.insert(100);
		heap.insert(100);
		heap.insert(100);
		heap.insert(100);
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.getMin();
		heap.insert(100);heap.insert(10);heap.insert(50);heap.insert(25);heap.insert(35);heap.insert(75);heap.insert(1);heap.insert(15);heap.insert(1);heap.insert(0);heap.insert(90);
		heap.getMin();heap.getMin();heap.getMin();heap.getMin();heap.getMin();heap.getMin();heap.getMin();heap.getMin();heap.getMin();heap.getMin();heap.getMin();heap.getMin();
	}

	public BinaryHeap() {
		this.data = new int[1000];
		this.size = 0;
	}

	public int getMin() {
		if (size == 0) {
			System.out.println("EMPTY");
			return -1;
		}
		int min = this.data[0];
		this.data[0] = this.data[--this.size];
		this.bubbleDown(0);
		System.out.println(min);
		return min;
	}

	public void insert(int item) {
		if (size == 1000) {
			System.out.println("FULL");
			return;			
		}
		this.data[size++] = item;
		this.bubbleUp(size-1);
	}

	public void bubbleDown(int idx) {

		while (idx < size) {
			int leftChild = 2 * idx + 1;
			int rightChild = leftChild + 1;

			if (leftChild >= size) {
				return;
			}

			int smallerChild = leftChild;
			if (rightChild < size) {
				if (this.data[rightChild] < this.data[leftChild]) {
					smallerChild = rightChild;
				}
			}

			if (this.data[idx] <= this.data[smallerChild]) {
				return;
			} else {
				this.swap(idx, smallerChild);
				idx = smallerChild;
			}
		}
	}

	public void bubbleUp(int idx) {
		int parent = ((idx + 1) / 2) - 1;

		while (parent > 0 && this.data[idx] < this.data[parent]) {
			this.swap(idx, parent);
			idx = parent;
			parent = ((parent + 1) / 2) - 1;
		}
	}

	public void swap(int i, int j) {
		int temp = this.data[i];
		this.data[i] = this.data[j];
		this.data[j] = temp;
	}

	
}