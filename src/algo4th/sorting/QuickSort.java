package algo4th.sorting;


import static algo4th.Utility.shuffleArray;

public class QuickSort extends AbstractSort {


    public static <T extends Comparable<T>> void sort(T[] array) {
        shuffleArray(array);
        sort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] array, int lowerBound, int higherBound) {
        if (lowerBound >= higherBound) return;

        int partitionInd = partition(array, lowerBound, higherBound);
        sort(array, lowerBound, partitionInd - 1);
        sort(array, partitionInd + 1, higherBound);
    }

    private static <T extends Comparable<T>> int partition(T[] array, int lowerBound, int higherBound) {
        T pivotValue = array[lowerBound];
        int i = lowerBound;
        int j = higherBound + 1;

        while (true) {
            while (less(array[++i], pivotValue)) if (i >= higherBound) break;
            while (less(pivotValue, array[--j]));
            if (i >= j) break;

            swap(array, i, j);
        }
        swap(array, lowerBound, j);

        return j;
    }
}
