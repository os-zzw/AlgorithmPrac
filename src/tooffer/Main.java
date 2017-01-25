package tooffer;

/**
 * Created by john(Zhewei) on 2016/12/22.
 */
public class Main {
    /**
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public boolean Find(int target, int[][] array) {
        //行数
        int rows = array.length - 1;
        int i = 0;//计数
        while ((rows >= 0) && (i < array[0].length)) {
            if (array[rows][i] == target) {
                return true;
            } else if (array[rows][i] > target) {
                rows--;
            } else {
                i++;
            }
        }
        return false;
    }
}
