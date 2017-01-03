package algo4th.sorting;


public class TopDownMergeSort extends AbstractMergeSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        T[] aux = (T[]) new Comparable[array.length];
        sort(aux, array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] aux, T[] array, int lowerBound, int higherBound) {
        if (higherBound <= lowerBound) return;

        int middle = lowerBound + (higherBound - lowerBound) / 2;

        sort(aux, array, lowerBound, middle);
        sort(aux, array, middle + 1, higherBound);
        merge(aux, array, lowerBound, middle, higherBound);
    }
}
