package jgproject.travis.painkillers;

public interface AllAboutArrays {

    int[] createArray( int size);

    void fillWithRandomNumbers(int[] arr);

    void fillWithParticularNumber(int[] arr, int sample);

    double getAggregate(int[] arr, AggregationType aggregation);

    void copyArrays(int[] src, int pos, int[] dest, int startPos, int size);

    void reverseArray(int[] arr);

    int[][] transpose(int[][] matrix);

    int[] subarray(int[] src, int from, int to);

    void sort(int[] arr);

    int findEntryIndex(int[] arr, int whatToFind);

    int[] removeDuplicates(int[] arr);

    enum AggregationType {
        MIN, MAX, AVG, SUM, CNT, MEDIAN, VARIANCE
    }


}
