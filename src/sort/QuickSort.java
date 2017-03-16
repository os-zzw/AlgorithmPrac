package sort;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * <p>不稳定
 * 原理：分治+递归
 * 复杂度：O(nlgn) - O(nlgn) - O(n^2) - O(1)[平均 - 最好 - 最坏 - 空间复杂度]
 * 栈空间0(lgn) - O(n)
 * <p>
 * 快排的优化：针对随机数组+有序数组+重复数组
 * 1.当待排序序列的长度分割到一定大小后，使用插入排序<三数取中+插入排序>：效率提高一些，但是都解决不了重复数组的问题。
 * 2.在一次分割结束后，可以把与Key相等的元素聚在一起，继续下次分割时，不用再对与key相等元素分割 <三数取中+插排+聚集相同元素>
 */
public class QuickSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    //递归调用
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
        while (true) {
            //扫描左右,检查扫描是否结束并交换元素
            while (less(a[++i], v)) {//当比v小的时候可以继续进行,否则将其和别的小于v的交换
                if (i == hi)
                    break;
            }
            while (less(v, a[--j])) {//当比v大的时候继续进行,否则将其和别的大于v的交换
                if (j == lo)
                    break;
            }
            if (i >= j)//退出外层while循环当两个指针相遇
                break;
            exch(a, i, j);//当执行完交换之后 还要进行 ++i --j的操作
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
