package test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by john(Zhewei) on 2016/12/7.
 */
public class Main {

    public static void main(String[] args) {
        Hashtable<Object, Object> hashtable = new Hashtable<>();
        Map<String, String> hashMap = new HashMap<>();

        Map<String, String> treeMap = new TreeMap<>();
        hashMap.put("sss", "sssssaaa");
        hashMap.put("sss", "aaaaaaasss");
        System.out.println(hashMap.get("sss"));

        String s1 = "aaa";
        String s2 = "bba";
        int i = s1.compareTo(s2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.yield();//线程进入就绪状态
                    Thread.sleep(110);//线程进入阻塞状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
