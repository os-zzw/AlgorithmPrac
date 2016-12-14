package search;

/**
 * Created by john(Zhewei) on 2016/12/14.
 * 顺序查找 基于无序链表
 */
public class SequentialSearchST<Key, Value> {
    private class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Node first; //链表首节点

    public Value get(Key key) {
        //查找给定的键,返回相关联的值
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.value;//命中
            }
        }
        return null;//未命中
    }

    public void put(Key key, Value value) {
        //首先查找给定的键值,找到就更新他的值,否则新建一个结点
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.value = value;//命中,更新值
                return;
            }
        }
        //未命中,新建结点
        first = new Node(key, value, first);
    }
}
