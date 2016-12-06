package experiment1;

import java.util.ArrayList;
import java.util.List;

import myutils.FileUtils;
import sort.MergeSort;

/**
 * Created by john(Zhewei) on 2016/12/6.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Advertisement> list = (ArrayList<Advertisement>) FileUtils.readFile();

        Integer[] nums = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i).num;
        }

        MergeSort.sort(nums);

        //将一个数组逆序输出
        for (int start = 0, end = nums.length - 1; start <= end; start++, end--) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }

        //逆序之后的List
        List<Advertisement> newlist = new ArrayList<>();
        for (Integer integer : nums) {
            for (Advertisement advertisement : list) {
                if (advertisement.num == integer)
                    newlist.add(advertisement);
            }
        }
        //将逆序之后的输出到文件output中
        FileUtils.writeFile(newlist);

    }
}
