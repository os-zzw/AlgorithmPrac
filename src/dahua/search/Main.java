package dahua.search;

/**
 * Created by john(Zhewei) on 2017/2/12.
 */
public class Main {
    public static void main(String[] args) {

    }

    /**
     * 二分查找
     */
    public int binarySearch(int []a,int key){
        int low,mid,high;
        low=1;
        high=a.length;
        while (low<=high){
            mid=low+high/2;

            if (key>a[mid]){
                low=mid+1;
            }else if (key<a[mid]){
                high=mid-1;
            }else {
                return mid;
            }

        }
        return 0;//沒有找到
    }
}
