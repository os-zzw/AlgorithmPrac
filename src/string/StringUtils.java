package string;

/**
 * Created by john(Zhewei) on 2016/12/10.
 * 这是一些字符串常用的算法集合
 */
public class StringUtils {

    /**
     * 实现字符串的反转
     */
    public void swap(char[] cArr, int front, int end) {
        while (front < end) {
            char tmp = cArr[end];
            cArr[end] = cArr[front];
            cArr[front] = tmp;
            front++;
            end--;
        }
    }

    /**
     * 实现对字符串中每个单词进行反转 : how are you  ->  you are how
     */
    public String swapString(String str) {
        char[] cArr = str.toCharArray();
        //首先对整个字符串进行反转操作
        swap(cArr, 0, cArr.length - 1);
        //然后对每个单词进行反转操作
        int begin = 0;
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == ' ') {
                swap(cArr, begin, i - 1);
                begin = i + 1;
            }
        }

        return new String(cArr);
    }
    /**
     *
     */
}
