package jgproject.travis.lecture_two;

import java.util.List;


public class SorterImpl implements Sorter {
    @Override
    public void sort(int... array) {

        if (array != null) {

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array.length - 1 - i; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }

        }
    }


    @Override
    public void sort(List<Integer> collection) {

     if (collection!=null) {
         for (int i = 0; i < collection.size(); i++) {

             for (int j = 0; j < collection.size() - 1 - i; j++) {

                 if (collection.get(j) > collection.get(j + 1)) {
                     int temp = collection.get(j + 1);
                     collection.set(j + 1, collection.get(j));
                     collection.set(j, temp);
                 }
             }
         }
     }

    }


    }
