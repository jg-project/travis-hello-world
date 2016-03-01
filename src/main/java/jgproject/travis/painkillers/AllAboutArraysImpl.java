package jgproject.travis.painkillers;

import jgproject.travis.lecture_two.Sorter;
import jgproject.travis.lecture_two.SorterImpl;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class AllAboutArraysImpl implements AllAboutArrays {

    ThreadLocalRandom rnd;

    @Override
    public int[] createArray(int size) {
        return new int[size];
    }

    @Override
    public void fillWithRandomNumbers(int[] arr) {
        ThreadLocalRandom randomElement = ThreadLocalRandom.current();
        for (int i=0; i<arr.length; i++ ) {
            arr[i] =  randomElement.nextInt();
        }
    }

    @Override
    public void fillWithParticularNumber(int[] arr, int sample) {
        Arrays.fill(arr, sample);
    }

    private int getSum(int[] arr) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum = sum+arr[i];
        }
        return sum;
    }

    @Override
    public double getAggregate(int arr[], AggregationType aggregation) {
        switch(aggregation) {
            case CNT:
               return arr.length;
            case SUM:
                return getSum(arr);
            case AVG:
                return (double)getSum(arr) / (double)arr.length;
            case MIN:
                sort(arr);
                return arr[0];
            case MAX:
                sort(arr);
                return arr[arr.length-1];
            case MEDIAN:
                if (arr.length % 2 == 0) {
                    return (arr[arr.length/2-1] + arr[arr.length/2])/2;
                }
                else {
                    return arr[arr.length/2];
                }
            case VARIANCE:
                double sumArr = 0;
                for (int i=0; i < arr.length; i++) {
                    sumArr = Math.pow(arr[i] - (double)getSum(arr)/(double)arr.length, 2)+sumArr;
                }
                return sumArr/arr.length;
        }
        return 0;
    }

    @Override
    public void copyArrays(int[] src, int pos, int[] dest, int startPos, int size) {
        for (int i=0; i < size; i++) {
            dest[startPos+i] = src[pos+i];
        }
    }

    @Override
    public void reverseArray(int[] arr) {
        int interim = 0;
        for (int i=0; i<arr.length/2 +1; i++) {
            interim = arr[i];
            arr[i] = arr[arr.length - i-1];
            arr[arr.length - i-1] = interim;
        }
    }

    @Override
    public int[][] transpose(int[][] matrix) {
        int[] innerArray = matrix[matrix.length-1];
        int[][] transposedArr = new int[innerArray.length][matrix.length];
        for (int i=0; i < innerArray.length; i++) {
            for (int j=0; j < matrix.length; j++) {
                transposedArr[i][j] = matrix [j][i];
            }
        }
        return transposedArr;
    }

    @Override
    public int[] subarray(int[] src, int from, int to) {
        int[] subArray = new int[to-from+1];
        for (int i=0; i< to-from+1; i++) {
           subArray[i] = src[from+i-1];
        }
        return subArray;
    }

    @Override
    public void sort(int[] arr) {
        Sorter sorter = new SorterImpl();
        sorter.sort(arr);
    }

    @Override
    public int findEntryIndex(int[] arr, int whatToFind) {
        boolean flagEntry = false;
        int i=0;
        while (!flagEntry) {
            if (arr[i] == whatToFind) {
                flagEntry = true;
            }
            i++;
        }
        return i;
    }

    @Override
    public int[] removeDuplicates(int[] arr) {
        List<Integer> arrList = new ArrayList<Integer>();
        for (int i : arr) {
            if(!arrList.contains(i)) {
                arrList.add(i);
            }
        }
        int[] resultArr = new int[arrList.size()];
        for (int i=0; i < arrList.size(); i++) {
            resultArr[i] = arrList.get(i);
        }
        return resultArr;
    }
}
