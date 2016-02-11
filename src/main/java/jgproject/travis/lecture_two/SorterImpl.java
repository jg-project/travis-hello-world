package jgproject.travis.lecture_two;

import java.util.List;

public class SorterImpl implements Sorter {
    @Override
    public void sort ( int... youx ) {
        Merge.sort ( youx );
        // heap.sort ( youx );
        //int[] a = youx;
//        if ( youx != null ) {
//            int n = youx.length;
//            for ( int i = 0 ; i < n ; i++ ) {
//                for ( int j = i ; j < n ; j++ ) {
//                    if ( youx[ i ] > youx[ j ] ) {
//                        int temp = youx[ i ];
//                        youx[ i ] = youx[ j ];
//                        youx[ j ] = temp;
//                    }
//                }
//            }
//        }
    }

    @Override
    public void sort ( List<Integer> collection ) {
        if ( collection != null ) {
            int n = collection.size ( );
            for ( int i = 0 ; i < n ; i++ ) {
                for ( int j = i ; j < n ; j++ ) {
                    if ( collection.get ( i ) > collection.get ( j ) ) {
                        int temp = collection.get ( i );
                        collection.set ( i, collection.get ( j ) );
                        collection.set ( j, temp );
                    }
                }
            }
        }
    }
}
