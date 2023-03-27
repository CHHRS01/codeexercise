package list.addTwoNumbersII;

import entity.ListNode;

/**
 * 445. 两数相加 II
 *
 * @auther HUAWEI
 * @since business V1.0.0
 */
public class AddTwoNumbersII {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        printList(l1);
        l2 = reverseList(l2);
        printList(l2);


        if (l1 == null) {return  l2;}
        if (l2 == null) {return  l1;}
        int pro = l1.val + l2.val;
        l1.val = pro % 10;
        int add = pro / 10;
        ListNode head = l1;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            pro = l1.val + l2.val + add;
            l1.val = pro % 10;
            add = pro / 10;
        }
        if (l1.next == null) {
            l1.next = l2.next;
        }
        while (add == 1 && l1.next != null) {
            l1 = l1.next;
            pro = l1.val + add;
            l1.val = pro % 10;
            add = pro / 10;
        }
        if (add == 1) {
            l1.next = new ListNode(1);
        }

        head = reverseList(head);
        printList(head);
        return head;

    }



    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        ListNode l1_1 = new ListNode(6);
        l1.next = l1_1;

        ListNode l2 = new ListNode(9);
        ListNode l2_1 = new ListNode(2);
        ListNode l2_2 = new ListNode(4);
        l2.next = l2_1;
        l2_1.next = l2_2;

        addTwoNumbers(l1, l2);
    }

    public static void printList(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
