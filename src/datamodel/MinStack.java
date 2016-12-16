package datamodel;

/**
 * Created by john(Zhewei) on 2016/12/14.
 * <p>
 * 如何通过O(1) 的时间复杂度来实现 求栈中的最小元素
 * 使用空间换时间的策略 用两个栈来实现 一个栈用来存储数据另一个栈保存栈的最小元素
 */

public class MinStack {
    private Stack<Integer> elem;
    private Stack<Integer> min;

    public MinStack(Stack<Integer> elem, Stack<Integer> min) {
        this.elem = elem;
        this.min = min;
    }

    public void push(Integer data) {
        elem.push(data);
        if (min.isEmpty())
            min.push(data);
        else {
            if (data < min.peek()) {
                min.push(data);
            }
        }
    }

    public int pop() {
        Integer topData = elem.pop();
        if (topData == min()) {
            min.pop();
        }
        return topData;
    }

    public int min() {
        if (min.isEmpty()) {
            return Integer.MAX_VALUE;
        } else
            return min.peek();
    }

}
