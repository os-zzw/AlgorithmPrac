package zuoshen.stack2queue;

import datamodel.Stack;

/**
 * Created by john(Zhewei) on 2017/1/25.
 */
public class StackUtil {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverseStack(stack);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }


    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    /**
     * 通过递归反转栈
     */
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverseStack(stack);
        stack.push(last);
    }

    /**
     * 通过一个栈对另一个栈进行排序
     */
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {

            int cur = stack.pop();

            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }


}
