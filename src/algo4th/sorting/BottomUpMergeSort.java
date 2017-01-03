package algo4th.sorting;


public class BottomUpMergeSort extends AbstractMergeSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        int N = array.length;
        T[] aux = (T[]) new Comparable[N];

        for (int size = 1; size < N; size *= 2) {
            for (int subarrayInd = 0; subarrayInd < N - size; subarrayInd += size * 2) {
                merge(aux, array, subarrayInd, subarrayInd + size - 1, Math.max(subarrayInd + size * 2 - 1, N -1));
            }
        }
    }
}
