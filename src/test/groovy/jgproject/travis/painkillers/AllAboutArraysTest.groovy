package jgproject.travis.painkillers

import static jgproject.travis.painkillers.AllAboutArrays.AggregationType.*

class AllAboutArraysTest extends GroovyTestCase {

    AllAboutArrays test
    Random rnd = new Random()

    void setUp() {
        test = new AllAboutArraysImpl()
    }

    void testCreateArray() {
        int[] array = test.createArray(10)
        assert array != null
        assert array.length == 10
    }

    void testFillWithRandomNumbers() {
        int[] arr = new int[3]
        int[] runOne = new int[3]
        int[] runTwo = new int[3]
        test.fillWithRandomNumbers(arr)
        System.arraycopy(arr, 0, runOne, 0, 3)
        test.fillWithRandomNumbers(arr)
        System.arraycopy(arr, 0, runTwo, 0, 3)

        int cnt = 0
        for (int i = 0; i < 3; i++) {
            cnt += (runOne[i] == runTwo[i]) ? 0 : 1;
        }
        assert cnt > 1


    }

    void testFillWithParticularNumber() {
        int[] arr = new int[3]
        int num = rnd.nextInt()
        test.fillWithParticularNumber(arr, num)
        arr.each {
            assert it == num
        }
    }

    void testGetAggregate() {
        int[] arr = [1, 7, 11, 13, 501]
        assert 5 == test.getAggregate(arr, CNT)
        assert 1 == test.getAggregate(arr, MIN)
        assert 501 == test.getAggregate(arr, MAX)
        assert Math.abs(106.6 - test.getAggregate(arr, AVG)) < 0.0000001
        assert Math.abs(533 - test.getAggregate(arr, SUM)) < 0.0000001
        assert 11 == test.getAggregate(arr, MEDIAN)
        assert Math.abs(38904.64 - test.getAggregate(arr, VARIANCE)) < 0.0000001
    }

    void testCopyArrays() {
        int[] src = [1, 2, 3, 4, 500]
        int[] dest = new int[4]
        test.copyArrays(src, 2, dest, 0, 3)
        assert [3,4,500,0] == dest
    }

    void testReverseArray() {
        int[] arr = [1,100,15,100500,-30]
        test.reverseArray(arr)
        assert [-30,100500,15,100,1] == arr
    }

    void testTranspose() {
        def int [][] src = [[1, 2, 3],[4, 5, 6]]
        assert [[1,4],[2,5],[3,6]] == test.transpose(src)

    }

    void testSubarray() {
        int[] src = [1, 2, 3, 4, 5, 6, 7]
        assert [1, 2, 3, 4, 5] ==  test.subarray(src, 0, 4)
    }

    void testSort() {
        int [] arr = [10,4,7,2,7,8,9];
        assert Arrays.sort(arr) == test.sort(arr)

    }

    void testFindEntryIndex() {
        int [] arr = [10,4,7,2,7,8,9];
        assert 7 == test.findEntryIndex(arr, 2)
    }

    void testRemoveDuplicates() {
        def int [] arr = [1,1,1,1,1,1,1,2,3]
        assert [1,2,3] == test.removeDuplicates(arr)

    }
}
