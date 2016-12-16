package datamodel;

/**
 * Created by john(Zhewei) on 2016/12/15.
 */
public class Main<Item> {
    private class Node {
        Item data;
        Node next;
    }

    public static void main(String[] args) {
    }

    /**
     * 从链表中删除重复数据
     * <p>
     * 1.遍历链表把数据存到hashMap中 当遍历到已经存在hasMap中的数据就将其删除
     * 2.双重循环遍历,外层正常遍历,内层从外层当前遍历的节点再进行遍历,若发现一样的就删除这个重复节点
     */
    public void deleteDuplecate(Node node) {

    }

    /**
     * 如何找出单链表中的倒数第k个节点
     * <p>
     * 1.先遍历一遍求长度,然后在遍历到n-k位置
     * 2.从开头每个节点 向前遍历k个 当找到一个节点遍历k个正好为空的时候就是他
     * 3.设两个指针,其中一个先遍历k个节点,然后一起走,当后一个节点到尾部的时候,前一个节点就是倒数第k个
     */
    public void findEnum(Node head, int k) {

    }

    /**
     * 实现链表的反转
     * 调整指针的指向
     */
    public void ReverseIteratively(Node node) {

    }

    /**
     * 从尾到头输出链表
     * 1.存入栈中,然后在弹出栈
     * 2.由于递归本质上就是一个栈结构,所以可以用递归来实现
     */
    public void printListReversely(Node node) {

    }

    /**
     * 寻找单链表的中间节点
     * 1.可以弄两个指针,一个一次走两步,一个一次走一步,当前者到末尾时,后者就在中间
     */
    public void searchMid(Node node){

    }
    /**
     *
     */

}
