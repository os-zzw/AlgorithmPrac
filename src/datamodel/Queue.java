package datamodel;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * 链表实现的队列
 */
public class Queue<Item> {
    private class Node {
        Item data;
        Node next;
    }

    private Node first;
    private Node last;
    private int N = 0;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public void enqueue(Item value) {
        //向队尾添加元素
        Node oldLast = this.last;
        last = new Node();
        last.data = value;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldLast.next = last;
        N++;
    }

    public Item dequeue() {
        //从表头删除数据
        Item data = first.data;
        first = first.next;
        if (isEmpty())
            last = null;
        N--;
        return data;
    }
}
