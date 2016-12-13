package sort;

/**
 * Created by john(Zhewei) on 2016/12/10.
 */
public class CommonSorts {
    /**
     * 冒泡(交换排序)
     */
    public static void BubbleSort(int a[]) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = a.length - 1; j > i; j--) {
                count++;
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 插入排序
     * 第一次循环 第一个是有序的 第二次循环 前两个是有序的 直到n个都是有序的
     */
    public static void insertSort(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                count++;
                if (a[j + 1] < a[j]) {
                    int tmp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = tmp;
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 选择排序
     * 每次选择最小的放到第一个,第二次选剩下的最小的放到第二个
     */
    public static void selectSort(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                count++;
                if (a[j] < a[min])
                    min = j;
            }
            if (min != i) {
                exch(a, i, min);
            }
        }
        System.out.println(count);
    }

    /**
     * 快速
     */
    public static void QuickSort(int[] a) {

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
