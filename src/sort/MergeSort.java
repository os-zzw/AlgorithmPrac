package sort;

/**
 * Created by john(Zhewei) on 2016/12/6.
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
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    //非递归
    public static void sort_non(Comparable[] a) {
        int lo = 0, hi = a.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            merge(a,lo,mid,hi);
        }
    }

    //原地归并的抽象方法
    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        //把元素保存到临时数组中
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
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
