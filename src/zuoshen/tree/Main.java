package zuoshen.tree;

import java.util.Stack;

/**
 * Created by john(Zhewei) on 2017/2/7.
 * 二叉树的一些操作
 */
public class Main {
    /**
     * 二叉树的遍历(递归)
     */
    public void preOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        preOrderRecur(root.left);
        preOrderRecur(root.right);

    }

    public void inOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        preOrderRecur(root.left);
        System.out.println(root.value);
        preOrderRecur(root.right);
    }

    public void postOrderRecur(Node root) {
        if (root == null) {
            return;
        }
        preOrderRecur(root.left);
        preOrderRecur(root.right);
        System.out.println(root.value);
    }

    /**
     * 二叉树的非递归遍历
     */
    public void preOrderUnRecur(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node node = stack.pop();
            System.out.println(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public void inOrderUnRecur(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty() || root != null) {
            if (root.left != null) {
                stack.push(root.left);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.println(root.value);
                root = root.right;
            }
        }
    }

    public void postOrderUnRecur(Node root) {

    }

    /**
     * 打印二叉树的边界节点
     */

    /**
     * 二叉树的序列化和反序列化(先序遍历)
     */
    public String serialByPre(Node root) {
        if (root == null) {
            return "#!";
        }
        String result = root.value + "!";
        result += serialByPre(root.left);
        result += serialByPre(root.right);
        return result;
    }


}
