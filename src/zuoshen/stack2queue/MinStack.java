package zuoshen.stack2queue;

import java.util.Stack;

/**
 * Created by john(Zhewei) on 2017/1/25.
 */
public class MinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int num) {
        stackData.push(num);
        if (stackMin.isEmpty()) {
            stackMin.push(num);
        } else {
            if (stackMin.peek() >= num) {
                stackMin.push(num);
            }
        }
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        int pop = stackData.pop();
        if (pop == stackMin.peek()) {
            stackMin.pop();
        }
        return pop;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stackMin.peek();
    }

}
