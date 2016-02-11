package jgproject.travis.lecture_two;

public class heap {

    public static void sort(int[] youx) {
        int N = youx.length;
        for (int k = N/2; k >= 1; k--)
            sink(youx, k, N);
        while (N > 1) {
            exch(youx, 1, N--);
            sink(youx, 1, N);
        }
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private static void sink(int[] youx, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(youx, j, j+1)) j++;
            if (!less(youx, k, j)) break;
            exch(youx, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(int[] youx, int i, int j) {
        return youx[i-1] < (youx[j-1]);
    }

    private static void exch(int[] youx, int i, int j) {
        int swap = youx[i-1];
        youx[i-1] = youx[j-1];
        youx[j-1] = swap;
    }

    // is v < w ?
    private static boolean less(int v, int w) {
        return v < w;
    }


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
}
