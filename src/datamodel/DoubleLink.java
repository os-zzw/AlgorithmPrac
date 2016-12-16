package datamodel;

/**
 * Created by john(Zhewei) on 2016/12/16.
 * 带有头结点的双向循环链表
 */
public class DoubleLink<Item> {
    //结点的定义
    private class Node {
        Item dta;//数据
        Node lLink;//左结点
        Node rLink;//右结点

        public Node() {
            this.dta = null;
            this.lLink = null;
            this.rLink = null;
        }

        public Node(Item dta) {
            this.dta = dta;
            this.lLink = null;
            this.rLink = null;
        }

        public Node(Item dta, Node lLink, Node rLink) {
            this.dta = dta;
            this.lLink = lLink;
            this.rLink = rLink;
        }

        public Item getDta() {
            return dta;
        }

        public void setDta(Item dta) {
            this.dta = dta;
        }

        public Node getlLink() {
            return lLink;
        }

        public void setlLink(Node lLink) {
            this.lLink = lLink;
        }

        public Node getrLink() {
            return rLink;
        }

        public void setrLink(Node rLink) {
            this.rLink = rLink;
        }
    }

    //带有头结点的双向循环链表的头结点
    private Node headNode = new Node();
    //链表长度
    private int length = 0;

    /**
     * 创建一个带有头结点的双向循环链表
     */
    public void createDoubleLink(Item[] items) {

    }


}
