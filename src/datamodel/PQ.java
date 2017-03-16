package datamodel;

/**
 * Created by john(Zhewei) on 2017/2/18.
 * 基于最大堆的优先队列
 */
public class PQ {

    private Integer a[];//基于堆的二叉堆
    private int N = 0; //0没有用

    public PQ(int n) {
        a = new Integer[n];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int v) {
        a[++N] = v;
        swim(v);
    }

    public int delMax() {
        int v = a[1];
        exch(a, 1, N--);//将他和最后一个节点交换
        a[N + 1] = null;//手动释放空间
        sink(1);//恢复有序性
        return v;
    }

    //下沉
    @SuppressWarnings("Duplicates")
    private void sink(int k) {
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

    //上游实现
    private void swim(int k) {
        while (k > 1 && less(a, k / 2, k)) {
            exch(a, k / 2, k);
            k = k / 2;
        }
    }


    private static void exch(Integer[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(Integer[] a, int i, int j) {
        return a[i] < a[j];
    }
}
