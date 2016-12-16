package datamodel;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * 链表实现的栈
 * 先进后出
 */
public class Stack<Item> {
    private class Node {
        Item data;
        Node next;
    }

    private int N = 0;//设置栈的大小
    private Node top = null;

    public void push(Item value) {
        Node oldTop = this.top;
        top = new Node();
        top.data = value;
        top.next = oldTop;
        N++;
    }

    public Item pop() {
        Item data = top.data;
        top = top.next;
        N--;
        return data;
    }

    public Item peek() {
        if (top == null) {
            return null;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return N;
    }


}
