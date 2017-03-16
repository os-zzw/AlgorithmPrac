package sort;

import java.util.Arrays;

/**
 * Created by john(Zhewei) on 2016/12/11.
 * 测试排序
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{20, 30, 29, 2, 5, 4, 9, 6, 7, 16, 3, 10, 1};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] c = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        //        ShellSort.sort(a);//24次比较
        //        CommonSorts.insertSort(a);//50次比较
        //        CommonSorts.selectSort(a);//78次比较
        //        CommonSorts.BubbleSort(b);//78次比较
        //        QuickSort.sort(c, 0, c.length - 1);
        CommonSorts.insertSort(a);
        System.out.println(Arrays.toString(a));
        //        CommonSorts.BubbleSort(a);
        //        System.out.println(Arrays.toString(a));
        //        partition(c, 0, c.length - 1);
    }

    //utils
    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int i, int j) {
        return i < j;
    }
}
