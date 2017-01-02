package algo4th.sorting;


public class ShellSort extends AbstractSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        int interval = computeStartingInterval(array.length);

        while (interval >= 1) {
            for (int i = interval; i < array.length; ++i) {
                for (int j = i; j >= interval && less(array[j], array[j - interval]); j -= interval) {
                    swap(array, j, j - interval);
                }
            }
            interval /= 3;
        }
    }

    private static int computeStartingInterval(int arraySize) {
        int h = 1;
        while (h < arraySize / 3) {
            h = 3 * h + 1;
        }
        return h;
    }
}
