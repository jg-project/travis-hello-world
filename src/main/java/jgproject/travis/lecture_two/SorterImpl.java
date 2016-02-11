package jgproject.travis.lecture_two;

import java.util.List;

public class SorterImpl implements Sorter {
    @Override
    public void sort(int... array) {
        Utils.Bubble.sort(array);
    }

    @Override
    //This is bad, and I feel bad because of this
    public void sort(List<Integer> collection) {
        if (collection != null) {
            int[] a = new int[collection.size()];
            int index = 0;
            for (Integer i : collection) {
                a[index++] = i;
            }
            sort(a);
            collection.clear();
            for (int i = 0; i < a.length; i++) {
                collection.add(a[i]);
            }
        }
    }
}
