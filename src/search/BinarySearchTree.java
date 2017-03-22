package search;

/**
 * Created by john(Zhewei) on 2016/12/14.
 * 二叉搜索树
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
    private class Node {
        private Key key;
        private Value value;
        private Node left = null;//左孩子
        private Node right = null;//右孩子
        private int N; //以这个结点为根节点的子树中的结点个数

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }



    private Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value);
        }
        int i = key.compareTo(node.key);
        if (i < 0)
            node.left = put(node.left, key, value);
        else if (i > 0)
            node.right = put(node.right, key, value);
        else
            node.value = value;
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        return x.N;
    }

}
