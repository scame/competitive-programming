package algo4th.sorting;

public class SelectionSort extends AbstractSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 0; i < array.length; i++) {
            int minInd = i;

            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[minInd])) {
                    minInd = j;
                }
            }
            swap(array, minInd, i);
        }
    }
}
