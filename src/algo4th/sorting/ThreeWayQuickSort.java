package algo4th.sorting;


import static algo4th.Utility.shuffleArray;

public class ThreeWayQuickSort extends AbstractSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        shuffleArray(array);
        sort(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void sort(T[] array, int lowerBound, int higherBound) {
        if (higherBound <= lowerBound) return;

        int lessPointer = lowerBound;
        int equalsPointer = lowerBound + 1;
        int greaterPointer = higherBound;
        T pivotVal = array[lowerBound];

        while (equalsPointer <= greaterPointer) {
            int cmp = array[equalsPointer].compareTo(pivotVal);

            if (cmp < 0) {
                swap(array, lessPointer++, equalsPointer++);
            } else if (cmp > 0) {
                swap(array, equalsPointer, greaterPointer--);
            } else {
                ++equalsPointer;
            }
        }

        sort(array, lowerBound, equalsPointer - 1);
        sort(array, greaterPointer + 1, higherBound);
    }
}
