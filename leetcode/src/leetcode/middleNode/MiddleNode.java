package leetcode.middleNode;

import entity.ListNode;

/**
 * 876. 链表的中间结点
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class MiddleNode {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.next;
    }
}
