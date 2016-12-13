package datamodel;

import java.util.Iterator;

/**
 * Created by john(Zhewei) on 2016/12/13.
 * 使用链表实现的背包-->只收集数据不删除.
 */
public class Bag<Item> {
    private class Node {
        Item data;
        Node next;
    }

    private Node top;
    private int N;

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return N;
    }

    public void add(Item item) {
        Node oldTop = this.top;
        top = new Node();
        top.data = item;
        top.next = oldTop;
        N++;
    }

    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item> {
        private Node currentNode = top;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            Item data = currentNode.data;
            currentNode = currentNode.next;
            return data;
        }
    }
}
