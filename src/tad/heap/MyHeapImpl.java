package tad.heap;

import java.util.Arrays;

public class MyHeapImpl<T extends Comparable<T>> implements MyHeap<T> {

	private static final int CAPACITY = 2;

	private int size; // Number of elements in heap
	private T[] heap; // The heap array
    private boolean isHeapMin = true;

	public MyHeapImpl() {
	    this(true);
	}

    public MyHeapImpl(boolean isHeapMin) {
        size = 0;
        heap = (T[]) new Comparable[CAPACITY];
        this.isHeapMin = isHeapMin;
    }

	public MyHeapImpl(int capacity) {
	    this(capacity, true);
	}

    public MyHeapImpl(int capacity, boolean isHeapMin) {
        size = 0;
        heap = (T[]) new Comparable[capacity + 1];
        this.isHeapMin = isHeapMin;
	}

	/**
	 * Construct the binary heap given an array of items.
	 */
	public MyHeapImpl(T[] array) {
	    this(array, true);
	}

    /**
     * Construct the binary heap given an array of items.
     */
    public MyHeapImpl(T[] array, boolean isHeapMin) {
        this.isHeapMin = isHeapMin;
        size = array.length;
        heap = (T[]) new Comparable[array.length + 1];

        System.arraycopy(array, 0, heap, 1, array.length);// we do not use 0
        // index

        buildHeap();
    }

	/**
	 * runs at O(size)
	 */
	private void buildHeap() {
		for (int k = size / 2; k > 0; k--) {
			percolatingDown(k);
		}
	}

	private void percolatingDown(int k) {
		T tmp = heap[k];
		int child;

		for (; 2 * k <= size; k = child) {
			child = 2 * k;

			if (child != size && (isHeapMin ? heap[child].compareTo(heap[child + 1]) > 0 : !(heap[child].compareTo(heap[child + 1]) > 0)))
				child++;

			if (isHeapMin ? tmp.compareTo(heap[child]) > 0 : !(tmp.compareTo(heap[child]) > 0))
				heap[k] = heap[child];
			else
				break;
		}
		heap[k] = tmp;
	}

	
	/**
	 * Deletes the top item
	 */
	public T delete() throws RuntimeException {
		if (size == 0)
			throw new RuntimeException();
		T min = heap[1];
		heap[1] = heap[size--];
		percolatingDown(1);
		return min;
	}
	
	@Override
	public T get() {
		if (size == 0)
			throw new RuntimeException();
		T min = heap[1];
		return min;
	}

	/**
	 * Inserts a new item
	 */
	public void insert(T x) {
		if (size == heap.length - 1)
			doubleSize();

		// Insert a new item to the end of the array
		int pos = ++size;

		// Percolate up
		for (; pos > 1 && (isHeapMin ? x.compareTo(heap[pos / 2]) < 0 : !(x.compareTo(heap[pos / 2]) < 0)); pos = pos / 2)
			heap[pos] = heap[pos / 2];

		heap[pos] = x;
	}

	private void doubleSize() {
		T[] old = heap;
		heap = (T[]) new Comparable[heap.length * 2];
		System.arraycopy(old, 1, heap, 1, size);
	}

	public String toString() {
		String out = "";
		for (int k = 1; k <= size; k++)
			out += heap[k] + " ";
		return out;
	}

	public int size() {
		return size;
	}

	/**
	 * Busca un elemento en el heap.
	 * @param element Elemento a buscar
	 * @return El elemento encontrado, o null si no se encuentra
	 */
	public T search(T element) {
		for (int i = 1; i <= size; i++) {
			if (heap[i].equals(element)) {
				return heap[i];
			}
		}
		return null;
	}

	@Override
	public MyHeapImpl<T> clone() {
		MyHeapImpl<T> clonedHeap = new MyHeapImpl<>(this.heap.length - 1, this.isHeapMin);
		clonedHeap.size = this.size;
		clonedHeap.heap = Arrays.copyOf(this.heap, this.heap.length);
		return clonedHeap;
	}

}