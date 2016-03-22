package jgproject.travis.lecture_two;


import java.util.Collections;
import java.util.List;

public class SorterImpl implements Sorter {
    @Override
    public void sort(int... array) {
        if (array == null){
            return;
        }
        int i;
        int temp;

        for (i = array.length / 2 - 1; i >= 0; i--)
        {
            shiftDown(array, i, array.length);
        }

        for (i = array.length - 1; i >= 1; i--)
        {
            temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            shiftDown(array, 0, i);
        }
    }
    public void shiftDown(int[] a, int i, int j)
    {
        boolean done = false;
        int maxChild;
        int temp;

        while ((i * 2 + 1 < j) && (!done))
        {
            if (i * 2 + 1 == j - 1)
                maxChild = i * 2 + 1;
            else if (a[i * 2 + 1] > a[i * 2 + 2])
                maxChild = i * 2 + 1;
            else
                maxChild = i * 2 + 2;

            if (a[i] < a[maxChild])
            {
                temp = a[i];
                a[i] = a[maxChild];
                a[maxChild] = temp;
                i = maxChild;
            }
            else
            {
                done = true;
            }

        }

    }


    public static void swap(int [] arr ,  int i, int j) {

        if (arr[i] > arr[j]){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

    }


    @Override
    public void sort(List<Integer> collection) {
        if (collection != null) {
            Collections.sort(collection);
        }
    }
}
