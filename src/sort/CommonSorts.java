package sort;

/**
 * Created by john(Zhewei) on 2016/12/10.
 * 三种基本排序
 * 选择 :不稳定 时间复杂度: 好:O(n^2) 坏:O(n^2) 平均:O(n^2)
 * 冒泡和插入: 稳定 时间复杂度: 好:O(n) 坏:O(n^2) 平均:O(n^2)
 */
public class CommonSorts {
    /**
     * 冒泡(交换排序)
     */
    public static void BubbleSort(int a[]) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                count++;
                if (a[j + 1] < a[j]) {
                    exch(a, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
        System.out.println(count);
    }

    /**
     * 插入排序
     * 适用于小数组,数组已排好序或接近于排好序速度将会非常快
     * 第一次循环 第一个是有序的 第二次循环 前两个是有序的 直到n个都是有序的
     */
    public static void insertSort(int[] a) {
        int count = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j >= 1 && less(a, j, j - 1); j--) {
                count++;
                exch(a, j, j - 1);
            }
        }
        System.out.println(count);//测试时间复杂度
    }

    /**
     * <p>不稳定
     * 原理：每次从无序序列选取最小的
     * 复杂度：O(n^2) - O(n^2) - O(n^2) - O(1)[平均 - 最好 - 最坏 - 空间复杂度]
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

    private static void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private static boolean less(int[] a, int i, int j) {
        return a[i] < a[j];
    }
}
