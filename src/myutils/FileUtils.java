package myutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import experiment1.Advertisement;

/**
 * Created by john(Zhewei) on 2016/12/6.
 */
public class FileUtils {

    public static int[] readFile2() throws Exception {
        FileReader fileReader = new FileReader(".\\src\\experiment2\\input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            String s = bufferedReader.readLine();
            String[] split = s.split(" ");
            for (String s1 : split) {
                int i = Integer.parseInt(s1);
                list.add(i);
            }
        }
        Object[] objects = Arrays.copyOfRange(list.toArray(), 1, 4);
        int[] a = new int[(int) list.toArray()[0]];
        for (int i = 0; i < objects.length; i++) {
            a[i] = (int) objects[i];
        }

        return a;
    }

    public static void writeFile2(int num) throws Exception {
        FileWriter fileWriter = new FileWriter(".\\src\\experiment2\\output.txt");
        fileWriter.write(num+"\n");
        fileWriter.flush();
        fileWriter.close();
    }

    public static List<Advertisement> readFile() throws Exception {
        List<Advertisement> list = new ArrayList<>();
        FileReader fileReader = new FileReader(".\\src\\experiment1\\input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        for (int i = 0; i < 4; i++) {
            Advertisement advertisement = new Advertisement();
            advertisement.name = bufferedReader.readLine();
            String num = bufferedReader.readLine();
            advertisement.num = Integer.parseInt(num);
            advertisement.email = bufferedReader.readLine();
            list.add(advertisement);
        }
        fileReader.close();
        bufferedReader.close();
        return list;
    }

    public static void writeFile(List<Advertisement> list) throws Exception {
        FileWriter fileWriter = new FileWriter(".\\src\\experiment1\\output.txt");
        for (Advertisement advertisement : list) {
            fileWriter.write(advertisement.name + "\n");
            fileWriter.write(advertisement.num + "\n");
            fileWriter.write(advertisement.email + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
