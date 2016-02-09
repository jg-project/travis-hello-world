package jgproject.travis.lecture_two

class SorterImplTest extends GroovyTestCase {

    Sorter sorter;

    static Random rnd = new Random();

    static int[] generateArray(int size) {
        int[] result
        if (size > -1) {
            result = new int[size]
            size.times { index ->
                result[index] = rnd.nextInt();
            }
        }
        result
    }

    void setUp() {
        sorter = new SorterImpl();
    }

    void testSortsEmptyArray() {
        int[] arr = new int[0]
        int[] expectedArr = new int[0]

        sorter.sort(arr)

        assertArraysSame(expectedArr, arr)
    }

   /* void testSortsNonEmptyArrays() {
        (1..1000).each {
            int[] arr = generateArray(it)
            int[] expectedArr = new int[it]
            System.arraycopy(arr, 0, expectedArr, 0, it)
            Arrays.sort(expectedArr)

            sorter.sort(arr)
            assertArraysSame(expectedArr, arr)
        }
    }
   */

    static assertArraysSame(int[] a, int[] b) {
        assert a != null && b != null && a.length == b.length

        for (int i = 0; i < a.length; i++) {
            assert a[i] == b[i]
        }
    }

    static assertListsSame(Collection a, Collection b) {
        assert a != null && b != null && a.size() == b.size()

        def aIt = a.iterator()
        def bIt = b.iterator()

        while (aIt.hasNext() && bIt.hasNext()) {
            assert aIt.next() == bIt.next()
        }
    }

    void testSortsEmptyCollection() {
        List<Integer> collection = new ArrayList<>()
        List<Integer> expectedCollection = new ArrayList<>()

        sorter.sort(collection)

        assertListsSame(collection, expectedCollection)
    }

 /*
    void testSortsNonEmptyCollection() {
        (1..1000).each {
            List<Integer> collection = new ArrayList<>(Arrays.asList(generateArray(it)))
            List<Integer> expectedCollection = new ArrayList<>(collection)

            Collections.sort(expectedCollection)

            sorter.sort(collection)

            assertListsSame(expectedCollection, collection)
        }
    }
*/

    void testNullIsProcessedCorrectly() {
        int[] arr = null
        ArrayList list = null
        sorter.sort(arr)
        sorter.sort(list)
    }


}
