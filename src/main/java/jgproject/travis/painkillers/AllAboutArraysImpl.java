package jgproject.travis.painkillers;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class AllAboutArraysImpl implements AllAboutArrays {

    ThreadLocalRandom rnd;

    @Override
    public int[] createArray(int size) {

        return new int[size];
    }

    @Override
    public void fillWithRandomNumbers(int[] arr) {
        Random random = new Random();
        for(int i = 0; i < arr.length; i++ ){
            arr[i] = random.nextInt();
        }
    }

    @Override
    public void fillWithParticularNumber(int[] arr, int sample) {
        for(int i = 0; i < arr.length; i++ ){
            arr[i] = sample;
        }
    }

    @Override
    public double getAggregate(int arr[], AggregationType aggregation) {

             switch (aggregation) {
                 case MIN:
                     int min = arr[0];
                     for (int i = 0; i < arr.length; i++) {
                         if (min > arr[i]) {
                             min = arr[i];
                         }
                     }
                     return min;

                 case MAX:
                     int max = arr[0];
                     for (int i = 0; i < arr.length; i++) {
                         if (max < arr[i]) {
                             max = arr[i];
                         }
                     }
                     return max;

                 case AVG:
                     return sumMethod(arr) / arr.length;

                 case SUM:
                     return sumMethod(arr);


                 case CNT:
                     return arr.length;

                 case MEDIAN:
                     int[] arr1 = Arrays.copyOf(arr, arr.length);
                     Arrays.sort(arr1);
                         if(arr1.length%2 != 0){
                             return arr1[(arr1.length/2)];
                         }else {
                             return (arr1[arr1.length/2] + arr1[(arr1.length/2)-1])/2;
                         }

                 case VARIANCE:
                     double tmp = 0;
                     double avr = sumMethod(arr) / arr.length;
                     for(int i = 0; i < arr.length; i++ ){
                        tmp += Math.pow((arr[i] - avr),2);
                     }
                     return tmp/(arr.length);

             }

        return 0;

    }

    public double sumMethod(int []arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum;
    }

    @Override
    public void copyArrays(int[] src, int pos, int[] dest, int startPos, int size) {
        int j = startPos;
        for(int i = pos ; i <pos+size; i++, j++){
                dest[j] = src[i];
        }
    }

    @Override
    public void reverseArray(int[] arr) {
        int tmp;
        for(int i = 0; i <= arr.length-1-i; i++){
            tmp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = tmp;
        }
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
