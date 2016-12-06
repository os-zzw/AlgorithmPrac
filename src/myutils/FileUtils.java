package myutils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import experiment1.Advertisement;

/**
 * Created by john(Zhewei) on 2016/12/6.
 */
public class FileUtils {

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
            fileWriter.write(advertisement.name+"\n");
            fileWriter.write(advertisement.num+"\n");
            fileWriter.write(advertisement.email+"\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
