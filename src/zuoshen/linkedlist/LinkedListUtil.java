package zuoshen.linkedlist;

/**
 * Created by john(Zhewei) on 2017/1/25.
 */
public class LinkedListUtil {


    public static void main(String[] args) {
    }

    /**
     * 反转单链表
     */
    public Node ReverseIteratively(Node head) {
        //首先创建三个节点
        Node pReversedHead = head;
        Node pNode = head;
        Node pPrev = head;
        //开始遍历
        while (pNode != null) {

            Node pNext = pNode.next;

            if (pNext == null) {
                pReversedHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }

        return pReversedHead;
    }

    /**
     * 从尾到头打印单链表
     * 1.可以把节点放到栈中,最后输出栈中的数据
     * 2.因为递归本身就是一个栈结构,所以可以用递归实现
     */
    public void printListReversely(Node head) {
        if (head != null) {
            printListReversely(head.next);
            System.out.println(head.val);
        }
    }


    /**
     * 打印两个有序链表的公共部分
     */
    public void printCommonPart(Node head1, Node head2) {
        //当head1为null或者head2为null的时候停止运行
        while (head1 != null && head2 != null) {
            //因为是有序链表
            //当head1小于head2的时候,下移
            if (head1.val < head2.val) {
                head1 = head1.next;
                //当head2小于head1的时候,head2下移
            } else if (head1.val > head2.val) {
                head2 = head2.next;
                //当head1和head2相等的时候,打印,且两者都下移
            } else {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }

    /**
     * 单链表和双链表删除第k个节点
     */
    public Node removeLastKthNode(Node head, int lastKth) {

        if (head == null || lastKth < 1) {
            return head;
        }

        Node cur = head;

        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        if (lastKth > 0) {
            return null;
        }

        if (lastKth == 0) {
            head = head.next;
        }

        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }

        return head;
    }

    public DoubleNode removeLastKthDoubleNode(DoubleNode head, int lastKth) {
        if (head == null || lastKth < 1) {
            return null;
        }

        DoubleNode cur = head;

        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }

        if (lastKth > 0) {
            return null;
        }

        if (lastKth == 0) {
            head = head.next;
        }

        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
            if (cur.next.next != null) {
                cur.next.next.last = cur;
            }
        }

        return head;
    }


}
