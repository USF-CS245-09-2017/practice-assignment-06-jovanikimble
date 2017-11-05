
/**
 * A class that implements a priority queue using a Binary Heap - specifically a
 * Min Heap.
 * 
 * @author jovanikimble
 *
 */
public class BinaryHeap {

	int[] heap;
	int size;

	public BinaryHeap() {
		heap = new int[10];
		size = 0;
	}

	/**
	 * Adds an int instance to the priority queue.
	 * 
	 * @param priority
	 *            priority of element to add to the heap
	 */
	public void add(int priority) {

		if (size >= heap.length) {
			growHeap();
		}

		heap[size] = priority;
		bubbleUp(size);
		size++;

	}

	/**
	 * Removes the highest priority item
	 * 
	 * @return the priority/data of item of highest priority
	 */
	public int remove() {
		if (empty()) {
			System.out.println("Exception: Priority Queue is empty");
			return -1;

			/*
			 * Not sure what to put here Exception wise. The test do not support
			 * the throwing of exceptions for the remove method.
			 */
		}

		int priority = heap[0];
		swap(0, --size);
		if (size != 0) {
			bubbleDown(0);
		}

		return priority;
	}

	/**
	 * Returns whether heap is empty
	 * 
	 * @return true if priority queue is empty
	 */
	public boolean empty() {
		return size == 0;
	}

	/**
	 * Bubbles up items in the list if value is less than parent in order to
	 * maintain the structure of the min heap.
	 * 
	 * @param pos
	 *            position to bubble up.
	 */
	public void bubbleUp(int pos) {
		while (heap[pos] < heap[parent(pos)]) {
			swap(pos, parent(pos));
			pos = parent(pos);

		}
	}

	/**
	 * Bubbles down items in the heap if item has a greater value than children
	 * in order to maintain the structure of the min heap
	 * 
	 * @param pos
	 *            position to bubble down
	 */
	public void bubbleDown(int pos) {
		if (leftChild(pos) >= size) {
			return;
		}

		int child = leftChild(pos);
		if (rightChild(pos) < size && heap[rightChild(pos)] < heap[child]) {
			child = rightChild(pos);
		}

		if (heap[child] < heap[pos]) {
			swap(child, pos);
			bubbleDown(child);
		}
	}

	/**
	 * Function to return the parent to the current position.
	 * 
	 * @param pos
	 *            current position
	 * @return position of parent within the heap
	 */
	public int parent(int pos) {
		return (pos - 1) / 2;
	}

	/**
	 * Function to return the left child to the current position.
	 * 
	 * @param pos
	 *            current position
	 * @return position of parent within the heap
	 */
	public int leftChild(int pos) {
		return (2 * pos) + 1;
	}

	/**
	 * Function to return the right child to the current position.
	 * 
	 * @param pos
	 *            current position
	 * @return position of parent within the heap
	 */
	public int rightChild(int pos) {
		return (2 * pos) + 2;
	}

	/**
	 * Exchanges data in between two positions
	 * 
	 * @param pos1
	 *            first position
	 * @param pos2
	 *            second position
	 */
	public void swap(int pos1, int pos2) {

		int temp = heap[pos1];
		heap[pos1] = heap[pos2];
		heap[pos2] = temp;
	}

	/**
	 * Grows the size of the heap if capacity is reached
	 */
	public void growHeap() {
		int[] temp = new int[size * 2];

		for (int i = 0; i < size; i++) {
			temp[i] = heap[i];
		}
		heap = temp;
	}

}
