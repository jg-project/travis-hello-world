package jgproject.travis.painkillers;

import jgproject.travis.lecture_two.Merge;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.out;

public class AllAboutArraysImpl implements AllAboutArrays {

    ThreadLocalRandom rnd;

    @Override
    public int[] createArray ( int size ) {

        return new int[ size ];
    }

    @Override
    public void fillWithRandomNumbers ( int[] arr ) {
        Random rand = new Random ( );

        for ( int i = 0 ; i < arr.length ; i++ ) {
            arr[ i ] = rand.nextInt ( );
            out.println ( arr[ i ] );
        }
    }

    @Override
    public void fillWithParticularNumber ( int[] arr, int sample ) {
        for ( int i = 0 ; i < arr.length ; i++ ) {
            arr[ i ] = sample;
            out.println ( arr[ i ] );
        }
    }

    @Override
    public double getAggregate ( int arr[], AggregationType aggregation ) {
        long sum = 0;
        switch (aggregation) {
            case CNT:
                return arr.length;
            case MAX:
                return getMax ( arr );
            case MIN:
                return getMin ( arr );
            case SUM:
                return getSum ( arr );
            case AVG:
                return getAvg ( arr, sum );
            case MEDIAN:
                return getMed ( arr );

            case VARIANCE:
                return getVar ( arr );

            default:
                return 0;
        }
    }

    private double getVar ( int[] arr ) {
        double tmp = 0;
        double avr = getSum ( arr ) / arr.length;
        for ( int i = 0 ; i < arr.length ; i++ ) {
            tmp += Math.pow ( (arr[ i ] - avr), 2 );
        }
        return tmp / (arr.length);
    }

    private double getMed ( int[] arr ) {
        int[] arr1 = Arrays.copyOf ( arr, arr.length );
        Arrays.sort ( arr1 );
        if ( arr1.length % 2 != 0 ) {
            return arr1[ (arr1.length / 2) ];
        } else {
            return (arr1[ arr1.length / 2 ] + arr1[ (arr1.length / 2) - 1 ]) / 2;
        }
    }

    private double getAvg ( int[] arr, long sum ) {
        double average;
        average = getSum ( arr ) / arr.length;
        System.out.print ( sum );
        System.out.print ( average );
        return average;
    }

    private double getSum ( int[] arr ) {
        long sum;
        int i;
        sum = 0;
        for ( i = 0; i < arr.length ; i++ ) {
            sum = sum + arr[ i ];
        }
        return sum;
    }

    private double getMax ( int[] arr ) {
        int maxIndex = 0;
        for ( int i = 1 ; i < arr.length ; i++ ) {
            if ( arr[ i ] > arr[ maxIndex ] ) {
                maxIndex = i;
            }
        }
        return arr[ maxIndex ];
    }

    private double getMin ( int[] arr ) {
        int minIndex = 0;
        for ( int i = 1 ; i < arr.length ; i++ ) {
            if ( arr[ i ] < arr[ minIndex ] ) {
                minIndex = i;
            }
        }
        return arr[ minIndex ];
    }

    @Override
    public void copyArrays ( int[] src, int pos, int[] dest, int startPos, int size ) {
        int srcIndex = pos;
        int destIndex = startPos;

        for ( ; srcIndex < pos + size ; ) {
            dest[ destIndex++ ] = src[ srcIndex++ ];
        }
    }

    @Override
    public void reverseArray ( int[] arr ) {
        revArr ( arr );
    }

    private void revArr ( int[] arr ) {
        int j = (arr.length - 1);
        for ( int i = 0 ; i < (int) arr.length / 2 ; i++ ) {
            int k = arr[ i ];
            arr[ i ] = arr[ j - i ];
            arr[ j - i ] = k;
        }
    }

    @Override
    public int[][] transpose ( int[][] matrix ) {
        int width = matrix.length;
        int height = matrix[ 0 ].length;
        int[][] result = new int[ height ][];
        for ( int i = 0 ; i < height ; i++ ) {
            result[ i ] = new int[ width ];
        }

        for ( int i = 0 ; i < width ; i++ ) {
            for ( int j = 0 ; j < height ; j++ ) {
                result[ j ][ i ] = matrix[ i ][ j ];
            }
        }
        return result;
    }

    @Override
    public int[] subarray ( int[] src, int from, int to ) {
        int[] subArr = new int[ to - from + 1 ];
        for ( int i = 0 ; i <= to - from ; i++ ) {
            subArr[ i ] = src[ from + i ];
//            for (int j = 0; j != to; j++ ){
//            subArr[ j ] = src [i];
//        }
        }

        return subArr;
    }

    @Override
    public void sort ( int[] arr ) {
        Merge.sort ( arr );
    }

    @Override
    public int findEntryIndex ( int[] arr, int whatToFind ) {
        for ( int i = 0 ; i < arr.length-1 ; i++ ) {
            if ( arr[ i ] == whatToFind ) {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int[] removeDuplicates ( int[] arr ) {
        Set<Integer> uniq = new TreeSet<> ( );

        for ( int m : arr ) {
            uniq.add ( m );
        }

        int[] larr = new int[ uniq.size ( ) ];

        int i = 0;
        for ( Integer n : uniq ) {
            larr[ i++ ] = n;
        }

        return larr;
    }
}
