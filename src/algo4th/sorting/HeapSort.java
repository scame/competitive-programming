package algo4th.sorting;

// sorts array[1] .. array[N - 1] items

public class HeapSort extends BinaryHeap {

    public static <T extends Comparable<T>> void sort(T[] array) {
        constructHeap(array);
        sortdown(array);
    }

    private static <T extends Comparable<T>> void constructHeap(T[] array) {
        int k = array.length / 2;

        while (k >= 1) {
            sink(array, k--, array.length - 1);
        }
    }

    private static <T extends Comparable<T>> void sortdown(T[] array) {
        int N = array.length;

        while (N > 1) {
            swap(array, 1, --N);
            sink(array, 1, N - 1);
        }
    }
}
