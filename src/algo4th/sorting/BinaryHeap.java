package algo4th.sorting;


public class BinaryHeap extends AbstractSort {

    static <T extends Comparable<T>> void swim(T[] array, int k) {
        while (k > 1 && less(array[k / 2], array[k])) {
            swap(array, k / 2, k);
            k /= 2;
        }
    }

    static <T extends Comparable<T>> void sink(T[] array, int k, int N) {
        while (k  * 2 <= N) {
            int childInd = k  * 2;

            if (childInd < N && less(array[childInd], array[childInd + 1])) ++childInd;
            if (!less(array[k], array[childInd])) break;
            swap(array, k, childInd);
            k = childInd;
        }
    }
}
