package jgproject.travis.lecture_two;

import java.util.ArrayList;
import java.util.List;

public class SorterImpl implements Sorter {

    @Override
    public void sort(int... array) {
        if (array == null) {
            return;
        }
        List<Integer> collection = new ArrayList<Integer>();
        for (int i=0; i < array.length; i++) {
            collection.add(array[i]);
        }
        sort(collection);
        for (int i=0; i<array.length; i++) {
            array[i] = collection.get(i);
        }
    }

    @Override
    public void sort(List<Integer> collection) {
        if (collection == null ) {
            return;
        }
        List<Integer> sortedList = mergesort(collection);
        collection.clear();
        collection.addAll(sortedList);
    }

    private List<Integer> mergesort (List<Integer> collection) {
        List<Integer> leftList = new ArrayList<Integer>();
        List<Integer> rightList = new ArrayList<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();
        if (collection.size() <= 1) {
            return new ArrayList<Integer>(collection);
        } else {
            for (int i = 0; i <  collection.size() / 2; i++) {
                leftList.add(collection.get(i));
            }
            for (int j = collection.size() / 2; j < collection.size(); j++) {
                rightList.add(collection.get(j));
            }
            leftList = mergesort(leftList);
            rightList = mergesort(rightList);
            resultList = merge(leftList, rightList);
            return resultList;
        }
    }

    private List<Integer> merge (List<Integer>  leftList, List<Integer> rightList) {
        List<Integer> resultList = new ArrayList<Integer>();
        while (leftList.size() > 0 && rightList.size() > 0) {
            if (leftList.get(0) <= rightList.get(0)) {
                resultList.add(leftList.remove(0));
            } else {
                resultList.add(rightList.remove(0));
            }
        }
            if (leftList.size() > 0) {
                resultList.addAll(leftList);
            }
            if (resultList.size() > 0 ) {
                resultList.addAll(rightList);
            }
            return resultList;
    }

}

