package algo4th.sorting;


public class MaxPriorityQueue<T extends Comparable<T>> extends BinaryHeap {

    private T[] array;
    private int N;

    public MaxPriorityQueue(int size) {
        array = (T[]) new Comparable[size + 1];
    }

    public void insert(T item) {
        array[++N] = item;
        swim(array, N);
    }

    public T delMax() {
        T max = array[1];
        array[1] = array[N--];
        array[N + 1] = null;
        sink(array, 1, N);

        return max;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }
}
