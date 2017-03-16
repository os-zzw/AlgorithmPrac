package dahua.search.binarytree;

/**
 * Created by john(Zhewei) on 2017/2/12.
 */
public class Main {
    public static void main(String[] args) {

    }


    /**
     * 查找(二叉排序树)
     */
    public boolean searchBST(Node root,int key,Node f,Node p){
        if (root==null){
            p=f;
            return false;
        }else if (root.data==key){
            p=root;
            return true;
        }else if (root.data<key){
            return searchBST(root.rchild,key,root,p);
        }else {
            return searchBST(root.lchild,key,root,p);
        }


    }

}
