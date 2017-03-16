package zuoshen.stack2queue;

import datamodel.Stack;

/**
 * Created by john(Zhewei) on 2017/1/25.
 * 用两个栈实现队列
 */
public class TwoStackQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public void add(int num) {
        stackPush.push(num);
    }

    public int peek() {
        if (stackPop.isEmpty()) {
            while (!stackPop.isEmpty()) {
                stackPush.push(stackPop.pop());
            }
        }
        return stackPop.peek();
    }

    public int pop() {
        if (stackPop.isEmpty()) {
            while (!stackPop.isEmpty()) {
                stackPush.push(stackPop.pop());
            }
        }
        return stackPop.pop();
    }
}
