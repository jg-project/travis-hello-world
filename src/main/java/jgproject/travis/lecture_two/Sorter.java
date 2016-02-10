package jgproject.travis.lecture_two;

import java.util.List;

public interface Sorter {
    void sort(int... array);

    void sort(List<Integer> collection);

}
