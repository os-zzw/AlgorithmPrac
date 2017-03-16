package sort;

/**
 * Created by john(Zhewei) on 2017/2/17.
 * 堆排序
 */
public class HeapSort {


    public static void heapSort(int[] a) {
        int N = a.length-1;
        for (int i = a.length / 2; i >= 0; i--) {
            sink(a, i, N);
        }
        while (N > 0) {
            exch(a, 0, N--);
            sink(a, 0, N);
        }

    }


    //下沉
    @SuppressWarnings("Duplicates")
    private static void sink(int[] a, int k, int N) {
        while (2 * k < N) {
            int j = 2 * k;
            if (j < N && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;
        }
    }

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }


}
