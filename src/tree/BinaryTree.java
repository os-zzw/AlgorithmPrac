package tree;

/**
 * Created by john(Zhewei) on 2016/12/14.
 * 二叉搜索树的实现  并递归实现了遍历
 * 二叉搜索树的中序遍历是排序过后的
 * 根据先序和中序可以还原树 中序和后序也可以但是 先后就不行因为无法辨别左右孩子
 * 根据先序的第一个后序的最后一个找到根 然后在中序中 根左边的是左孩子右边的是右孩子
 */
public class BinaryTree {
    private class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root = null;

    //插入一个节点
    public void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = this.root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    //讲数值输入创建一个二叉搜索树
    public void buildTree(int[] datas) {
        for (int data : datas) {
            insert(data);
        }
    }

    //先序遍历递归实现
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data);
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    //中序遍历递归
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data);
            inOrder(localRoot.right);
        }
    }

    //后序遍历递归实现
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data);
        }
    }

    /**
     * 反转二叉树,左孩子变为右孩子,右孩子变为左孩子
     * 递归实现(效率低)
     */
    public void reverseNode(Node localRoot) {
        Node temp = null;
        if (localRoot.left == null && localRoot.right == null) {
            return;
        } else {
            temp = localRoot.left;
            localRoot.left = localRoot.right;
            localRoot.right = temp;
        }
        if (localRoot.left != null) {
            reverseNode(localRoot.left);
        }
        if (localRoot.right != null) {
            reverseNode(localRoot.right);
        }
    }

}
