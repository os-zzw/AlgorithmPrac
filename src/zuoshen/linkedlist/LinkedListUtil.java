package zuoshen.linkedlist;

/**
 * Created by john(Zhewei) on 2017/1/25.
 */
public class LinkedListUtil {


    public static void main(String[] args) {
    }


    /**
     * 打印两个有序链表的公共部分
     */
    public void printCommonPart(Node head1, Node head2) {
        while (head1 != null || head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
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
