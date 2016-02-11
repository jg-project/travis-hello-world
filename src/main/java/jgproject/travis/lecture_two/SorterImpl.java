package jgproject.travis.lecture_two;

import java.util.List;

public class SorterImpl implements Sorter {
    @Override
    public void sort(int... array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }


    @Override
    public void sort(List<Integer> collection) {
        for (int i = 0; i < collection.size() - 1; i++) {
            for (int j = 0; j < collection.size() - i - 1; j++) {
                if (collection.get(j) > collection.get(j + 1)) {
                    int tmp = collection.get(j);
                    collection.set(j, collection.get(j + 1));
                    collection.set(j + 1, tmp);
                }

            }

        }

    }
}
