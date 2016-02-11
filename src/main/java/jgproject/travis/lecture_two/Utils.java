package jgproject.travis.lecture_two;

public class Utils {

    public static class Heap {
        public static void sort(int[] a) {
            heapify(a, a.length);

            int end = a.length - 1;

            while (end > 0) {
                swap(a, end, 0);
                end--;
                siftDown(a, 0, end);
            }
        }

        private static void heapify(int[] a, int count) {
            int start = parent(count - 1);

            while (start >= 0) {
                siftDown(a, start, count - 1);
                start--;
            }
        }

        private static void siftDown(int[] a, int start, int end) {
            int root = start;

            while (leftChild(root) <= end) {
                int child = leftChild(root);
                int swap = root;

                if (a[swap] < a[child]) {
                    swap = child;
                }
                if ((child + 1 <= end) && a[swap] < a[child + 1]) {
                    swap = child + 1;
                }
                if (swap == root) {
                    return;
                } else {
                    swap(a, root, swap);
                    root = swap;
                }
            }
        }

        private static void swap(int[] a, int i, int j) {
            int buf = a[i];
            a[i] = a[j];
            a[j] = buf;
        }


        private static int parent(int i) {
            return (int) Math.floor(((double) i - 1) / 2);
        }

        private static int leftChild(int i) {
            return 2 * i + 1;
        }

    }

    public static class Merge {

        public static void sort(int[] a) {
            int[] b = new int[a.length];
            topDownSplitMerge(a, 0, a.length, b);
        }

        public static void topDownSplitMerge(int[] a, int begin, int end, int[] b) {
            if (end - begin < 2) {
                return;
            }
            int middle = (end + begin) / 2;
            topDownSplitMerge(a, begin, middle, b);
            topDownSplitMerge(a, middle, end, b);
            topDownMerge(a, begin, middle, end, b);
            coppyArray(b, begin, end, a);
        }

        private static void topDownMerge(int[] a, int begin, int middle, int end, int[] b) {
            int i = begin;
            int j = middle;
            for (int k = begin; k < end; k++) {
                if (i < middle && (j >= end || a[i] <= a[j])) {
                    b[k] = a[i];
                    i++;
                } else {
                    b[k] = a[j];
                    j++;
                }
            }
        }

        private static void coppyArray(int[] b, int begin, int end, int[] a) {
            for (int k = begin; k < end; k++) {
                a[k] = b[k];
            }
        }

    }

    public static class Bubble {
        public static void sort(int[] a) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        int buf = a[i];
                        a[i] = a[j];
                        a[j] = buf;
                    }
                }
            }
        }
    }

}
