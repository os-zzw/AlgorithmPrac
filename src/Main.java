import commonutils.StdOut;
import sort.MergeSort;

public class Main {

    public static void main(String[] args) {
        Integer[] luan = new Integer[]{2, 10, 5, 8, 4, 16, 9, 14};
        MergeSort.sort(luan);
        show(luan);
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }
}
