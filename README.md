# AlgorithmPrac
一些常用的算法
##归并排序
	1. 归并操作,就是将两个有序的数组合并成为一个更大的有序数组.
	2. 归并排序:就是可以先将他们(递归地)分成两半进行排序,最后将结果归并起来.
	3. 归并排序能够保证将任意长度n的数组排序所需的时间和nlogN成正比.他所需要的


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

##将一个数组进行逆序重排
	Integer[] nums = new Integer[length];
	//将一个数组逆序输出
        for (int start = 0, end = nums.length - 1; start <= end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
	
