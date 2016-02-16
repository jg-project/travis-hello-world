package jgproject.travis.painkillers;

import java.util.concurrent.ThreadLocalRandom;

public class AllAboutArraysImpl implements AllAboutArrays {

    ThreadLocalRandom rnd;

    @Override
    public int[] createArray(int size) {
        return new int[0];
    }

    @Override
    public void fillWithRandomNumbers(int[] arr) {
    }

    @Override
    public void fillWithParticularNumber(int[] arr, int sample) {
    }

    @Override
    public double getAggregate(int arr[], AggregationType aggregation) {
        return 0;
    }

    @Override
    public void copyArrays(int[] src, int pos, int[] dest, int startPos, int size) {
    }

    @Override
    public void reverseArray(int[] arr) {
    }

    @Override
    public int[][] transpose(int[][] matrix) {
        return new int[0][];
    }

    @Override
    public int[] subarray(int[] src, int from, int to) {
        return new int[0];
    }

    @Override
    public void sort(int[] arr) {

    }

    @Override
    public int findEntryIndex(int[] arr, int whatToFind) {
        return 0;
    }

    @Override
    public int[] removeDuplicates(int[] arr) {
        return new int[0];
    }
}
