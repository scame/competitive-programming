package algo4th.sorting;


public abstract class AbstractMergeSort extends AbstractSort {

    public static <T extends Comparable<T>> void merge(T[] aux, T[] source, int lowerBound, int middle, int higherBound) {
        int i = lowerBound;
        int j = middle + 1;

        System.arraycopy(source, lowerBound, aux, lowerBound, higherBound - lowerBound + 1);

        for (int k = lowerBound; k <= higherBound; k++) {
            if (i > middle) {
                source[k] = aux[j++];
            } else if (j > higherBound) {
                source[k] = aux[i++];
            } else if (less(aux[i], aux[j])) {
                source[k] = aux[i++];
            } else {
                source[k] = aux[j++];
            }
        }
    }
}
