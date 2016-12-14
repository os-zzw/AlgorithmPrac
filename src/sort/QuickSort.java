package sort;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * 快速排序是一种分治的排序算法
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
        int count = 0;
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
