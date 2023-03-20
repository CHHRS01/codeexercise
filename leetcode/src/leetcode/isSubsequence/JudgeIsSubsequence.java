package leetcode.isSubsequence;

import entity.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author 韩仁松
 * @since businessV1.0.0
 */

public class JudgeIsSubsequence {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = head;
        head = head.next;
        newHead.next = null;
        ListNode temp = null;
        while (head != null) {
            temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }

        return newHead;
    }
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }

        ListNode middle = head;
        ListNode fast = head.next;
        while (fast.next != null && fast.next.next != null) {
            middle = middle.next;
            fast = fast.next.next;
        }
        return middle.next;

    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;

            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                // 无环
                return null;
            }

            // 有环
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;

    }

    public int maxProfit(int[] prices) {
        // 取左侧最小 右侧最大
        int length = prices.length;
        int[] leftMin = new int[length];
        leftMin[0] = prices[0];
        int[] rightMax = new int[length];
        rightMax[length - 1] = prices[length -1];
        for (int i = 1; i < length; i++) {
            leftMin[i] = prices[i] < leftMin[i - 1] ? prices[i] : leftMin[i - 1];
            rightMax[length - 1 - i] = prices[length - 1 - i] > rightMax[length - i] ? prices[length - 1 - i] : rightMax[length - i];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++){
            max = Math.max(max, rightMax[i] - leftMin[i]);
        }
        return max < 0 ? 0 : max;
    }

    public static int longestPalindrome(String s) {
        int[] charStatis = new int[64];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            charStatis[index] = charStatis[index] + 1;
        }
        int one = 0;
        int ans = 0;
        for (int i = 0; i < 64; i++) {
            if (one == 0 && (charStatis[i] & 1) == 1) {
                one = 1;
            }

            ans = ans + ((charStatis[i] & 1) == 1 ? charStatis[i] - 1 : charStatis[i]);
        }

        return ans + one;
    }

    public static void main(String[] args) {
        String s = "abccccdd";

        System.out.println(longestPalindrome(s));
    }
}