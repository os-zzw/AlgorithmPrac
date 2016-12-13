package sort;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * 快速排序是一种分治的排序算法,
 */
public class QuickSort {

    public static void sort(int[] a, int lo, int hi) {
        //当划分到最后只剩下一个元素的时候退出
        if (lo >= hi)
            return;
        //对数组进行划分
        int mid = partition(a, lo, hi);
        //对划分后的左边进行划分
        sort(a, lo, mid - 1);
        //对划分后的右边进行划分
        sort(a, mid + 1, hi);
    }

    /**
     * @param a  这是要进行划分的部分数组
     * @param lo 这是部分数组的 0下标
     * @param hi 这是部分数组的 a.length-1 上标
     */
    public static int partition(int[] a, int lo, int hi) {
        //将数组切分成 a[lo..i-1] a[i] a[i+1..hi]
        int i = lo, j = hi + 1;
        int v = a[lo];//这是进行比较的元素
        int count = 0;
        while (true) {
            //扫描左右,检查扫描是否结束并交换元素
            while (less(a[++i], v)) {
                if (i == hi)
                    break;
            }
            while (less(v, a[--j])) {
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
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
