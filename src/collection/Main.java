package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by john(Zhewei) on 2017/2/3.
 * 快速找出两个集合中不同的元素
 * <p>
 * 用一个map存放lsit的所有元素，其中的key为lsit1的各个元素，
 * value为该元素出现的次数,接着把list2的所有元素也放到map里，
 * 如果已经存在则value加1，最后我们只要取出map里value为1的元素即可，
 * 这样我们只需循环m+n次，大大减少了循环的次数。
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer integer : list1) {
            map.put(integer, 1);
        }

        for (Integer integer : list2) {
            if (map.containsKey(integer)) {
                map.put(integer, 2);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }
}
