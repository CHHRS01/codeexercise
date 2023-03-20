package leetcode.getDecimalValue;

import entity.ListNode;

/**
 * 1290. 二进制链表转整数
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class GetDecimalValue {
    public int getDecimalValue(ListNode head) {

        int cur = 0;
        while (head != null) {
            cur = cur << 1;
            cur += head.val;
            head = head.next;
        }

        return cur;
    }
}
