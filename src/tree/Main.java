package tree;

import java.util.Stack;

import zuoshen.tree.Node;

/**
 * Created by john(Zhewei) on 2016/12/14.
 */
public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildTree(new int[]{2, 8, 7, 4, 9, 3, 1, 6, 7, 5});

        binaryTree.postOrder(binaryTree.root);
    }




}
