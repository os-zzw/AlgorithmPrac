package sort;

/**
 * Created by john(Zhewei) on 2016/12/6.
 * <p>稳定
 * 原理：采用分治法 递归
 * 复杂度：O(nlogn) - O(nlgn) - O(nlgn) -O (n)[平均 - 最好 - 最坏 - 空间复杂度]
 * <p>
 * 将已有序的子序列合并，得到完全有序的序列；
 * 即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并。
 */
public class MergeSort {
    private static Comparable[] aux; //归并所需要的辅助数组

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    //递归
    public static void sort(Comparable[] a, int lo, int hi) {
        //将数组a进行排序
        if (hi <= lo)
            return;//当仅剩一个元素的时候就是排好序的了
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);//将左侧进行排序
        sort(a, mid + 1, hi);//将右侧进行排序
        merge(a, lo, mid, hi);//把左右两侧的有序的合并为一个大的有序的
    }


    /**
     * 数组中lo到mid 是有序的 mid+1到hi是有序,该方法是将两个有序的合并为一个有序的大数组
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        //首先把所有元素保存到临时数组中
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        //开始进行比较和存入有序元素
        for (int k = lo; k <= hi; k++) {
            if (i > mid)//这是当左侧元素全存入后直接存剩下的右边的有序数组
                a[k] = aux[j++];
            else if (j > hi)//这是当右侧有序元素全存入后直接存剩下的左侧的有序数组
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))//当右侧元素小于左侧元素时,存入右侧
                a[k] = aux[j++];
            else//否则存左侧元素
                a[k] = aux[i++];
        }
    }


    //通用模板
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
