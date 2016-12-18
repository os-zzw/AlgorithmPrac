package experiment3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import myutils.FileUtils;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * 回溯法
 */
public class Main {

    public static void main(String[] args) throws IOException {
        List<Integer> doubleList = FileUtils.readFile3();
        double[] weight = new double[doubleList.get(0) + 1];
        double[] prices = new double[doubleList.get(0) + 1];
        double cc = doubleList.get(1);
        for (int i = 2; i <= 5; i++) {
            weight[i - 1] = doubleList.get(i);
        }
        for (int i = 6; i < doubleList.size(); i++) {
            prices[i - 5] = doubleList.get(i);
        }
        Main k = new Main();
        double best = k.knapsack(prices, weight, cc);

        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            nums.add(0);
        }
        for (int i = 1; i < k.bestx.length; i++) {
            if (k.bestx[i] == 1) {//k.q[i].id
                for (int j = 1; j < 5; j++) {
                    if (k.q[i].id == j) {
                        nums.set(j - 1, 1);
                    }
                }
            }
        }
        FileUtils.writeFile3(nums);
    }

    public static class Element implements Comparable {
        int id;//物品编号
        double d;

        public Element(int id, double d) {
            this.id = id;
            this.d = d;
        }

        @Override
        public int compareTo(Object x) {
            double xd = ((Element) x).d;//递减顺序排列
            if (d > xd)
                return -1;
            if (d == xd)
                return 0;
            return 1;
        }
    }

    double c;//背包容量
    int n;//物品数
    double[] w;//物品重量数组
    double[] p;//物品价值数组
    double cw;//当前重量
    double cp;//当前价值
    double bestp;//最优价值
    int[] x;//当前装入背包顺序
    int[] bestx;//最优装入背包顺序
    Element[] q;//q为单位重量价值数组

    public double knapsack(double[] pp, double[] ww, double cc) {
        //初始化
        c = cc;
        n = pp.length - 1;
        cw = 0;
        cp = 0;
        bestp = 0;
        x = new int[n + 1];
        bestx = new int[n + 1];
        //q为单位重量价值数组
        q = new Element[n + 1];
        for (int i = 0; i <= n; i++) {
            q[i] = new Element(i, pp[i] / ww[i]);
        }
        //将个物品依单位重量价值从大到小排列
        java.util.Arrays.sort(q);
        p = new double[n + 1];
        w = new double[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = pp[q[i].id];
            w[i] = ww[q[i].id];
        }
        backtrack(1);
        return bestp;
    }

    public void backtrack(int i) {
        if (i > n) {//到达叶子节点
            bestp = cp;
            for (int j = 1; j <= n; j++) {//保存最优值对应的包的编号
                bestx[j] = x[j];
            }
            return;
        }
        if (cw + w[i] <= c) {//左子树
            x[i] = 1;
            cw += w[i];
            cp += p[i];
            backtrack(i + 1);
            cw -= w[i];//恢复现场
            cp -= p[i];
        }
        if (bound(i + 1) > bestp) {
            x[i] = 0;
            backtrack(i + 1);
        }
    }

    public double bound(int i) {//上界函数
        double cleft = c - cw;
        double bound = cp;
        while (i <= n && w[i] <= cleft) {
            cleft -= w[i];
            bound += p[i];
            i++;
        }
        if (i <= n) {
            bound += p[i] * cleft / w[i];
        }
        return bound;
    }
}
