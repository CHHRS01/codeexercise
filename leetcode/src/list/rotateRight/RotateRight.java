package list.rotateRight;

import entity.ListNode;

/**
 * 61. 旋转链表
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class RotateRight {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {return head;}

        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            ++count;
            cur = cur.next;
        }
        if (k > count){k = k % count;}
        else if (k % count == 0) {
            return head;
        }
        if (k == 0) {return head;}
        count = count - k - 1;
        ListNode end = head;
        while (count > 0) {
            end = end.next;
            --count;
        }
        ListNode newHead = end.next;
        cur.next = head;
        end.next = null;
        return newHead;

    }
}
