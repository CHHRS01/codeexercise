package list.reorderList;

import entity.ListNode;

/**
 * 143. 重排链表
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class ReorderList {
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = middle.next;
        middle.next = null;
        l2 = reverseList(l2);

        // merge  列表
        mergeList(l1, l2);

    }

    // 中点


    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 反转链表
    public static ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void mergeList(ListNode l1, ListNode l2) {
        ListNode l1_tmp;
        ListNode l2_tmp;
        while (l1 != null && l2 != null) {
            l1_tmp = l1.next;
            l2_tmp = l2.next;

            l1.next = l2;
            l1 = l1_tmp;

            l2.next = l1;
            l2 = l2_tmp;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        reorderList(node1);
        while (node1 != null) {
            System.out.print(node1.val);
            System.out.print(" ");
            node1 = node1.next;
        }

    }
}
