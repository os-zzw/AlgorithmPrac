package sort;

import java.util.Arrays;

/**
 * Created by john(Zhewei) on 2016/12/11.
 */
public class Main {
    public static void main(String[] args) {
        int[] a = new int[]{20, 30, 29, 2, 5, 4, 9, 6, 7, 16, 3, 10, 1};
        int[] b = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        CommonSorts.selectSort(b);
        System.out.println(Arrays.toString(b));
        //        CommonSorts.BubbleSort(a);
        //        System.out.println(Arrays.toString(a));
    }
}
