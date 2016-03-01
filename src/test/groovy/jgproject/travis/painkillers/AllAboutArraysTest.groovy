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
        assert 5d == test.getAggregate(arr, CNT)
        assert 1d == test.getAggregate(arr, MIN)
        assert 501d == test.getAggregate(arr, MAX)
        assert Math.abs(106.6 - test.getAggregate(arr, AVG)) < 0.0000001
        assert Math.abs(533 - test.getAggregate(arr, SUM)) < 0.0000001
        assert 11d == test.getAggregate(arr, MEDIAN)
        assert Math.abs(38904.64 - test.getAggregate(arr, VARIANCE)) < 0.0000001
    }

    void testCopyArrays() {
        int[] src = [1, 2, 3, 4, 500]
        int[] dest = new int[4]
        test.copyArrays(src, 2, dest, 0, 3)
        int[] expectedArr = [3,4,500,0]
        assertArraysSame(dest, expectedArr)
    }

    void testReverseArray() {
        int[] arr = [1,100,15,100500,-30]
        int[] reversedArr = [-30,100500,15,100,1]
        test.reverseArray(arr)
        assertArraysSame(arr,reversedArr)
    }

    void testTranspose() {
        int[][] arr = [[1,2,3],[4,5,6]]
        int[][] transposedArr = test.transpose(arr)
        assert [[1,4],[2,5],[3,6]] == transposedArr
    }

    void testSubarray() {
        int[] arr = [5,3,22,7,16,13]
        int[] expectedArr = [22,7,16]
        int[] subArray = test.subarray(arr,3,5)
        assertArraysSame(expectedArr,subArray)
    }

    void testSort() {
        int[] arr = [4,25,3,943,777]
        int[] expectedArr = new int[arr.length]
        System.arraycopy(arr, 0, expectedArr, 0,arr.length)
        Arrays.sort(expectedArr)
        test.sort(arr)
        assert arr == expectedArr
    }

    void testFindEntryIndex() {
        int[] arr = [84,285,6,6,1039,6]
        int foundElementIndex = test.findEntryIndex(arr,6)
        assert foundElementIndex == 3
    }

    void testRemoveDuplicates() {
        int[] arr = [923,44,923,923,54,7,0,923]
        int[] expectedArr = [923,44,54,7,0]
        int[] uniqueElementsArr = test.removeDuplicates(arr)
        assertArraysSame(expectedArr, uniqueElementsArr)
    }

    static assertArraysSame(int[] a, int[] b) {
        assert a != null && b != null && a.length == b.length

        for (int i = 0; i < a.length; i++) {
            assert a[i] == b[i]
        }
    }
}
