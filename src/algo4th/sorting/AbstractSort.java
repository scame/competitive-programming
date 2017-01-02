package algo4th.sorting;


abstract class AbstractSort {

    static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static <T extends Comparable<T>> boolean less(T first, T second) {
        return first.compareTo(second) < 0;
    }
}
