package sort;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * 希尔排序(Shell Sort)是插入排序的一种。
 * 也称缩小增量排序，是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法.
 * <p>
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，
 * 每组包含的关键词越来越多，当增量减至1时，整个文件恰被分成一组，算法便终止
 */
public class ShellSort {

    public static void sort(int[] a) {
        int count = 0;
        int N = a.length;
        int h = 1;
        while (h < N / 3)
            h = 3 * h + 1;//1 4 13 40...
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a, j, j - h); j -= h) {
                    exch(a, j, j - h);
                    count++;
                }
            }
            h = h / 3;
        }
        System.out.println(count);
    }


    //utils
    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }
}
