package zuoshen.linkedlist;

import java.util.HashMap;

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
     * 检查一个链表是否为环
     * 定义快慢指针,最后两者相等就是有环,若快指针为null就是无环
     */
    public boolean isLoop(Node head) {
        if (head == null) {
            return false;
        }
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;

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
     * 从链表中删除重复数据
     * 1.遍历链表，保存到map中，若遍历过程中已经存在，就说明是重复的
     */
    public void deleteDuplecate(Node head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Node tmp = head;
        Node pre = null;
        while (tmp != null) {
            if (map.containsKey(tmp.val)) {
                pre.next = tmp.next;
            } else {
                map.put(tmp.val, 1);
                pre = tmp;
            }
            tmp = tmp.next;
        }

    }

    /**
     * 找出链表的倒数第k个元素
     * 采用先后指针的方法，来得到
     */
    public Node findElem(Node head, int k) {
        if (k < 1)
            return null;
        Node p1 = head;
        Node p2 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    /**
     * 单链表和双链表删除倒数第k个节点
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

    /**
     * 找到单链表的中间节点
     * 使用快慢指针，一个一次走两步，一个一次走一步，链表长度为奇数的时候慢指针为中，
     * 链表长度为快指针的时候，慢指针和他的前一个节点都是中间节点
     */
    public Node SearchMid(Node head) {
        if (head == null)
            return null;
        Node p1 = head;
        Node p2 = head;
        while (p1 != null && p1.next != null && p1.next.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
        }
        return p2;
    }
}
